/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jobscrapper;

import com.leapfrog.jobscrapper.command.JobsNepalScrapper;
import com.leapfrog.jobscrapper.command.Scrapper;
import com.leapfrog.jobscrapper.entity.Job;
import com.leapfrog.jobscrapper.util.CSVHandler;
import com.leapfrog.jobscrapper.util.Grabber;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Narayan
 */
public class Program {
    
    public static void main(String[] args) {
        try {
          
           Grabber grabber=new Grabber("http://jobsnepal.com");
           String content=grabber.grab();
           
           String regPattern="<a class=\"job-item\"(.*?)href=\"(.*?)\" >(.*?)</a>";
           Pattern pattern=Pattern.compile(regPattern);
           Matcher matcher=pattern.matcher(content);
           
           List<Job> jobList=new ArrayList<Job>();
           
           while(matcher.find()){
               Job job=new Job();
               job.setLink(matcher.group(2));
               job.setTitle(matcher.group(3).trim());
               grabber.setWebGrabber(job.getLink());
               content=grabber.grab();
               jobList.add(job); 
               String desPattern=" <div class=\"detail-text\">(.*?)</div>(.*?)<div style=\"display:block; margin: 0 auto; margin-top: 20px;margin-bottom: 20px;height:40px\">";
               pattern=Pattern.compile(desPattern);
               Matcher subMatcher=pattern.matcher(content);
               if(subMatcher.find()){
                   System.out.println(subMatcher.group());
               }
               String companyPattern="";
               String addressPattern="";
           }
           
           
           StringBuilder builder=new StringBuilder();
           for(Job j: jobList){
               builder.append(j.toCSV());
               
           }
            CSVHandler.write("D:/jobsNepal.csv", builder.toString());
            System.out.println("Scrapping completed");
           
        } catch (IOException e) {
            e.getMessage();
        }
        
    }
    
}
