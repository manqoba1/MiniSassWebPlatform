/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.dvs.data;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author CodeTribe1
 */
@Entity
@Table(name = "patientfile")
@NamedQueries({
    @NamedQuery(name = "Patientfile.findAll", query = "SELECT p FROM Patientfile p"),
    @NamedQuery(name = "Patientfile.findClientByStdDocIDSurgID", 
            query = "SELECT p FROM Patientfile p WHERE p.client.standNumber = :stnd AND p.doctor.doctorID = :doctorID AND p.doctor.surgery.surgeryID =:surgeryID"),
    @NamedQuery(name = "Patientfile.findClientByClientIDDocIDSurgID", 
            query = "SELECT p FROM Patientfile p WHERE p.client.clientID = :clientID AND p.doctor.doctorID = :doctorID AND p.doctor.surgery.surgeryID =:surgeryID"),    
    @NamedQuery(name = "Patientfile.findByDoctor", query = "SELECT p FROM Patientfile p WHERE p.doctor.doctorID = :id"),
    @NamedQuery(name = "Patientfile.findByPatientFileID", query = "SELECT p FROM Patientfile p WHERE p.patientFileID = :patientFileID"),
    @NamedQuery(name = "Patientfile.findByFileUrl", query = "SELECT p FROM Patientfile p WHERE p.fileUrl = :fileUrl"),
    @NamedQuery(name = "Patientfile.findByDateMade", query = "SELECT p FROM Patientfile p WHERE p.dateMade = :dateMade")})
public class Patientfile implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientfile")
    private List<Visit> visitList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patientFileID")
    private Integer patientFileID;
    @Size(max = 1000)
    @Column(name = "fileUrl")
    private String fileUrl;
    @Column(name = "dateMade")
    @Temporal(TemporalType.DATE)
    private Date dateMade;
    @JoinColumn(name = "clientID", referencedColumnName = "clientID")
    @ManyToOne(optional = false)
    private Client client;
    @JoinColumn(name = "doctorID", referencedColumnName = "doctorID")
    @ManyToOne(optional = false)
    private Doctor doctor;

    public Patientfile() {
    }

    public Patientfile(Integer patientFileID) {
        this.patientFileID = patientFileID;
    }

    public Integer getPatientFileID() {
        return patientFileID;
    }

    public void setPatientFileID(Integer patientFileID) {
        this.patientFileID = patientFileID;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Date getDateMade() {
        return dateMade;
    }

    public void setDateMade(Date dateMade) {
        this.dateMade = dateMade;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientFileID != null ? patientFileID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patientfile)) {
            return false;
        }
        Patientfile other = (Patientfile) object;
        if ((this.patientFileID == null && other.patientFileID != null) || (this.patientFileID != null && !this.patientFileID.equals(other.patientFileID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.dvs.data.Patientfile[ patientFileID=" + patientFileID + " ]";
    }

    public List<Visit> getVisitList() {
        return visitList;
    }

    public void setVisitList(List<Visit> visitList) {
        this.visitList = visitList;
    }

}
