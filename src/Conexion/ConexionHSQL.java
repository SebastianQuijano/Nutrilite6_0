/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Erick
 */
public class ConexionHSQL implements Conexion {

    private static Connection conexion = null;
    private static Conexion singleton = null;
    private static final String desconectar = "SHUTDOWN";
    
    private ConexionHSQL(String bd) throws SQLException, ClassNotFoundException {
        crearConexion(bd);
    }
    
    private Connection crearConexion(String bd) throws SQLException, ClassNotFoundException {
        Class.forName("org.hsqldb.jdbcDriver");
        String url = "jdbc:hsqldb:file:data/" + bd;
        conexion = DriverManager.getConnection(url, "NLBDNEWUSER", "NLBDNEWUSER");
        return conexion;
    }

    @Override
    public Connection getConexion() throws SQLException {
        return conexion;
    }

    @Override
    public Statement createStatement() throws SQLException {
        return conexion.createStatement();
    }

    @Override
    public PreparedStatement prepareStatement(String query) throws SQLException {
        return conexion.prepareStatement(query);
    }

    @Override
    public void desconectar() throws SQLException {
        conexion.createStatement().executeUpdate(desconectar);
        conexion.close();
        conexion = null;
        singleton = null;
    }

    public static Conexion getInstance(String bd) throws SQLException, ClassNotFoundException {
        if (singleton == null)
            singleton = new ConexionHSQL(bd);
        return singleton;
    }
    
}
