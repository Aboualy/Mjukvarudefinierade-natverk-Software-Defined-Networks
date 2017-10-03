package com.example.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.model.ServiceCustomer;
import com.example.service.ServiceCustomerService;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServiceCustomerController {

    @Autowired
    private ServiceCustomerService serviceCustomerService;
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/serviceCustomers")
    public List<ServiceCustomer> getAllServiceCustomers(){
        return serviceCustomerService.getAllServiceCustomers();
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/serviceCustomers/{id}")
    public ServiceCustomer getOnePoductCustomer(@PathVariable int id){
        return serviceCustomerService.getOneServiceCustomer(id);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/services/providers/{providerId}/serviceCustomers")
    public List<ServiceCustomer> ServiceCustomer(@PathVariable int providerId){
        return serviceCustomerService.getServiceCustomersByServiceProvider(providerId);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "api/services/{serviceId}/providers/{providerId}/serviceCustomers")
    public Set<ServiceCustomer> getServiceCustomersByServiceProviderAppServiceAndId(@PathVariable int serviceId, @PathVariable int providerId){
        return serviceCustomerService.getServiceCustomersByServiceProviderAndAppService(serviceId, providerId);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "api/services/{serviceId}/providers/{providerId}/serviceCustomers/{id}")
    public ServiceCustomer getOneServiceCustomerByFloorSiteAndId(@PathVariable int serviceId, @PathVariable int providerId, @PathVariable int id){
        return serviceCustomerService.getOneServiceCustomerByServiceProviderAppServiceAndId(serviceId, providerId, id);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/services/{serviceId}/providers/{providerId}/serviceCustomers")
    public void addServiceCustomer(@RequestBody ServiceCustomer serviceCustomer, @PathVariable int providerId){
        serviceCustomerService.addServiceCustomer(serviceCustomer, providerId);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/services/{serviceId}/providers/{providerId}/serviceCustomers/{id}")
    public void updateServiceCustomer(@RequestBody ServiceCustomer serviceCustomer, @PathVariable int serviceId, @PathVariable int providerId, @PathVariable int id){
        serviceCustomerService.updateServiceCustomer(serviceCustomer, serviceId, providerId, id);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value = "/services/{serviceId}/providers/{providerId}/serviceCustomers/{id}")
    public void deleteServiceCustomer(@PathVariable int serviceId, @PathVariable int providerId, @PathVariable int id){
            serviceCustomerService.deleteServiceCustomer(serviceId, providerId, id);
    }
}
