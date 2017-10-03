package com.example.repository;

import com.example.model.ServiceProvider;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Integer> {


    List<ServiceProvider> findByAppServiceId(int appService);

   
    ServiceProvider findByAppServiceIdAndId(int appService, int id);
}
