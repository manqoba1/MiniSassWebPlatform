/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.dvs.util;

import com.google.android.gcm.server.Constants;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.sifiso.dvs.data.Gcmdevice;

import java.io.IOException;
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

/**
 *
 * @author aubreyM
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CloudMsgUtil {

    @PersistenceContext
    EntityManager em;
    private static final int RETRIES = 5;
    public static final String API_KEY = "AIzaSyB-FM6qVRi_vzU5JOGoqmNW28S5tZT-CNU";

    /*public ResponseDTO sendTeacherToParentMessage(VisitDTO req, PlatformUtil platformUtil, DataUtil dataUtil) throws
            Exception, DataException {

        ResponseDTO resp = new ResponseDTO();
        //write record to table

        Student st = em.find(Student.class, req.getStudentID());

        Issue h = new Issue();
        h.setIssueDate(new Date());
        h.setMessage(req.getMessage());
        h.setStudent(em.find(Student.class, req.getStudentID()));
        h.setTeacher(em.find(Teacher.class, req.getTeacherID()));

        try {
            em.persist(h);
            em.flush();
            
            LOG.log(Level.INFO, "HelpResponse added to db");
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "HelpResponse add failed", e);
            throw new DataException("HelpResponse add failed\n" + dataUtil.getErrorString(e));
        }

        resp.setIssue(new IssueDTO(h));
        LOG.log(Level.INFO, "Teacher to Parent msg added");
        //send message to Google servers
        Sender sender = new Sender(API_KEY);
        Gson g = new Gson();
        String txJSON = g.toJson(resp);
        Message message = new Message.Builder()
                .addData("message", txJSON)
                .addData("dateStamp", "" + new Date().getTime()).build();

        List<String> registrationIDs = new ArrayList<>();
        Parent pt = st.getParent();
        
        for (Gcmdevice m : pt.getGcmdeviceList()) {
            registrationIDs.add(m.getRegistrationID());
        }
        if (registrationIDs.isEmpty()) {
            LOG.log(Level.SEVERE, "#### No trainee registrationIDs found for instructor to send message to trainee");
            resp.setMessage("No trainee found or their devices are not registered");
            resp.setStatusCode(RETRIES);
            platformUtil.addServerError(889, "#### No trainee devices found for instructor to send message to.", "Cloud Message Services");
            return resp;
        }
        boolean OK;
        String rMsg;
        if (registrationIDs.size() == 1) {
            Result result = sender.send(message, registrationIDs.get(0), RETRIES);
            OK = handleResult(result, platformUtil);
        } else {
            MulticastResult multiCastResult = sender.send(
                    message, registrationIDs, RETRIES);
            OK = handleMultiCastResult(multiCastResult, platformUtil);
        }
        if (OK) {
            rMsg = "Google GCM - message has been sent to Google servers";
        } else {
            rMsg = "Google GCM - message has not been sent. Error occured";
            resp.setStatusCode(ResponseDTO.ERROR_SERVER);
            resp.setMessage(rMsg);
            platformUtil.addServerError(889, "Google GCM - message has not been sent. Error occured", "Cloud Message Services");
        }
        resp.setMessage(rMsg);
        return resp;

    }*/

    private List<Gcmdevice> getDevices(int companyID) {
        Query q = em.createNamedQuery("GcmDevice.findInstructorDevices");
        q.setParameter("id", companyID);
        return q.getResultList();
    }

    public static final int GCM_MESSAGE_ERROR = 3, ALL_OK = 0;

    public int sendMessage(String json, List<String> registrationIDs, PlatformUtil platformUtil) throws IOException, Exception {
        Sender sender = new Sender(API_KEY);
        Message message = new Message.Builder()
                .addData("message", json)
                .addData("dateStamp", "" + new Date().getTime()).build();

        boolean OK;
        if (registrationIDs.size() == 1) {
            Result result = sender.send(message, registrationIDs.get(0), RETRIES);
            OK = handleResult(result, platformUtil);
        } else {
            MulticastResult multiCastResult = sender.send(
                    message, registrationIDs, RETRIES);
            OK = handleMultiCastResult(multiCastResult, platformUtil);
        }
        if (!OK) {
            platformUtil.addServerError(89, "Google GCM - message has not been sent. Error occured", "Cloud Message Services");
            return GCM_MESSAGE_ERROR;
        }
        return ALL_OK;
    }

    private boolean handleResult(Result result, PlatformUtil platformUtil)
            throws Exception {

        LOG.log(Level.INFO, "Handle result from Google GCM servers: {0}", result.toString());
        if (result.getErrorCodeName() != null) {
            if (result.getErrorCodeName().equals(
                    Constants.ERROR_NOT_REGISTERED)) {
                // TODO remove the registration from the database
                LOG.log(Level.SEVERE, "#### GCM device not registered");
                platformUtil.addServerError(889, "#### GCM device not registered", "Cloud Message Services");
                return false;
            }
            if (result.getErrorCodeName().equals(
                    Constants.ERROR_UNAVAILABLE)) {
                LOG.log(Level.SEVERE, "#### GCM servers not available");
                platformUtil.addServerError(889, "#### GCM servers not available", "Cloud Message Services");
                return false;
            }
            LOG.log(Level.SEVERE, "#### GCM message send error : {0}",
                    result.getErrorCodeName());
            platformUtil.addServerError(889, "#### GCM message send error\nErrorCodeName: " + result.getErrorCodeName(), "Cloud Message Services");
            return false;
        }

        if (result.getMessageId() != null) {
            LOG.log(Level.INFO, "Result messageID from GCM: {0}", result.getMessageId());
            if (result.getCanonicalRegistrationId() != null) {
                LOG.log(Level.INFO,
                        "### Google GCM - canonical registration id found, updating db ...");
                //TODO update device registration id
                //EntityManager em = EMUtil.getEntityManager();

            }
        }
        return true;
    }

    private boolean handleMultiCastResult(MulticastResult multiCastResult, PlatformUtil platformUtil)
            throws Exception {
        LOG.log(Level.INFO, "Handle result from Google GCM servers: {0}", multiCastResult.toString());
        if (multiCastResult.getFailure() == 0
                && multiCastResult.getCanonicalIds() == 0) {
            LOG.log(Level.INFO, "### Google Cloud message send is OK, messages: {0}", multiCastResult.getTotal());
            return true;
        }
        LOG.log(Level.INFO,
                "### Google GCM - iterating through multicast Result for errors...");
        for (Result result : multiCastResult.getResults()) {
            if (result.getErrorCodeName() != null) {
                if (result.getErrorCodeName().equals(
                        Constants.ERROR_NOT_REGISTERED)) {
                    // TODO remove the registration from the database
                    LOG.log(Level.SEVERE, "#### GCM device not registered");
                    platformUtil.addServerError(889, "#### GCM device not registered", "Cloud Message Services");
                    return false;
                }
                if (result.getErrorCodeName().equals(
                        Constants.ERROR_UNAVAILABLE)) {
                    // TODO resubmit this message after back-off
                    LOG.log(Level.SEVERE, "#### GCM servers not available");
                    platformUtil.addServerError(889, "#### GCM servers not available", "Cloud Message Services");
                    return false;
                }
                LOG.log(Level.SEVERE, "#### GCM message send error : {0}",
                        result.getErrorCodeName());
                platformUtil.addServerError(889, "#### GCM message send error\nErrorCodeName: " + result.getErrorCodeName(), "Cloud Message Services");
                return false;
            }

            if (result.getMessageId() != null) {
                LOG.log(Level.INFO, "Result messageID from GCM: {0}", result.getMessageId());
                if (result.getCanonicalRegistrationId() != null) {
                    LOG.log(Level.INFO,
                            "### Google GCM - canonical registration id found, updating db ...");
                    //update device registration id - query by gcmdevice by reg id ???????????

                }
            }
        }
        return true;
    }
    static final Logger LOG = Logger.getLogger("CloudMsgUtil");
}
