/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Objetos.ObjetoComplemento;
import Objetos.ObjetoPaquete;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Erick
 */
public class PaqueteDAO {
    
    private Conexion conexion;
    private static final String agregarPaquete = "INSERT INTO NL_PAQUETE(NOMBRE, DESCRIPCION) VALUES (?,?)";
    private static final String agregarPaqueteComplemento = "INSERT INTO NL_PAQUETECOMPLEMENTO(ID_PAQUETE, ID_COMPLEMENTO) VALUES (?,?)";
    private static final String modificarPaquete = "UPDATE NL_PAQUETE SET NOMBRE = ?, DESCRIPCION = ? WHERE ID_PAQUETE = ?";
    private static final String eliminarPaquete  = "DELETE FROM NL_PAQUETE WHERE ID_PAQUETE = ?";
    private static final String eliminarPaqueteComplemento = "DELETE FROM NL_PAQUETECOMPLEMENTO WHERE ID_PAQUETE = ?";
    private static final String verPaquetes = "SELECT * FROM NL_PAQUETE";
    private static final String getIdentity = "SELECT LAST_INSERT_ID()";
    
    
    public PaqueteDAO(Conexion conexion) {
        this.conexion = conexion;
    }
    
    /*Agrega un paquete vacio, solo el registro de un paquete nuevo que recibe el nombre y la descripcion del paquete*/
    public void agregarPaqueteVacio(String nombre, String descripcion) throws SQLException {
        PreparedStatement pst = conexion.prepareStatement(agregarPaquete);
        pst.setString(1, nombre);
        pst.setString(2, descripcion);
        pst.executeUpdate();
        
        pst.close();
    }
    
    /*Agrega un paquete y los complementos relacionados con ese paquete a la tabla PaqueteComplemento*/
    public void agregarPaqueteConComplemento(String nombre, String descripcion, ArrayList<ObjetoComplemento> lista) throws SQLException {
        PreparedStatement pst = conexion.prepareStatement(agregarPaquete);
        pst.setString(1, nombre);
        pst.setString(2, descripcion);
        pst.executeUpdate();
        
        int idPaquete = getIdentity();
        
        for (ObjetoComplemento complemento : lista) {
            agregarPaqueteComplemento(idPaquete, complemento.getIdComplemento());
        }
        
        pst.close();
    }
    
    /*Agrega un comlemento a un paquete creando la relacion en la tabla PaqueteComplemento */
    public void agregarPaqueteComplemento(int idPaquete, int idComplemento) throws SQLException {
        PreparedStatement pst = conexion.prepareStatement(agregarPaqueteComplemento);
        pst.setInt(1, idPaquete);
        pst.setInt(2, idComplemento);
        pst.executeUpdate();
        
        pst.close();
    }
    
    /*Agrega todos los paquetes recibidos en un ArrayList a la BD. Usado para actualizar la Tabla Paquete*/
    public void agregarPaquetes(ArrayList<ObjetoPaquete> lista) throws SQLException {
        for (ObjetoPaquete Paquete : lista) {
            agregarPaqueteVacio(Paquete.getNombre(), Paquete.getDescripcion());
        }
    }
    
    /*Modifica el nombre y la descripcion de un paquete*/
    public void modificarPaquete(int idPaquete, String nombre, String descripcion) throws SQLException {
        PreparedStatement pst = conexion.prepareStatement(modificarPaquete);
        pst.setString(1, nombre);
        pst.setString(2, descripcion);
        pst.setInt(3, idPaquete);
        pst.executeUpdate();
        
        pst.close();
    }
    
    /*Regresa un ArrayList con todos los paquetes existentes en la BD*/
    public ArrayList<ObjetoPaquete> verPaquetes() throws SQLException {
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(verPaquetes);
        ArrayList<ObjetoPaquete> lista = new ArrayList<>();
        ObjetoPaquete paquete;
        while (rs.next()) {
            paquete = new ObjetoPaquete();
            paquete.setIdPaquete(rs.getInt("ID_PAQUETE"));
            paquete.setNombre(rs.getString("NOMBRE"));
            paquete.setDescripcion(rs.getString("DESCRIPCION"));
            lista.add(paquete);
        }
        
        rs.close();
        st.close();
        return lista;
    }
    
    /*Elimina un paquete de la BD, despues de haber borrado todos sus registros de la tabla PaqueteComplemento*/
    public void eliminarPaquete(int idPaquete) throws SQLException {
        eliminarPaqueteComplemento(idPaquete);
        PreparedStatement pst = conexion.prepareStatement(eliminarPaquete);
        pst.setInt(1, idPaquete);
        pst.executeUpdate();
        
        pst.close();
    }
    
    /*Elimina los registros de un paquete definido or su id de la tabla PaqueteComplemento*/
    private void eliminarPaqueteComplemento(int idPaquete) throws SQLException {
        PreparedStatement pst = conexion.prepareStatement(eliminarPaqueteComplemento);
        pst.setInt(1, idPaquete);
        pst.executeUpdate();
        
        pst.close();
    }
    
    /*Regresa el ultimo ID identity agregado a la BD*/
    private int getIdentity() throws SQLException {
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(getIdentity);
        int id = 0;
        if (rs.next()) {
            id = rs.getInt(1);
        }
        
        rs.close();
        st.close();
        return id;
    }
    
}
