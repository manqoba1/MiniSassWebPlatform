/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.dvs.data;

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
@Table(name = "doctortype")
@NamedQueries({
    @NamedQuery(name = "Doctortype.findAll", query = "SELECT d FROM Doctortype d"),
    @NamedQuery(name = "Doctortype.findByDoctorTypeID", query = "SELECT d FROM Doctortype d WHERE d.doctorTypeID = :doctorTypeID"),
    @NamedQuery(name = "Doctortype.findByName", query = "SELECT d FROM Doctortype d WHERE d.name = :name")})
public class Doctortype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "doctorTypeID")
    private Integer doctorTypeID;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctorType")
    private List<Doctor> doctorList;

    public Doctortype() {
    }

    public Doctortype(Integer doctorTypeID) {
        this.doctorTypeID = doctorTypeID;
    }

    public Integer getDoctorTypeID() {
        return doctorTypeID;
    }

    public void setDoctorTypeID(Integer doctorTypeID) {
        this.doctorTypeID = doctorTypeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doctorTypeID != null ? doctorTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctortype)) {
            return false;
        }
        Doctortype other = (Doctortype) object;
        if ((this.doctorTypeID == null && other.doctorTypeID != null) || (this.doctorTypeID != null && !this.doctorTypeID.equals(other.doctorTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.dvs.data.Doctortype[ doctorTypeID=" + doctorTypeID + " ]";
    }
    
}
