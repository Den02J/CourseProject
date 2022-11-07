package com.example.courseproject.controller;

/*
 * Created by IntelliJ IDEA.
 * Class: ViewUIController
 *
 * Author: DenysZhytariu
 * Version 1.0
 */

import com.example.courseproject.model.Examiner;
import com.example.courseproject.model.Specialty;
import com.example.courseproject.model.Student;
import com.example.courseproject.repository.IStudentMongoRepository;
import com.example.courseproject.service.impls.ExaminerServiceImpls;
import com.example.courseproject.service.impls.SpecialtyServiceImpls;
import com.example.courseproject.service.impls.StudentServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/view")
public class ViewUIController {

    @Autowired
    StudentServiceImpls studentService;
    @Autowired
    ExaminerServiceImpls examinerService;
    @Autowired
    SpecialtyServiceImpls specialtyService;
    @Autowired
    IStudentMongoRepository mongoRepository;

    @GetMapping("/")
    String view(Model model, @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Student> page = mongoRepository.findAll(pageable);
        model.addAttribute("page", page);
        model.addAttribute("url", "/view/");
        return "view";
    }

    @RequestMapping (value = "/points/{id}", method = RequestMethod.GET)
    public String showPoints(Model model, @PathVariable("id") String id) {
        Student student = studentService.get(id);
        model.addAttribute("student", student);
        return "view-points";
    }

    @GetMapping("/examiners/")
    String showExaminers(Model model) {
        List<Examiner> list = examinerService.getAll();
        model.addAttribute("examiners", list);
        return "examiners";
    }

    @GetMapping("/specialties/")
    String showSpecialties(Model model) {
        List<Specialty> list = specialtyService.getAll();
        model.addAttribute("specialties", list);
        return "specialties";
    }
}
