/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.dvs.gate.dto;

import java.util.List;

/**
 *
 * @author aubreyM
 */
public class PhotoUploadDTO {

    public static final int FILES_SURGERY = 1, FILES_DOCTOR = 2;
    private Integer patientfileID, pictureType, doctorID, surgeryID;
    private List<String> tags;
    private boolean isFullPicture;

    public Integer getPatientfileID() {
        return patientfileID;
    }

    public void setPatientfileID(Integer patientfileID) {
        this.patientfileID = patientfileID;
    }

    public Integer getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Integer doctorID) {
        this.doctorID = doctorID;
    }

    public Integer getPictureType() {
        return pictureType;
    }

    public Integer getSurgeryID() {
        return surgeryID;
    }

    public void setSurgeryID(Integer surgeryID) {
        this.surgeryID = surgeryID;
    }

    public void setPictureType(Integer pictureType) {
        this.pictureType = pictureType;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public boolean isIsFullPicture() {
        return isFullPicture;
    }

    public void setIsFullPicture(boolean isFullPicture) {
        this.isFullPicture = isFullPicture;
    }

}
