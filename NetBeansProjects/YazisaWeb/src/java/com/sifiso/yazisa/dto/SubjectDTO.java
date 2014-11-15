/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.dto;

import com.sifiso.yazisa.data.Subject;
import java.util.List;

/**
 *
 * @author CodeTribe1
 */
public class SubjectDTO {

    private Integer subjectID;

    private String subjectName;
    private List<TeachersubDTO> teachersubList;
    private List<SubclazzDTO> subclazzList;

    public SubjectDTO(Subject s) {
        subjectID = s.getSubjectID();
        subjectName = s.getSubjectName();

    }

    public Integer getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(Integer subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public List<TeachersubDTO> getTeachersubList() {
        return teachersubList;
    }

    public void setTeachersubList(List<TeachersubDTO> teachersubList) {
        this.teachersubList = teachersubList;
    }

    public List<SubclazzDTO> getSubclazzList() {
        return subclazzList;
    }

    public void setSubclazzList(List<SubclazzDTO> subclazzList) {
        this.subclazzList = subclazzList;
    }

}
