/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.shop.dao;

import com.mycompany.shop.dto.Producto;
import java.util.List;

/**
 *
 * @author Daviid
 */
public interface DAOProducto {
    
    
    public void registrar(Producto pro) throws Exception;
    public void modificar(Producto pro) throws Exception;
    public void eliminar(Producto pro) throws Exception;
    public List<Producto> listar() throws Exception;
    
    
}
