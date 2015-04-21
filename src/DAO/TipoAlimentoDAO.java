/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Objetos.ObjetoTipoAlimento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public class TipoAlimentoDAO {

    private Conexion conexion;
    private static final String verTipoAlimento = "SELECT * FROM NL_TIPOALIMENTO";
    private static final String verTipoAlimentoDeMacronutriente = "SELECT * FROM NL_TIPOALIMENTO WHERE ID_MACRONUTRIENTES = ?";
//    private static final String editarTipoAlimento = "";
    
    
    
    public TipoAlimentoDAO(Conexion conexion) {
        this.conexion = conexion;
    }
    
    public ArrayList<ObjetoTipoAlimento> verTipoAlimento() throws SQLException{
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(verTipoAlimento);
        ArrayList<ObjetoTipoAlimento> lista = new ArrayList<>();
        ObjetoTipoAlimento tipoalimento;
        while(rs.next()){
            tipoalimento = new ObjetoTipoAlimento();
            tipoalimento.setIdMacronutriente(rs.getInt("ID_MACRONUTRIENTES"));
            tipoalimento.setIdTipoAlimento(rs.getInt("ID_TIPOALIMENTO"));
            tipoalimento.setNombre(rs.getString("NOMBRE"));
            lista.add(tipoalimento);
        }
        return lista;

    }
    
    public ArrayList<ObjetoTipoAlimento> verTipoAlimentoDeMacronutriente(int IdMacronutriente) throws SQLException{
        PreparedStatement pst = conexion.prepareStatement(verTipoAlimentoDeMacronutriente);
        pst.setInt(1, IdMacronutriente);
        ResultSet rs = pst.executeQuery();
        ArrayList<ObjetoTipoAlimento> lista = new ArrayList<>();
        ObjetoTipoAlimento tipoalimento;
        while(rs.next()){
            tipoalimento = new ObjetoTipoAlimento();
            tipoalimento.setIdMacronutriente(rs.getInt("ID_MACRONUTRIENTES"));
            tipoalimento.setIdTipoAlimento(rs.getInt("ID_TIPOALIMENTO"));
            tipoalimento.setNombre(rs.getString("NOMBRE"));
            lista.add(tipoalimento);
        }
        return lista;
    }

}
