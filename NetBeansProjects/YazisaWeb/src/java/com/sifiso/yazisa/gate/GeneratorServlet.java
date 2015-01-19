/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.gate;

import com.google.gson.Gson;
import com.sifiso.yazisa.transfer.dto.ResponseDTO;
import com.sifiso.yazisa.util.DataUtil;
import com.sifiso.yazisa.util.Generator;
import com.sifiso.yazisa.util.ListUtil;
import com.sifiso.yazisa.util.PlatformUtil;
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
@WebServlet(name = "GeneratorServlet", urlPatterns = {"/gs"})
public class GeneratorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
    Generator generator;
    @EJB
    DataUtil dataUtil;
    @EJB
    ListUtil listUtil;
    @EJB
    PlatformUtil platformUtil;
    Gson gson = new Gson();

    static final Logger log = Logger.getLogger(GeneratorServlet.class.getSimpleName());

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //generator.generate();
        int row = generator.attendanceCounts(11, 3);
        PrintWriter out = response.getWriter();
        log.log(Level.INFO, "Count{0}", row);//Thabo@gmail.com, 206
        ResponseDTO resp = null;
        try {
           // resp = dataUtil.loginParent("Sifiso@gmail.com", "558", listUtil, platformUtil);
            //snpeace.sifiso@gmail.com,123
            resp = listUtil.getStudentDataByID(2);
            //resp = listUtil.getStudentList(5);
        } catch (Exception e) {
            log.log(Level.INFO, "Count{0}", e);
        } finally {
            String json = gson.toJson(resp);
            out.println(json);
            out.close();
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

}
