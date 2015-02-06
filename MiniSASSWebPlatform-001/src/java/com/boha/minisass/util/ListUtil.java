package com.boha.minisass.util;

import com.boha.minisass.data.Category;
import com.boha.minisass.data.Comment;
import com.boha.minisass.data.Conditions;
import com.boha.minisass.data.Country;
import com.boha.minisass.data.Evaluation;
import com.boha.minisass.data.Evaluationinsect;
import com.boha.minisass.data.Evaluationsite;
import com.boha.minisass.data.Insect;
import com.boha.minisass.data.Province;
import com.boha.minisass.data.River;
import com.boha.minisass.data.Rivertown;
import com.boha.minisass.data.Team;
import com.boha.minisass.data.Teammember;
import com.boha.minisass.data.Town;
import com.boha.minisass.dto.CategoryDTO;
import com.boha.minisass.dto.CommentDTO;
import com.boha.minisass.dto.ConditionsDTO;
import com.boha.minisass.dto.CountryDTO;
import com.boha.minisass.dto.EvaluationDTO;
import com.boha.minisass.dto.EvaluationInsectDTO;
import com.boha.minisass.dto.EvaluationSiteDTO;
import com.boha.minisass.dto.InsectDTO;
import com.boha.minisass.dto.ProvinceDTO;
import com.boha.minisass.dto.RiverDTO;
import com.boha.minisass.dto.RiverTownDTO;
import com.boha.minisass.dto.TeamDTO;
import com.boha.minisass.dto.TeamMemberDTO;
import com.boha.minisass.dto.TownDTO;
import com.boha.minisass.transfer.ResponseDTO;
import static com.boha.minisass.util.DataUtil.log;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
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
        List<Insect> list = q.getResultList();
        for (Insect ins : list) {
            resp.getInsectList().add(new InsectDTO(ins));
        }

        return resp;
    }

    public ResponseDTO getEvaluationByTeamMember(Integer teamMemberID) {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("Evaluation.findByTeamMemberID", Evaluation.class);
        q.setParameter("teamMemberID", teamMemberID);
        List<Evaluation> list = q.getResultList();
        for (Evaluation e : list) {
            resp.getEvaluationList().add(new EvaluationDTO(e));
        }

        return resp;
    }
    
    public ResponseDTO getTeamByTown(Integer townID) {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("Team.findByTownID", Team.class);
        q.setParameter("townID", townID);
        List<Team> list = q.getResultList();
        for (Team te : list) {
            resp.getTeamList().add(new TeamDTO(te));
        }

        return resp;
    }
    
    public ResponseDTO getEvaluationInsectByEvaluation(Integer evaluationID) {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("Evaluationinsect.findByEvaluationID", Evaluationinsect.class);
        q.setParameter("evaluationID", evaluationID);
        List<Evaluationinsect> list = q.getResultList();
        for (Evaluationinsect ei : list) {
            resp.getEvaluationInsectList().add(new EvaluationInsectDTO(ei));
        }

        return resp;
    }
    
    public ResponseDTO getEvaluationSiteByCategory(Integer categoryID) {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("Evaluationsite.findByCategoryID", Evaluationsite.class);
        q.setParameter("categoryID", categoryID);
        List<Evaluationsite> list = q.getResultList();
        for (Evaluationsite es : list) {
            resp.getEvaluationSiteList().add(new EvaluationSiteDTO(es));
        }

        return resp;
    }
    
    public ResponseDTO getEvaluationByCondtions(Integer conditionsID) {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("Evaluation.findByConditionsID", Evaluation.class);
        q.setParameter("conditionsID", conditionsID);
        List<Evaluation> list = q.getResultList();
        for (Evaluation e : list) {
            resp.getEvaluationList().add(new EvaluationDTO(e));
        }

        return resp;
    }
    
    
    public ResponseDTO getAllProvince() throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Province.findAll", Province.class);
            List<Province> list = q.getResultList();
            resp.setProvinceList(new ArrayList<ProvinceDTO>());
            for (Province p : list) {
                resp.getProvinceList().add(new ProvinceDTO(p));
            }
            log.log(Level.OFF, "Provinces failed: {0}", resp.getProvinceList().size());
        } catch (Exception e) {
            log.log(Level.OFF, "failed to get provinces", e);
            throw new DataException("failed ........");
        }
        return resp;
    }

    public ResponseDTO getProvinceByCountry(Integer countryID) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Province.findByCountryID", Province.class);
            q.setParameter("countryID", countryID);
            List<Province> list = q.getResultList();
            resp.setProvinceList(new ArrayList<ProvinceDTO>());
            for (Province p : list) {
                resp.getProvinceList().add(new ProvinceDTO(p));
            }
            log.log(Level.OFF, "Found Provinces : {0}", resp.getProvinceList().size());
        } catch (Exception e) {
            log.log(Level.OFF, "failed to get provinces", e);
            throw new DataException("failed ........");
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

    
    
    public ResponseDTO getTownByProvince(Integer provinceID) {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("Town.findByProvinceID", Town.class);
        q.setParameter("provinceID", provinceID);
        List<Town> list = q.getResultList();
        for (Town to : list) {
            resp.getTownList().add(new TownDTO(to));
        }

        return resp;
    }
    
    public ResponseDTO getTeamMemberList() {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("Teammember.findAll", Teammember.class);
        List<Teammember> list = q.getResultList();
        for (Teammember tm : list) {
            resp.getTeamMemberList().add(new TeamMemberDTO(tm));
        }

        return resp;
    }

    public ResponseDTO getRiverInCountry(Integer countryID) {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("River.findByCountryID", River.class);
        q.setParameter("countryID", countryID);
        List<River> list = q.getResultList();
        for (River riv : list) {
            resp.getRiverList().add(new RiverDTO(riv));
        }

        return resp;
    }

    
    public ResponseDTO getRiverList() {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("River.findAll", River.class);
        List<River> list = q.getResultList();
        for (River riv : list) {
            resp.getRiverList().add(new RiverDTO(riv));
        }

        return resp;
    }

    public ResponseDTO getRiverTownList(Integer riverID) {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("River.findByRiverID", Rivertown.class);
        q.setParameter("riverID", riverID);
        List<River> list = q.getResultList();
        for (River riv : list) {
            resp.getRiverList().add(new RiverDTO(riv));
        }

        return resp;
    }

    public ResponseDTO getCommentList() {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("Comment.findAll", Comment.class);
        List<Comment> list = q.getResultList();
        for (Comment com : list) {
            resp.getCommentList().add(new CommentDTO(com));
        }

        return resp;
    }

    public ResponseDTO getEvaluationList() {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("Evaluation.findAll", Evaluation.class);
        List<Evaluation> list = q.getResultList();
        for (Evaluation eva : list) {
            resp.getEvaluationList().add(new EvaluationDTO(eva));
        }

        return resp;
    }

    public ResponseDTO getEvaluationSiteList(Integer evaluationSiteID) {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("EvaluationSite.findByEvaluationSiteID", Evaluationsite.class);
        q.setParameter("evaluationSiteID", evaluationSiteID);
        List<Evaluationsite> list = q.getResultList();
        for (Evaluationsite es : list) {
            resp.getEvaluationSiteList().add(new EvaluationSiteDTO(es));
        }

        return resp;
    }

    public ResponseDTO getCategoryList() {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("Category.findAll", Category.class);
        List<Category> list = q.getResultList();
        for (Category cat : list) {
            resp.getCategoryList().add(new CategoryDTO(cat));
        }

        return resp;
    }

    public ResponseDTO getTeamList() {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("Team.findAll", Team.class);
        List<Team> list = q.getResultList();
        for (Team tea : list) {
            resp.getTeamList().add(new TeamDTO(tea));
        }
    return resp;
    }
    
    public ResponseDTO getEvaluationSiteList() {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("Evaluatiosite.findAll", Evaluationsite.class);
        List<Evaluationsite> list = q.getResultList();
        for (Evaluationsite es : list) {
            resp.getEvaluationSiteList().add(new EvaluationSiteDTO(es));
        }

        return resp;
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
