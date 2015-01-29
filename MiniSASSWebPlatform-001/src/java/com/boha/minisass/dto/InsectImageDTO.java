/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.minisass.dto;

import com.boha.minisass.data.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author aubreyM
 */
public class InsectImageDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer insectImageID;
    private String uri;
    private Date dateRegistered;
    private Integer insectID;

    public InsectImageDTO() {
    }
    public InsectImageDTO(InsectImage a) {
        this.insectImageID = a.getInsectImageID();
        this.uri = a.getUri();
        this.dateRegistered = a.getDateRegistered();
        this.insectID = a.getInsect().getInsectID();
    }

    public Integer getInsectImageID() {
        return insectImageID;
    }

    public Integer getInsectID() {
        return insectID;
    }

    public void setInsectID(Integer insectID) {
        this.insectID = insectID;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (insectImageID != null ? insectImageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InsectImageDTO)) {
            return false;
        }
        InsectImageDTO other = (InsectImageDTO) object;
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
