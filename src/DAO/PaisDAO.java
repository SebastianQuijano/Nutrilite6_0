/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Objetos.ObjetoPais;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Erick
 */
public class PaisDAO {
    
    private Conexion conexion;
    private static final String verPais = "SELECT * FROM NL_PAIS WHERE ID_PAIS = ?";
    private static final String verPaises = "SELECT * FROM NL_PAIS";
    private static final String verPaisesPorNombre = "SELECT * FROM NL_PAIS ORDER BY NOMBRE";
    private static final String agregarPais = "INSERT INTO NL_PAIS(NOMBRE)VALUES(?)";
    
    
    public PaisDAO(Conexion conexion) {
        this.conexion = conexion;
    }
    
    public ObjetoPais verPais(int idPais) throws SQLException {
        PreparedStatement pst = conexion.prepareStatement(verPais);
        pst.setInt(1, idPais);
        ResultSet rs = pst.executeQuery();
        ObjetoPais pais = null;
        if (rs.next()) {
            pais = new ObjetoPais(idPais, rs.getString("NOMBRE"));
        }
        rs.close();
        pst.close();
        return pais;
    }
    
    public void agregarPais(String nombre) throws SQLException {
        PreparedStatement pst = conexion.prepareStatement(agregarPais);
        pst.setString(1, nombre);
        pst.executeUpdate();
        pst.close();
    }
    
    public void agregarPaises(ArrayList<ObjetoPais> lista) throws SQLException {
        for (ObjetoPais pais : lista) {
            agregarPais(pais.getNombre());
        }
    }
    
    public ArrayList<ObjetoPais> verPaises() throws SQLException {
        
        Statement pst = conexion.createStatement();
        ResultSet rs = pst.executeQuery(verPaises);
        ArrayList<ObjetoPais> lista = new ArrayList<>();
        ObjetoPais pais;
        while (rs.next()) {
            pais = new ObjetoPais(rs.getInt("ID_PAIS"), rs.getString("NOMBRE"));
            lista.add(pais);
        }
        rs.close();
        pst.close();

        return lista;
    }
    
    /*Este metodo busca todos los paises y los retorna en una lista*/
    public ArrayList<ObjetoPais> verPaisesPorNombre() throws SQLException {
        
        Statement pst = conexion.createStatement();
        ResultSet rs = pst.executeQuery(verPaisesPorNombre);
        ArrayList<ObjetoPais> lista = new ArrayList<>();
        ObjetoPais pais;
        while (rs.next()) {
            pais = new ObjetoPais(rs.getInt("ID_PAIS"), rs.getString("NOMBRE"));
            lista.add(pais);
        }
        rs.close();
        pst.close();

        return lista;
    }
    
}
