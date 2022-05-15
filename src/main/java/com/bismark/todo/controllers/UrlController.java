package com.bismark.todo.controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/UrlChecker")
public class UrlController {


    @GetMapping("/checking")
    public String isSiteUp(@RequestParam String param){

        String returnedMessage = "";

        URL url;
        try {
            url = new URL(param);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode()/100;

            if(responseCode == 2 || responseCode == 3){
                returnedMessage = "Site is up";
            }else{
                returnedMessage = "Site is down";
            }
        } catch (MalformedURLException e) {
            returnedMessage = "Incorrect URL";
        } catch (IOException e) {
            returnedMessage = "Site is down";
        }
        

        return returnedMessage;
    }
    
    
}
