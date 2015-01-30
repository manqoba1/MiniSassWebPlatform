package com.boha.minisass.util;

import com.boha.minisass.data.Category;
import com.boha.minisass.data.Comment;
import com.boha.minisass.data.Country;
import com.boha.minisass.data.Evaluation;
import com.boha.minisass.data.EvaluationSite;
import com.boha.minisass.data.Insect;
import com.boha.minisass.data.Province;
import com.boha.minisass.data.River;
import com.boha.minisass.data.RiverTown;
import com.boha.minisass.data.Team;
import com.boha.minisass.data.TeamMember;
import com.boha.minisass.data.Town;
import com.boha.minisass.dto.CategoryDTO;
import com.boha.minisass.dto.CommentDTO;
import com.boha.minisass.dto.CountryDTO;
import com.boha.minisass.dto.EvaluationDTO;
import com.boha.minisass.dto.EvaluationSiteDTO;
import com.boha.minisass.dto.InsectDTO;
import com.boha.minisass.dto.ProvinceDTO;
import com.boha.minisass.dto.RiverDTO;
import com.boha.minisass.dto.RiverTownDTO;
import com.boha.minisass.dto.TeamDTO;
import com.boha.minisass.dto.TeamMemberDTO;
import com.boha.minisass.dto.TownDTO;
import com.boha.minisass.transfer.ResponseDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author CodeTribe1
 */

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ListUtil {
    
     @PersistenceContext
    EntityManager em;
    
    public ResponseDTO getCountryList() {
        ResponseDTO resp = new ResponseDTO();
        
        Query q = em.createNamedQuery("Country.findAll", Country.class);
        List<Country> list = q.getResultList();
        resp.setCountryList(new ArrayList<CountryDTO>());
        for (Country cp : list) {
            CountryDTO cn = new CountryDTO(cp);
            for (Province p : cp.getProvinceList()) {
                ProvinceDTO province = new ProvinceDTO(p);
                province.setTownList(new ArrayList<TownDTO>());
                for (Town town : p.getTownList()) {
                    TownDTO townDTO = new TownDTO(town);
                    townDTO.setRiverTownList(new ArrayList<RiverTownDTO>());
                }
                cn.getProvinceList().add(province);
            }
            resp.getCountryList().add(cn);
        }
        
        return resp;
    }
    
     public ResponseDTO getInsectList() {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("Insect.findAll", Insect.class);
        //q.setParameter("", );
        List<Insect> list = q.getResultList();
        for (Insect ins : list) {
            resp.getInsectList().add(new InsectDTO(ins));
        }

        return resp;
    }
   
     public ResponseDTO getTeamList(Integer teamID) {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("Team.findByTeamID", Team.class);
        q.setParameter("teamID", teamID);
        List<Team> list = q.getResultList();
        for (Team tea : list) {
            resp.getTeamList().add(new TeamDTO(tea));
        }

        return resp;
    }

public ResponseDTO getTeamMemberList(Integer teamMemberID) {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("TeamMember.findByTeamMemberID", TeamMember.class);
        q.setParameter("teamMemberID", teamMemberID);
        List<TeamMember> list = q.getResultList();
        for (TeamMember tm : list) {
            resp.getTeamMemberList().add(new TeamMemberDTO(tm));
        }

        return resp;
    }

public ResponseDTO getRiverList(Integer riverID) {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("River.findByRiverID", River.class);
        q.setParameter("riverID", riverID);
        List<River> list = q.getResultList();
        for (River riv : list) {
            resp.getRiverList().add(new RiverDTO(riv));
        }

        return resp;
    }

public ResponseDTO getRiverTownList(Integer riverID) {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("River.findByRiverID", RiverTown.class);
        q.setParameter("riverID", riverID);
        List<River> list = q.getResultList();
        for (River riv : list) {
            resp.getRiverList().add(new RiverDTO(riv));
        }

        return resp;
    }

public ResponseDTO getCommentList(Integer commentID) {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("Comment.findByCommentID", Comment.class);
        q.setParameter("commentID", commentID);
        List<Comment> list = q.getResultList();
        for (Comment com : list) {
            resp.getCommentList().add(new CommentDTO(com));
        }

        return resp;
    }

public ResponseDTO getEvaluationList(Integer evaluationID) {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("Evaluation.findByEvaluationID", Evaluation.class);
        q.setParameter("evaluationID", evaluationID);
        List<Evaluation> list = q.getResultList();
        for (Evaluation eva : list) {
            resp.getEvaluationList().add(new EvaluationDTO(eva));
        }

        return resp;
    }

public ResponseDTO getEvaluationSiteList(Integer evaluationSiteID) {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("EvaluationSite.findByEvaluationSiteID", EvaluationSite.class);
        q.setParameter("evaluationSiteID", evaluationSiteID);
        List<EvaluationSite> list = q.getResultList();
        for (EvaluationSite es : list) {
            resp.getEvaluationSiteList().add(new EvaluationSiteDTO(es));
        }

        return resp;
    }

public ResponseDTO getCategoryList(Integer categoryID) {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("Category.findByCategoryId", Category.class);
        q.setParameter("categoryID", categoryID);
        List<Category> list = q.getResultList();
        for (Category cat : list) {
            resp.getCategoryList().add(new CategoryDTO(cat));
        }

        return resp;
    }


    
    public EvaluationSite getEvaluationSite(Integer id) {
        EvaluationSite es = em.find(EvaluationSite.class, id);
        return es;
    }
    
    private String getRandomPin() {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random(System.currentTimeMillis());
        int x = rand.nextInt(9);
        if (x == 0) {
            x = 3;
        }
        sb.append(x);
        sb.append(rand.nextInt(9));
        sb.append(rand.nextInt(9));
        sb.append(rand.nextInt(9));
        sb.append(rand.nextInt(9));
        sb.append(rand.nextInt(9));
        return sb.toString();
    }
    
}
