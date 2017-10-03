package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "productProvider")
public class ProductProvider {

    private int id;
    private String name;
	private String shopBrancheNr;
	private String address;
	private String phoneNumber;
	private String email;
	
    private AppProduct appProduct;
    private Set<ProductCustomer> productCustomers = new HashSet<>();

    public ProductProvider(){}

    public ProductProvider(int id, String name, String shopBrancheNr, String address, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
		this.shopBrancheNr = shopBrancheNr;
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
    @JoinColumn(name = "appProduct_id", referencedColumnName = "id")
    public AppProduct getAppProduct() {
        return this.appProduct;
    }

    public void setAppProduct(final AppProduct appProduct) {
        this.appProduct = appProduct;
    }

    @OneToMany(mappedBy = "productProvider", targetEntity = ProductCustomer.class, cascade = CascadeType.ALL)
    public Set<ProductCustomer> getProductCustomers() {
        return productCustomers;
    }

    public void setProductCustomers(Set<ProductCustomer> productCustomers) {
        this.productCustomers = productCustomers;
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
	
	public String getShopBrancheNr() {
		return shopBrancheNr;
	}

	public void setShopBrancheNr(String shopBrancheNr) {
		this.shopBrancheNr = shopBrancheNr;
	}
	
	
	
	
}
