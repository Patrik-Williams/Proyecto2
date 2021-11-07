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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Ian
 */
@ManagedBean(name = "dataGridView")
@ViewScoped
public class DataGridView implements Serializable {

    private List<Product> products;
    private Product selectedProduct;

    @ManagedProperty("#{servicioProducto}")
    private ServicioProducto servicio;

    @PostConstruct
    public void init() {
        products = servicio.demeTodosProductos();
    }

    public ServicioProducto getServicio() {
        return servicio;
    }

    public void setServicio(ServicioProducto servicio) {
        this.servicio = servicio;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setService(ServicioProducto servicio) {
        this.servicio = servicio;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public void clearMultiViewState() {
        FacesContext context = FacesContext.getCurrentInstance();
        String viewId = context.getViewRoot().getViewId();
        PrimeFaces.current().multiViewState().clearAll(viewId, true, this::showMessage);
    }

    private void showMessage(String clientId) {
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, clientId + " multiview state has been cleared out", null));
    }
}