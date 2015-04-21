/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Objetos.ObjetoAlimento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public class AlimentoDAO {
    
    private Conexion conexion;
    private static final String verTodosAlimentos = "SELECT * FROM NL_ALIMENTOS";
    private static final String verAlimentosDeTipoDeAlimento = "SELECT * FROM NL_ALIMENTOS WHERE ID_TIPOALIMENTO = ?";
    private static final String agregarAlimentos = "INSERT INTO NL_ALIMENTOS(ID_ALIMENTO, NOMBRE, PORCION, MEDIDA, CALORIAS, ID_TIPOALIMENTO)VALUES(?,?,?,?,?,?)";

    
    public AlimentoDAO(){
        
    }
    
    public AlimentoDAO(Conexion conexion){
        this.conexion = conexion;
    }
    
    public ArrayList<ObjetoAlimento> verAlimentosDeTipoAlimentos (int idTipoAlimento) throws SQLException{
        PreparedStatement pst = conexion.prepareStatement(verAlimentosDeTipoDeAlimento);
        pst.setInt(1, idTipoAlimento);
        ResultSet rs = pst.executeQuery();
        ArrayList<ObjetoAlimento> lista = new ArrayList();
        ObjetoAlimento alimento = null;
        while(rs.next()){
            alimento = new ObjetoAlimento();
            alimento.setIdAlimento(rs.getInt("ID_ALIMENTO"));
            alimento.setNombre(rs.getString("NOMBRE"));
            alimento.setPorcion(rs.getDouble("PORCION"));
            alimento.setMedida(rs.getString("MEDIDA"));
            alimento.setCalorias(rs.getDouble("CALORIAS"));
            alimento.setIdTipoAlimento(rs.getInt("ID_TIPOALIMENTO"));
            lista.add(alimento);
        }
        rs.close();
        pst.close();
        return lista;
    }
    
    public ArrayList<ObjetoAlimento> verTodosAlimentos() throws SQLException{
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(verTodosAlimentos);
        ArrayList<ObjetoAlimento> lista = new ArrayList<>();
        ObjetoAlimento alimento = new ObjetoAlimento();
        while(rs.next()){
            alimento.setIdAlimento(rs.getInt("ID_ALIMENTO"));
            alimento.setNombre(rs.getString("NOMBRE"));
            alimento.setPorcion(rs.getDouble("PORCION"));
            alimento.setMedida(rs.getString("MEDIDA"));
            alimento.setCalorias(rs.getDouble("CALORIAS"));
            alimento.setIdTipoAlimento(rs.getInt("ID_TIPOALIMENTO"));
            lista.add(alimento);
        }
        rs.close();
        return lista;
    }
}
