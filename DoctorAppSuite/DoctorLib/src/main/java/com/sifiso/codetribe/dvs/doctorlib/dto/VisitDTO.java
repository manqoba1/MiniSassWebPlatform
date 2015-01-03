package com.sifiso.codetribe.dvs.doctorlib.dto;

import java.io.Serializable;

/**
 * Created by CodeTribe1 on 2014-12-30.
 */
public class VisitDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer visitID, doctorID, receptionistID, patientfileID;
    private long dateMade;
    private Integer flag;
    private long visitedDate;
    private String paymentType;
    private DoctorDTO doctor;
    private PatientfileDTO patientfile;
    private ReceptionistDTO receptionist;

    public VisitDTO() {
    }

    public Integer getVisitID() {
        return visitID;
    }

    public void setVisitID(Integer visitID) {
        this.visitID = visitID;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Integer doctorID) {
        this.doctorID = doctorID;
    }

    public Integer getReceptionistID() {
        return receptionistID;
    }

    public void setReceptionistID(Integer receptionistID) {
        this.receptionistID = receptionistID;
    }

    public long getDateMade() {
        return dateMade;
    }

    public void setDateMade(long dateMade) {
        this.dateMade = dateMade;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public long getVisitedDate() {
        return visitedDate;
    }

    public void setVisitedDate(long visitedDate) {
        this.visitedDate = visitedDate;
    }

    public DoctorDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDTO doctor) {
        this.doctor = doctor;
    }

    public Integer getPatientfileID() {
        return patientfileID;
    }

    public void setPatientfileID(Integer patientfileID) {
        this.patientfileID = patientfileID;
    }

    public PatientfileDTO getPatientfile() {
        return patientfile;
    }

    public void setPatientfile(PatientfileDTO patientfile) {
        this.patientfile = patientfile;
    }

    public ReceptionistDTO getReceptionist() {
        return receptionist;
    }

    public void setReceptionist(ReceptionistDTO receptionist) {
        this.receptionist = receptionist;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (visitID != null ? visitID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VisitDTO)) {
            return false;
        }
        VisitDTO other = (VisitDTO) object;
        if ((this.visitID == null && other.visitID != null) || (this.visitID != null && !this.visitID.equals(other.visitID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.dvs.data.Visit[ visitID=" + visitID + " ]";
    }

}
