package com.example.mealsdelivery.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;


@Document(collection = "customers")
public class Customer {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    
    //Getters & setters
    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id=id;
    }

   public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
 public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    


    
}
