package com.bismark.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name="password")
    private String password;
    @Column(name = "created_date")
    private Long createdDate;
    @Column(name = "created_by")
    private String createdBy;

    public User(String name, String password, String createdBy, Long createdDate){
        this.name = name;
        this.password = password;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    public Long getID(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }

    public String getCreatedBy(){
        return this.createdBy;
    }

    public void setCreatedDate(Long createdDate){
        this.createdDate = createdDate;
    }

    public Long getCreatedDate(){
        return this.createdDate;
    }

}
