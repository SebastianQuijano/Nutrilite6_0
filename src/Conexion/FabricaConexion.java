/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.SQLException;

/**
 *
 * @author Erick
 */
public class FabricaConexion {
    
    public static Conexion getConexionHSQL() throws SQLException, ClassNotFoundException {
        return ConexionHSQL.getInstance("Nutrilite");
    }
    
    public static Conexion getConexionMySQL() throws SQLException, ClassNotFoundException {
        return ConexionMySQL.getInstance("localhost", "Nutrilite", "NLBDNEWUSER", "NLBDNEWUSER");
    }
    
}
