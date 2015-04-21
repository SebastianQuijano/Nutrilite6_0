/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Objetos.ObjetoEstado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public class EstadoDAO {

    private Conexion conexion;
    private static final String verEstado = "SELECT * FROM NL_ESTADO WHERE ID_ESTADO = ?";
    private static final String verEstados = "SELECT * FROM NL_ESTADO";
    private static final String verEstadosPais = "SELECT * FROM NL_ESTADO WHERE ID_PAIS = ? ORDER BY NOMBRE";
    private static final String agregarEstado = "INSERT INTO NL_ESTADO(NOMBRE,ID_PAIS) VALUES(?,?)";
    
    public EstadoDAO(Conexion conexion) {
        this.conexion = conexion;
    }
    
    public ObjetoEstado verEstado(int idEstado) throws SQLException {
        PreparedStatement pst = conexion.prepareStatement(verEstado);
        pst.setInt(1, idEstado);
        ResultSet rs = pst.executeQuery();
        ObjetoEstado estado = null;
        if (rs.next()) {
            estado = new ObjetoEstado(idEstado, rs.getString("NOMBRE"), rs.getInt("ID_PAIS"));
        }
        rs.close();
        pst.close();
        return estado;
    }
    
    /*Este metodo busca el nombre de los Estados relacionados con Pais, cuyo id es enviado como parametro*/
    public ArrayList<ObjetoEstado> verEstadosPorPais(int idPais) throws SQLException {
        PreparedStatement pst = conexion.prepareStatement(verEstadosPais);
        pst.setInt(1, idPais);
        ResultSet rs = pst.executeQuery();
        ArrayList<ObjetoEstado> lista = new ArrayList<>();
        ObjetoEstado estado;
        while (rs.next()) {
            estado = new ObjetoEstado(rs.getInt("ID_ESTADO"), rs.getString("NOMBRE"), rs.getInt("ID_PAIS"));
            lista.add(estado);
        }
        rs.close();
        pst.close();
        
        return lista;
    }
    
    public ArrayList<ObjetoEstado> verEstados() throws SQLException {
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(verEstados);
        ArrayList<ObjetoEstado> estados = new ArrayList<>();
        ObjetoEstado estado = null;
        while (rs.next()) {
            estado = new ObjetoEstado();
            estado.setId(rs.getInt("ID_ESTADO"));
            estado.setNombre(rs.getString("NOMBRE"));
            estado.setIdPais(rs.getInt("ID_PAIS"));
            estados.add(estado);
        }
        rs.close();
        st.close();
        return estados;
    }
    
    public int agregarEstado(ObjetoEstado estado) throws SQLException {
        PreparedStatement pst = conexion.prepareStatement(agregarEstado);
        pst.setString(1, estado.getNombre());
        pst.setInt(2, estado.getIdPais());
        int resultado = pst.executeUpdate();
        pst.close();
        return resultado;
    }
    
    public void agregarEstados(ArrayList<ObjetoEstado> lista) throws SQLException {
        for (ObjetoEstado estado : lista) {
            agregarEstado(estado);
        }
    }
    
}
