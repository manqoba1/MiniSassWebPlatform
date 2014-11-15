/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.dto;

import com.sifiso.yazisa.data.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author CodeTribe1
 */
public class ClazzlearnerDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer clazzLearnerID;
    private List<AbsenteeDTO> absenteeList;
    private LearnersDTO learners;
    private ClazzDTO clazz;

    public ClazzlearnerDTO() {
    }

    public ClazzlearnerDTO(Clazzlearner cl) {
        clazzLearnerID = cl.getClazzLearnerID();
        learners = new LearnersDTO(cl.getLearners());
        clazz = new ClazzDTO(cl.getClazz());
    }

    public Integer getClazzLearnerID() {
        return clazzLearnerID;
    }

    public void setClazzLearnerID(Integer clazzLearnerID) {
        this.clazzLearnerID = clazzLearnerID;
    }

    public List<AbsenteeDTO> getAbsenteeList() {
        return absenteeList;
    }

    public void setAbsenteeList(List<AbsenteeDTO> absenteeList) {
        this.absenteeList = absenteeList;
    }

    public LearnersDTO getLearners() {
        return learners;
    }

    public void setLearners(LearnersDTO learners) {
        this.learners = learners;
    }

    public ClazzDTO getClazz() {
        return clazz;
    }

    public void setClazz(ClazzDTO clazz) {
        this.clazz = clazz;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clazzLearnerID != null ? clazzLearnerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClazzlearnerDTO)) {
            return false;
        }
        ClazzlearnerDTO other = (ClazzlearnerDTO) object;
        if ((this.clazzLearnerID == null && other.clazzLearnerID != null) || (this.clazzLearnerID != null && !this.clazzLearnerID.equals(other.clazzLearnerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.dto.ClazzlearnerDTO[ clazzLearnerID=" + clazzLearnerID + " ]";
    }

}
