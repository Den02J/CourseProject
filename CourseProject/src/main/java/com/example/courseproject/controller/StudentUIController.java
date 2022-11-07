package com.example.courseproject.controller;

/*
 * Created by IntelliJ IDEA.
 * Class: StudentUIController
 *
 * Author: DenysZhytariu
 * Version 1.0
 */

import com.example.courseproject.form.StudentForm;
import com.example.courseproject.model.Examiner;
import com.example.courseproject.model.Specialty;
import com.example.courseproject.model.Student;
import com.example.courseproject.repository.IStudentMongoRepository;
import com.example.courseproject.service.impls.SpecialtyServiceImpls;
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
@RequestMapping("/students")
public class StudentUIController {
    @Autowired
    StudentServiceImpls service;
    @Autowired
    IStudentMongoRepository mongoRepository;
    @Autowired
    SpecialtyServiceImpls specialtyService;

    @GetMapping("/")
    String showAll(Model model, @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Student> page = mongoRepository.findAll(pageable);
        List<Student> list = service.getAll();
        model.addAttribute("page", page);
        model.addAttribute("url", "/students/");
        return "students-all";
    }

    @GetMapping("/delete/{id}")
    String delete(@PathVariable String id) {
        service.delete(id);
        return "redirect:/students/";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String createStudent(Model model){
        StudentForm studentForm = new StudentForm();

        List<Specialty> list = specialtyService.getAll();
        model.addAttribute("specialties", list);

        model.addAttribute("form", studentForm);
        return "create-student";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String createStudent( @ModelAttribute("form") StudentForm form ){

        Student student = new Student();

        List<Specialty> spList = specialtyService.getAll();
        for(Specialty sp: spList){
            if (form.specialty.equals(sp.name)) {
                student.setSpecialty(sp);
                break;
            }
        }

        Examiner examiner = new Examiner("");
        student.specialty.subject1.examiner = examiner;
        student.specialty.subject2.examiner = examiner;
        student.specialty.subject3.examiner = examiner;

        student.setFirstName(form.getFirstName());
        student.setLastName(form.getLastName());

        student.specialty.subject1.setPoints("");
        student.specialty.subject2.setPoints("");
        student.specialty.subject3.setPoints("");

        service.create(student);
        return "redirect:/students/";
    }


    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateStudent(Model model, @PathVariable("id") String id){
        Student student = service.get(id);
        StudentForm studentform = new StudentForm();
        studentform.setId(student.getId());
        studentform.setFirstName(student.getFirstName());
        studentform.setLastName(student.getLastName());
        studentform.setSpecialty(student.specialty.name);

        List<Specialty> list = specialtyService.getAll();
        model.addAttribute("specialties", list);

        model.addAttribute("form",studentform);

        return "update-student";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateStudent(@PathVariable("id") String id,
                                @ModelAttribute("form") StudentForm form){
        Student student = service.get(form.getId());
        student.setFirstName(form.getFirstName());
        student.setLastName(form.getLastName());

        List<Specialty> spList = specialtyService.getAll();
        for(Specialty sp: spList){
            if (form.getSpecialty().equals(sp.name)) {
                student.setSpecialty(sp);
                break;
            }
        }

        Examiner examiner = new Examiner("");
        student.specialty.subject1.examiner = examiner;
        student.specialty.subject2.examiner = examiner;
        student.specialty.subject3.examiner = examiner;

        student.setFirstName(form.getFirstName());
        student.setLastName(form.getLastName());

        student.specialty.subject1.setPoints("");
        student.specialty.subject2.setPoints("");
        student.specialty.subject3.setPoints("");

        service.update(student);
        return "redirect:/students/";
    }

}
