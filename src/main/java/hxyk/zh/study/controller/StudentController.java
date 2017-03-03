package hxyk.zh.study.controller;
import hxyk.zh.study.domain.Student;
import hxyk.zh.study.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2017-2-22.
 */
@Controller
@Slf4j
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/")
    @ResponseBody
    public String hello(){
        return "hello SpringBoot!";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String toIndex(){
//        int currentPage = 1;
//        int totalPage = (int)Math.ceil(studentService.getStudents().size()/2.0);
//        modelMap.put("totalPage",totalPage);
//        Page<Student> students1 = studentService.getStudents(0);
//        modelMap.put("students",students1);
//        modelMap.put("currentPage",currentPage);
//        return "student/index";

        return "redirect:/index/1";
    }
    @RequestMapping(value = "/index/{limit}",method = RequestMethod.GET)
    public String indexLimit(@PathVariable int limit, ModelMap modelMap){
        int currentPage;
        int totalPage = (int)Math.ceil(studentService.getStudents().size()/2.0);
        modelMap.put("totalPage",totalPage);
        if(limit<=1){
            limit = 1;
            currentPage = limit;
            Page<Student> students1 = studentService.getStudents(limit-1);
            modelMap.put("students",students1);
            modelMap.put("currentPage",currentPage);
        }else if (limit>=totalPage){
            limit = totalPage;
            currentPage = limit;
            Page<Student> students1 = studentService.getStudents(limit-1);
            modelMap.put("students",students1);
            modelMap.put("currentPage",currentPage);
        }else {
            currentPage = limit;
            Page<Student> students1 = studentService.getStudents(limit-1);
            modelMap.put("students",students1);
            modelMap.put("currentPage",currentPage);
        }
        return "student/index";
    }

    @RequestMapping("/modify/{id}")
    public String modify(@PathVariable Long id,Map<String,Object> map){
        Student student = studentService.getStudent(id);
        map.put("student",student);
        return "student/modify";
    }
    @PostMapping("/doModify")
    public String modify(Student student){
        studentService.updateStudent(student);
        return "redirect:index";
    }
    @GetMapping("/forwardAdd")
    public String forwardAdd(Map<String,Object> map){
        map.put("student",new Student());
        return "student/modify";
    }
    @PostMapping("/doAdd")
    public String add(Student student){
        studentService.addStudent(student);
        return "redirect:index";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id,ModelMap modelMap){
        studentService.deleteS(id);
        List<Student> students = studentService.getStudents();
        modelMap.put("students",students);
        return "redirect:../index/1";
    }

    @RequestMapping("/ajaxstudent/{id}")
    @ResponseBody
    public Student ajaxstudent(@PathVariable Long id, HttpServletResponse response){
        return studentService.getStudent(id);
    }
    @RequestMapping("/ajaxstudents")
    @ResponseBody
    public List<Student> ajaxstudents(HttpServletResponse response){
        return studentService.getStudents();
    }
    @RequestMapping("/img")
    @ResponseBody
    public byte[] img() throws Exception {
        InputStream inputStream = new BufferedInputStream(
                new FileInputStream(
                        new File("G:\\java\\汇新优科\\EduProject\\student\\123.jpg")
                )
        );
        return IOUtils.toByteArray(inputStream);
    }
}
