/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.model;

import com.ulatina.model.InventoryStatus;
import java.io.Serializable;
import java.util.List;
//import org.apache.catalina.servlets.DefaultServlet.SortManager.Order;

/**
 *
 * @author Ian
 */
public class Product implements Serializable {

   
    private String codigo;
    private String nombre;
    private String marca;
    private String descripcion;
    private int cantidad;
    private String categoria;
    private double precio;
    private String image;

    public Product(String codigo, String nombre, String marca, String descripcion, int cantidad,String categoria, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.descripcion =  descripcion;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.precio = precio;
        
        
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public Product clone() {
        return new Product(getCodigo(), getNombre(), getMarca(), getDescripcion(), getCantidad(), getCategoria(), getPrecio());
    }
    
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
  
    //private List<Order> orders;

    public Product() {
    }

    

   

    /*public List<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }*/

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Product other = (Product) obj;
        if (codigo == null) {
            return other.codigo == null;
        }
        else {
            return codigo.equals(other.codigo);
        }
    }

}