package com.sifiso.codetribe.dvs.doctorlib.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CodeTribe1 on 2014-12-30.
 */
public class DoctortypeDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer doctorTypeID;
    private String name;
    private List<DoctorDTO> doctorList = new ArrayList<DoctorDTO>();

    public DoctortypeDTO() {
    }

    public List<DoctorDTO> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<DoctorDTO> doctorList) {
        this.doctorList = doctorList;
    }

    public Integer getDoctorTypeID() {
        return doctorTypeID;
    }

    public void setDoctorTypeID(Integer doctorTypeID) {
        this.doctorTypeID = doctorTypeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doctorTypeID != null ? doctorTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DoctortypeDTO)) {
            return false;
        }
        DoctortypeDTO other = (DoctortypeDTO) object;
        if ((this.doctorTypeID == null && other.doctorTypeID != null) || (this.doctorTypeID != null && !this.doctorTypeID.equals(other.doctorTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.dvs.data.Doctortype[ doctorTypeID=" + doctorTypeID + " ]";
    }
}
