package com.boha.minisass.transfer;

import com.boha.minisass.dto.CommentDTO;
import com.boha.minisass.dto.CountryDTO;
import com.boha.minisass.dto.EvaluationDTO;
import com.boha.minisass.dto.EvaluationSiteDTO;
import com.boha.minisass.dto.InsectDTO;
import com.boha.minisass.dto.InsectImageDTO;
import com.boha.minisass.dto.ProvinceDTO;
import com.boha.minisass.dto.RiverDTO;
import com.boha.minisass.dto.RiverTownDTO;
import com.boha.minisass.dto.TeamDTO;
import com.boha.minisass.dto.TeamMemberDTO;
import com.boha.minisass.dto.TownDTO;

/**
 *
 * @author aubreyM
 */
public class RequestDTO {

    private int requestType;
    private String email, password;
    private Integer countryID;

    public static final int REGISTER_TEAM = 1,
            REGISTER_TEAM_MEMBER = 2,
            SIGN_IN_MEMBER = 3,
            IMPORT_MEMBERS = 4;

    public static final int ADD_RIVER = 10,
            ADD_RIVER_TOWN = 11,
            ADD_EVALUATION_SITE = 12,
            ADD_INSECT = 13,
            ADD_INSECT_IMAGE = 14,
            ADD_EVALUATION = 15,
            ADD_COMMENT = 16;

    public static final int ADD_COUNTRY = 21,
            ADD_PROVINCE = 22,
            ADD_TOWN = 23;

    public static final int UPDATE_RIVER = 30,
            UPDATE_RIVER_TOWN = 31,
            UPDATE_EVALUATION_SITE = 32,
            UPDATE_INSECT = 33,
            UPDATE_INSECT_IMAGE = 34;

    public static final int
            LIST_RIVERS_IN_COUNTRY = 40,
            LIST_RIVER_TOWNS = 41,
            LIST_EVALUATION_SITES = 42,
            LIST_INSECTS = 43,
            LIST_TEAMS = 44,
            LIST_EVALUATIONS_BY_RIVER = 45,
            LIST_PROVINCE_COUNTRY = 46,
            LIST_ALL_PROVINCES = 50;

    private EvaluationDTO evaluation;
    private TeamDTO team;
    private TeamMemberDTO teamMember;
    private RiverDTO river;
    private RiverTownDTO riverTown;
    private EvaluationSiteDTO evaluationSite;
    private CommentDTO comment;
    private InsectDTO insect;
    private InsectImageDTO insectImage;
    private CountryDTO country;
    private TownDTO town;
    private ProvinceDTO province;

    public static final String SAMPLE_DIR = "company";
    public static final String INSECTS_DIR = "insert";
    public static final String TEAM_DIR = "team";

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    public TownDTO getTown() {
        return town;
    }

    public void setTown(TownDTO town) {
        this.town = town;
    }

    public Integer getCountryID() {
        return countryID;
    }

    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    public ProvinceDTO getProvince() {
        return province;
    }

    public void setProvince(ProvinceDTO province) {
        this.province = province;
    }

    public int getRequestType() {
        return requestType;
    }

    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }

    public String getEmail() {
        return email;
    }

    public CommentDTO getComment() {
        return comment;
    }

    public void setComment(CommentDTO comment) {
        this.comment = comment;
    }

    public InsectDTO getInsect() {
        return insect;
    }

    public void setInsect(InsectDTO insect) {
        this.insect = insect;
    }

    public InsectImageDTO getInsectImage() {
        return insectImage;
    }

    public void setInsectImage(InsectImageDTO insectImage) {
        this.insectImage = insectImage;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EvaluationDTO getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(EvaluationDTO evaluation) {
        this.evaluation = evaluation;
    }

    public TeamDTO getTeam() {
        return team;
    }

    public void setTeam(TeamDTO team) {
        this.team = team;
    }

    public TeamMemberDTO getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(TeamMemberDTO teamMember) {
        this.teamMember = teamMember;
    }

    public RiverDTO getRiver() {
        return river;
    }

    public void setRiver(RiverDTO river) {
        this.river = river;
    }

    public RiverTownDTO getRiverTown() {
        return riverTown;
    }

    public void setRiverTown(RiverTownDTO riverTown) {
        this.riverTown = riverTown;
    }

    public EvaluationSiteDTO getEvaluationSite() {
        return evaluationSite;
    }

    public void setEvaluationSite(EvaluationSiteDTO evaluationSite) {
        this.evaluationSite = evaluationSite;
    }

}
