package com.model;

import javax.persistence.*;

@Entity
public class Analysis {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Enumerated(EnumType.STRING)
    private Age age;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    private double erythrocytes;
    private int platelets;
    private double leukocytes;
    private int hemoglobin;
}
