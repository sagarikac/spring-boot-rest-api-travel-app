package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
    private int typeOfCab;
    private String company;
    private String capacity;
    private float fare;
}
