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
@Table(name = "school")
@NamedQueries({
    @NamedQuery(name = "School.findAll", query = "SELECT s FROM School s"),
    @NamedQuery(name = "School.findBySchoolID", query = "SELECT s FROM School s WHERE s.schoolID = :schoolID"),
    @NamedQuery(name = "School.findBySchoolName", query = "SELECT s FROM School s WHERE s.schoolName = :schoolName"),
    @NamedQuery(name = "School.findByLatitude", query = "SELECT s FROM School s WHERE s.latitude = :latitude"),
    @NamedQuery(name = "School.findByLongitude", query = "SELECT s FROM School s WHERE s.longitude = :longitude"),
    @NamedQuery(name = "School.findByTell", query = "SELECT s FROM School s WHERE s.tell = :tell"),
    @NamedQuery(name = "School.findByAddress", query = "SELECT s FROM School s WHERE s.address = :address"),
    @NamedQuery(name = "School.findByPostalCode", query = "SELECT s FROM School s WHERE s.postalCode = :postalCode"),
    @NamedQuery(name = "School.findByEmail", query = "SELECT s FROM School s WHERE s.email = :email")})
public class School implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "schoolID")
    private Integer schoolID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 225)
    @Column(name = "schoolName")
    private String schoolName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitude")
    private double latitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitude")
    private double longitude;
    @Size(max = 45)
    @Column(name = "tell")
    private String tell;
    @Size(max = 45)
    @Column(name = "address")
    private String address;
    @Size(max = 45)
    @Column(name = "postalCode")
    private String postalCode;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
    private List<Deviceerror> deviceerrorList;
    @JoinColumn(name = "townshipID", referencedColumnName = "townshipID")
    @ManyToOne(optional = false)
    private Township township;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
    private List<Clazz> clazzList;

    public School() {
    }

    public School(Integer schoolID) {
        this.schoolID = schoolID;
    }

    public School(Integer schoolID, String schoolName, double latitude, double longitude) {
        this.schoolID = schoolID;
        this.schoolName = schoolName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(Integer schoolID) {
        this.schoolID = schoolID;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Deviceerror> getDeviceerrorList() {
        return deviceerrorList;
    }

    public void setDeviceerrorList(List<Deviceerror> deviceerrorList) {
        this.deviceerrorList = deviceerrorList;
    }

    public Township getTownship() {
        return township;
    }

    public void setTownship(Township township) {
        this.township = township;
    }

    public List<Clazz> getClazzList() {
        return clazzList;
    }

    public void setClazzList(List<Clazz> clazzList) {
        this.clazzList = clazzList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (schoolID != null ? schoolID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof School)) {
            return false;
        }
        School other = (School) object;
        if ((this.schoolID == null && other.schoolID != null) || (this.schoolID != null && !this.schoolID.equals(other.schoolID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.data.School[ schoolID=" + schoolID + " ]";
    }

}
