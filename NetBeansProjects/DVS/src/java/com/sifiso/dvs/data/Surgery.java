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
import javax.persistence.Lob;
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
@Table(name = "surgery")
@NamedQueries({
    @NamedQuery(name = "Surgery.findAll", query = "SELECT s FROM Surgery s"),
    @NamedQuery(name = "Surgery.findBySurgeryID", query = "SELECT s FROM Surgery s WHERE s.surgeryID = :surgeryID"),
    @NamedQuery(name = "Surgery.findByName", query = "SELECT s FROM Surgery s WHERE s.name = :name"),
    @NamedQuery(name = "Surgery.findByCode", query = "SELECT s FROM Surgery s WHERE s.code = :code"),
    @NamedQuery(name = "Surgery.findByEmail", query = "SELECT s FROM Surgery s WHERE s.email = :email"),
    @NamedQuery(name = "Surgery.findByTel", query = "SELECT s FROM Surgery s WHERE s.tel = :tel"),
    @NamedQuery(name = "Surgery.findByLatitude", query = "SELECT s FROM Surgery s WHERE s.latitude = :latitude"),
    @NamedQuery(name = "Surgery.findByLongitude", query = "SELECT s FROM Surgery s WHERE s.longitude = :longitude")})
public class Surgery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "surgeryID")
    private Integer surgeryID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "CODE")
    private String code;
    @Lob
    @Size(max = 65535)
    @Column(name = "address")
    private String address;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "tel")
    private String tel;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "surgery")
    private List<Doctor> doctorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "surgery")
    private List<Receptionist> receptionistList;
    @JoinColumn(name = "townshipID", referencedColumnName = "townshipID")
    @ManyToOne(optional = false)
    private Township township;

    public Surgery() {
    }

    public Surgery(Integer surgeryID) {
        this.surgeryID = surgeryID;
    }

    public Surgery(Integer surgeryID, String name) {
        this.surgeryID = surgeryID;
        this.name = name;
    }

    public Integer getSurgeryID() {
        return surgeryID;
    }

    public void setSurgeryID(Integer surgeryID) {
        this.surgeryID = surgeryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    public List<Receptionist> getReceptionistList() {
        return receptionistList;
    }

    public void setReceptionistList(List<Receptionist> receptionistList) {
        this.receptionistList = receptionistList;
    }

    public Township getTownship() {
        return township;
    }

    public void setTownship(Township township) {
        this.township = township;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (surgeryID != null ? surgeryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Surgery)) {
            return false;
        }
        Surgery other = (Surgery) object;
        if ((this.surgeryID == null && other.surgeryID != null) || (this.surgeryID != null && !this.surgeryID.equals(other.surgeryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.dvs.data.Surgery[ surgeryID=" + surgeryID + " ]";
    }

}
