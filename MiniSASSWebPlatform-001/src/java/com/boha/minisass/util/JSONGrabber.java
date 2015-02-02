package com.boha.minisass.util;

import com.boha.minisass.dto.ProvinceDTO;
import com.boha.minisass.transfer.RequestDTO;
import com.google.gson.Gson;

/**
 *
 * @author aubreyM
 */
public class JSONGrabber {
    
    public static void main(String[] args) {
        
        //create the object you want in the servlet
        RequestDTO req = new RequestDTO();
        req.setRequestType(101);
        
        ProvinceDTO prov = new ProvinceDTO();
        prov.setProvinceID(3);
        prov.setProvinceName("Gauteng");
        
        req.setProvince(prov);
        
        //turn the REquestDTO object into a JSON string
        
        Gson gson = new Gson();     
        String json = gson.toJson(req);
        
        System.out.println("JSON created\n" + json);
    } 
}

/* THE RESULT

JSON created
{"requestType":101,"province":{"provinceID":3,"provinceName":"Gauteng"}}

*/