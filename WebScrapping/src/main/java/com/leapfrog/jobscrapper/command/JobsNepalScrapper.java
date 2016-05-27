/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jobscrapper.command;

import com.leapfrog.jobscrapper.util.Grabber;
import java.io.IOException;

/**
 *
 * @author Narayan
 */
public class JobsNepalScrapper extends Scrapper {

    private String webUrl="http://jobsnepal.com";
    @Override
    public void scrapp() throws IOException{
        
        Grabber grabber=new Grabber(webUrl);
        System.out.println(grabber.grab());
        
        
    }
    
}
