/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sifiso.yazisa.data;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author CodeTribe1
 */
@Entity
@Table(name = "exammark")
@NamedQueries({
    @NamedQuery(name = "Exammark.findAll", query = "SELECT e FROM Exammark e"),
    @NamedQuery(name = "Exammark.findByExamMarkID", query = "SELECT e FROM Exammark e WHERE e.examMarkID = :examMarkID"),
    @NamedQuery(name = "Exammark.findByMark", query = "SELECT e FROM Exammark e WHERE e.mark = :mark"),
    @NamedQuery(name = "Exammark.findByPassFail", query = "SELECT e FROM Exammark e WHERE e.passFail = :passFail"),
    @NamedQuery(name = "Exammark.findByDateRegistered", query = "SELECT e FROM Exammark e WHERE e.dateRegistered = :dateRegistered")})
public class Exammark implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "examMarkID")
    private Integer examMarkID;
    @Column(name = "mark")
    private Integer mark;
    @Column(name = "passFail")
    private Integer passFail;
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @JoinColumn(name = "examID", referencedColumnName = "examID")
    @ManyToOne
    private Exam exam;
    @JoinColumn(name = "learnersID", referencedColumnName = "learnersID")
    @ManyToOne
    private Learners learners;

    public Exammark() {
    }

    public Exammark(Integer examMarkID) {
        this.examMarkID = examMarkID;
    }

    public Integer getExamMarkID() {
        return examMarkID;
    }

    public void setExamMarkID(Integer examMarkID) {
        this.examMarkID = examMarkID;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Integer getPassFail() {
        return passFail;
    }

    public void setPassFail(Integer passFail) {
        this.passFail = passFail;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Learners getLearners() {
        return learners;
    }

    public void setLearners(Learners learners) {
        this.learners = learners;
    }

  
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (examMarkID != null ? examMarkID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exammark)) {
            return false;
        }
        Exammark other = (Exammark) object;
        if ((this.examMarkID == null && other.examMarkID != null) || (this.examMarkID != null && !this.examMarkID.equals(other.examMarkID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.data.Exammark[ examMarkID=" + examMarkID + " ]";
    }
    
}
