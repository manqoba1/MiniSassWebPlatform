/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.dto;

import com.sifiso.yazisa.data.Clazzteacher;

/**
 *
 * @author CodeTribe1
 */
public class ClazzteacherDTO {

    private Integer clazzTeacherID;
    private TeachersDTO teacher;
    private ClazzDTO clazz;

    public ClazzteacherDTO() {
    }

    public ClazzteacherDTO(Clazzteacher a) {
        clazzTeacherID = a.getClazzTeacherID();
        teacher = new TeachersDTO(a.getTeacher());
        clazz = new ClazzDTO(a.getClazz());
    }

    public Integer getClazzTeacherID() {
        return clazzTeacherID;
    }

    public void setClazzTeacherID(Integer clazzTeacherID) {
        this.clazzTeacherID = clazzTeacherID;
    }

    public TeachersDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeachersDTO teacher) {
        this.teacher = teacher;
    }

    public ClazzDTO getClazz() {
        return clazz;
    }

    public void setClazz(ClazzDTO clazz) {
        this.clazz = clazz;
    }

}
