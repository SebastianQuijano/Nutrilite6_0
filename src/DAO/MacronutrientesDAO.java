/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Objetos.ObjetoMacronutrientes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public class MacronutrientesDAO {

    private Conexion conexion;
    private static final String verMacronutrientes = "SELECT * FROM NL_MACRONUTRIENTES";
    private static final String agregarMacronutrientes = "INSERT INTO NL_MACRONUTRIENTES(NOMBRE)VALUES(?)";
    private static final String editarMacronutrientes = "UPDATE NL_MACRONUTRIENTES SET NOMBRE = ? WHERE ID_MACRONUTRIENTES = ?";

    public MacronutrientesDAO(Conexion conexion) {
        this.conexion = conexion;
    }
    
    public ArrayList<ObjetoMacronutrientes> verMacronutrientes() throws SQLException {
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(verMacronutrientes);
        ArrayList<ObjetoMacronutrientes> lista = new ArrayList<>();
        ObjetoMacronutrientes objMacro;
        while (rs.next()) {
            objMacro = new ObjetoMacronutrientes();
            objMacro.setIdMacronutrientes(rs.getInt("ID_MACRONUTRIENTES"));
            objMacro.setNombre(rs.getString("NOMBRE"));
            lista.add(objMacro);
        }
        rs.close();
        st.close();
        return lista;
    }
    
    public int editarMacronutrientes(ObjetoMacronutrientes objMacro) throws SQLException {
        PreparedStatement pst = conexion.prepareStatement(editarMacronutrientes);
        pst.setString(1, objMacro.getNombre());
        pst.setInt(2, objMacro.getIdMacronutrientes());
        int estado = pst.executeUpdate();
        pst.close();
        return estado;
    }
    
    public int agregarMacronutrientes(ObjetoMacronutrientes objMacro) throws SQLException {
        PreparedStatement pst = conexion.prepareStatement(agregarMacronutrientes);
        pst.setString(1, objMacro.getNombre());
        int estado = pst.executeUpdate();
        pst.close();
        return estado;
    }

    public void guardarMacronutrientes(ArrayList<ObjetoMacronutrientes> lista) throws SQLException {
        for (ObjetoMacronutrientes macro : lista) {
            agregarMacronutrientes(macro);
        }
    }
    
}
