package com.example.repository;

import com.example.model.ProductCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCustomerRepository extends JpaRepository<ProductCustomer, Integer> {

    /**
     * @param - id of the selected productProvider
     * @return - list of productCustomers on selected productProvider
     */
    List<ProductCustomer> findByProductProviderId(int providerId);
}
