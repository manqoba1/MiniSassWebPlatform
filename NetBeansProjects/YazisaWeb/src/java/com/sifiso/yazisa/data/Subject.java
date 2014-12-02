/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author CodeTribe1
 */
@Entity
@Table(name = "subject")
@NamedQueries({
    @NamedQuery(name = "Subject.findAll", query = "SELECT s FROM Subject s"),
    @NamedQuery(name = "Subject.findBySubjectID", query = "SELECT s FROM Subject s WHERE s.subjectID = :subjectID"),
    @NamedQuery(name = "Subject.findByName", query = "SELECT s FROM Subject s WHERE s.name = :name"),
    @NamedQuery(name = "Subject.findByGrade", query = "SELECT s FROM Subject s WHERE s.grade = :grade"),
    @NamedQuery(name = "Subject.findByCode", query = "SELECT s FROM Subject s WHERE s.code = :code")})
public class Subject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "subjectID")
    private Integer subjectID;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "grade")
    private String grade;
    @Size(max = 45)
    @Column(name = "code")
    private String code;
    @OneToMany(mappedBy = "subject")
    private List<Attendence> attendenceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
    private List<Teachersubject> teachersubjectList;

    public Subject() {
    }

    public Subject(Integer subjectID) {
        this.subjectID = subjectID;
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

    public List<Attendence> getAttendenceList() {
        return attendenceList;
    }

    public void setAttendenceList(List<Attendence> attendenceList) {
        this.attendenceList = attendenceList;
    }

    public List<Teachersubject> getTeachersubjectList() {
        return teachersubjectList;
    }

    public void setTeachersubjectList(List<Teachersubject> teachersubjectList) {
        this.teachersubjectList = teachersubjectList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subjectID != null ? subjectID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subject)) {
            return false;
        }
        Subject other = (Subject) object;
        if ((this.subjectID == null && other.subjectID != null) || (this.subjectID != null && !this.subjectID.equals(other.subjectID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.data.Subject[ subjectID=" + subjectID + " ]";
    }
    
}
