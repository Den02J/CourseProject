package com.example.courseproject.controller;

/*
 * Created by IntelliJ IDEA.
 * Class: ExaminerUIController
 *
 * Author: DenysZhytariu
 * Version 1.0
 */

import com.example.courseproject.form.ExaminerForm;
import com.example.courseproject.model.Examiner;
import com.example.courseproject.model.Student;
import com.example.courseproject.repository.IStudentMongoRepository;
import com.example.courseproject.service.impls.ExaminerServiceImpls;
import com.example.courseproject.service.impls.StudentServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/examinerPage")
public class ExaminerUIController {
    @Autowired
    StudentServiceImpls studentService;
    @Autowired
    IStudentMongoRepository mongoRepository;
    @Autowired
    ExaminerServiceImpls examinerService;

    @GetMapping("/")
    String examinerView(Model model, @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Student> page = mongoRepository.findAll(pageable);
        model.addAttribute("page", page);
        model.addAttribute("url", "/examinerPage/");
        return "examinerView";
    }

    @RequestMapping (value = "/points/{id}", method = RequestMethod.GET)
    public String showPoints(Model model, @PathVariable("id") String id) {
        Student student = studentService.get(id);
        model.addAttribute("student", student);
        return "points";
    }

    @RequestMapping(value = "/estimate/{id}", method = RequestMethod.GET)
    public String estimate(Model model, @PathVariable("id") String id){
        Student student = studentService.get(id);
        ExaminerForm examinerForm = new ExaminerForm();
        examinerForm.setPoints1(student.specialty.subject1.getPoints());
        examinerForm.setPoints2(student.specialty.subject2.getPoints());
        examinerForm.setPoints3(student.specialty.subject3.getPoints());

        List<Examiner> list = examinerService.getAll();
        model.addAttribute("examiners", list);
        model.addAttribute("form", examinerForm);
        model.addAttribute("student", student);

        return "estimate";
    }

    @RequestMapping(value = "/estimate/{id}", method = RequestMethod.POST)
    public String estimate(@PathVariable("id") String id,
                                @ModelAttribute("form") ExaminerForm form ){
        Student student = studentService.get(form.getId());
        student.specialty.subject1.setPoints(form.getPoints1());
        student.specialty.subject2.setPoints(form.getPoints2());
        student.specialty.subject3.setPoints(form.getPoints3());
        student.specialty.subject1.examiner.setFullName(form.getExaminer1());
        student.specialty.subject2.examiner.setFullName(form.getExaminer2());
        student.specialty.subject3.examiner.setFullName(form.getExaminer3());

        studentService.update(student);
        return "redirect:/examinerPage/points/{id}";
    }

}