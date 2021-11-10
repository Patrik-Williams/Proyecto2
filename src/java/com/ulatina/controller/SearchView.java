/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ian
 */

@ManagedBean(name = "searchView")
@SessionScoped
public class SearchView implements Serializable {

    private String text1;
    private String text2;
    DataScrollerView ds = new DataScrollerView();

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
        
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }
    
    
    public void search(){
        
        
        ds.setSearch(text1);
        this.redireccionar("/faces/Search.xhtml");
    }

    
     public void redireccionar(String ruta) {
        HttpServletRequest request;
        try {
            request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            FacesContext.getCurrentInstance().getExternalContext().redirect(request.getContextPath() + ruta);
        } catch (Exception e) {

        }
    }
    
    
    
    
    
}

