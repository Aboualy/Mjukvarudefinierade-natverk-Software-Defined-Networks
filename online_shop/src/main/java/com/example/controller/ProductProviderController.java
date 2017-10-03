package com.example.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.service.ProductProviderService;
import com.example.model.ProductProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductProviderController {

    @Autowired
    private ProductProviderService productProviderService;
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/ProductProviders")
    public List<ProductProvider> getAllProductProviders(){
        return productProviderService.getAllProductProviders();
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/ProductProviders/{id}")
    public ProductProvider getOneProductProvider(@PathVariable int id){
        return productProviderService.findOne(id);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/products/{id}/ProductProviders")
    public List<ProductProvider> getProductProvidersByAppProductId(@PathVariable int id){
        return productProviderService.findProductProviderByAppProductId(id);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/products/{productId}/ProductProviders/{id}")
    public ProductProvider findProductProviderByAppProductIdAndProductProviderId(@PathVariable int productId, @PathVariable int id){
        return productProviderService.findProductProviderByAppProductIdAndProductProviderId(productId, id);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/products/{productId}/ProductProviders")
    public void addProductProvider(@RequestBody ProductProvider productProvider, @PathVariable int productId){
        productProviderService.addProductProvider(productProvider, productId);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/products/{productId}/ProductProviders/{id}")
    public void putProductProvider(@RequestBody ProductProvider productProvider, @PathVariable int productId, @PathVariable int id){
        productProviderService.putProductProvider(productProvider, productId, id);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value = "/products/{productId}/ProductProviders/{id}")
    public void deleteProductProvider(@PathVariable int productId, @PathVariable int id){
        productProviderService.deleteProductProvider(productId, id);
    }

}
