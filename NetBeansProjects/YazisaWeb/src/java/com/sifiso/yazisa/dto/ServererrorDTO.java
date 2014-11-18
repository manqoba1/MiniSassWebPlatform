/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.dto;

import com.sifiso.yazisa.data.*;
import java.io.Serializable;

/**
 *
 * @author CodeTribe1
 */
public class ServererrorDTO implements Serializable {

    private Integer serverErrorID;
    private Integer statusCode;
    private String message;
    private long dateOccured;
    private String origin;

    public ServererrorDTO() {
    }

    public ServererrorDTO(Servererror a) {
        serverErrorID = a.getServerErrorID();
        statusCode = a.getStatusCode();
        message = a.getMessage();
        dateOccured = a.getDateOccured().getTime();
        origin = a.getOrigin();
    }

    public ServererrorDTO(Integer serverErrorID) {
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

    public long getDateOccured() {
        return dateOccured;
    }

    public void setDateOccured(long dateOccured) {
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
        if (!(object instanceof ServererrorDTO)) {
            return false;
        }
        ServererrorDTO other = (ServererrorDTO) object;
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
