/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sifiso.yazisa.dto;

import com.sifiso.yazisa.data.*;
import java.io.Serializable;
import java.util.List;

 /*
 * @author CodeTribe1
 */
public class ClazzDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer clazzID;
    private String className;
    private int classTypeID;
    private List<Clazzteacher> clazzteacherList;
    private List<Clazzlearner> clazzlearnerList;
    private List<Exam> examList;
    private List<Subclazz> subclazzList;

    public ClazzDTO() {
    }



    public ClazzDTO(Clazz c) {
      clazzID = c.getClazzID();
      className = c.getClassName();
      classTypeID = c.getClassTypeID();
      
    }

    public Integer getClazzID() {
        return clazzID;
    }

    public void setClazzID(Integer clazzID) {
        this.clazzID = clazzID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getClassTypeID() {
        return classTypeID;
    }

    public void setClassTypeID(int classTypeID) {
        this.classTypeID = classTypeID;
    }

    public List<Clazzteacher> getClazzteacherList() {
        return clazzteacherList;
    }

    public void setClazzteacherList(List<Clazzteacher> clazzteacherList) {
        this.clazzteacherList = clazzteacherList;
    }

    public List<Clazzlearner> getClazzlearnerList() {
        return clazzlearnerList;
    }

    public void setClazzlearnerList(List<Clazzlearner> clazzlearnerList) {
        this.clazzlearnerList = clazzlearnerList;
    }

    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }

    public List<Subclazz> getSubclazzList() {
        return subclazzList;
    }

    public void setSubclazzList(List<Subclazz> subclazzList) {
        this.subclazzList = subclazzList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clazzID != null ? clazzID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClazzDTO)) {
            return false;
        }
        ClazzDTO other = (ClazzDTO) object;
        if ((this.clazzID == null && other.clazzID != null) || (this.clazzID != null && !this.clazzID.equals(other.clazzID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.data.Clazz[ clazzID=" + clazzID + " ]";
    }
    
}
