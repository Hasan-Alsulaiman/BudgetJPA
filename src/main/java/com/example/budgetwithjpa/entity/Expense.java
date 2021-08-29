package com.example.budgetwithjpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Expense {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn
    @NonNull
    private Category category;
    @NonNull
    @Min(value = 0, message = "value should not be less than 0")
    private Double value;

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", type='" + category + '\'' +
                ", value=" + value +
                '}';
    }
}
