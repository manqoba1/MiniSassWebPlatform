
package com.boha.minisass.gate;

import com.boha.minisass.data.Teammember;
import static com.boha.minisass.gate.CachedRequestWebSocket.log;
import com.boha.minisass.transfer.RequestDTO;
import com.boha.minisass.transfer.ResponseDTO;
import com.boha.minisass.util.DataUtil;
import com.boha.minisass.util.GZipUtility;
import com.boha.minisass.util.ListUtil;
import com.boha.minisass.util.PlatformUtil;
import com.boha.minisass.util.TrafficCop;
import java.nio.ByteBuffer;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author CodeTribe1
 */

@ServerEndpoint("/wsteam")
@Stateless
public class TeamWebsockect {
    
    Gson gson = new Gson();
    static final Logger log = Logger.getLogger(TeamWebsockect.class.getSimpleName()); 
    @EJB
    DataUtil dataUtil;
    @EJB
    ListUtil listUtil;
    @EJB
    TrafficCop trafficCop;
    @EJB
    PlatformUtil platformUtil;
    @EJB
    Teammember teammember;
    
    static final String SOURCE = "teamWebSocket";
    
     public static final Set<Session> peers
            = Collections.synchronizedSet(new HashSet<Session>());
    
    
       @OnMessage
    public ByteBuffer onMessage(String message) {
        log.log(Level.WARNING, "***** onMessage: {0}", message);
        ResponseDTO resp = new ResponseDTO();
        ByteBuffer gg = null;
        
        try {
            RequestDTO dto = gson.fromJson(message, RequestDTO.class);
            resp = trafficCop.processRequest(dto, 
                    dataUtil, listUtil,teammember);
            gg = GZipUtility.getZippedResponse(resp);
        } catch (Exception ex) {
            log.log(Level.SEVERE, null, ex);
            resp.setStatusCode(111);
            resp.setMessage("Problem processing request on server");
            dataUtil.addErrorStore(19, dataUtil.getErrorString(ex), SOURCE);
            try {
                gg = GZipUtility.getZippedResponse(resp);
            } catch (Exception ex1) {
                log.log(Level.SEVERE, "Failed to zip error response!!!!!!!!", ex1);
            }
        }
        return gg;
    }
    
      @OnOpen
    public void onOpen(Session session) {
        peers.add(session);
        try {
            ResponseDTO r = new ResponseDTO();
            r.setSessionID(session.getId());
            r.setStatusCode(0);
            session.getBasicRemote().sendText(gson.toJson(r));
            log.log(Level.WARNING, "******** onOpen...sent....session id: {0}", session.getId());
        } catch (IOException ex) {
            log.log(Level.SEVERE, "Failed to send websocket sessionID keep digging", ex);
        }
    }

    @OnClose
    public void onClose(Session session
    ) {
        log.log(Level.WARNING, "onClose - remove session: {0}", session.getId());
        for (Session mSession : peers) {
            if (session.getId().equalsIgnoreCase(mSession.getId())) {
                peers.remove(mSession);
                break;
            }
        }
    }

       @OnError
    public void onError(Session session, Throwable t) {
        log.log(Level.SEVERE, "### @OnError, websocket failed.......please check your connection");
        try {
            session.getBasicRemote().sendText("Eish!!!!!!!, something went wrong!");
        } catch (IOException ex) {
            Logger.getLogger(TeamWebsockect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    
     
    
}