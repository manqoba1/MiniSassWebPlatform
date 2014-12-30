/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.dvs.data;

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
import javax.validation.constraints.Size;

/**
 *
 * @author CodeTribe1
 */
@Entity
@Table(name = "visit")
@NamedQueries({
    @NamedQuery(name = "Visit.findAll", query = "SELECT v FROM Visit v"),
    @NamedQuery(name = "Visit.findByReceptionistID",
            query = "SELECT v FROM Visit v WHERE  v.receptionist.receptionistID = :id"),
    @NamedQuery(name = "Visit.findByDoctorID",
            query = "SELECT v FROM Visit v WHERE  v.doctor.doctorID = :id"),    
    @NamedQuery(name = "Visit.findByVisitID", query = "SELECT v FROM Visit v WHERE v.visitID = :visitID"),
    @NamedQuery(name = "Visit.findByDateMade", query = "SELECT v FROM Visit v WHERE v.dateMade = :dateMade"),
    @NamedQuery(name = "Visit.findByFlag", query = "SELECT v FROM Visit v WHERE v.flag = :flag"),
    @NamedQuery(name = "Visit.findByVisitedDate", query = "SELECT v FROM Visit v WHERE v.visitedDate = :visitedDate"),
    @NamedQuery(name = "Visit.findByPaymentType", query = "SELECT v FROM Visit v WHERE v.paymentType = :paymentType")})
public class Visit implements Serializable {

    @JoinColumn(name = "patientfileID", referencedColumnName = "patientFileID")
    @ManyToOne(optional = false)
    private Patientfile patientfile;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "visitID")
    private Integer visitID;
    @Column(name = "dateMade")
    @Temporal(TemporalType.DATE)
    private Date dateMade;
    @Column(name = "flag")
    private Integer flag;
    @Column(name = "visitedDate")
    @Temporal(TemporalType.DATE)
    private Date visitedDate;
    @Size(max = 255)
    @Column(name = "paymentType")
    private String paymentType;
    @JoinColumn(name = "doctorID", referencedColumnName = "doctorID")
    @ManyToOne(optional = false)
    private Doctor doctor;
    @JoinColumn(name = "receptionistID", referencedColumnName = "receptionistID")
    @ManyToOne(optional = false)
    private Receptionist receptionist;

    public Visit() {
    }

    public Visit(Integer visitID) {
        this.visitID = visitID;
    }

    public Integer getVisitID() {
        return visitID;
    }

    public void setVisitID(Integer visitID) {
        this.visitID = visitID;
    }

    public Date getDateMade() {
        return dateMade;
    }

    public void setDateMade(Date dateMade) {
        this.dateMade = dateMade;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Date getVisitedDate() {
        return visitedDate;
    }

    public void setVisitedDate(Date visitedDate) {
        this.visitedDate = visitedDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Receptionist getReceptionist() {
        return receptionist;
    }

    public void setReceptionist(Receptionist receptionist) {
        this.receptionist = receptionist;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (visitID != null ? visitID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visit)) {
            return false;
        }
        Visit other = (Visit) object;
        if ((this.visitID == null && other.visitID != null) || (this.visitID != null && !this.visitID.equals(other.visitID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.dvs.data.Visit[ visitID=" + visitID + " ]";
    }

    public Patientfile getPatientfile() {
        return patientfile;
    }

    public void setPatientfile(Patientfile patientfile) {
        this.patientfile = patientfile;
    }

}
