/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Erick
 */
public interface Conexion {
    
    //Conexion getInstance() throws SQLException, ClassNotFoundException ;
    
//    Connection crearConexion(String ip, String bd, String user, String password) throws SQLException, ClassNotFoundException;
    
    Connection getConexion() throws SQLException;
    
    Statement createStatement() throws SQLException;
    
    PreparedStatement prepareStatement(String query) throws SQLException;
    
    void desconectar() throws SQLException;
    
}
