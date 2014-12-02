/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.dto;

import com.sifiso.yazisa.data.Subject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CodeTribe1
 */
public class SubjectDTO implements Serializable {

    private Integer subjectID;
    private String name;
    private String grade;
    private String code;
    private List<AttendenceDTO> attendenceList = new ArrayList<>();
    private List<TeachersubjectDTO> teachersubjectList = new ArrayList<>();

    public SubjectDTO(Subject a) {
        subjectID = a.getSubjectID();
        name = a.getName();
        code = a.getCode();
        grade = a.getGrade();

    }

    public Integer getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(Integer subjectID) {
        this.subjectID = subjectID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<AttendenceDTO> getAttendenceList() {
        return attendenceList;
    }

    public void setAttendenceList(List<AttendenceDTO> attendenceList) {
        this.attendenceList = attendenceList;
    }

    public List<TeachersubjectDTO> getTeachersubjectList() {
        return teachersubjectList;
    }

    public void setTeachersubjectList(List<TeachersubjectDTO> teachersubjectList) {
        this.teachersubjectList = teachersubjectList;
    }

}
