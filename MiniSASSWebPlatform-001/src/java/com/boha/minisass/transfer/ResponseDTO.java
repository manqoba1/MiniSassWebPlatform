/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.minisass.transfer;

import com.boha.minisass.dto.CategoryDTO;
import com.boha.minisass.dto.CommentDTO;
import com.boha.minisass.dto.CountryDTO;
import com.boha.minisass.dto.ErrorStoreAndroidDTO;
import com.boha.minisass.dto.ErrorStoreDTO;
import com.boha.minisass.dto.EvaluationDTO;
import com.boha.minisass.dto.EvaluationSiteDTO;
import com.boha.minisass.dto.InsectDTO;
import com.boha.minisass.dto.ProvinceDTO;
import com.boha.minisass.dto.RiverDTO;
import com.boha.minisass.dto.RiverTownDTO;
import com.boha.minisass.dto.TeamDTO;
import com.boha.minisass.dto.TeamMemberDTO;
import com.boha.minisass.dto.TownDTO;
import java.util.List;

/**
 *
 * @author aubreyM
 */
public class ResponseDTO {
    private int statusCode;
    private String message;
    private Integer statusCountInPeriod, goodCount, badCount;
    private String sessionID, GCMRegistrationID, fileString;
    private double elapsedRequestTimeInSeconds;
    
    private List<TeamDTO> teamList;
    private List<TeamMemberDTO> teamMemberList;
    private List<RiverDTO> riverList;
    private List<RiverTownDTO> riverTownList;
    private List<InsectDTO> insectList;
    private List<CommentDTO> commentList;
    private List<EvaluationDTO> evaluationList;
    private List<EvaluationSiteDTO> evaluationSiteList;
    private List<CategoryDTO> categoryList;
    private List<CountryDTO> countryList;
    private List<ProvinceDTO> provinceList;
    private List<TownDTO> townList;
    
     private List<ErrorStoreDTO> errorStoreList;
    private List<ErrorStoreAndroidDTO> errorStoreAndroidList;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<TeamDTO> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<TeamDTO> teamList) {
        this.teamList = teamList;
    }

    public List<TeamMemberDTO> getTeamMemberList() {
        return teamMemberList;
    }

    public void setTeamMemberList(List<TeamMemberDTO> teamMemberList) {
        this.teamMemberList = teamMemberList;
    }

    public List<RiverDTO> getRiverList() {
        return riverList;
    }

    public void setRiverList(List<RiverDTO> riverList) {
        this.riverList = riverList;
    }

    public List<RiverTownDTO> getRiverTownList() {
        return riverTownList;
    }

    public void setRiverTownList(List<RiverTownDTO> riverTownList) {
        this.riverTownList = riverTownList;
    }

    public List<InsectDTO> getInsectList() {
        return insectList;
    }

    public void setInsectList(List<InsectDTO> insectList) {
        this.insectList = insectList;
    }

    public List<CommentDTO> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentDTO> commentList) {
        this.commentList = commentList;
    }

    public List<EvaluationDTO> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<EvaluationDTO> evaluationList) {
        this.evaluationList = evaluationList;
    }

    public List<EvaluationSiteDTO> getEvaluationSiteList() {
        return evaluationSiteList;
    }

    public void setEvaluationSiteList(List<EvaluationSiteDTO> evaluationSiteList) {
        this.evaluationSiteList = evaluationSiteList;
    }

    public List<CategoryDTO> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CategoryDTO> categoryList) {
        this.categoryList = categoryList;
    }

    public List<CountryDTO> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<CountryDTO> countryList) {
        this.countryList = countryList;
    }

    public List<ProvinceDTO> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<ProvinceDTO> provinceList) {
        this.provinceList = provinceList;
    }

    public List<TownDTO> getTownList() {
        return townList;
    }

    public void setTownList(List<TownDTO> townList) {
        this.townList = townList;
    }

    public Integer getStatusCountInPeriod() {
        return statusCountInPeriod;
    }

    public void setStatusCountInPeriod(Integer statusCountInPeriod) {
        this.statusCountInPeriod = statusCountInPeriod;
    }

    public Integer getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }

    public Integer getBadCount() {
        return badCount;
    }

    public void setBadCount(Integer badCount) {
        this.badCount = badCount;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getGCMRegistrationID() {
        return GCMRegistrationID;
    }

    public void setGCMRegistrationID(String GCMRegistrationID) {
        this.GCMRegistrationID = GCMRegistrationID;
    }

    public String getFileString() {
        return fileString;
    }

    public void setFileString(String fileString) {
        this.fileString = fileString;
    }

    public double getElapsedRequestTimeInSeconds() {
        return elapsedRequestTimeInSeconds;
    }

    public void setElapsedRequestTimeInSeconds(double elapsedRequestTimeInSeconds) {
        this.elapsedRequestTimeInSeconds = elapsedRequestTimeInSeconds;
    }

    public List<ErrorStoreDTO> getErrorStoreList() {
        return errorStoreList;
    }

    public void setErrorStoreList(List<ErrorStoreDTO> errorStoreList) {
        this.errorStoreList = errorStoreList;
    }

    public List<ErrorStoreAndroidDTO> getErrorStoreAndroidList() {
        return errorStoreAndroidList;
    }

    public void setErrorStoreAndroidList(List<ErrorStoreAndroidDTO> errorStoreAndroidList) {
        this.errorStoreAndroidList = errorStoreAndroidList;
    }
    
    
}
