/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sifiso.yazisa.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author CodeTribe1
 */
@Entity
@Table(name = "servererror")
@NamedQueries({
    @NamedQuery(name = "Servererror.findAll", query = "SELECT s FROM Servererror s"),
    @NamedQuery(name = "Servererror.findByServerErrorID", query = "SELECT s FROM Servererror s WHERE s.serverErrorID = :serverErrorID"),
    @NamedQuery(name = "Servererror.findByStatusCode", query = "SELECT s FROM Servererror s WHERE s.statusCode = :statusCode"),
    @NamedQuery(name = "Servererror.findByDateOccured", query = "SELECT s FROM Servererror s WHERE s.dateOccured = :dateOccured"),
    @NamedQuery(name = "Servererror.findByOrigin", query = "SELECT s FROM Servererror s WHERE s.origin = :origin")})
public class Servererror implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "serverErrorID")
    private Integer serverErrorID;
    @Column(name = "statusCode")
    private Integer statusCode;
    @Lob
    @Size(max = 65535)
    @Column(name = "message")
    private String message;
    @Column(name = "dateOccured")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOccured;
    @Size(max = 255)
    @Column(name = "origin")
    private String origin;

    public Servererror() {
    }

    public Servererror(Integer serverErrorID) {
        this.serverErrorID = serverErrorID;
    }

    public Integer getServerErrorID() {
        return serverErrorID;
    }

    public void setServerErrorID(Integer serverErrorID) {
        this.serverErrorID = serverErrorID;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateOccured() {
        return dateOccured;
    }

    public void setDateOccured(Date dateOccured) {
        this.dateOccured = dateOccured;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serverErrorID != null ? serverErrorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servererror)) {
            return false;
        }
        Servererror other = (Servererror) object;
        if ((this.serverErrorID == null && other.serverErrorID != null) || (this.serverErrorID != null && !this.serverErrorID.equals(other.serverErrorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.data.Servererror[ serverErrorID=" + serverErrorID + " ]";
    }
    
}
