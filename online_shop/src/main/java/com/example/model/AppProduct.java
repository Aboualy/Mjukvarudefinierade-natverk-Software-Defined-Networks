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
@Table(name = "appProduct")
public class AppProduct implements Serializable {

    private int id;
    
    private String name;
    
    private String productDescription;
    private String productGuarantee;
    private String productPrice;
  private Set<ProductProvider> productProviders = new HashSet<>();

    public AppProduct() {
    }

    public AppProduct(int productId, String name , String productDescription, String productGuarantee, String productPrice) {
        this.id = productId;
        this.name = name;
        this.productDescription = productDescription;
        this.productGuarantee = productGuarantee;
        this.productPrice = productPrice;
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

    
    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
	
	public String getProductGuarantee() {
        return productGuarantee;
    }

    public void setProductGuarantee(String productguarantee) {
        this.productGuarantee = productguarantee;
    }
	
	
	public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
	
    @OneToMany(mappedBy = "appProduct", targetEntity = ProductProvider.class, cascade = CascadeType.ALL)
    public Set<ProductProvider> getProductProviders() {
        return this.productProviders;
    }

    public void setProductProviders(Set<ProductProvider> productProviders) {
        this.productProviders = productProviders;
    }
    
  
    
    
    
}
