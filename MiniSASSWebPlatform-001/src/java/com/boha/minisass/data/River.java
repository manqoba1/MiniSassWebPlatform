/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.minisass.data;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "river")
@NamedQueries({
    @NamedQuery(name = "River.findAll", query = "SELECT r FROM River r"),
    @NamedQuery(name = "River.findByRiverID", query = "SELECT r FROM River r WHERE r.riverID = :riverID"),
    @NamedQuery(name = "River.findByRiverName", query = "SELECT r FROM River r WHERE r.riverName = :riverName"),
    @NamedQuery(name = "River.findByOriginLatitude", query = "SELECT r FROM River r WHERE r.originLatitude = :originLatitude"),
    @NamedQuery(name = "River.findByOriginLongitude", query = "SELECT r FROM River r WHERE r.originLongitude = :originLongitude"),
    @NamedQuery(name = "River.findByEndLatitude", query = "SELECT r FROM River r WHERE r.endLatitude = :endLatitude"),
    @NamedQuery(name = "River.findByEndLongitude", query = "SELECT r FROM River r WHERE r.endLongitude = :endLongitude"),
    @NamedQuery(name = "River.findByDateRegistered", query = "SELECT r FROM River r WHERE r.dateRegistered = :dateRegistered")})
public class River implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "riverID")
    private Integer riverID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "riverName")
    private String riverName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "originLatitude")
    private Double originLatitude;
    @Column(name = "originLongitude")
    private Double originLongitude;
    @Column(name = "endLatitude")
    private Double endLatitude;
    @Column(name = "endLongitude")
    private Double endLongitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "river")
    private List<RiverTown> riverTownList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "river")
    private List<EvaluationSite> evaluationSiteList;
    @JoinColumn(name = "originCountryID", referencedColumnName = "countryID")
    @ManyToOne
    private Country originCountry;
    @JoinColumn(name = "endCountryID", referencedColumnName = "countryID")
    @ManyToOne
    private Country endCountry;

    public River() {
    }

    public River(Integer riverID) {
        this.riverID = riverID;
    }

    public River(Integer riverID, String riverName, Date dateRegistered) {
        this.riverID = riverID;
        this.riverName = riverName;
        this.dateRegistered = dateRegistered;
    }

    public Integer getRiverID() {
        return riverID;
    }

    public void setRiverID(Integer riverID) {
        this.riverID = riverID;
    }

    public String getRiverName() {
        return riverName;
    }

    public void setRiverName(String riverName) {
        this.riverName = riverName;
    }

    public Double getOriginLatitude() {
        return originLatitude;
    }

    public void setOriginLatitude(Double originLatitude) {
        this.originLatitude = originLatitude;
    }

    public Double getOriginLongitude() {
        return originLongitude;
    }

    public void setOriginLongitude(Double originLongitude) {
        this.originLongitude = originLongitude;
    }

    public Double getEndLatitude() {
        return endLatitude;
    }

    public void setEndLatitude(Double endLatitude) {
        this.endLatitude = endLatitude;
    }

    public Double getEndLongitude() {
        return endLongitude;
    }

    public void setEndLongitude(Double endLongitude) {
        this.endLongitude = endLongitude;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public List<RiverTown> getRiverTownList() {
        return riverTownList;
    }

    public void setRiverTownList(List<RiverTown> riverTownList) {
        this.riverTownList = riverTownList;
    }

    public List<EvaluationSite> getEvaluationSiteList() {
        return evaluationSiteList;
    }

    public void setEvaluationSiteList(List<EvaluationSite> evaluationSiteList) {
        this.evaluationSiteList = evaluationSiteList;
    }

    public Country getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(Country originCountry) {
        this.originCountry = originCountry;
    }

    public Country getEndCountry() {
        return endCountry;
    }

    public void setEndCountry(Country endCountry) {
        this.endCountry = endCountry;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (riverID != null ? riverID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof River)) {
            return false;
        }
        River other = (River) object;
        if ((this.riverID == null && other.riverID != null) || (this.riverID != null && !this.riverID.equals(other.riverID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.minisass.data.River[ riverID=" + riverID + " ]";
    }
    
}
