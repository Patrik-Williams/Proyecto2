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
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Ian
 */
@ManagedBean(name = "dataScrollerView")
@ViewScoped
public class DataScrollerView implements Serializable {

    public ServicioProducto getServicio() {
        return servicio;
    }

    public void setServicio(ServicioProducto servicio) {
        this.servicio = servicio;
    }

    private List<Product> products;

    @ManagedProperty("#{servicioProducto}")
    private ServicioProducto servicio;

    @PostConstruct
    public void init() {
        products = servicio.demeTodosProductos();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setService(ServicioProducto servicio) {
        this.servicio = servicio;
    }
    
}