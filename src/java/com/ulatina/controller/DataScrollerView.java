/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.controller;

import com.ulatina.model.Product;
import com.ulatina.service.ProductService;
import com.ulatina.service.ServicioProducto;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
//import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ian
 */
@ManagedBean(name = "dataScrollerView")
@SessionScoped
public class DataScrollerView implements Serializable {

    private String search =  "Ha";

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    @ManagedProperty("#{servicioProducto}")
    private ServicioProducto servicio;

    @PostConstruct
    public void init() {
        System.out.println("" + search);
        products = servicio.buscar(search);
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public ServicioProducto getServicio() {
        return servicio;
    }

    public void setServicio(ServicioProducto servicio) {
        this.servicio = servicio;
    }

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setService(ServicioProducto servicio) {
        this.servicio = servicio;
    }

}
