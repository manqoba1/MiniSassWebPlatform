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
import javax.persistence.Lob;
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
@Table(name = "client")
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByClientID", query = "SELECT c FROM Client c WHERE c.clientID = :clientID"),
    @NamedQuery(name = "Client.findByName", query = "SELECT c FROM Client c WHERE c.name = :name"),
    @NamedQuery(name = "Client.findBySurname", query = "SELECT c FROM Client c WHERE c.surname = :surname"),
    @NamedQuery(name = "Client.findByEmail", query = "SELECT c FROM Client c WHERE c.email = :email"),
    @NamedQuery(name = "Client.findByTell", query = "SELECT c FROM Client c WHERE c.tell = :tell"),
    @NamedQuery(name = "Client.findByPin", query = "SELECT c FROM Client c WHERE c.pin = :pin"),
    @NamedQuery(name = "Client.findByStandNumber", query = "SELECT c FROM Client c WHERE c.standNumber = :standNumber")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "clientID")
    private Integer clientID;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "surname")
    private String surname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "tell")
    private String tell;
    @Size(max = 45)
    @Column(name = "pin")
    private String pin;
    @Lob
    @Size(max = 65535)
    @Column(name = "address")
    private String address;
    @Size(max = 45)
    @Column(name = "standNumber")
    private String standNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Medicalaid> medicalaidList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Patientfile> patientfileList;

    public Client() {
    }

    public Client(Integer clientID) {
        this.clientID = clientID;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStandNumber() {
        return standNumber;
    }

    public void setStandNumber(String standNumber) {
        this.standNumber = standNumber;
    }

    public List<Medicalaid> getMedicalaidList() {
        return medicalaidList;
    }

    public void setMedicalaidList(List<Medicalaid> medicalaidList) {
        this.medicalaidList = medicalaidList;
    }

    public List<Patientfile> getPatientfileList() {
        return patientfileList;
    }

    public void setPatientfileList(List<Patientfile> patientfileList) {
        this.patientfileList = patientfileList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientID != null ? clientID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.clientID == null && other.clientID != null) || (this.clientID != null && !this.clientID.equals(other.clientID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.dvs.data.Client[ clientID=" + clientID + " ]";
    }

}
