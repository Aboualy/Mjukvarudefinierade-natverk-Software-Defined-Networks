package com.example.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.model.ProductCustomer;
import com.example.service.ProductCustomerService;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductCustomerController {

    @Autowired
    private ProductCustomerService productCustomerService;
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/productCustomers")
    public List<ProductCustomer> getAllProductCustomers(){
        return productCustomerService.getAllProductCustomers();
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/productCustomers/{id}")
    public ProductCustomer getOnePoductCustomer(@PathVariable int id){
        return productCustomerService.getOneProductCustomer(id);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/products/providers/{providerId}/productCustomers")
    public List<ProductCustomer> ProductCustomer(@PathVariable int providerId){
        return productCustomerService.getProductCustomersByProductProvider(providerId);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "api/products/{productId}/providers/{providerId}/productCustomers")
    public Set<ProductCustomer> getProductCustomersByProductProviderAppProductAndId(@PathVariable int productId, @PathVariable int providerId){
        return productCustomerService.getProductCustomersByProductProviderAndAppProduct(productId, providerId);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "api/products/{productId}/providers/{providerId}/productCustomers/{id}")
    public ProductCustomer getOneProductCustomerByFloorSiteAndId(@PathVariable int productId, @PathVariable int providerId, @PathVariable int id){
        return productCustomerService.getOneProductCustomerByProductProviderAppProductAndId(productId, providerId, id);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/products/{productId}/providers/{providerId}/productCustomers")
    public void addProductCustomer(@RequestBody ProductCustomer productCustomer, @PathVariable int providerId){
        productCustomerService.addProductCustomer(productCustomer, providerId);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/products/{productId}/providers/{providerId}/productCustomers/{id}")
    public void updateProductCustomer(@RequestBody ProductCustomer productCustomer, @PathVariable int productId, @PathVariable int providerId, @PathVariable int id){
        productCustomerService.updateProductCustomer(productCustomer, productId, providerId, id);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value = "/products/{productId}/providers/{providerId}/productCustomers/{id}")
    public void deleteProductCustomer(@PathVariable int productId, @PathVariable int providerId, @PathVariable int id){
            productCustomerService.deleteProductCustomer(productId, providerId, id);
    }
}
