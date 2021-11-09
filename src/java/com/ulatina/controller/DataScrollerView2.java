/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.controller;


import com.ulatina.service.Product2;

import com.ulatina.service.ProductService2;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author Ian
 */

@ManagedBean(name = "dataScrollerView2")
@ViewScoped
public class DataScrollerView2 implements Serializable {

    private List<Product2> products;

    public void setProducts(List<Product2> products) {
        this.products = products;
    }

    public ProductService2 getService() {
        return service;
    }

    @ManagedProperty("#{productService2}")
    private ProductService2 service;

    @PostConstruct
    
    public void init() {
        products = service.getProducts(100);
    }

    public List<Product2> getProducts() {
        return products;
    }

    public void setService(ProductService2 service) {
        this.service = service;
    }
}
