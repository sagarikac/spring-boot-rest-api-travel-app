package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
//@Setter
//@Getter
public class Account {
@Id
private int accno;
private String name;
private float amount;
@Column(unique = true)
private String emailid;
}