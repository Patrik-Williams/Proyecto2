/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.controller;

import com.ulatina.model.Product;
import com.ulatina.service.ProductService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.model.ResponsiveOption;


/**
 *
 * @author Ian
 */
@ManagedBean(name = "carouselView")
@SessionScoped
public class CarouselView implements Serializable {

    private List<Product> products;

    private List<ResponsiveOption> responsiveOptions;

    @ManagedProperty("#{productService}")
    private ProductService service;

    @PostConstruct
    public void init() {
        products = service.getProducts(9);
        responsiveOptions = new ArrayList<>();
        responsiveOptions.add(new ResponsiveOption("1024px", 3, 3));
        responsiveOptions.add(new ResponsiveOption("768px", 2, 2));
        responsiveOptions.add(new ResponsiveOption("560px", 1, 1));
    }
    
    
    
    public void CarouselView(){
        
    }
    
    
     public void ingresar() {
        
        this.redireccionar("/faces/LogIn.xhtml");

    }

    public void redireccionar(String ruta) {
        HttpServletRequest request;
        try {
            request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            FacesContext.getCurrentInstance().getExternalContext().redirect(request.getContextPath() + ruta);
        } catch (Exception e) {

        }
    }
    
    public List<Product> getProducts() {
        return products;
    }

    public void setService(ProductService service) {
        this.service = service;
    }

    public List<ResponsiveOption> getResponsiveOptions() {
        return responsiveOptions;
    }

    public void setResponsiveOptions(List<ResponsiveOption> responsiveOptions) {
        this.responsiveOptions = responsiveOptions;
    }

   
}
