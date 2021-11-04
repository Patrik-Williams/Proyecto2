/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.controller;

import com.ulatina.model.Persona;
import com.ulatina.service.Servicio;
import com.ulatina.service.ServicioPersona;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ian
 */
@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController extends Servicio implements Serializable {

    private String correo;
    private String contrasenna;
    private Persona persona;
    
    private List<Persona> personas = new ArrayList<>();

    ServicioPersona sp = new ServicioPersona();

    public LoginController() {
    }

    public void cargarListaPersonas() {

    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public ServicioPersona getSp() {
        return sp;
    }

    public void setSp(ServicioPersona sp) {
        this.sp = sp;
    }

    public void ingresar() {

        System.out.println("" + personas.size());

        if (this.getCorreo().equals("iancrpb@hotmail.com") && this.getContrasenna().equals("ianpat2301")) {
            this.redireccionar("/faces/Administrador.xhtml");
        } else {
            FacesContext.getCurrentInstance().addMessage("sticky-key", new FacesMessage(FacesMessage.SEVERITY_FATAL, "Campos inválidos", "La contrasena o correo no son correctos"));
        }

    }

    public void ingresarAdm() {
        Statement stmt = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            stmt = super.getConexion().createStatement();
            String sql = "SELECT * FROM administrador Where correo='" + this.getCorreo() + "' && contrasena='" + this.getContrasenna() + "'";

            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString("correo").equals(this.getCorreo()) && rs.getString("contrasena").equals(this.getContrasenna())) {

                    
                    flag = true;
                }else {
                    flag =false;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(flag==true){
            this.redireccionar("/faces/Administrador.xhtml");
        }
        else{
            FacesContext.getCurrentInstance().addMessage("sticky-key", new FacesMessage(FacesMessage.SEVERITY_FATAL, "Campos inválidos", "La contrasena o correo no son correctos"));
        }

    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getListPersonas() {
        return personas;
    }

    public void setListPersonas(List<Persona> listPersonas) {
        this.personas = listPersonas;
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
