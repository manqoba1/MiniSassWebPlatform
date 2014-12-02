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
    private Integer clazzID, schoolID;
    private String className;
    private Integer totalStudentsPerClazz;
    private Integer activeFlag;
    private List<ClazzstudentDTO> clazzstudentList = new ArrayList<>();
    private SchoolDTO school;
    private List<ClazzteacherDTO> clazzteacherList = new ArrayList<>();

    public ClazzDTO() {
    }

    public ClazzDTO(Clazz c) {
        clazzID = c.getClazzID();
        className = c.getClassName();
        totalStudentsPerClazz = c.getTotalStudentsPerClazz();
        activeFlag = c.getActiveFlag();
        schoolID = c.getSchool().getSchoolID();
        school = new SchoolDTO(c.getSchool());
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

    public Integer getTotalStudentsPerClazz() {
        return totalStudentsPerClazz;
    }

    public void setTotalStudentsPerClazz(Integer totalStudentsPerClazz) {
        this.totalStudentsPerClazz = totalStudentsPerClazz;
    }

    public Integer getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(Integer schoolID) {
        this.schoolID = schoolID;
    }

    public Integer getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Integer activeFlag) {
        this.activeFlag = activeFlag;
    }

    public List<ClazzstudentDTO> getClazzstudentList() {
        return clazzstudentList;
    }

    public void setClazzstudentList(List<ClazzstudentDTO> clazzstudentList) {
        this.clazzstudentList = clazzstudentList;
    }

    public SchoolDTO getSchool() {
        return school;
    }

    public void setSchool(SchoolDTO school) {
        this.school = school;
    }

    public List<ClazzteacherDTO> getClazzteacherList() {
        return clazzteacherList;
    }

    public void setClazzteacherList(List<ClazzteacherDTO> clazzteacherList) {
        this.clazzteacherList = clazzteacherList;
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
