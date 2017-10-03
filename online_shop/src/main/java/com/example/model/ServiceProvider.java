package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "serviceProvider")
public class ServiceProvider {

    private int id;
    private String name;
	private String companyType;
	private String address;
	private String phoneNumber;
	private String email;
	
	
    private AppService appService;
    private Set<ServiceCustomer> serviceCustomers = new HashSet<>();

    public ServiceProvider(){}

    public ServiceProvider(int id, String name, String companyType, String address, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
		this.companyType = companyType;
		this.address= address;
		this.phoneNumber = phoneNumber;
		this.email= email;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "appService_id", referencedColumnName = "id")
    public AppService getAppService() {
        return this.appService;
    }

    public void setAppService(final AppService appService) {
        this.appService = appService;
    }

    @OneToMany(mappedBy = "serviceProvider", targetEntity = ServiceCustomer.class, cascade = CascadeType.ALL)
    public Set<ServiceCustomer> getServiceCustomers() {
        return serviceCustomers;
    }

    public void setServiceCustomers(Set<ServiceCustomer> serviceCustomers) {
        this.serviceCustomers = serviceCustomers;
    }
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
		
	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	
	
	
	
	
	
}
