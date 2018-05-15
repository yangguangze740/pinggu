package com.zhulin.bus.controller.file.paper;

import com.zhulin.bus.bean.*;
import com.zhulin.bus.service.college.CollegeServiceI;
import com.zhulin.bus.service.discipline.DisciplineServiceI;
import com.zhulin.bus.service.file.paper.PaperFileServiceI;
import com.zhulin.bus.service.paper.PaperServiceI;
import com.zhulin.bus.service.subject.SubjectServiceI;
import com.zhulin.common.annotation.menu.ClassMenuURL;
import com.zhulin.common.def.Constants;
import com.zhulin.framework.controller.ArcController;
import com.zhulin.sys.pojo.SystemUser;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/paperFile")
@ClassMenuURL(value = "/admin/paperFile", group = "paperFile", name = "试卷文件管理", groupName = "试卷文件管理")
public class PaperFileController extends ArcController<PaperFile>{

    @Autowired
    private PaperFileServiceI paperFileServiceI;

    @Autowired
    private CollegeServiceI collegeServiceI;

    @Autowired
    private DisciplineServiceI disciplineServiceI;

    @Autowired
    private SubjectServiceI subjectServiceI;

    @Autowired
    private PaperServiceI paperServiceI;

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(PaperFile paperFile, HttpServletRequest request, Model model) {
        List<PaperFile> paperFiles = paperFileServiceI.appReadList(paperFile);
        List<College> colleges = collegeServiceI.appReadList(new College());
        List<Discipline> disciplines = disciplineServiceI.appReadList(new Discipline());
        List<Subject> subjects = subjectServiceI.appReadList(new Subject());
        List<Paper> papers = paperServiceI.appReadList(new Paper());

        model.addAttribute("paperFiles", paperFiles);
        model.addAttribute("colleges", colleges);
        model.addAttribute("disciplines", disciplines);
        model.addAttribute("subjects", subjects);
        model.addAttribute("papers", papers);

        return "bus/file/paper/index";
    }

    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public String selectList(PaperFile paperFile, HttpServletRequest request, Model model) {
        List<PaperFile> paperFiles = paperFileServiceI.appReadList(paperFile);
        List<College> colleges = collegeServiceI.appReadList(new College());
        List<Discipline> disciplines = disciplineServiceI.appReadList(new Discipline());
        List<Subject> subjects = subjectServiceI.appReadList(new Subject());
        List<Paper> papers = paperServiceI.appReadList(new Paper());

        model.addAttribute("paperFiles", paperFiles);
        model.addAttribute("colleges", colleges);
        model.addAttribute("disciplines", disciplines);
        model.addAttribute("subjects", subjects);
        model.addAttribute("papers", papers);

        return "bus/file/paper/index";
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
    public String update(PaperFile paperFile, HttpServletRequest request, Model model, RedirectAttributes message) {
        return null;
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable String id, HttpServletRequest request, Model model, RedirectAttributes message) {
        SystemUser user =(SystemUser) request.getSession().getAttribute(Constants.LOGIN_USER);
        PaperFileModify paperFileModify = new PaperFileModify();

        paperFileModify.setUserId(user.getUserId());
        paperFileModify.setPaperFileId(id);

        boolean isDelete = paperFileServiceI.appDelete(id);
        boolean isInsert = paperFileServiceI.insertModify(paperFileModify);

        if (isDelete && isInsert){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除文件成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除文件失败");
        }

        return "redirect:/admin/paperFile";
    }

    @Override
    public String routeAdd(HttpServletRequest request, Model model) {
        return null;
    }

    @Override
    public String saveAdd(PaperFile paperFile, HttpServletRequest request, Model model, RedirectAttributes message) {
        return null;
    }

    @RequestMapping(value = "/preview/{id}", method = RequestMethod.GET)
    public void raterFilePreview(@PathVariable("id") String fileId, HttpServletResponse response) {
        try {
            PaperFile paperFile = paperFileServiceI.readPaperFileFullPathFile(fileId);

            File file = new File(paperFile.getPaperFilePath() + paperFile.getPaperFileDBName());
            FileInputStream fis = new FileInputStream(file);

            response.setHeader("Content-Disposition", "attachment;fileName=" + paperFile.getPaperFileDBName() + ".pdf");
            response.setContentType("multipart/form-data");

            OutputStream outputStream = response.getOutputStream();

            IOUtils.write(IOUtils.toByteArray(fis), outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/downLoad", method = RequestMethod.GET)
    public void raterFileDownload(@RequestParam("c") String fileId, HttpServletResponse response) {
        PaperFile paperFile = paperFileServiceI.readPaperFileFullPathFile(fileId);

        try {
            File file = new File(paperFile.getPaperFilePath() + paperFile.getPaperFileDBName());

            String sourceFileName = paperFile.getPaperFileDBName();
            String subName = sourceFileName.substring(sourceFileName.lastIndexOf("."));

            if (subName.equals(Constants.EXCEL_FILE_SUFFIX_1) || subName.equals(Constants.EXCEL_FILE_SUFFIX_2)) {
                response.setContentType("application/x-excel");
            } else {
                response.setContentType("application/msword");
            }

            // 配置文件下载属性
            String downloadFileName = new String(paperFile.getPaperFileName().getBytes("utf-8"), "ISO-8859-1");
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

    @ResponseBody
    @RequestMapping(value = "/paper",method = RequestMethod.GET )
    public Map<String,List<Paper>> routeAdd(Subject subject) {
        Map<String,List<Paper>> map = new HashMap<>();

        List<Paper> papers = paperFileServiceI.queryPaperBySubjectId(subject.getSubjectId());

        map.put("papers", papers);

        return map;
    }
}
