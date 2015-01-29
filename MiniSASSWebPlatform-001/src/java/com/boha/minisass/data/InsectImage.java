/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.minisass.data;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "insectImage")
@NamedQueries({
    @NamedQuery(name = "InsectImage.findAll", query = "SELECT i FROM InsectImage i"),
    @NamedQuery(name = "InsectImage.findByInsectImageID", query = "SELECT i FROM InsectImage i WHERE i.insectImageID = :insectImageID"),
    @NamedQuery(name = "InsectImage.findByUri", query = "SELECT i FROM InsectImage i WHERE i.uri = :uri"),
    @NamedQuery(name = "InsectImage.findByDateRegistered", query = "SELECT i FROM InsectImage i WHERE i.dateRegistered = :dateRegistered")})
public class InsectImage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "insectImageID")
    private Integer insectImageID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "uri")
    private String uri;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @JoinColumn(name = "insectID", referencedColumnName = "insectID")
    @ManyToOne(optional = false)
    private Insect insect;

    public InsectImage() {
    }

    public InsectImage(Integer insectImageID) {
        this.insectImageID = insectImageID;
    }

    public InsectImage(Integer insectImageID, String uri, Date dateRegistered) {
        this.insectImageID = insectImageID;
        this.uri = uri;
        this.dateRegistered = dateRegistered;
    }

    public Integer getInsectImageID() {
        return insectImageID;
    }

    public void setInsectImageID(Integer insectImageID) {
        this.insectImageID = insectImageID;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public Insect getInsect() {
        return insect;
    }

    public void setInsect(Insect insect) {
        this.insect = insect;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (insectImageID != null ? insectImageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InsectImage)) {
            return false;
        }
        InsectImage other = (InsectImage) object;
        if ((this.insectImageID == null && other.insectImageID != null) || (this.insectImageID != null && !this.insectImageID.equals(other.insectImageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.minisass.data.InsectImage[ insectImageID=" + insectImageID + " ]";
    }
    
}
