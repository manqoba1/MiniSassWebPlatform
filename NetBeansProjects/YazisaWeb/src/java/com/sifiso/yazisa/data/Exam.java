/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author CodeTribe1
 */
@Entity
@Table(name = "exam")
@NamedQueries({
    @NamedQuery(name = "Exam.findAll", query = "SELECT e FROM Exam e"),
    @NamedQuery(name = "Exam.findByExamID", query = "SELECT e FROM Exam e WHERE e.examID = :examID"),
    @NamedQuery(name = "Exam.findByExamDate", query = "SELECT e FROM Exam e WHERE e.examDate = :examDate"),
    @NamedQuery(name = "Exam.findByDescription", query = "SELECT e FROM Exam e WHERE e.description = :description"),
    @NamedQuery(name = "Exam.findByCourseName", query = "SELECT e FROM Exam e WHERE e.courseName = :courseName"),
    @NamedQuery(name = "Exam.findByTotalMarks", query = "SELECT e FROM Exam e WHERE e.totalMarks = :totalMarks")})
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "examID")
    private Integer examID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "examDate")
    @Temporal(TemporalType.DATE)
    private Date examDate;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "courseName")
    private String courseName;
    @Column(name = "totalMarks")
    private Integer totalMarks;
    @JoinColumn(name = "clazzID", referencedColumnName = "clazzID")
    @ManyToOne(optional = false)
    private Clazz clazz;
    @JoinColumn(name = "teacherID", referencedColumnName = "teacherID")
    @ManyToOne(optional = false)
    private Teachers teacher;
    @OneToMany(mappedBy = "exam")
    private List<Exammark> exammarkList;

    public Exam() {
    }

    public Exam(Integer examID) {
        this.examID = examID;
    }

    public Exam(Integer examID, Date examDate, String courseName) {
        this.examID = examID;
        this.examDate = examDate;
        this.courseName = courseName;
    }

    public Integer getExamID() {
        return examID;
    }

    public void setExamID(Integer examID) {
        this.examID = examID;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(Integer totalMarks) {
        this.totalMarks = totalMarks;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Teachers getTeacher() {
        return teacher;
    }

    public void setTeacher(Teachers teacher) {
        this.teacher = teacher;
    }

    public List<Exammark> getExammarkList() {
        return exammarkList;
    }

    public void setExammarkList(List<Exammark> exammarkList) {
        this.exammarkList = exammarkList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (examID != null ? examID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exam)) {
            return false;
        }
        Exam other = (Exam) object;
        if ((this.examID == null && other.examID != null) || (this.examID != null && !this.examID.equals(other.examID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.data.Exam[ examID=" + examID + " ]";
    }

}
