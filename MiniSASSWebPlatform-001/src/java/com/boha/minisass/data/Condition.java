/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.minisass.data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "condition")
@NamedQueries({
    @NamedQuery(name = "Condition.findAll", query = "SELECT c FROM Condition c"),
    @NamedQuery(name = "Condition.findByConditionID", query = "SELECT c FROM Condition c WHERE c.conditionID = :conditionID"),
    @NamedQuery(name = "Condition.findByConditionName", query = "SELECT c FROM Condition c WHERE c.conditionName = :conditionName"),
    @NamedQuery(name = "Condition.findByLow", query = "SELECT c FROM Condition c WHERE c.low = :low"),
    @NamedQuery(name = "Condition.findByHigh", query = "SELECT c FROM Condition c WHERE c.high = :high")})
public class Condition implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "conditionID")
    private Integer conditionID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "conditionName")
    private String conditionName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "low")
    private double low;
    @Basic(optional = false)
    @NotNull
    @Column(name = "high")
    private double high;
    @OneToMany(mappedBy = "condition")
    private List<Evaluation> evaluationList;
    @JoinColumn(name = "categoryID", referencedColumnName = "categoryId")
    @ManyToOne(optional = false)
    private Category category;

    public Condition() {
    }

    public Condition(Integer conditionID) {
        this.conditionID = conditionID;
    }

    public Condition(Integer conditionID, String conditionName, double low, double high) {
        this.conditionID = conditionID;
        this.conditionName = conditionName;
        this.low = low;
        this.high = high;
    }

    public Integer getConditionID() {
        return conditionID;
    }

    public void setConditionID(Integer conditionID) {
        this.conditionID = conditionID;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public List<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluation> evaluationList) {
        this.evaluationList = evaluationList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conditionID != null ? conditionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Condition)) {
            return false;
        }
        Condition other = (Condition) object;
        if ((this.conditionID == null && other.conditionID != null) || (this.conditionID != null && !this.conditionID.equals(other.conditionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.minisass.data.Condition[ conditionID=" + conditionID + " ]";
    }
    
}
