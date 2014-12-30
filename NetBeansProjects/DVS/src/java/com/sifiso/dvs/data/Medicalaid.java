/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.dvs.data;

import java.io.Serializable;
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
import javax.validation.constraints.Size;

/**
 *
 * @author CodeTribe1
 */
@Entity
@Table(name = "medicalaid")
@NamedQueries({
    @NamedQuery(name = "Medicalaid.findAll", query = "SELECT m FROM Medicalaid m"),
    @NamedQuery(name = "Medicalaid.findByMedicalAidID", query = "SELECT m FROM Medicalaid m WHERE m.medicalAidID = :medicalAidID"),
    @NamedQuery(name = "Medicalaid.findByName", query = "SELECT m FROM Medicalaid m WHERE m.name = :name"),
    @NamedQuery(name = "Medicalaid.findByMemberNumber", query = "SELECT m FROM Medicalaid m WHERE m.memberNumber = :memberNumber"),
    @NamedQuery(name = "Medicalaid.findByOption", query = "SELECT m FROM Medicalaid m WHERE m.aidOption = :aidOption"),
    @NamedQuery(name = "Medicalaid.findByClientType", query = "SELECT m FROM Medicalaid m WHERE m.clientType = :clientType"),
    @NamedQuery(name = "Medicalaid.findByGender", query = "SELECT m FROM Medicalaid m WHERE m.gender = :gender")})
public class Medicalaid implements Serializable {

    @Size(max = 255)
    @Column(name = "aidOption")
    private String aidOption;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "medicalAidID")
    private Integer medicalAidID;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "memberNumber")
    private String memberNumber;

    @Size(max = 255)
    @Column(name = "clientType")
    private String clientType;
    @Column(name = "gender")
    private Integer gender;
    @JoinColumn(name = "clientID", referencedColumnName = "clientID")
    @ManyToOne(optional = false)
    private Client client;

    public Medicalaid() {
    }

    public Medicalaid(Integer medicalAidID) {
        this.medicalAidID = medicalAidID;
    }

    public Integer getMedicalAidID() {
        return medicalAidID;
    }

    public void setMedicalAidID(Integer medicalAidID) {
        this.medicalAidID = medicalAidID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }

  

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicalAidID != null ? medicalAidID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicalaid)) {
            return false;
        }
        Medicalaid other = (Medicalaid) object;
        if ((this.medicalAidID == null && other.medicalAidID != null) || (this.medicalAidID != null && !this.medicalAidID.equals(other.medicalAidID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.dvs.data.Medicalaid[ medicalAidID=" + medicalAidID + " ]";
    }

    public String getAidOption() {
        return aidOption;
    }

    public void setAidOption(String aidOption) {
        this.aidOption = aidOption;
    }

}
