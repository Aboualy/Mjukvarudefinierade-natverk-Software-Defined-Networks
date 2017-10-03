package com.example.repository;

import com.example.model.ServiceCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceCustomerRepository extends JpaRepository<ServiceCustomer, Integer> {

 
    List<ServiceCustomer> findByServiceProviderId(int providerId);
}
