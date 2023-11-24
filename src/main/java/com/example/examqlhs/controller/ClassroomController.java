package com.example.examqlhs.controller;

import com.example.examqlhs.model.Classroom;
import com.example.examqlhs.service.classroom.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/classroom")
public class ClassroomController {
    @Autowired
    private IClassroomService classroomService;

    @GetMapping
    public ModelAndView showClassList(){
        ModelAndView modelAndView = new ModelAndView("/classroom/list");
        modelAndView.addObject("listClass", classroomService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateClass(){
        ModelAndView modelAndView = new ModelAndView("/classroom/create");
        modelAndView.addObject("createClass", new Classroom());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(Classroom classroom){
        classroomService.save(classroom);
        return "redirect:/classroom";
    }

    @GetMapping("/update/{id}")
    public ModelAndView showFormUpdate(@PathVariable Long id){
        Classroom classroom = classroomService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("/classroom/update");
        modelAndView.addObject("classUp", classroom);
        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, Classroom classroom){
        classroomService.save(classroom);
        return "redirect:/classroom";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        classroomService.remove(id);
        return ("redirect:/classroom");
    }
}
