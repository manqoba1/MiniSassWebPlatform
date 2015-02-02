/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.minisass.dto;

import com.boha.minisass.data.Evaluationcomment;
import java.io.Serializable;

/**
 *
 * @author aubreyM
 */
public class EvaluationCommentDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer evaluationCommentID;
    private Integer evaluationID;
    private CommentDTO comment;

    public EvaluationCommentDTO() {
    }

    public EvaluationCommentDTO(Evaluationcomment a) {
        this.evaluationCommentID = a.getEvaluationCommentID();
        this.evaluationID = a.getEvaluation().getEvaluationID();
        this.comment = new CommentDTO(a.getComment());
    }

    public Integer getEvaluationCommentID() {
        return evaluationCommentID;
    }

    public void setEvaluationCommentID(Integer evaluationCommentID) {
        this.evaluationCommentID = evaluationCommentID;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluationCommentID != null ? evaluationCommentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluationCommentDTO)) {
            return false;
        }
        EvaluationCommentDTO other = (EvaluationCommentDTO) object;
        if ((this.evaluationCommentID == null && other.evaluationCommentID != null) || (this.evaluationCommentID != null && !this.evaluationCommentID.equals(other.evaluationCommentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.minisass.data.EvaluationComment[ evaluationCommentID=" + evaluationCommentID + " ]";
    }
    
}
