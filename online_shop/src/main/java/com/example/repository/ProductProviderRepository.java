package com.example.repository;

import com.example.model.ProductProvider;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductProviderRepository extends JpaRepository<ProductProvider, Integer> {


    List<ProductProvider> findByAppProductId(int appProduct);

   
    ProductProvider findByAppProductIdAndId(int appProduct, int id);
}
