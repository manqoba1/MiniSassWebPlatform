/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.minisass.dto;

import com.boha.minisass.data.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aubreyM
 */
public class EvaluationDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer evaluationID;
    private Date evaluationDate;
    private String comment;
    private Double score;
    private Double pH;
    private Double waterTemperature;
    private Double oxygen;
    private Double waterClarity;
    private Double latitude;
    private Double longitude;
    private List<EvaluationImageDTO> evaluationImageList;
    private TeamMemberDTO teamMember;
    private EvaluationSiteDTO evaluationSite;
    private List<EvaluationInsectDTO> evaluationInsectList;
    private List<EvaluationCommentDTO> evaluationCommentList;

    public EvaluationDTO() {
    }

  
    public EvaluationDTO(Evaluation a) {
        this.evaluationID = a.getEvaluationID();
        this.evaluationDate = a.getEvaluationDate();
        this.latitude = a.getLatitude();
        this.longitude = a.getLongitude();
        this.score = a.getScore();
        this.pH = a.getPH();
        this.waterClarity = a.getWaterClarity();
        this.oxygen = a.getOxygen();
        this.waterTemperature = a.getWaterTemperature();
        this.teamMember = new TeamMemberDTO(a.getTeamMember());
        this.evaluationSite = new EvaluationSiteDTO(a.getEvaluationSite());
    }

    public List<EvaluationCommentDTO> getEvaluationCommentList() {
        return evaluationCommentList;
    }

    public void setEvaluationCommentList(List<EvaluationCommentDTO> evaluationCommentList) {
        this.evaluationCommentList = evaluationCommentList;
    }

   
    public Integer getEvaluationID() {
        return evaluationID;
    }

    public void setEvaluationID(Integer evaluationID) {
        this.evaluationID = evaluationID;
    }

    public Date getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(Date evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getPH() {
        return pH;
    }

    public void setPH(Double pH) {
        this.pH = pH;
    }

    public Double getWaterTemperature() {
        return waterTemperature;
    }

    public void setWaterTemperature(Double waterTemperature) {
        this.waterTemperature = waterTemperature;
    }

    public Double getOxygen() {
        return oxygen;
    }

    public void setOxygen(Double oxygen) {
        this.oxygen = oxygen;
    }

    public Double getWaterClarity() {
        return waterClarity;
    }

    public void setWaterClarity(Double waterClarity) {
        this.waterClarity = waterClarity;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }


    public List<EvaluationImageDTO> getEvaluationImageList() {
        return evaluationImageList;
    }

    public void setEvaluationImageList(List<EvaluationImageDTO> evaluationImageList) {
        this.evaluationImageList = evaluationImageList;
    }

    public Double getpH() {
        return pH;
    }

    public void setpH(Double pH) {
        this.pH = pH;
    }

    public TeamMemberDTO getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(TeamMemberDTO teamMember) {
        this.teamMember = teamMember;
    }

    public EvaluationSiteDTO getEvaluationSite() {
        return evaluationSite;
    }

    public void setEvaluationSite(EvaluationSiteDTO evaluationSite) {
        this.evaluationSite = evaluationSite;
    }

    public List<EvaluationInsectDTO> getEvaluationInsectList() {
        return evaluationInsectList;
    }

    public void setEvaluationInsectList(List<EvaluationInsectDTO> evaluationInsectList) {
        this.evaluationInsectList = evaluationInsectList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluationID != null ? evaluationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluationDTO)) {
            return false;
        }
        EvaluationDTO other = (EvaluationDTO) object;
        if ((this.evaluationID == null && other.evaluationID != null) || (this.evaluationID != null && !this.evaluationID.equals(other.evaluationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.minisass.data.Evaluation[ evaluationID=" + evaluationID + " ]";
    }
    
}
