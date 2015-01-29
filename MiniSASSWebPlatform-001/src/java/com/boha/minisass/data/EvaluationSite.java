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

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "evaluationSite")
@NamedQueries({
    @NamedQuery(name = "EvaluationSite.findAll", query = "SELECT e FROM EvaluationSite e"),
    @NamedQuery(name = "EvaluationSite.findByEvaluationSiteID", query = "SELECT e FROM EvaluationSite e WHERE e.evaluationSiteID = :evaluationSiteID"),
    @NamedQuery(name = "EvaluationSite.findByLatitude", query = "SELECT e FROM EvaluationSite e WHERE e.latitude = :latitude"),
    @NamedQuery(name = "EvaluationSite.findByLongitude", query = "SELECT e FROM EvaluationSite e WHERE e.longitude = :longitude"),
    @NamedQuery(name = "EvaluationSite.findByDateRegistered", query = "SELECT e FROM EvaluationSite e WHERE e.dateRegistered = :dateRegistered")})
public class EvaluationSite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "evaluationSiteID")
    private Integer evaluationSiteID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitude")
    private double latitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitude")
    private double longitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @JoinColumn(name = "categoryID", referencedColumnName = "categoryID")
    @ManyToOne(optional = false)
    private Category category;
    @JoinColumn(name = "riverID", referencedColumnName = "riverID")
    @ManyToOne(optional = false)
    private River river;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluationSite")
    private List<Evaluation> evaluationList;

    public EvaluationSite() {
    }

    public EvaluationSite(Integer evaluationSiteID) {
        this.evaluationSiteID = evaluationSiteID;
    }

    public EvaluationSite(Integer evaluationSiteID, double latitude, double longitude, Date dateRegistered) {
        this.evaluationSiteID = evaluationSiteID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dateRegistered = dateRegistered;
    }

    public Integer getEvaluationSiteID() {
        return evaluationSiteID;
    }

    public void setEvaluationSiteID(Integer evaluationSiteID) {
        this.evaluationSiteID = evaluationSiteID;
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

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public River getRiver() {
        return river;
    }

    public void setRiver(River river) {
        this.river = river;
    }

    public List<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluation> evaluationList) {
        this.evaluationList = evaluationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluationSiteID != null ? evaluationSiteID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluationSite)) {
            return false;
        }
        EvaluationSite other = (EvaluationSite) object;
        if ((this.evaluationSiteID == null && other.evaluationSiteID != null) || (this.evaluationSiteID != null && !this.evaluationSiteID.equals(other.evaluationSiteID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.minisass.data.EvaluationSite[ evaluationSiteID=" + evaluationSiteID + " ]";
    }
    
}
