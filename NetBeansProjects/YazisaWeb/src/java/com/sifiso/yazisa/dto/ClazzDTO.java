/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.dto;

import com.sifiso.yazisa.data.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * @author CodeTribe1
 */
public class ClazzDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer clazzID;
    private String className;

    private int classYear;
    private List<ClazzteacherDTO> clazzteacherList = new ArrayList<>();
    private List<ClazzlearnerDTO> clazzlearnerList = new ArrayList<>();
    private List<ExamDTO> examList = new ArrayList<>();
    private List<SubclazzDTO> subclazzList = new ArrayList<>();

    public ClazzDTO() {
    }

    public ClazzDTO(Clazz c) {
        clazzID = c.getClazzID();
        className = c.getClassName();
        classYear = c.getClassYear();
    }

    public int getClassYear() {
        return classYear;
    }

    public void setClassYear(int classYear) {
        this.classYear = classYear;
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

    public List<ClazzteacherDTO> getClazzteacherList() {
        return clazzteacherList;
    }

    public void setClazzteacherList(List<ClazzteacherDTO> clazzteacherList) {
        this.clazzteacherList = clazzteacherList;
    }

    public List<ClazzlearnerDTO> getClazzlearnerList() {
        return clazzlearnerList;
    }

    public void setClazzlearnerList(List<ClazzlearnerDTO> clazzlearnerList) {
        this.clazzlearnerList = clazzlearnerList;
    }

    public List<ExamDTO> getExamList() {
        return examList;
    }

    public void setExamList(List<ExamDTO> examList) {
        this.examList = examList;
    }

    public List<SubclazzDTO> getSubclazzList() {
        return subclazzList;
    }

    public void setSubclazzList(List<SubclazzDTO> subclazzList) {
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
