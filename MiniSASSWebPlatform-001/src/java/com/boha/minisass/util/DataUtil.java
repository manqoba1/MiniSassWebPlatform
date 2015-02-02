package com.boha.minisass.util;

import com.boha.minisass.data.Category;
import com.boha.minisass.data.Comment;
import com.boha.minisass.data.Country;
import com.boha.minisass.data.ErrorStore;
import com.boha.minisass.data.ErrorStoreAndroid;
import com.boha.minisass.data.Evaluation;
import com.boha.minisass.data.EvaluationSite;
import com.boha.minisass.data.Insect;
import com.boha.minisass.data.InsectImage;
import com.boha.minisass.data.Province;
import com.boha.minisass.data.River;
import com.boha.minisass.data.RiverTown;
import com.boha.minisass.data.Team;
import com.boha.minisass.data.TeamMember;
import com.boha.minisass.data.Town;
import com.boha.minisass.dto.CategoryDTO;
import com.boha.minisass.dto.CommentDTO;
import com.boha.minisass.dto.CountryDTO;
import com.boha.minisass.dto.ErrorStoreDTO;
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
import com.boha.minisass.transfer.ResponseDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.joda.time.DateTime;

/**
 *
 * @author CodeTribe1
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DataUtil {
    @PersistenceContext
    EntityManager em;
    
     public EntityManager getEm() {
        return em;
    }
     
      public ResponseDTO registerTeamMember(TeamMemberDTO member) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            TeamMember tm = new TeamMember();
            if (member != null | member.getTeamMemberID() != null) {
                tm.setTeam(em.find(Team.class, member.getTeamID()));
            }
            tm.setFirstName(member.getFirstName());
            tm.setLastName(member.getLastName());
            tm.setEmail(member.getEmail());
            tm.setCellphone(member.getCellphone());
            tm.setActiveFlag(member.getActiveFlag());
            tm.setPin(member.getPin());
            tm.setTeamMemberID(member.getTeamMemberID());

            em.persist(tm);
            em.flush();

            resp.getTeamMemberList().add(new TeamMemberDTO(tm));

            log.log(Level.OFF, "Citizen has been registered for: {0} ",
                    new Object[]{tm.getFirstName()});

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException("Failed");
        }
        return resp;
    }
    
      public ResponseDTO registerTeam(TeamDTO team) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Team t = new Team();
            if (team != null | team.getTeamID() != null) {
                t.setTown(em.find(Town.class, team.getTownID()));
            }
            
            t.setTeamName(team.getTeamName());
            t.setDateRegistered(new Date());
            t.setTeamID(team.getTeamID());

            em.persist(t);
            em.flush();

            resp.getTeamList().add(new TeamDTO(t));

            log.log(Level.OFF, "Team has been registered for: {0} ",
                    new Object[]{t.getTeamName()});

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException("Failed");
        }
        return resp;
    }
      
     public ResponseDTO addEvaluationSite(EvaluationSiteDTO site) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            EvaluationSite ts = new EvaluationSite();
            if (site != null | site.getEvaluationSiteID() != null) {
                ts.setRiver(em.find(River.class, site.getRiverID()));
            }
            else
                if (site != null | site.getEvaluationSiteID() != null) {
                ts.setCategory(em.find(Category.class, site.getCategoryID()));
            }
            
            ts.setDateRegistered(new Date());
            ts.setLatitude(site.getLatitude());
            ts.setLongitude(site.getLongitude());

            em.persist(ts);
            em.flush();

            resp.getEvaluationSiteList().add(new EvaluationSiteDTO(ts));

            log.log(Level.OFF, "Evaluation site has been registered for: {0} ",
                    new Object[]{ts.getDateRegistered()});

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException("Failed");
        }
        return resp;
    }
     
     public ResponseDTO addInsect(InsectDTO insect) throws DataException{
         ResponseDTO resp = new ResponseDTO();
        try {
            Insect i = new Insect();
            i.setGroupName(insect.getGroupName());
            i.setInsectID(insect.getInsectID());
            i.setSensitivityScore(insect.getSensitivityScore());
            
            em.persist(i);
            em.flush();

            resp.getInsectList().add(new InsectDTO(i));

            log.log(Level.OFF, "province has been added for: {0} ",
                    new Object[]{i.getGroupName()});

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException("Failed");
        }
        return resp;
     }
      public ResponseDTO addCtategory(CategoryDTO category) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Category c = new Category();
            c.setCategoryID(category.getCategoryID());
            c.setCategoryName(category.getCategoryName());
            
            em.persist(c);
            em.flush();

            resp.getCategoryList().add(new CategoryDTO(c));

            log.log(Level.OFF, "province has been added for: {0} ",
                    new Object[]{c.getCategoryName()});

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException("Failed");
        }
        return resp;
    }
     public ResponseDTO addProvince(ProvinceDTO province) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Province p = new Province();
            p.setLatitude(province.getLatitude());
            p.setLongitude(province.getLongitude());
            p.setProvinceName(province.getProvinceName());

            em.persist(p);
            em.flush();

            resp.getProvinceList().add(new ProvinceDTO(p));

            log.log(Level.OFF, "province has been added for: {0} ",
                    new Object[]{p.getProvinceName()});

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException("Failed");
        }
        return resp;
    }
      
    
      public ResponseDTO addRiverTown(RiverTownDTO rivert) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            RiverTown rt = new RiverTown();
            if (rivert != null | rivert.getRiverTownID()!= null) {
                rt.setRiver(em.find(River.class, rt.getRiverTownID()));
                rt.setTown(em.find(Town.class, rt.getRiverTownID()));
            }
            
            rt.setRiverTownID(rivert.getRiverTownID());
           
            em.persist(rt);
            em.flush();
            
            resp.getRiverTownList().add(new RiverTownDTO(rt));

            log.log(Level.OFF, "River town has been added for: {0} ",
                    new Object[]{rt.getRiverTownID()});

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException("Failed");
        }
        return resp;
    }
      
       public ResponseDTO addComment(CommentDTO comment) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Comment cm = new Comment();
            cm.setCommentID(comment.getCommentID());
            cm.setRemarks(comment.getRemarks());
           
            em.persist(cm);
            em.flush();
            
            resp.getCommentList().add(new CommentDTO(cm));

            log.log(Level.OFF, "comment has been added for: {0} ",
                    new Object[]{cm.getCommentID()});

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException("Failed");
        }
        return resp;
    }
     public ResponseDTO addEvaluation(EvaluationDTO evaluation) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Evaluation e = new Evaluation();
             if (evaluation != null | evaluation.getEvaluationID()!= null) {
                 e.setTeamMember(em.find(TeamMember.class, e.getTeamMember()));
                 e.setEvaluationSite(em.find(EvaluationSite.class, e.getEvaluationSite()));
                
            }
            e.setConditionID(e.getConditionID());
           
            em.persist(e);
            em.flush();
            
            resp.getEvaluationList().add(new EvaluationDTO(e));

            log.log(Level.OFF, "comment has been added for: {0} ",
                    new Object[]{e.getEvaluationID()});

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException("Failed");
        }
        return resp;
    }
    public ResponseDTO addTown(TownDTO town) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Town tw = new Town();
            tw.setTownName(town.getTownName());
            tw.setTownID(town.getTownID());
            tw.setLatitude(town.getLatitude());
            tw.setLongitude(town.getLongitude());
            tw.setProvince(em.find(Province.class, town.getProvinceID()));

            em.persist(tw);
            em.flush();
            resp.getTownList().add(new TownDTO(tw));

            log.log(Level.OFF, "Township has been added for: {0} ",
                    new Object[]{tw.getTownName()});

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException("Failed");
        }
        return resp;
    }

 public ResponseDTO addCountry(CountryDTO country) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Country ct = new Country();
            ct.setCountryID(country.getCountryID());
            ct.setCountryName(country.getCountryName());
            ct.setLatitude(country.getLatitude());
            ct.setLongitude(country.getLongitude());
           

            em.persist(ct);
            em.flush();
            resp.getCountryList().add(new CountryDTO(ct));

            log.log(Level.OFF, "Township has been added for: {0} ",
                    new Object[]{ct.getCountryName()});

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException("Failed");
        }
        return resp;
    }
 public ResponseDTO addInsertImage(InsectImageDTO image) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            InsectImage i = new InsectImage();
            
             if (image != null | image.getInsectImageID()!= null) {
                 i.setInsect(em.find(Insect.class,i.getInsect()));
                
            }
            i.setDateRegistered(new Date());
            i.setInsectImageID(image.getInsectImageID());
            i.setUri(image.getUri());

            em.persist(i);
            em.flush();
            resp.getInsectList().add(new InsectDTO());

            log.log(Level.OFF, "Township has been added for: {0} ",
                    new Object[]{i.getUri()});

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException("Failed");
        }
        return resp;
    }
 
   public void updateRiver(RiverDTO dto) throws DataException {
        try {
            River r = em.find(River.class, dto.getRiverID());
            if (r != null) {
                if (dto.getRiverName() != null) {
                    r.setRiverName(dto.getRiverName());
                }
                if (dto.getOriginLongitude() != null) {
                    r.setOriginLongitude(dto.getOriginLongitude());
                }
                if(dto.getDateRegistered() !=null){
                    r.setDateRegistered(dto.getDateRegistered());
                }
                
                if(dto.getEndCountryID() !=null)
                {
                    //r.setEndCountry(dto.getEndCountry());
                }
                if(dto.getEndLatitude() !=null){
                    r.setEndLatitude(dto.getEndLatitude());
                }
                
                if(dto.getEndLongitude() !=null){
                    r.setEndLongitude(dto.getEndLongitude());
                }
                if(dto.getOriginCountryName() !=null){
                   // r.setOriginCountryName(dto.getOriginCountryName());
                }
                em.merge(r);
                log.log(Level.INFO, "River updated");
            }
        } catch (Exception e) {
            log.log(Level.OFF, null, e);
            throw new DataException("Failed to update river\n" + getErrorString(e));
        }

    }
    
    public void updateRiverTown(RiverTownDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            RiverTown rt = em.find(RiverTown.class, dto.getRiverTownID());
            if (rt != null) {
                if (dto.getRiverID() != null) {
                    rt.setRiver(new River());
                }
                
                if (dto.getTownID()!= null) {
                    rt.setTown(new Town());
                }
               
                em.merge(rt);
                log.log(Level.INFO, "River Town updated");
            }
        } catch (Exception e) {
            log.log(Level.OFF, null, e);
            throw new DataException("Failed to update river town\n" + getErrorString(e));
        }

    }
      
     public void updateEvaluationSite(EvaluationSiteDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            EvaluationSite ev = em.find(EvaluationSite.class, dto.getEvaluationSiteID());
            if (ev != null) {
                if (dto.getEvaluationSiteID() != null) {
                    ev.setEvaluationSiteID(dto.getEvaluationSiteID());
                } 
               
                em.merge(ev);
                log.log(Level.INFO, "Evaluation site updated");
            }
        } catch (Exception e) {
            log.log(Level.OFF, null, e);
            throw new DataException("Failed to update Evaluation site\n" + getErrorString(e));
        }

    }
    
     public ResponseDTO updateInsert(InsectDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Insect i = em.find(Insect.class, dto.getInsectID());
            if (i != null) {
                if (dto.getGroupName() != null) {
                    i.setGroupName(dto.getGroupName());
                }

                em.merge(i);
                log.log(Level.INFO, "Insect updated");
            }
        } catch (Exception e) {
            log.log(Level.OFF, null, e);
            throw new DataException("Failed to update Insect\n" + getErrorString(e));
        }

        return resp;
    }
     
     public ResponseDTO updateInsertImage(InsectImageDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            InsectImage ii = em.find(InsectImage.class, dto.getInsectImageID());
            if (ii != null) {
                if (dto.getDateRegistered() != null) {
                    ii.setDateRegistered(dto.getDateRegistered());
                }
                if(dto.getInsectID() !=null)
                {
                    ii.setInsect(new Insect());
                }
                if(dto.getUri() !=null){
                    ii.setUri(dto.getUri());
                }

                em.merge(ii);
                log.log(Level.INFO, "Insert Image updated");
            }
        } catch (Exception e) {
            log.log(Level.OFF, null, e);
            throw new DataException("Failed to update Insect Image\n" + getErrorString(e));
        }

        return resp;
    }
     
    
     
     public void addAndroidError(ErrorStoreAndroid err) throws DataException {
        try {
            em.persist(err);
            log.log(Level.INFO, "Android error added");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to add Android Error", e);
            throw new DataException("Failed to add Android Error\n"
                    + getErrorString(e));
        }
    }
      
      
      public ResponseDTO getServerErrors(
            long startDate, long endDate) throws DataException {
        ResponseDTO r = new ResponseDTO();
        if (startDate == 0) {
            DateTime ed = new DateTime();
            DateTime sd = ed.minusMonths(3);
            startDate = sd.getMillis();
            endDate = ed.getMillis();
        }
        try {
            Query q = em.createNamedQuery("ErrorStore.findByPeriod", ErrorStore.class);
            q.setParameter("startDate", new Date(startDate));
            q.setParameter("endDate", new Date(endDate));
            List<ErrorStore> list = q.getResultList();
            List<ErrorStoreDTO> dList = new ArrayList();
            for (ErrorStore e : list) {
                dList.add(new ErrorStoreDTO(e));
            }
            r.setErrorStoreList(dList);
            log.log(Level.OFF, "Errors found {0}", r.getErrorStoreList().size());
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to getServerErrors");
            throw new DataException("Failed to getServerErrors\n"
                    + getErrorString(e));
        }
        return r;
    }
    
      public String getErrorString(Exception e) {
        StringBuilder sb = new StringBuilder();
        if (e.getMessage() != null) {
            sb.append(e.getMessage()).append("\n\n");
        }
        if (e.toString() != null) {
            sb.append(e.toString()).append("\n\n");
        }
        StackTraceElement[] s = e.getStackTrace();
        if (s.length > 0) {
            StackTraceElement ss = s[0];
            String method = ss.getMethodName();
            String cls = ss.getClassName();
            int line = ss.getLineNumber();
            sb.append("Class: ").append(cls).append("\n");
            sb.append("Method: ").append(method).append("\n");
            sb.append("Line Number: ").append(line).append("\n");
        }

        return sb.toString();
    }

     public void addErrorStore(int statusCode, String message, String origin) {
        log.log(Level.OFF, "------ adding errorStore, message: {0} origin: {1}", new Object[]{message, origin});
        try {
            ErrorStore t = new ErrorStore();
            t.setDateOccured(new Date());
            t.setMessage(message);
            t.setStatusCode(statusCode);
            t.setOrigin(origin);
            em.persist(t);
            log.log(Level.INFO, "####### ErrorStore row added, origin {0} \nmessage: {1}",
                    new Object[]{origin, message});
        } catch (Exception e) {
            log.log(Level.SEVERE, "####### Failed to add errorStore from " + origin + "\n" + message, e);
        }
    }
     static final Logger log = Logger.getLogger(DataUtil.class.getSimpleName());
}
