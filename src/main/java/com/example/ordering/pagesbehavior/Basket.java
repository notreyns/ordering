package com.example.ordering.pagesbehavior;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.HashMap;

@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    private String colorradio;

    private String materialradio;


    public Basket() {
    }
    public Basket(String name, String colorradio, String materialradio){
        this.name= name;
        this.colorradio=colorradio;
        this.materialradio=materialradio;
    }

    public String getMaterialradio() {
        return materialradio;
    }
    public void setMaterialradio(String materialradio) {
        this.materialradio = materialradio;
    }

    public String getColorradio() {
        return colorradio;
    }

    public void setColorradio(String colorradio) {
        this.colorradio = colorradio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
