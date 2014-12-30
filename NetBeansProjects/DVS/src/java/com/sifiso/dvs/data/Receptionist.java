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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "receptionist")
@NamedQueries({
    @NamedQuery(name = "Receptionist.findAll", query = "SELECT r FROM Receptionist r"),
     @NamedQuery(name = "Receptionist.loginReception", 
             query = "SELECT r FROM Receptionist r WHERE r.email = :email AND r.pin = :pin"),
    @NamedQuery(name = "Receptionist.findByReceptionistID", query = "SELECT r FROM Receptionist r WHERE r.receptionistID = :receptionistID"),
    @NamedQuery(name = "Receptionist.findByName", query = "SELECT r FROM Receptionist r WHERE r.name = :name"),
    @NamedQuery(name = "Receptionist.findBySurname", query = "SELECT r FROM Receptionist r WHERE r.surname = :surname"),
    @NamedQuery(name = "Receptionist.findByEmail", query = "SELECT r FROM Receptionist r WHERE r.email = :email"),
    @NamedQuery(name = "Receptionist.findByTell", query = "SELECT r FROM Receptionist r WHERE r.tell = :tell"),
    @NamedQuery(name = "Receptionist.findByPin", query = "SELECT r FROM Receptionist r WHERE r.pin = :pin")})
public class Receptionist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "receptionistID")
    private Integer receptionistID;
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
    @JoinColumn(name = "surgeryID", referencedColumnName = "surgeryID")
    @ManyToOne(optional = false)
    private Surgery surgery;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receptionist")
    private List<Visit> visitList;

    public Receptionist() {
    }

    public Receptionist(Integer receptionistID) {
        this.receptionistID = receptionistID;
    }

    public Integer getReceptionistID() {
        return receptionistID;
    }

    public void setReceptionistID(Integer receptionistID) {
        this.receptionistID = receptionistID;
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

    public Surgery getSurgery() {
        return surgery;
    }

    public void setSurgery(Surgery surgery) {
        this.surgery = surgery;
    }

    public List<Visit> getVisitList() {
        return visitList;
    }

    public void setVisitList(List<Visit> visitList) {
        this.visitList = visitList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (receptionistID != null ? receptionistID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receptionist)) {
            return false;
        }
        Receptionist other = (Receptionist) object;
        if ((this.receptionistID == null && other.receptionistID != null) || (this.receptionistID != null && !this.receptionistID.equals(other.receptionistID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.dvs.data.Receptionist[ receptionistID=" + receptionistID + " ]";
    }

}
