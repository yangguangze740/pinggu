package com.zhulin.bus.controller.file.support;

import com.zhulin.bus.bean.*;
import com.zhulin.bus.service.DutyDepartment.DutyDepartmentServiceI;
import com.zhulin.bus.service.department.DepartmentServiceI;
import com.zhulin.bus.service.element.ElementServiceI;
import com.zhulin.bus.service.file.support.SupportFileServiceI;
import com.zhulin.bus.service.lead.LeadServiceI;
import com.zhulin.bus.service.point.PointServiceI;
import com.zhulin.bus.service.project.ProjectServiceI;
import com.zhulin.bus.service.user.general.GeneralUserServiceI;
import com.zhulin.common.annotation.menu.ClassMenuURL;
import com.zhulin.common.def.Constants;
import com.zhulin.framework.controller.ArcController;
import com.zhulin.sys.pojo.SystemUser;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
@RequestMapping("/admin/supportFile")
@ClassMenuURL(value = "/admin/supportFile", name = "支撑文件管理", group = "file", groupName = "文件管理")
public class SupportFileController extends ArcController<SupportFile>{

    @Autowired
    private SupportFileServiceI supportFileServiceI;

    @Autowired
    private DepartmentServiceI departmentServiceI;

    @Autowired
    private GeneralUserServiceI generalUserServiceI;

    @Autowired
    private PointServiceI pointServiceI;

    @Autowired
    private DutyDepartmentServiceI dutyDepartmentServiceI;

    @Autowired
    private LeadServiceI leadServiceI;

    @Autowired
    private ElementServiceI elementServiceI;

    @Autowired
    private ProjectServiceI projectServiceI;

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(SupportFile supportFile, HttpServletRequest request, Model model) {
        List<SupportFile> supportFiles = supportFileServiceI.appReadList(supportFile);
        List<Department> departments = departmentServiceI.appReadList(new Department());
        List<Point> points = pointServiceI.appReadList(new Point());
        List<DutyDepartment> dutyDepartments = dutyDepartmentServiceI.appReadList(new DutyDepartment());
        List<Lead> leads = leadServiceI.appReadList(new Lead());
        List<Element> elements = elementServiceI.appReadList(new Element());
        List<Project> projects = projectServiceI.appReadList(new Project());
        List<User> users = generalUserServiceI.appReadList(new User());

        model.addAttribute("supportFiles", supportFiles);
        model.addAttribute("departments", departments);
        model.addAttribute("points", points);
        model.addAttribute("dutyDepartments", dutyDepartments);
        model.addAttribute("leads", leads);
        model.addAttribute("elements", elements);
        model.addAttribute("projects", projects);
        model.addAttribute("users", users);

        return "bus/file/support/index";
    }

    @Override
    public String detail(String id, HttpServletRequest request, Model model) {
        return null;
    }

    @Override
    public String query4Edit(String id, HttpServletRequest request, Model model) {
        return null;
    }

    @Override
    public String update(SupportFile supportFile, HttpServletRequest request, Model model, RedirectAttributes message) {
        return null;
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable String id, HttpServletRequest request, Model model, RedirectAttributes message) {
        SystemUser user =(SystemUser) request.getSession().getAttribute(Constants.LOGIN_USER);

        SupportFileModify supportFileModify = new SupportFileModify();
        supportFileModify.setUserId(user.getUserId());
        supportFileModify.setSupportFileId(id);

        boolean isDelete = supportFileServiceI.appDelete(id);
        boolean isModify = supportFileServiceI.insertModify(supportFileModify);

        if (isDelete && isModify){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除文件成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除文件失败");
        }

        return "redirect:/admin/supportFile";
    }

    @Override
    public String routeAdd(HttpServletRequest request, Model model) {
        return null;
    }

    @Override
    public String saveAdd(SupportFile supportFile, HttpServletRequest request, Model model, RedirectAttributes message) {
        return null;
    }

    @RequestMapping(value = "/preview/{id}", method = RequestMethod.GET)
    public void raterFilePreview(@PathVariable("id") String fileId, HttpServletResponse response) {
        try {
            SupportFile supportFile = supportFileServiceI.readFileFullPathFile(fileId);

            File file = new File(supportFile.getSupportFilePath() + supportFile.getSupportFileDbName());
            FileInputStream fis = new FileInputStream(file);

            response.setHeader("Content-Disposition", "attachment;fileName=" + supportFile.getSupportFileDbName() + ".pdf");
            response.setContentType("multipart/form-data");

            OutputStream outputStream = response.getOutputStream();

            IOUtils.write(IOUtils.toByteArray(fis), outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/downLoad", method = RequestMethod.GET)
    public void raterFileDownload(@RequestParam("c") String fileId, HttpServletResponse response) {
        SupportFile supportFile = supportFileServiceI.readFileFullPathFile(fileId);

        try {
            File file = new File(supportFile.getSupportFilePath() + supportFile.getSupportFileDbName());

            String sourceFileName = supportFile.getSupportFileDbName();
            String subName = sourceFileName.substring(sourceFileName.lastIndexOf("."));

            if (subName.equals(Constants.EXCEL_FILE_SUFFIX_1) || subName.equals(Constants.EXCEL_FILE_SUFFIX_2)) {
                response.setContentType("application/x-excel");
            } else {
                response.setContentType("application/msword");
            }

            // 配置文件下载属性
            String downloadFileName = new String(supportFile.getSupportFileName().getBytes("utf-8"), "ISO-8859-1");
            response.setCharacterEncoding("ISO-8859-1");
            response.setHeader("Content-Disposition", "attachment; filename=" + downloadFileName);
            response.setHeader("Content-Length", String.valueOf(file.length()));

            int length = 0;
            byte[] buffer = new byte[1024];

            FileInputStream fis = new FileInputStream(file);
            OutputStream os = response.getOutputStream();

            while (-1 != (length = fis.read(buffer, 0, buffer.length))) {
                os.write(buffer, 0, length);
            }

            fis.close();
            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
