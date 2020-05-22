/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.shop.conexion;

/**
 *
 * @author Daviid
 */
import java.sql.*;

public class ConexionPostgres {

    public Connection conexion;
    private static String JDBC_DRIVER = "org.postgresql.Driver";
    private static String JDBC_url = "jdbc:postgresql://192.168.0.31:1201/shop";
    private static String JDBC_USER = "postgres";
    private static String JDBC_PASWORD = "amazing";
    private static Driver driver = null;

    public void getConexion() throws SQLException {
        try {
            conexion = DriverManager.getConnection(JDBC_url, JDBC_USER, JDBC_PASWORD);
            Class.forName(JDBC_DRIVER);
        } catch (Exception e) {
            System.out.println("fallo carga driver");
            e.printStackTrace();
        }
    }

    public void close() throws SQLException {

        if (conexion != null) {
            if (!conexion.isClosed()) {
                conexion.close();
            }
        }
    }
}
