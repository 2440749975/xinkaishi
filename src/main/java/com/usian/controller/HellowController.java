package com.usian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.usian.pojo.Student;
import com.usian.pojo.StudentVo;
import com.usian.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HellowController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("tologin")
    public String tologin(){
        return  "login";
    }
    @RequestMapping("login")
    public String login(Model model, Student student, HttpSession session) {
        Student student1= studentService.login(student);
        if(student1!=null){
            session.setAttribute("user", student1);
            return "redirect:toshow";
        }else {
            model.addAttribute("err","姓名或学号错误");
            System.out.println("没查到东西");
            return "login";
        }
    }
    @RequestMapping("toshow")
    public String toshow(StudentVo student, @RequestParam(defaultValue = "1")Integer pageNum, Model model){
        PageHelper.startPage(pageNum,2);
       List<StudentVo> list= studentService.findAll(student);
        PageInfo<StudentVo> page = new PageInfo<>(list);
        model.addAttribute("page",page);
        model.addAttribute("student",student);
        return  "show";
    }
   @RequestMapping("toadd")
   public String toadd(){
       return  "add";
   }
    @RequestMapping("tozhuce")
    public String tozhuce(){

        return  "zhuce";
    }
    @RequestMapping("zhuce")
    public String zhuce (Student student,Model model){
        String sname = student.getSname().trim();
        Student byadd = studentService.findByadd(sname);
        if (byadd==null) {
            studentService.addStudent(student);
            return "login";
        }else {
            model.addAttribute("err","用户名重复！！");
            return "zhuce";
        }
    }
    @RequestMapping("add")
    public String insertinto (Student student){
        studentService.addStudent(student);
        return "redirect:toshow";
    }
//
    @RequestMapping("toupdate")
    public String toupdate(Integer sid,Model model){
        Student student=studentService.findByid(sid);
        model.addAttribute("stu",student);
        return "update";
    }
    @RequestMapping("delete")
    public String delete(Integer sid){
        studentService.delete(sid);
        return "redirect:toshow";
    }
    @RequestMapping("update")
    public String update(Student student){
        studentService.update(student);
        return "redirect:toshow";
    }
}
