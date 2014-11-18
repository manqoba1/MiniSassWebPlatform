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
import javax.validation.constraints.NotNull;

/**
 *
 * @author CodeTribe1
 */
@Entity
@Table(name = "absentee")
@NamedQueries({
    @NamedQuery(name = "Absentee.findAll", query = "SELECT a FROM Absentee a"),
    @NamedQuery(name = "Absentee.findByAbsenteeID", query = "SELECT a FROM Absentee a WHERE a.absenteeID = :absenteeID"),
    @NamedQuery(name = "Absentee.findByAbsentDate", query = "SELECT a FROM Absentee a WHERE a.absentDate = :absentDate"),
    @NamedQuery(name = "Absentee.findByLateForClass", query = "SELECT a FROM Absentee a WHERE a.lateForClass = :lateForClass")})
public class Absentee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "absenteeID")
    private Integer absenteeID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "absentDate")
    @Temporal(TemporalType.DATE)
    private Date absentDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lateForClass")
    private int lateForClass;
    @JoinColumn(name = "clazzLearnerID", referencedColumnName = "clazzLearnerID")
    @ManyToOne(optional = false)
    private Clazzlearner clazzLearner;

    public Absentee() {
    }

    public Absentee(Integer absenteeID) {
        this.absenteeID = absenteeID;
    }

    public Absentee(Integer absenteeID, Date absentDate, int lateForClass) {
        this.absenteeID = absenteeID;
        this.absentDate = absentDate;
        this.lateForClass = lateForClass;
    }

    public Integer getAbsenteeID() {
        return absenteeID;
    }

    public void setAbsenteeID(Integer absenteeID) {
        this.absenteeID = absenteeID;
    }

    public Date getAbsentDate() {
        return absentDate;
    }

    public void setAbsentDate(Date absentDate) {
        this.absentDate = absentDate;
    }

    public int getLateForClass() {
        return lateForClass;
    }

    public void setLateForClass(int lateForClass) {
        this.lateForClass = lateForClass;
    }

    public Clazzlearner getClazzLearner() {
        return clazzLearner;
    }

    public void setClazzLearner(Clazzlearner clazzLearner) {
        this.clazzLearner = clazzLearner;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (absenteeID != null ? absenteeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Absentee)) {
            return false;
        }
        Absentee other = (Absentee) object;
        if ((this.absenteeID == null && other.absenteeID != null) || (this.absenteeID != null && !this.absenteeID.equals(other.absenteeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.data.Absentee[ absenteeID=" + absenteeID + " ]";
    }

}
