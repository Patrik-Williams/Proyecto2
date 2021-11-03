/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ian
 */
@ManagedBean(name = "loginController")
@SessionScoped
public class loginController {
    
    private String correo;
    private String contrasenna;
    //private PersonaTO persona;
    //private List<PersonaTO> listPersonas = new ArrayList<>();

    public loginController() {
    }

    public void cargarListaPersonas() {
        
    }

    public void ingresar() {
            if(this.getCorreo().equals("hola@hola.com") && this.getContrasenna().equals("admin"))
            this.redireccionar("/faces/Administrador.xhtml");
            else
                FacesContext.getCurrentInstance().addMessage("sticky-key", new FacesMessage(FacesMessage.SEVERITY_FATAL, "Campos inválidos", "La contrasena o correo no son correctos"));
        
    }

    public void redireccionar(String ruta) {
        HttpServletRequest request;
        try {
            request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            FacesContext.getCurrentInstance().getExternalContext().redirect(request.getContextPath() + ruta);
        } catch (Exception e) {

        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    
    
    
}