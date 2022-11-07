package com.example.courseproject.service.interfaces;

/*
 * Created by IntelliJ IDEA.
 * Class: IExaminerService
 *
 * Author: DenysZhytariu
 * Version 1.0
 */

import com.example.courseproject.model.Examiner;

import java.util.List;

public interface IExaminerService {
    List<Examiner> getAll();
    Examiner create(Examiner examiner);
}
