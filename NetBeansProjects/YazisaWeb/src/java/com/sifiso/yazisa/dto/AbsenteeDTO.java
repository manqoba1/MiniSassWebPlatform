/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sifiso.yazisa.dto;

import com.sifiso.yazisa.data.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author CodeTribe1
 */
public class AbsenteeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private Integer absenteeID;
    private long absentDate;
    private int lateForClass;
    private ClazzlearnerDTO clazzLearner;


    public AbsenteeDTO() {
    }

  

    public AbsenteeDTO(Absentee a) {
        absenteeID = a.getAbsenteeID();
        absentDate = a.getAbsentDate().getTime();
        lateForClass = a.getLateForClass();
        clazzLearner = new ClazzlearnerDTO(a.getClazzLearner());
    }

    public Integer getAbsenteeID() {
        return absenteeID;
    }

    public void setAbsenteeID(Integer absenteeID) {
        this.absenteeID = absenteeID;
    }

    public long getAbsentDate() {
        return absentDate;
    }

    public void setAbsentDate(long absentDate) {
        this.absentDate = absentDate;
    }

    public int getLateForClass() {
        return lateForClass;
    }

    public void setLateForClass(int lateForClass) {
        this.lateForClass = lateForClass;
    }

    public ClazzlearnerDTO getClazzLearner() {
        return clazzLearner;
    }

    public void setClazzLearner(ClazzlearnerDTO clazzLearner) {
        this.clazzLearner = clazzLearner;
    }

  
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (absenteeID != null ? absenteeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AbsenteeDTO)) {
            return false;
        }
        AbsenteeDTO other = (AbsenteeDTO) object;
        if ((this.absenteeID == null && other.absenteeID != null) || (this.absenteeID != null && !this.absenteeID.equals(other.absenteeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.dto.AbsenteeDTO[ absenteeID=" + absenteeID + " ]";
    }
    
}
