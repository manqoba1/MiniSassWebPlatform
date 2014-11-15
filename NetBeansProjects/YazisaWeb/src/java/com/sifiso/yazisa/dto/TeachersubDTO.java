/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.dto;

import com.sifiso.yazisa.data.Teachersub;

/**
 *
 * @author CodeTribe1
 */
public class TeachersubDTO {

    private Integer teacherSubID;

    private TeachersDTO teacher;
    private SubclazzDTO subclazz;

    public TeachersubDTO() {
    }

    public TeachersubDTO(Teachersub a) {
        teacherSubID = a.getTeacherSubID();
        teacher = new TeachersDTO(a.getTeacher());
        subclazz = new SubclazzDTO(a.getSubclazz());
    }

    public Integer getTeacherSubID() {
        return teacherSubID;
    }

    public void setTeacherSubID(Integer teacherSubID) {
        this.teacherSubID = teacherSubID;
    }

    public TeachersDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeachersDTO teacher) {
        this.teacher = teacher;
    }

    public SubclazzDTO getSubclazz() {
        return subclazz;
    }

    public void setSubclazz(SubclazzDTO subclazz) {
        this.subclazz = subclazz;
    }

}
