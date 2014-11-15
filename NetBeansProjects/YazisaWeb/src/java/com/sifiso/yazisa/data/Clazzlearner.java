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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author CodeTribe1
 */
@Entity
@Table(name = "clazzlearner")
@NamedQueries({
    @NamedQuery(name = "Clazzlearner.findAll", query = "SELECT c FROM Clazzlearner c"),
    @NamedQuery(name = "Clazzlearner.findByClazzLearnerID", query = "SELECT c FROM Clazzlearner c WHERE c.clazzLearnerID = :clazzLearnerID")})
public class Clazzlearner implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "clazzLearnerID")
    private Integer clazzLearnerID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clazzLearner")
    private List<Absentee> absenteeList;
    @JoinColumn(name = "learnersID", referencedColumnName = "learnersID")
    @ManyToOne(optional = false)
    private Learners learners;
    @JoinColumn(name = "clazzID", referencedColumnName = "clazzID")
    @ManyToOne(optional = false)
    private Clazz clazz;

    public Clazzlearner() {
    }

    public Clazzlearner(Integer clazzLearnerID) {
        this.clazzLearnerID = clazzLearnerID;
    }

    public Integer getClazzLearnerID() {
        return clazzLearnerID;
    }

    public void setClazzLearnerID(Integer clazzLearnerID) {
        this.clazzLearnerID = clazzLearnerID;
    }

    public List<Absentee> getAbsenteeList() {
        return absenteeList;
    }

    public void setAbsenteeList(List<Absentee> absenteeList) {
        this.absenteeList = absenteeList;
    }

    public Learners getLearners() {
        return learners;
    }

    public void setLearners(Learners learners) {
        this.learners = learners;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clazzLearnerID != null ? clazzLearnerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clazzlearner)) {
            return false;
        }
        Clazzlearner other = (Clazzlearner) object;
        if ((this.clazzLearnerID == null && other.clazzLearnerID != null) || (this.clazzLearnerID != null && !this.clazzLearnerID.equals(other.clazzLearnerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.data.Clazzlearner[ clazzLearnerID=" + clazzLearnerID + " ]";
    }

}
