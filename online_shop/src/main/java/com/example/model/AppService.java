package com.example.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "appService")
public class AppService {

    private int id;
    
    private String name;
    
    private String serviceDescription;
    private String serviceLength;
    private String servicePrice;
    private Set<ServiceProvider> serviceProviders = new HashSet<>();

    public AppService() {
    }

    public AppService(int serviceId, String s, String l, String t, String m) {
        this.id = serviceId;
        this.name = s;
        this.serviceDescription = l;
        this.serviceLength = l;
        this.servicePrice = l;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }
	
	public String getServiceLength() {
        return serviceLength;
    }

    public void setServiceLength(String serviceLength) {
        this.serviceLength = serviceLength;
    }
	
	
	public String getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(String servicePrice) {
        this.servicePrice = servicePrice;
    }
	
    
	
	    @OneToMany(mappedBy = "appService", targetEntity = ServiceProvider.class, cascade = CascadeType.ALL)
    public Set<ServiceProvider> getServiceProviders() {
        return this.serviceProviders;
    }

    public void setServiceProviders(Set<ServiceProvider> serviceProviders) {
        this.serviceProviders = serviceProviders;
    }
    
  
	
	
	
}
