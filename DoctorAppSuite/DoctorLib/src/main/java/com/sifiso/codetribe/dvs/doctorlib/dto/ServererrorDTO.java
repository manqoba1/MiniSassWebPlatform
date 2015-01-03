package com.sifiso.codetribe.dvs.doctorlib.dto;

import java.io.Serializable;

/**
 * Created by CodeTribe1 on 2014-12-30.
 */
public class ServererrorDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer serverErrorID;
    private Integer statusCode;
    private String message;
    private long dateOccured;
    private String origin;

    public ServererrorDTO() {
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
        return "com.sifiso.dvs.data.Servererror[ serverErrorID=" + serverErrorID + " ]";
    }

}
