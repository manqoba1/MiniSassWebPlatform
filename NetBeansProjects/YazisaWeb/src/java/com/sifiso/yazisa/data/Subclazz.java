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
@Table(name = "subclazz")
@NamedQueries({
    @NamedQuery(name = "Subclazz.findAll", query = "SELECT s FROM Subclazz s"),
    @NamedQuery(name = "Subclazz.findBySubjectAndClass",
            query = "SELECT s FROM Subclazz s WHERE s.clazz.clazzID = :clazzID AND s.subject.subjectID = :subjectID"),
    @NamedQuery(name = "Subclazz.findBySubClazzID", query = "SELECT s FROM Subclazz s WHERE s.subClazzID = :subClazzID")})
public class Subclazz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "subClazzID")
    private Integer subClazzID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subclazz")
    private List<Teachersub> teachersubList;
    @JoinColumn(name = "subjectID", referencedColumnName = "subjectID")
    @ManyToOne(optional = false)
    private Subject subject;
    @JoinColumn(name = "clazzID", referencedColumnName = "clazzID")
    @ManyToOne(optional = false)
    private Clazz clazz;
    @JoinColumn(name = "learnersID", referencedColumnName = "learnersID")
    @ManyToOne(optional = false)
    private Learners learners;

    public Subclazz() {
    }

    public Subclazz(Integer subClazzID) {
        this.subClazzID = subClazzID;
    }

    public Integer getSubClazzID() {
        return subClazzID;
    }

    public void setSubClazzID(Integer subClazzID) {
        this.subClazzID = subClazzID;
    }

    public List<Teachersub> getTeachersubList() {
        return teachersubList;
    }

    public void setTeachersubList(List<Teachersub> teachersubList) {
        this.teachersubList = teachersubList;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
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
        hash += (subClazzID != null ? subClazzID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subclazz)) {
            return false;
        }
        Subclazz other = (Subclazz) object;
        if ((this.subClazzID == null && other.subClazzID != null) || (this.subClazzID != null && !this.subClazzID.equals(other.subClazzID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.data.Subclazz[ subClazzID=" + subClazzID + " ]";
    }

}
