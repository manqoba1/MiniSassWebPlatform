/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.dto;

import com.sifiso.yazisa.data.*;
import java.io.Serializable;

/**
 *
 * @author CodeTribe1
 */
public class ClazzstudentDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer clazzStudentID, clazzID, studentID;
    private long clazzYear;
    private ClazzDTO clazz;
    private StudentDTO student;

    public ClazzstudentDTO() {
    }

    public ClazzstudentDTO(Clazzstudent a) {
        clazzStudentID = a.getClazzStudentID();
        clazz = new ClazzDTO(a.getClazz());
        student = new StudentDTO(a.getStudent());
        clazzID = a.getClazz().getClazzID();
        studentID = a.getStudent().getStudentID();
    }

    public Integer getClazzStudentID() {
        return clazzStudentID;
    }

    public void setClazzStudentID(Integer clazzStudentID) {
        this.clazzStudentID = clazzStudentID;
    }

    public Integer getClazzID() {
        return clazzID;
    }

    public void setClazzID(Integer clazzID) {
        this.clazzID = clazzID;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public long getClazzYear() {
        return clazzYear;
    }

    public void setClazzYear(long clazzYear) {
        this.clazzYear = clazzYear;
    }

    public ClazzDTO getClazz() {
        return clazz;
    }

    public void setClazz(ClazzDTO clazz) {
        this.clazz = clazz;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clazzStudentID != null ? clazzStudentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClazzstudentDTO)) {
            return false;
        }
        ClazzstudentDTO other = (ClazzstudentDTO) object;
        if ((this.clazzStudentID == null && other.clazzStudentID != null) || (this.clazzStudentID != null && !this.clazzStudentID.equals(other.clazzStudentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.data.Clazzstudent[ clazzStudentID=" + clazzStudentID + " ]";
    }

}
