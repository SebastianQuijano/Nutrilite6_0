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
public class ConexionMySQL implements Conexion{

    private static Connection conexion = null;
    private static Conexion singleton = null;
    
    private ConexionMySQL(String ip, String bd, String user, String password) throws SQLException, ClassNotFoundException {
        crearConexion(ip, bd, user, password);
    }
    
    private Connection crearConexion(String ip, String bd, String user, String password) throws SQLException, ClassNotFoundException {
        if (conexion == null) {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + ip + "/" + bd;
            conexion = DriverManager.getConnection(url, user, password);
        }
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
        conexion.close();
        conexion = null;
        singleton = null;
    }

    public static Conexion getInstance(String ip, String bd, String user, String password) throws SQLException, ClassNotFoundException {
        if (singleton == null)
            singleton = new ConexionMySQL(ip, bd, user, password);
        return singleton;
    }
    
}
