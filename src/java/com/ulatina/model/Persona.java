/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.model;

import java.io.Serializable;

/**
 *
 * @author Ian
 */
public class Persona implements Serializable {

    private String cedula;
    private String nombre;
    private String apellidos;
    private String correo;
    private String contraseña;
    private String fecha;

    public Persona() {
    }

    public Persona(String cedula, String nombre, String apellidos, String correo, String contraseña, String fecha) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contraseña = contraseña;
        this.fecha = fecha;

    }

     @Override
    public Persona clone() {
        return new Persona(getCedula(), getNombre(), getApellidos(), getCorreo(), getContraseña(), getFecha());
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
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
        Persona other = (Persona) obj;
        if (cedula == null) {
            return other.cedula == null;
        } else {
            return cedula.equals(other.cedula);
        }
    }

}
