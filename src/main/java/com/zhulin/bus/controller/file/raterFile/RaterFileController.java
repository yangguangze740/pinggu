package com.zhulin.bus.controller.file.raterFile;

import com.zhulin.bus.bean.*;
import com.zhulin.bus.service.department.DepartmentServiceI;
import com.zhulin.bus.service.file.raterFile.RaterFileServiceI;
import com.zhulin.bus.service.type.TypeServiceI;
import com.zhulin.bus.service.user.general.impl.GeneralUserServiceImpl;
import com.zhulin.common.annotation.menu.ClassMenuURL;
import com.zhulin.common.def.Constants;
import com.zhulin.framework.controller.ArcController;
import com.zhulin.sys.pojo.SystemUser;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/raterFile")
@ClassMenuURL(value = "/admin/raterFile", group = "file", name = "评审文件管理", groupName = "文件管理")
public class RaterFileController extends ArcController<RaterFile>{

    @Resource
    private RaterFileServiceI raterFileServiceI;

    @Resource
    private DepartmentServiceI departmentServiceI;

    @Resource
    private TypeServiceI typeServiceI;

    @Resource
    private GeneralUserServiceImpl generalUserService;

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(RaterFile raterFile, HttpServletRequest request, Model model) {

        List<RaterFile> raterFiles = raterFileServiceI.appReadList(raterFile);

        List<Department> departments = departmentServiceI.appReadList(new Department());
        List<Type> types = typeServiceI.appReadList(new Type());
//        List<User> users = generalUserService.appReadList(new User());

        model.addAttribute("raterFiles", raterFiles);
        model.addAttribute("departments", departments);
        model.addAttribute("types", types);
//        model.addAttribute("users", users);

        return "bus/file/rater/index";
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
    public String update(RaterFile raterFile, HttpServletRequest request, Model model, RedirectAttributes message) {
        return null;
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable String id, HttpServletRequest request, Model model, RedirectAttributes message) {
        SystemUser user =(SystemUser) request.getSession().getAttribute(Constants.LOGIN_USER);

        RaterFileModify raterFileModify = new RaterFileModify();
        raterFileModify.setUserId(user.getUserId());
        raterFileModify.setRaterFileId(id);

        boolean isDelete = raterFileServiceI.appDelete(id);
        boolean isModify = raterFileServiceI.insertModify(raterFileModify);

        if (isDelete && isModify){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除文件成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除文件失败");
        }

        return "redirect:/admin/raterFile";
    }

    @Override
    public String routeAdd(HttpServletRequest request, Model model) {
        return null;
    }

    @Override
    public String saveAdd(RaterFile raterFile, HttpServletRequest request, Model model, RedirectAttributes message) {
        return null;
    }

    @RequestMapping(value = "/preview/{id}", method = RequestMethod.GET)
    public void raterFilePreview(@PathVariable("id") String fileId, HttpServletResponse response) {
        try {
            RaterFile raterFile = raterFileServiceI.readRaterFileFullPathFile(fileId);

            File file = new File(raterFile.getRaterFilePath() + raterFile.getRaterFileDbName());
            FileInputStream fis = new FileInputStream(file);

            response.setHeader("Content-Disposition", "attachment;fileName=" + raterFile.getRaterFileDbName() + ".pdf");
            response.setContentType("multipart/form-data");

            OutputStream outputStream = response.getOutputStream();

            IOUtils.write(IOUtils.toByteArray(fis), outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/downLoad", method = RequestMethod.GET)
    public void raterFileDownload(@RequestParam("c") String fileId, HttpServletResponse response) {
        RaterFile raterFile = raterFileServiceI.readRaterFileFullPathFile(fileId);

        try {
            File file = new File(raterFile.getRaterFilePath() + raterFile.getRaterFileDbName());

            String sourceFileName = raterFile.getRaterFileDbName();
            String subName = sourceFileName.substring(sourceFileName.lastIndexOf("."));

            if (subName.equals(Constants.EXCEL_FILE_SUFFIX_1) || subName.equals(Constants.EXCEL_FILE_SUFFIX_2)) {
                response.setContentType("application/x-excel");
            } else {
                response.setContentType("application/msword");
            }

            // 配置文件下载属性
            String downloadFileName = new String(raterFile.getRaterFileName().getBytes("utf-8"), "ISO-8859-1");
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

    @RequestMapping(value = "/selectById", method = RequestMethod.POST)
    public String selectById(RaterFile raterFile, HttpServletRequest request, Model model, RedirectAttributes message){
        List<RaterFile> raterFiles = raterFileServiceI.appReadList(raterFile);
        List<Department> departments = departmentServiceI.appReadList(new Department());
        List<Type> types = typeServiceI.appReadList(new Type());
        List<User> users = generalUserService.appReadList(new User());

        model.addAttribute("raterFiles", raterFiles);
        model.addAttribute("departments", departments);
        model.addAttribute("types", types);
        model.addAttribute("users", users);

        return "bus/file/rater/index";
    }

    @ResponseBody
    @RequestMapping(value = "/type", method = RequestMethod.GET)
    public Map<String, List<Type>> selectTypeByDepartment(Department department, HttpServletRequest request, Model model){
        Map<String, List<Type>> map = new HashMap<>();

        if (department.getDepartmentId()==null){
            List<Type> types = typeServiceI.appReadList(new Type());

            map.put("types", types);

            return map;
        } else {
            List<Type> types = typeServiceI.readHaveTypes(department.getDepartmentId());

            map.put("types", types);

            return map;
        }
    }
}
