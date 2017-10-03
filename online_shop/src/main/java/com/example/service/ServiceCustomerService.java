package com.example.service;

import com.example.model.ServiceCustomer;
import com.example.model.ServiceProvider;
import com.example.repository.ServiceCustomerRepository;
import com.example.repository.ServiceProviderRepository;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCustomerService {

    @Autowired
    private ServiceCustomerRepository serviceCustomerRepository;

    @Autowired
    private ServiceProviderRepository serviceProviderRepository;


    public List<ServiceCustomer> getAllServiceCustomers(){
        List<ServiceCustomer> serviceCustomers = serviceCustomerRepository.findAll();
        return serviceCustomers;
    }

    public ServiceCustomer getOneServiceCustomer(int id){
        ServiceCustomer serviceCustomer = serviceCustomerRepository.findOne(id);
        return serviceCustomer;
    }

    public List<ServiceCustomer> getServiceCustomersByServiceProvider(int providerId){
        List<ServiceCustomer> serviceCustomers = serviceCustomerRepository.findByServiceProviderId(providerId);
        return serviceCustomers;
    }

    public Set<ServiceCustomer> getServiceCustomersByServiceProviderAndAppService(int serviceId, int providerId){
        ServiceProvider serviceProvider = serviceProviderRepository.findByAppServiceIdAndId(serviceId, providerId);
        Set<ServiceCustomer> serviceCustomers = serviceProvider.getServiceCustomers();
        return serviceCustomers;
    }

    public ServiceCustomer getOneServiceCustomerByServiceProviderAppServiceAndId(int serviceId, int providerId, int id){
        Set<ServiceCustomer> serviceCustomers = getServiceCustomersByServiceProviderAndAppService(serviceId, providerId);

        ServiceCustomer getServiceCustomer = new ServiceCustomer();

        for (ServiceCustomer serviceCustomer : serviceCustomers)
        if (serviceCustomer.getId() == id){
            getServiceCustomer = serviceCustomer;
        }
        return getServiceCustomer;
    }

    public void addServiceCustomer(ServiceCustomer serviceCustomer, int providerId){
        serviceCustomer.setServiceProvider(new ServiceProvider(providerId,"","","","",""));
        serviceCustomerRepository.save(serviceCustomer);
    }

    public void updateServiceCustomer(ServiceCustomer serviceCustomer, int serviceId, int providerId, int id) {
        ServiceCustomer updatedServiceCustomer = getOneServiceCustomerByServiceProviderAppServiceAndId(serviceId, providerId, id);
        updatedServiceCustomer.setName(serviceCustomer.getName());
        serviceCustomerRepository.save(updatedServiceCustomer);
    }

    public void deleteServiceCustomer(int serviceId, int providerId, int id){
        ServiceCustomer deleteServiceCustomer = getOneServiceCustomerByServiceProviderAppServiceAndId(serviceId, providerId, id);
        serviceCustomerRepository.delete(deleteServiceCustomer);
    }
}
