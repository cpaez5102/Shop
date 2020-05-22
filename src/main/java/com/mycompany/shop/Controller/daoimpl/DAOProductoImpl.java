/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.shop.Controller.daoimpl;

import com.mycompany.shop.conexion.ConexionPostgres;
import com.mycompany.shop.dao.DAOProducto;
import com.mycompany.shop.dto.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daviid
 */
public class DAOProductoImpl extends ConexionPostgres implements DAOProducto {

    @Override
    public void registrar(Producto pro) throws Exception {

        try {
            this.getConexion();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO PRODUCTS(nombre,cantidad,precio,nombre_imagen) values(?,?,?,?)");
            st.setString(1, pro.getNombre());
            st.setInt(2, pro.getCantidad());
            st.setDouble(3, pro.getPrecio());
            st.setString(4, pro.getNombreImagen());
        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }

    }

    @Override
    public void modificar(Producto pro) throws Exception {
       try {
            this.getConexion();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE PRODUCTS SET nombre=?,cantidad=?,precio=?,nombre_imagen=? where id=?");
            st.setString(1, pro.getNombre());
            st.setInt(2, pro.getCantidad());
            st.setDouble(3, pro.getPrecio());
            st.setString(4, pro.getNombreImagen());
            st.setInt(5,pro.getId());
        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
    }

    @Override
    public void eliminar(Producto pro) throws Exception {
        try {
            this.getConexion();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM PRODUCTS where id=?");          
            st.setInt(1,pro.getId());
        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
    }

    @Override
    public List<Producto> listar() throws Exception {        
        List<Producto> lista = null;        
        try {
            this.getConexion();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM PRODUCTS");          
            lista = new ArrayList();            
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
            Producto producto = new Producto();
            producto.setId(rs.getInt("id"));
            producto.setNombre(rs.getString("nombre"));
            producto.setCantidad(rs.getInt("cantidad"));
            producto.setPrecio(rs.getDouble("precio"));
            producto.setNombreImagen(rs.getString("nombre_imagen"));            
            lista.add(producto);            
            }            
            rs.close();
            st.close();                   
        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
        
        return lista;
    }

}
