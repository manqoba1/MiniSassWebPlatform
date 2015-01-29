/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.minisass.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "teamMember")
@NamedQueries({
    @NamedQuery(name = "TeamMember.findAll", query = "SELECT t FROM TeamMember t"),
    @NamedQuery(name = "TeamMember.findByTeamMemberID", query = "SELECT t FROM TeamMember t WHERE t.teamMemberID = :teamMemberID"),
    @NamedQuery(name = "TeamMember.findByFirstName", query = "SELECT t FROM TeamMember t WHERE t.firstName = :firstName"),
    @NamedQuery(name = "TeamMember.findByLastName", query = "SELECT t FROM TeamMember t WHERE t.lastName = :lastName"),
    @NamedQuery(name = "TeamMember.findByEmail", query = "SELECT t FROM TeamMember t WHERE t.email = :email"),
    @NamedQuery(name = "TeamMember.findByCellphone", query = "SELECT t FROM TeamMember t WHERE t.cellphone = :cellphone"),
    @NamedQuery(name = "TeamMember.findByDateRegistered", query = "SELECT t FROM TeamMember t WHERE t.dateRegistered = :dateRegistered"),
    @NamedQuery(name = "TeamMember.findByPin", query = "SELECT t FROM TeamMember t WHERE t.pin = :pin"),
    @NamedQuery(name = "TeamMember.findByActiveFlag", query = "SELECT t FROM TeamMember t WHERE t.activeFlag = :activeFlag")})
public class TeamMember implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "teamMemberID")
    private Integer teamMemberID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lastName")
    private String lastName;
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "cellphone")
    private String cellphone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pin")
    private String pin;
    @Column(name = "activeFlag")
    private Integer activeFlag;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teamMember")
    private List<Evaluation> evaluationList;
    @JoinColumn(name = "teamID", referencedColumnName = "teamID")
    @ManyToOne(optional = false)
    private Team team;

    public TeamMember() {
    }

    public TeamMember(Integer teamMemberID) {
        this.teamMemberID = teamMemberID;
    }

    public TeamMember(Integer teamMemberID, String firstName, String lastName, Date dateRegistered, String pin) {
        this.teamMemberID = teamMemberID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateRegistered = dateRegistered;
        this.pin = pin;
    }

    public Integer getTeamMemberID() {
        return teamMemberID;
    }

    public void setTeamMemberID(Integer teamMemberID) {
        this.teamMemberID = teamMemberID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Integer getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Integer activeFlag) {
        this.activeFlag = activeFlag;
    }

    public List<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluation> evaluationList) {
        this.evaluationList = evaluationList;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teamMemberID != null ? teamMemberID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeamMember)) {
            return false;
        }
        TeamMember other = (TeamMember) object;
        if ((this.teamMemberID == null && other.teamMemberID != null) || (this.teamMemberID != null && !this.teamMemberID.equals(other.teamMemberID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.minisass.data.TeamMember[ teamMemberID=" + teamMemberID + " ]";
    }
    
}
