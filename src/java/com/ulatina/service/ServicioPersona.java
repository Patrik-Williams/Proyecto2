/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.service;

import com.ulatina.model.InventoryStatus;
import com.ulatina.model.Persona;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Ian
 */
@ManagedBean(name = "servicioPersona")
@ApplicationScoped
public class ServicioPersona extends Servicio {

    public List<Persona> demeTodasPersonas() {

        Statement stmt = null;
        ResultSet rs = null;
        List<Persona> listaRetorno = new ArrayList<>();

        try {

            //Paso 3
            stmt = super.getConexion().createStatement();
            String sql = "SELECT * FROM administrador";
            //Paso 4
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Persona p = new Persona();
                String en = "";
                p.setCedula(rs.getString("cedula"));
                p.setNombre(rs.getString("nombre"));
                p.setApellidos(rs.getString("apellido"));
                p.setCorreo(rs.getString("correo"));
                p.setContraseña(rs.getString("contrasena"));
                p.setFecha(rs.getString("fechaNacimiento"));
               
                listaRetorno.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Paso 5
            cerrarResultSet(rs);
            cerrarStatement(stmt);
            desconectar();
        }
        return listaRetorno;
    }
    
    public void buscar(Persona p){
        
    }
}