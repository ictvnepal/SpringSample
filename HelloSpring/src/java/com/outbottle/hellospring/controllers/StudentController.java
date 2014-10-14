/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outbottle.hellospring.controllers;


import com.outbottle.hellospring.entities.Student;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author forsell
 */
@Controller
public class StudentController {
    
    public StudentController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        //setCommandClass(MyCommand.class);
        //setCommandName("MyCommandName");
        //setSuccessView("successView");
        //setFormView("formView");
    }
    
    @RequestMapping(value="/student", method= RequestMethod.GET)
    public String index(ModelMap map) {
        ArrayList<Student> students=getStudents();
        map.put("students",students);
        return "student/index";
    }
    
    @RequestMapping(value="/student/edit/{id}",method=RequestMethod.GET)
    public String edit(@PathVariable(value="id")Integer id,ModelMap map){
        map.put("student",getById(id));
        return "student/edit";
    }
    
    @RequestMapping(value="/student/save",method=RequestMethod.POST)
    public String save(@ModelAttribute("student") Student student,ModelMap map){
        map.put("student",student);
        return "student/test";
    }
    
    private ArrayList<Student> getStudents(){
        ArrayList<Student> students=new ArrayList<Student>();
        students.add(new Student(1,"Amit","Shrestha"));
        students.add(new Student(2,"Bijesh","Shrestha"));
        students.add(new Student(3,"Karma","Lama"));
        return students;
    }
    private Student getById(Integer id){
        ArrayList<Student> students=getStudents();
        Student student=null;
        for(Student s: students){
            if(s.getStudentId()==id){
                student=s;
                break;
            }
        }
        return student;
    }
}
