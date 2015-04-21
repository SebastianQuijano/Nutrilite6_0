/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Objetos.ObjetoComplemento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Erick
 */
public class ComplementoDAO {
    
    private Conexion conexion;
    private static final String agregarComplemento = "INSERT INTO NL_COMPLEMENTO(NOMBRE, DESCRIPCION) VALUES (?,?)";
    private static final String modificarComplemento = "UPDATE NL_COMPLEMENTO SET NOMBRE = ?, DESCRIPCION = ? WHERE ID_COMPLEMENTO = ?;";
    private static final String eliminarComplemento = "DELETE FROM NL_COMPLEMENTO WHERE ID_COMPLEMENTO = ?";
    private static final String eliminarPaqueteComplemento = "DELETE FROM NL_PAQUETECOMPLEMENTO WHERE ID_COMPLEMENTO = ?";
    private static final String verComplementos = "SELECT * FROM NL_COMPLEMENTO;";
    
    public ComplementoDAO(Conexion conexion) {
        this.conexion = conexion;
    }
    
    /*Agrega un Complemento nuevo a la BD*/
    public void agregarComplemento(String nombre, String descripcion) throws SQLException{
        PreparedStatement pst = conexion.prepareStatement(agregarComplemento);
        pst.setString(1, nombre);
        pst.setString(2, descripcion);
        pst.executeUpdate();
        
        pst.close();
    }
    
    /*Agrega todos los Complementos enviados mediante un ArrayList. Usado para actualizar la Tabla Complemento*/
    public void agregarComplementos(ArrayList<ObjetoComplemento> lista) throws SQLException{
        for (ObjetoComplemento complemento : lista) {
            agregarComplemento(complemento.getNombre(), complemento.getDescripcion());
        }
    }
    
    /*Modifica el nombre y la descripcion de un complemento*/
    public void modificarComplemento(int idComplemento, String nombre, String descripcion) throws SQLException{
        PreparedStatement pst = conexion.prepareStatement(modificarComplemento);
        pst.setString(1, nombre);
        pst.setString(2, descripcion);
        pst.setInt(3, idComplemento);
        pst.executeUpdate();
        
        pst.close();
    }
    
    /*Regresa todos los complementos en un ArrayList*/
    public ArrayList<ObjetoComplemento> verComplementos() throws SQLException{
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(verComplementos);
        ArrayList<ObjetoComplemento> lista = new ArrayList<>();
        ObjetoComplemento complemento;
        while (rs.next()) {
            complemento = new ObjetoComplemento();
            complemento.setIdComplemento(rs.getInt("ID_COMPLEMENTO"));
            complemento.setNombre(rs.getString("NOMBRE"));
            complemento.setDescripcion(rs.getString("DESCRIPCION"));
            lista.add(complemento);
        }
        
        rs.close();
        st.close();
        return lista;
    }
    
    /*Elimina un complemento despues de haber aliminado todos sus registros en la tabla PaqueteComplemento*/
    public void eliminarComplemento(int idComplemento) throws SQLException{
        eliminarPaqueteComplemento(idComplemento);
        PreparedStatement pst = conexion.prepareStatement(eliminarComplemento);
        pst.setInt(1, idComplemento);
        pst.executeUpdate();
        
        pst.close();
    }
    
    /*Elimina un complemento de cada paquete en el que se encuentra, eliminando sus registros de la tabla PaqueteComplemento*/
    private void eliminarPaqueteComplemento(int idComplemento) throws SQLException{
        PreparedStatement pst = conexion.prepareStatement(eliminarPaqueteComplemento);
        pst.setInt(1, idComplemento);
        pst.executeUpdate();
        
        pst.close();
    }
    
}
