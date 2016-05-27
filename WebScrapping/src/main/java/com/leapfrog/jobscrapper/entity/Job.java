/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jobscrapper.entity;

/**
 *
 * @author Narayan
 */
public class Job {
     private String link,title,description,company,address;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Job() {
    }

    public Job(String link, String title, String description, String company, String address) {
        this.link = link;
        this.title = title;
        this.description = description;
        this.company = company;
        this.address = address;
    }

    

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Job{" + "link=" + link + ", title=" + title + ", description=" + description + ", company=" + company + ", address=" + address + '}';
    }

   

   
   public String toCSV(){
       
       return title + ","+description +"," +company+","+address+ "," +link+"\r\n";
   }
    
}
