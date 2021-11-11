/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ian
 */
public abstract class Servicio {

    private Connection conexion = null;
    private String host = "localhost";
    private String puerto = "3306";
    private String sid = "proyecto2";
    private String usuario = "root";
    private String clave = "Fortcod03";
    
    
    
    
    
    
    private void conectar() {

        try {
            //Paso 1
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Paso 2
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://" + host + ":" + puerto + "/" + sid + /*"?autoReconnect=true"*/ "?serverTimezone=UTC",
                    usuario, clave);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected Connection getConexion() {
        //patron singleton?
        try {
            if (this.conexion != null && !this.conexion.isClosed()) {
                return this.conexion;
            } else {
                this.conectar();
            }
        } catch (Exception e) {

        }
        return this.conexion;
    }

    protected void cerrarStatement(Statement stmt) {
        try {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
                stmt = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void cerrarResultSet(ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
                rs = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void desconectar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                conexion = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}