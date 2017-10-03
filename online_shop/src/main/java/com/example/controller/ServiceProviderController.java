package com.example.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.service.ServiceProviderService;
import com.example.model.ServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceProviderController {

    @Autowired
    private ServiceProviderService serviceProviderService;
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/ServiceProviders")
    public List<ServiceProvider> getAllServiceProviders(){
        return serviceProviderService.getAllServiceProviders();
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/ServiceProviders/{id}")
    public ServiceProvider getOneServiceProvider(@PathVariable int id){
        return serviceProviderService.findOne(id);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/services/{id}/ServiceProviders")
    public List<ServiceProvider> getServiceProvidersByAppServiceId(@PathVariable int id){
        return serviceProviderService.findServiceProviderByAppServiceId(id);
                                      
                                      
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/services/{serviceId}/ServiceProviders/{id}")
    public ServiceProvider findServiceProviderByAppServiceIdAndFloorId(@PathVariable int serviceId, @PathVariable int id){
        return serviceProviderService.findServiceProviderByAppServiceIdAndServiceProviderId(serviceId, id);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/services/{serviceId}/ServiceProviders")
    public void addServiceProvider(@RequestBody ServiceProvider serviceProvider, @PathVariable int serviceId){
        serviceProviderService.addServiceProvider(serviceProvider, serviceId);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/services/{serviceId}/ServiceProviders/{id}")
    public void putServiceProvider(@RequestBody ServiceProvider serviceProvider, @PathVariable int serviceId, @PathVariable int id){
        serviceProviderService.putServiceProvider(serviceProvider, serviceId, id);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value = "/services/{serviceId}/ServiceProviders/{id}")
    public void deleteServiceProvider(@PathVariable int serviceId, @PathVariable int id){
        serviceProviderService.deleteServiceProvider(serviceId, id);
    }

}
