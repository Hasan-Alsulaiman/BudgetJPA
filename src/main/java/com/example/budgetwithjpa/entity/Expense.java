package com.example.budgetwithjpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Expense {
    @Id
    @GeneratedValue
    private Long id;
    private String type;
    private Double value;

    public Expense(String type, Double value) {
        this.type = type;
        this.value = value;
    }

    public Expense() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
