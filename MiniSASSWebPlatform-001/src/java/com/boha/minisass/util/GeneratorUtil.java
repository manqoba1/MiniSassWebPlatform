/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.minisass.util;

import com.boha.minisass.data.Country;
import com.boha.minisass.data.River;
import com.boha.minisass.data.Team;
import com.boha.minisass.data.Teammember;
import com.boha.minisass.dto.RiverDTO;
import com.boha.minisass.dto.TeamDTO;
import com.boha.minisass.dto.TeamMemberDTO;
import com.boha.minisass.transfer.ResponseDTO;
import static com.boha.minisass.util.DataUtil.log;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 *
 * @author CodeTribe1
 */

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GeneratorUtil {
   
    
        //constants array firstNames strings
public  String[] firstNames = { "george","kim","kurisani","Sfiso","Chris","Thabang","Hosea",
    "Siya","Danny","Ross","Gee","Curtis","Jojo","Aubrey","Rulani","Dereck","Lee","Jacob","Julius"};

//constants array surnames strings
public  String[] surnaames = {"kapoya","Chauke","Smith","Matsobane","Zuma","Malema","Maluleka",
           "Modise","Kekana","Lawrence","Willis","Chan","Lee","Ford","Haris","Malabie","Jackson"};
   

//constants array team strings
public String[] TeamNames = {"Mabopane High shcool","Hoër Volkskool","Funda High School",
    "Mhlotshana High School","Laudium Secondary School","Giyani High School",
    "Capricon High School",
    "Makgongoana High School","Maroba High School","Thagaetala High School",
    "Hoërskool Wesvalia ","Amnesty International ",
    "Conquest For Life","love life","Pink drive","Sonlife Africa","Yazisa",
    "Kasi Hive","CodeTribe","Geekulcha","Muxum","Think Bike!","UNDP","Red Cross","Africa United"};

 //create random new random number generator for use in generateProject method
     public static final Random randomNumbers = new Random();
    @PersistenceContext
    EntityManager em;
    
    public ResponseDTO generateTeam(ListUtil listUtil,TeamDTO team, TeamMemberDTO teamMemberDTO)  throws DataException{
        log.log(Level.OFF, "*******Attempt to generate team.........");
        ResponseDTO resp = new ResponseDTO();
        try{
            for (int i = 0; i < 20; i++){
        Team t = new Team();
        t.setTeamName(TeamNames[randomNumbers.nextInt(TeamNames.length - 1)]);
        em.persist(t);
        em.flush();  
        //TeamMembers    
      Teammember tm = new Teammember();
      tm.setFirstName(firstNames[randomNumbers.nextInt(firstNames.length - 1)]);
      tm.setLastName(surnaames[randomNumbers.nextInt(surnaames.length - 1)]);
      tm.setEmail(firstNames[randomNumbers.nextInt(firstNames.length - 1)]+ "@gmail.com");
      tm.setCellphone("076 234 451" + randomNumbers.nextInt() );
      tm.setDateRegistered(new Date());
      tm.setPin("123" + randomNumbers.nextInt());
      tm.setActiveFlag(randomNumbers.nextInt()); 
            }
        } catch (PersistenceException e){    
       log.log(Level.SEVERE, "Failed", e);
            resp.setStatusCode(301);
            resp.setMessage("Duplicate detected, request ignored./nPlease try again");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException("Failed to generate TeaM\n" );
        }    
     return  resp;
    }    
    
     public ResponseDTO generateRiver(RiverDTO riv) throws DataException {
          log.log(Level.OFF, "*******Attempt to generate a river.........");
        ResponseDTO resp = new ResponseDTO();
        
        try{
            for (int i = 0; i < 20; i++){
              River ri = new River();
            Country cou = em.find(Country.class, riv.getOriginCountryID());
            ri.setDateRegistered(new Date());
           // ri.setEndLongitude(riv.getEndLongitude());
            //ri.setEndLatitude(riv.getEndLatitude());
            ri.setEndCountry(cou);
            ri.setRiverName(riverNames[randomNumbers.nextInt(riverNames.length -1)]);
           // ri.setOriginLatitude(riv.getOriginLatitude());
            //ri.setOriginLongitude(riv.getOriginLongitude());
            ri.setOriginCountry(cou);

            em.persist(ri);
            em.flush();
            resp.getRiverList().add(new RiverDTO(ri));
            log.log(Level.OFF, " River has been generated successfully : {0}", ri.getRiverName());       
            }
        }
             catch (PersistenceException e){    
       log.log(Level.SEVERE, "Failed", e);
            resp.setStatusCode(301);
            resp.setMessage("Duplicate detected, request ignored./nPlease try again");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException("Failed to generate TeaM\n" );
                }     
     
        return resp;
        
     } 
    public String[] riverNames = {"Bhira River","Bivane River","Blesbokspruit","Bloukrans River","Bloukrans River",
        "Elands River","Ga-Selati River","Gamka River","Gamtoos River","Bamboesspruit (or Bamboes Spruit0","Baviaanskloof River","Bell River",
        "Berg River (or Great Berg River)","Black Kei River","Blesbokspruit (or Blesbok Spruit)","Blood River (or Ncome River)","Bloukrans River",
        "Bloukrans River","Bloukrans River","Blyde River (or Motlatse River)","Boesmans River","Boesmans River",
        "Boesmanspruit (or Boesman Spruit)","Bonte River","Bot River","Braamfontein Spruit (or Braamfonteinspruit)",
        "Brak River","Breede River (or Breë River)","Bronkhorst Spruit(or Bronkhorstspruit)","Buffalo River (Eastern Cape)",
        "Buffalo River (KwaZulu-Natal)","Buffels River","Buffels River","Bushman River","Caledon River"
    
       };  
    
}
