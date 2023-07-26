package com.riscoapp.riscoappbackend.datamodel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "element")
public class Element implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "weight")
    private float weight;

    @Column(name = "calories")
    private float calories;

    public Element(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }
}
