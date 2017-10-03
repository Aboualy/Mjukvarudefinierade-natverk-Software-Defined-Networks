package com.example.service;

import com.example.model.AppService;
import com.example.repository.AppServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceService {

    @Autowired
    private AppServiceRepository appServiceRepository;

    public List<AppService> getAllAppServices(){
        List<AppService> allAppServices = appServiceRepository.findAll();
        return allAppServices;
    }

    public AppService findOne(int id){
        AppService appService = appServiceRepository.findOne(id);
        return appService;
    }

    public void addAppService(AppService appService){
        appServiceRepository.save(appService);
    }

    public void putAppService(AppService appService, int id) {
        AppService updatedAppService = findOne(id);
        updatedAppService.setId(appService.getId());
        updatedAppService.setName(appService.getName());
        updatedAppService.setServiceDescription(appService.getServiceDescription());
        updatedAppService.setServiceLength(appService.getServiceLength());
        updatedAppService.setServicePrice(appService.getServicePrice());
        appServiceRepository.save(updatedAppService);
    }

    public void deleteAppService(int id){
        appServiceRepository.delete(id);
    }
}
