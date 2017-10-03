package com.example.service;

import com.example.model.AppProduct;
import com.example.repository.AppProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppProductService {

    @Autowired
    private AppProductRepository appProductRepository;

    public List<AppProduct> getAllAppProducts(){
        List<AppProduct> allAppProducts = appProductRepository.findAll();
        return allAppProducts;
    }

    public AppProduct findOne(int id){
        AppProduct appProduct = appProductRepository.findOne(id);
        return appProduct;
    }

    public void addAppProduct(AppProduct appService){
        appProductRepository.save(appService);
    }

    public void putAppProduct(AppProduct appService, int id) {
        AppProduct updatedAppService = findOne(id);
        updatedAppService.setId(appService.getId());
        updatedAppService.setName(appService.getName());
        updatedAppService.setProductDescription(appService.getProductDescription());
        updatedAppService.setProductGuarantee(appService.getProductGuarantee());
        updatedAppService.setProductPrice(appService.getProductPrice());
        appProductRepository.save(updatedAppService);
    }

    public void deleteAppProduct(int id){
        appProductRepository.delete(id);
    }
}
