/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.minisass.data;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "evaluationImage")
@NamedQueries({
    @NamedQuery(name = "EvaluationImage.findAll", query = "SELECT e FROM EvaluationImage e"),
    @NamedQuery(name = "EvaluationImage.findByEvaluationImageID", query = "SELECT e FROM EvaluationImage e WHERE e.evaluationImageID = :evaluationImageID"),
    @NamedQuery(name = "EvaluationImage.findByDateTaken", query = "SELECT e FROM EvaluationImage e WHERE e.dateTaken = :dateTaken"),
    @NamedQuery(name = "EvaluationImage.findByFileName", query = "SELECT e FROM EvaluationImage e WHERE e.fileName = :fileName")})
public class EvaluationImage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "evaluationImageID")
    private Integer evaluationImageID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateTaken")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTaken;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "fileName")
    private String fileName;
    @JoinColumn(name = "evaluationID", referencedColumnName = "evaluationID")
    @ManyToOne(optional = false)
    private Evaluation evaluation;

    public EvaluationImage() {
    }

    public EvaluationImage(Integer evaluationImageID) {
        this.evaluationImageID = evaluationImageID;
    }

    public EvaluationImage(Integer evaluationImageID, Date dateTaken, String fileName) {
        this.evaluationImageID = evaluationImageID;
        this.dateTaken = dateTaken;
        this.fileName = fileName;
    }

    public Integer getEvaluationImageID() {
        return evaluationImageID;
    }

    public void setEvaluationImageID(Integer evaluationImageID) {
        this.evaluationImageID = evaluationImageID;
    }

    public Date getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluationImageID != null ? evaluationImageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluationImage)) {
            return false;
        }
        EvaluationImage other = (EvaluationImage) object;
        if ((this.evaluationImageID == null && other.evaluationImageID != null) || (this.evaluationImageID != null && !this.evaluationImageID.equals(other.evaluationImageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.minisass.data.EvaluationImage[ evaluationImageID=" + evaluationImageID + " ]";
    }
    
}
