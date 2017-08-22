package com.test.controller;


import com.test.model.DAO;
import com.test.model.DAO2;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by kamel on 7/13/2016
 * and Peter on 8/15/2017
 * JAVA DREAM TEAM
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String Home() {
        return "test";// or views/test
    }

    @RequestMapping(value = "/customerForm")
    public String customerForm() {
        //if a controller method returns just a String
        //Spring MVC knows it's a view name
        return "customerForm";
    }

    @RequestMapping("/test")
    public ModelAndView viewresourceList () {
        ArrayList<Resources> resourceList = DAO2.getResourceList();


    //TODO: make error.jsp
        if (resourceList == null) {
        return new ModelAndView("error", "errmsg", "No more resources - null");
    }

        return new ModelAndView("test","rList", resourceList);

    }


    //handle the submit of the customer form
    @RequestMapping(value = "/addCustomer")
    public ModelAndView addCustomer (
        @RequestParam("CustomerID") String custID,
        @RequestParam("CompanyName") String compName,
        @RequestParam("ContactName") String contactName,
        @RequestParam("ContactTitle") String contactTitle
        ) {

        //add the info to DB through DAO
        boolean result = DAO.addCustomer(custID, compName, contactName, contactTitle);
        //best to check the result
        if (result == false) {
            //still have to write this view
            return new ModelAndView("error", "errmsg", "customer add failed");
        }

        ModelAndView mv = new ModelAndView("addResult");
        mv.addObject("CustomerID", custID);
        mv.addObject("CompanyName", compName);
        mv.addObject("ContactName", contactName);
        mv.addObject("ContactTitle", contactTitle);

        return mv;
    }

    @RequestMapping(value = "getAllCustomers")
    public ModelAndView getAllCustomers() {
        ArrayList<Customer> customerList = DAO.getCustomerList();

        //TODO: make error.jsp
        if (customerList == null) {
            return new ModelAndView("error", "errmsg", "Customer list is null");
        }

        return new ModelAndView("customerView","cList",customerList);
    }

    @RequestMapping("/deleteCustomer")
    public String deleteCustomer (
            Model model,
            @RequestParam("CustomerID") String custID) {
        //make it happen with the DB
        boolean result = DAO.deleteCustomer(custID);

        if (result == false) {
            model.addAttribute("errmsg", "Delete failed");
            return "error";
        }
        //adding info without a ModelAndView
        //get the model as a argument above
        //and add to it
        model.addAttribute("custID", custID);
        return "deleted";
    }
    @RequestMapping("/weather")
    public ModelAndView weather (){
        try {
            //this HttpClient will make requests from the other server
            HttpClient http = HttpClientBuilder.create().build();

            HttpHost host = new HttpHost("Forecast.weather.gov",80,"http");

            //HttpGet will actually retrieve the information from the specific URI
            HttpGet getPage = new HttpGet("/MapClick.php?lat=42.331427&lon=-83.045754&FcstType=json");

            //actually run it and pull in the response

            HttpResponse resp = http.execute(host, getPage);
            //get the actual content from inside the response
            String jsonString = EntityUtils.toString(resp.getEntity());

            //turn the string into an actual JSON object

            JSONObject json = new JSONObject(jsonString);

            //get the response code & some info from JSON
            int status = resp. getStatusLine().getStatusCode();
            String prodCenter = json.get("productionCenter").toString();

            JSONArray days = json.getJSONObject("time").getJSONArray("startPeriodName");
            JSONArray temps = json.getJSONObject("data").getJSONArray("temperature");
            JSONArray weats = json.getJSONObject("data").getJSONArray("weather");
            //JSONArray icon = json.getJSONObject("data").getJSONArray("iconLink");



            ModelAndView mv = new ModelAndView("weather");
            mv.addObject("status", status);
            mv.addObject("prodCenter", prodCenter);

            mv.addObject("day1", days.getString(0));
            mv.addObject("day2", days.getString(1));
            mv.addObject("day3", days.getString(2));
            mv.addObject("day4", days.getString(3));
            mv.addObject("day5", days.getString(4));
            mv.addObject("day6", days.getString(5));
            mv.addObject("day7", days.getString(6));
            mv.addObject("day8", days.getString(7));
            mv.addObject("day9", days.getString(8));
            mv.addObject("day10", days.getString(9));
            mv.addObject("day11", days.getString(10));

            mv.addObject("temp1", temps.getString(0));
            mv.addObject("temp2", temps.getString(1));
            mv.addObject("temp3", temps.getString(2));
            mv.addObject("temp4", temps.getString(3));
            mv.addObject("temp5", temps.getString(4));
            mv.addObject("temp6", temps.getString(5));
            mv.addObject("temp7", temps.getString(6));
            mv.addObject("temp8", temps.getString(7));
            mv.addObject("temp9", temps.getString(8));
            mv.addObject("temp10", temps.getString(9));
            mv.addObject("temp11", temps.getString(10));

            mv.addObject("weats1", weats.getString(0));
            mv.addObject("weats2", weats.getString(1));
            mv.addObject("weats3", weats.getString(2));
            mv.addObject("weats4", weats.getString(3));
            mv.addObject("weats5", weats.getString(4));
            mv.addObject("weats6", weats.getString(5));
            mv.addObject("weats7", weats.getString(6));
            mv.addObject("weats8", weats.getString(7));
            mv.addObject("weats9", weats.getString(8));
            mv.addObject("weats10", weats.getString(9));
            mv.addObject("weats11", weats.getString(10));

//            mv.addObject("icon1", icon.getString(0));
//            mv.addObject("icon2", icon.getString(1));
//            mv.addObject("icon3", icon.getString(2));
//            mv.addObject("icon4", icon.getString(3));
//            mv.addObject("icon5", icon.getString(4));
//            mv.addObject("icon6", icon.getString(5));
//            mv.addObject("icon7", icon.getString(6));
//            mv.addObject("icon8", icon.getString(7));
//            mv.addObject("icon9", icon.getString(8));
//            mv.addObject("icon10", icon.getString(9));
//            mv.addObject("icon11", icon.getString(10));

            return mv;
        } catch (IOException e) {
            e.printStackTrace();
        }catch (JSONException e){
            e.printStackTrace();
        }

        return null;
    }
}