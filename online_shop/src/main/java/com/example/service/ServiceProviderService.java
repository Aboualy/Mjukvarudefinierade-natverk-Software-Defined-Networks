package com.example.service;

import com.example.model.ServiceProvider;
import com.example.model.AppService;
import com.example.repository.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProviderService {

    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    public List<ServiceProvider> getAllServiceProviders(){
        List<ServiceProvider> allServiceProviders = serviceProviderRepository.findAll();
        return allServiceProviders;
    }

    public ServiceProvider findOne(int id){
        ServiceProvider serviceProvider = serviceProviderRepository.findOne(id);
        return serviceProvider;
    }
                                 
    public List<ServiceProvider> findServiceProviderByAppServiceId(int id){
        List<ServiceProvider> serviceProviders = serviceProviderRepository.findByAppServiceId(id);
        return serviceProviders;
    }

    public ServiceProvider findServiceProviderByAppServiceIdAndServiceProviderId(int serviceId, int id){
        ServiceProvider serviceProvider = serviceProviderRepository.findByAppServiceIdAndId(serviceId, id);
        return serviceProvider;
    }

    public void addServiceProvider(ServiceProvider serviceProvider, int serviceId){
        serviceProvider.setAppService(new AppService(serviceId,"","","",""));
        serviceProviderRepository.save(serviceProvider);
    }

    public void putServiceProvider(ServiceProvider serviceProvider, int serviceId, int id){
        ServiceProvider updatedServiceProvider = findServiceProviderByAppServiceIdAndServiceProviderId(serviceId, id);
        updatedServiceProvider.setName(serviceProvider.getName());
        serviceProviderRepository.save(updatedServiceProvider);
    }

    public void deleteServiceProvider(int serviceId, int id){
        ServiceProvider deletedServiceProvider = findServiceProviderByAppServiceIdAndServiceProviderId(serviceId, id);
        serviceProviderRepository.delete(deletedServiceProvider);
    }

   
}
