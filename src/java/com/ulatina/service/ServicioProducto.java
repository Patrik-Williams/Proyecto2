/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.service;

import com.ulatina.model.InventoryStatus;
import com.ulatina.model.Product;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.swing.JOptionPane;

/**
 *
 * @author Ian
 */
@ManagedBean(name = "servicioProducto")
@ApplicationScoped
public class ServicioProducto extends Servicio {

    public List<Product> demeTodosProductos() {

        Statement stmt = null;
        ResultSet rs = null;
        List<Product> listaRetorno = new ArrayList<>();

        try {

            //Paso 3
            stmt = super.getConexion().createStatement();
            String sql = "SELECT * FROM producto";
            //Paso 4
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Product p = new Product();
                String en = "";
                //p.setId(rs.getInt("id"));
                p.setCodigo(rs.getString("codigo"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("marca"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setCategoria(rs.getString("categoria"));
                p.setPrecio(rs.getDouble("precio"));
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

    //metodos
    public void insertar(Product p) {
        Statement stmt = null;
        ResultSet rs = null;
        //List<Product> listaRetorno = new ArrayList<>();
        try {

            //Paso 3
            stmt = super.getConexion().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM products";   
            //Paso 4
           
            rs = stmt.executeQuery(sql);
            rs.last();
            int id = rs.getInt("ID") + 1;
            rs.moveToInsertRow();
            rs.updateString("codigo", p.getCodigo());
            rs.updateString("nombre", p.getNombre());
            rs.updateString("marca", p.getMarca());
            rs.updateString("descripcion", p.getDescripcion());
            rs.updateInt("cantidad", p.getCantidad());
            rs.updateString("categoria", p.getCategoria());
            rs.updateDouble("precio", p.getPrecio());
            rs.insertRow();
            rs.beforeFirst();

            System.out.println("" + sql);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Paso 5
            cerrarResultSet(rs);
            cerrarStatement(stmt);
            desconectar();
        }
    }

    public void borrar(Product p) {
        Statement stmt = null;
        ResultSet rs = null;
        //List<Product> listaRetorno = new ArrayList<>();
        JOptionPane.showMessageDialog(null,"entrooooo");
        try {

            //Paso 3
            stmt = super.getConexion().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM products";
            //String sql = "SELECT id FROM products WHERE code = "+p.getCode();
           
            //Paso 4
            rs = stmt.executeQuery(sql);
            rs.last();
           
            //la tabla productos tiene una falla con las llaves primarias ya que el codigo del producto no es la PK de la tabla
            int id = rs.getInt("ID");
           // rs.
            //JOptionPane.showMessageDialog(null,"tengo el code" +id + " " + p.getName() );
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Paso 5
            cerrarResultSet(rs);
            cerrarStatement(stmt);
            desconectar();
        }

    }
    
    public List<Product> buscar(String prod) {

        Statement stmt = null;
        ResultSet rs = null;
        List<Product> listaRetorno = new ArrayList<>();

        try {

            //Paso 3
            stmt = super.getConexion().createStatement();
            String sql = "SELECT * FROM producto where nombre like '%"+ prod +" %'";
            //Paso 4
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Product p = new Product();
                String en = "";
                //p.setId(rs.getInt("id"));
                p.setCodigo(rs.getString("codigo"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("marca"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setCategoria(rs.getString("categoria"));
                p.setPrecio(rs.getDouble("precio"));
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
    
    
    
}