package com.boha.minisass.util;

import com.boha.minisass.dto.EvaluationDTO;
import com.boha.minisass.transfer.RequestDTO;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author aubreyM
 */
public class JSONGrabber {

    public static void main(String[] args) {

        //create the object you want in the servlet
        RequestDTO req = new RequestDTO();
        req.setRequestType(101);

        EvaluationDTO e = new EvaluationDTO();
        e.setComment("water is clean");
        e.setLatitude(0.2);
        e.setLongitude(0.4);
        e.setOxygen(0.6);
        e.setPH(0.8);
        e.setRemarks("ggggggg");
        e.setScore(0.2);
        e.setWaterClarity(0.3);
        e.setWaterTemperature(0.3);
        e.setEvaluationDate(new Date().getTime());
        e.setTeamMemberID(1);
        e.setConditionsID(1);
        e.setEvaluationSiteID(1);

        req.setEvaluation(e);

        //turn the REquestDTO object into a JSON string
        Gson gson = new Gson();
        String json = gson.toJson(req);

        System.out.println("JSON created\n" + json);
        JSONGrabber grabber = new JSONGrabber();
        grabber.run();
    }

    public void run() {

        String csvFile = "C:/Users/CodeTribe1/Downloads/RiversExcel.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);

                System.out.println("Country [code= " + country[0]
                        + " , name=" + country[2] + "]");

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Done");
    }
}

/* THE RESULT

 JSON created
 {"requestType":101,"province":{"provinceID":3,"provinceName":"Gauteng"}}

 */
