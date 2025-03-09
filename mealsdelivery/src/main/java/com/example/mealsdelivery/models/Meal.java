package com.example.mealsdelivery.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "meals")
public class Meal {


    @Id
    private String id;
    private String name;
    private String description;
    private double price;
    private boolean isAvailable;
    private String type;

    public String getId(){return id;}
    public void setId(String id){
        this.id=id;
    }

    public  String getName(){return name;}
    public void setName(String name){
        this.name=name;
    }

    public String getDescription(){return description;}
    public void setDescription(String description){
        this.description=description;
    }

    public double getPrice(){return price;}
    public void setPrice(double price){
        this.price=price;
    }


    public boolean getIsAvailable(){
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable){
        this.isAvailable=isAvailable;
    }

    public String getType(){return type;}
    public void setType(String type){
        this.type=type;
    }



}
