package com.example.repository;

import com.example.model.AppProduct;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppProductRepository extends JpaRepository<AppProduct, Integer> {

 
}
