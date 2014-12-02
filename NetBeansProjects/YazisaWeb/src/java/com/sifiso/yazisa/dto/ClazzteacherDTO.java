/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.dto;

import com.sifiso.yazisa.data.Clazzteacher;
import java.io.Serializable;

/**
 *
 * @author CodeTribe1
 */
public class ClazzteacherDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer clazzTeacherID, clazzID, teacherID;
    private ClazzDTO clazz;
    private TeacherDTO teacher;

    public ClazzteacherDTO(Clazzteacher a) {
        clazzTeacherID = a.getClazzTeacherID();
        clazzID = a.getClazz().getClazzID();
        teacherID = a.getTeacher().getTeacherID();
        teacher = new TeacherDTO(a.getTeacher());
        clazz = new ClazzDTO(a.getClazz());

    }

    public Integer getClazzTeacherID() {
        return clazzTeacherID;
    }

    public void setClazzTeacherID(Integer clazzTeacherID) {
        this.clazzTeacherID = clazzTeacherID;
    }

    public Integer getClazzID() {
        return clazzID;
    }

    public void setClazzID(Integer clazzID) {
        this.clazzID = clazzID;
    }

    public Integer getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Integer teacherID) {
        this.teacherID = teacherID;
    }

    public ClazzDTO getClazz() {
        return clazz;
    }

    public void setClazz(ClazzDTO clazz) {
        this.clazz = clazz;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

}
