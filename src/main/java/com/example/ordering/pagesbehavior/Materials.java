package com.example.ordering.pagesbehavior;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Materials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String materialName;

    public Materials() {
    }

    public Materials(Integer id, String name) {
        this.id = id;
        this.materialName = name;
    }

    public String getMaterialName() {
        return materialName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}