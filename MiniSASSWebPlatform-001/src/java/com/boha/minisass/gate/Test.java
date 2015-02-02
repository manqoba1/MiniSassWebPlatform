/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.minisass.gate;

import com.boha.minisass.transfer.RequestDTO;
import com.boha.minisass.transfer.ResponseDTO;
import com.boha.minisass.util.DataUtil;
import com.boha.minisass.util.ListUtil;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CodeTribe1
 */
@WebServlet(name = "Test", urlPatterns = {"/test1"})
public class Test extends HttpServlet {

    @EJB
    DataUtil dataUtil;

    @EJB
    ListUtil listUtil;

    Gson gson = new Gson();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        log.log(Level.OFF, "Servlet starting ...");
        PrintWriter out = response.getWriter();
        String json;
        ResponseDTO ur = new ResponseDTO();
        try {
            RequestDTO req = getRequest(request);

            switch (req.getRequestType()) {
                case RequestDTO.REGISTER_TEAM:
                    ur = dataUtil.registerTeam(req.getTeam());
                    break;
                case RequestDTO.REGISTER_TEAM_MEMBER:
                    ur = dataUtil.registerTeamMember(req.getTeamMember());
                    break;
                case RequestDTO.ADD_COMMENT:
                    ur = dataUtil.addComment(req.getComment());
                    break;
                case RequestDTO.ADD_COUNTRY:
                    ur = dataUtil.addCountry(req.getCountry());
                    break;
                case RequestDTO.ADD_EVALUATION:
                    ur = dataUtil.addEvaluation(req.getEvaluation());
                    break;
                case RequestDTO.ADD_EVALUATION_SITE:
                    ur = dataUtil.addEvaluationSite(req.getEvaluationSite());
                    break;
                case RequestDTO.ADD_INSECT_IMAGE:
                    ur = dataUtil.addInsertImage(req.getInsectImage());
                    break;
                case RequestDTO.ADD_PROVINCE:
                    ur = dataUtil.addProvince(req.getProvince());
                    break;
                case RequestDTO.ADD_RIVER:
                    //  ur = dataUtil.
                    break;
                case RequestDTO.ADD_RIVER_TOWN:
                    ur = dataUtil.addRiverTown(req.getRiverTown());
                    break;
                case RequestDTO.ADD_TOWN:
                    ur = dataUtil.addTown(req.getTown());
                    break;
                case RequestDTO.LIST_EVALUATIONS_BY_RIVER:
                    ur = listUtil.getEvaluationList(req.getRiver().getRiverID());
                    break;
                case RequestDTO.LIST_EVALUATION_SITES:
                    ur = listUtil.getEvaluationList(req.getEvaluationSite().getEvaluationSiteID());
                    break;
                case RequestDTO.LIST_INSECTS:
                    ur = listUtil.getInsectList();
                    break;
                case RequestDTO.LIST_RIVER_TOWNS:
                    ur = listUtil.getRiverTownList(req.getRiverTown().getRiverTownID());
                    break;
                case RequestDTO.LIST_TEAMS:
                    ur = listUtil.getTeamList(req.getTeam().getTeamID());
                    break;
                case RequestDTO.LIST_RIVERS_IN_COUNTRY:
                    ur = listUtil.getRiverList(req.getRiver().getRiverID());
                    break;
                case RequestDTO.LIST_ALL_PROVINCES:
                    ur = listUtil.getAllProvince();
                    break;
                     
                case RequestDTO.LIST_ROVINCE_COUNTRY:
                    log.log(Level.OFF, "ProvinceID checking in progress.....");
                    if (req.getProvince() == null) {
                        log.log(Level.OFF, "ProvinceID is null....why???");
                        ur.setStatusCode(777);
                        ur.setMessage("Debugging ProvinceID - is NULL!!");
                        
                    } else {
                    ur = listUtil.getProvinceByCountry(req.getCountry().getCountryID());
                    }
                    break;

                default:
                    ur.setStatusCode(444);
                    ur.setMessage("#### Unknown Request");
                    log.log(Level.SEVERE, "Couldn't find request,you fool");
                    break;

            }
        } catch (Exception ex) {
            log.log(Level.OFF, "Failed.....{0}", ex);
            ur.setStatusCode(10);
            ur.setMessage("broken sasa u r nt a geek");
        } finally {
            json = gson.toJson(ur);
            out.println(json);
            out.close();
            log.log(Level.OFF, "Servlet ending");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private RequestDTO getRequest(HttpServletRequest req) {
        String json = req.getParameter("JSON");
        RequestDTO re = null;
        if (json == null) {
            log.log(Level.OFF, "Json parameter not found...");
            re = new RequestDTO();
            re.setRequestType(0);
            return re;
        }

        try {
            re = gson.fromJson(json, RequestDTO.class);
            log.log(Level.INFO, "JSON okay. ...");
        } catch (Exception e) {
            log.log(Level.OFF, "JSON is not okay. ...");
            re = new RequestDTO();
            re.setRequestType(0);
        }
        return re;
    }
    
    static final Logger log = Logger.getLogger(Test.class.getSimpleName());
}
