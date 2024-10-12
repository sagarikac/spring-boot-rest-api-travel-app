package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Cab;

public interface CabRepository extends JpaRepository<Cab, Integer>{ 

}

