package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Booking {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int bid;
	private int cid;
	private String time;
	private float distance;
	private float amount;
	
}
