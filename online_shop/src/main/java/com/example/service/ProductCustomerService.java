package com.example.service;

import com.example.model.ProductCustomer;
import com.example.model.ProductProvider;
import com.example.repository.ProductCustomerRepository;
import com.example.repository.ProductProviderRepository;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCustomerService {

    @Autowired
    private ProductCustomerRepository productCustomerRepository;

    @Autowired
    private ProductProviderRepository floorRepository;


    public List<ProductCustomer> getAllProductCustomers(){
        List<ProductCustomer> productCustomers = productCustomerRepository.findAll();
        return productCustomers;
    }

    public ProductCustomer getOneProductCustomer(int id){
        ProductCustomer productCustomer = productCustomerRepository.findOne(id);
        return productCustomer;
    }

    public List<ProductCustomer> getProductCustomersByProductProvider(int providerId){
        List<ProductCustomer> productCustomers = productCustomerRepository.findByProductProviderId(providerId);
        return productCustomers;
    }

    public Set<ProductCustomer> getProductCustomersByProductProviderAndAppProduct(int productId, int providerId){
        ProductProvider productProvider = floorRepository.findByAppProductIdAndId(productId, providerId);
        Set<ProductCustomer> productCustomers = productProvider.getProductCustomers();
        return productCustomers;
    }

    public ProductCustomer getOneProductCustomerByProductProviderAppProductAndId(int productId, int providerId, int id){
        Set<ProductCustomer> productCustomers = getProductCustomersByProductProviderAndAppProduct(productId, providerId);

        ProductCustomer getProductCustomer = new ProductCustomer();

        for (ProductCustomer productCustomer : productCustomers)
        if (productCustomer.getId() == id){
            getProductCustomer = productCustomer;
        }
        return getProductCustomer;
    }

    public void addProductCustomer(ProductCustomer productCustomer, int providerId){
        productCustomer.setProductProvider(new ProductProvider(providerId,"","","","",""));
        productCustomerRepository.save(productCustomer);
    }

    public void updateProductCustomer(ProductCustomer productCustomer, int productId, int providerId, int id) {
        ProductCustomer updatedProductCustomer = getOneProductCustomerByProductProviderAppProductAndId(productId, providerId, id);
        updatedProductCustomer.setName(productCustomer.getName());
        productCustomerRepository.save(updatedProductCustomer);
    }

    public void deleteProductCustomer(int productId, int providerId, int id){
        ProductCustomer deleteProductCustomer = getOneProductCustomerByProductProviderAppProductAndId(productId, providerId, id);
        productCustomerRepository.delete(deleteProductCustomer);
    }
}
