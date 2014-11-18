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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author CodeTribe1
 */
@Entity
@Table(name = "headmaster")
@NamedQueries({
    @NamedQuery(name = "Headmaster.findAll", query = "SELECT h FROM Headmaster h"),
    @NamedQuery(name = "Headmaster.findByHeadMasterID", query = "SELECT h FROM Headmaster h WHERE h.headMasterID = :headMasterID"),
    @NamedQuery(name = "Headmaster.findByName", query = "SELECT h FROM Headmaster h WHERE h.name = :name"),
    @NamedQuery(name = "Headmaster.findBySurname", query = "SELECT h FROM Headmaster h WHERE h.surname = :surname"),
    @NamedQuery(name = "Headmaster.findByIdNumber", query = "SELECT h FROM Headmaster h WHERE h.idNumber = :idNumber"),
    @NamedQuery(name = "Headmaster.findByEmail", query = "SELECT h FROM Headmaster h WHERE h.email = :email"),
    @NamedQuery(name = "Headmaster.findByCell", query = "SELECT h FROM Headmaster h WHERE h.cell = :cell"),
    @NamedQuery(name = "Headmaster.findByUsername", query = "SELECT h FROM Headmaster h WHERE h.username = :username"),
    @NamedQuery(name = "Headmaster.findByPassword", query = "SELECT h FROM Headmaster h WHERE h.password = :password")})
public class Headmaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "headMasterID")
    private Integer headMasterID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "surname")
    private String surname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "idNumber")
    private String idNumber;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "cell")
    private String cell;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "schoolID", referencedColumnName = "schoolID")
    @ManyToOne(optional = false)
    private School school;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "headmaster")
    private List<Gcmdevice> gcmdeviceList;

    public Headmaster() {
    }

    public Headmaster(Integer headMasterID) {
        this.headMasterID = headMasterID;
    }

    public Headmaster(Integer headMasterID, String name, String surname, String idNumber, String email, String cell, String username, String password) {
        this.headMasterID = headMasterID;
        this.name = name;
        this.surname = surname;
        this.idNumber = idNumber;
        this.email = email;
        this.cell = cell;
        this.username = username;
        this.password = password;
    }

    public Integer getHeadMasterID() {
        return headMasterID;
    }

    public void setHeadMasterID(Integer headMasterID) {
        this.headMasterID = headMasterID;
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

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }


    public List<Gcmdevice> getGcmdeviceList() {
        return gcmdeviceList;
    }

    public void setGcmdeviceList(List<Gcmdevice> gcmdeviceList) {
        this.gcmdeviceList = gcmdeviceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (headMasterID != null ? headMasterID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Headmaster)) {
            return false;
        }
        Headmaster other = (Headmaster) object;
        if ((this.headMasterID == null && other.headMasterID != null) || (this.headMasterID != null && !this.headMasterID.equals(other.headMasterID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.data.Headmaster[ headMasterID=" + headMasterID + " ]";
    }
    
}
