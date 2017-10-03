package com.example.service;

import com.example.model.ProductProvider;
import com.example.model.AppProduct;
import com.example.repository.ProductProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductProviderService {

    @Autowired
    private ProductProviderRepository productProviderRepository;

    public List<ProductProvider> getAllProductProviders(){
        List<ProductProvider> allProductProviders = productProviderRepository.findAll();
        return allProductProviders;
    }

    public ProductProvider findOne(int id){
        ProductProvider productProvider = productProviderRepository.findOne(id);
        return productProvider;
    }

    public List<ProductProvider> findProductProviderByAppProductId(int id){
        List<ProductProvider> productProviders = productProviderRepository.findByAppProductId(id);
        return productProviders;
    }

    public ProductProvider findProductProviderByAppProductIdAndProductProviderId(int productId, int id){
        ProductProvider productProvider = productProviderRepository.findByAppProductIdAndId(productId, id);
        return productProvider;
    }

    public void addProductProvider(ProductProvider productProvider, int productId){
        productProvider.setAppProduct(new AppProduct(productId,"","","",""));
        productProviderRepository.save(productProvider);
    }

    public void putProductProvider(ProductProvider productProvider, int productId, int id){
        ProductProvider updatedProductProvider = findProductProviderByAppProductIdAndProductProviderId(productId, id);
        updatedProductProvider.setName(productProvider.getName());
        productProviderRepository.save(updatedProductProvider);
    }

    public void deleteProductProvider(int productId, int id){
        ProductProvider deletedProductProvider = findProductProviderByAppProductIdAndProductProviderId(productId, id);
        productProviderRepository.delete(deletedProductProvider);
    }
}
