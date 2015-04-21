/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Objetos.ObjetoMedidaFecha;
import Objetos.ObjetoMedidas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public class MedidasDAO {
    
    private Conexion conexion;
    private static final String agregarMedidas = "INSERT INTO NL_MEDIDAS(CINTURA,MUNECA,PECHO,CADERA,FECHA,CUELLO,PESO,ALTURA,ID_CLIENTE)"
            + "VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String verMedidas = "SELECT * FROM NL_MEDIDAS";
    private static final String verMedidasDeCliente = "SELECT * FROM NL_MEDIDAS WHERE ID_CLIENTE = ?";
    private static final String verCintura = "SELECT CINTURA FROM NL_MEDIDAS WHERE ID_CLIENTE = ?";
    private static final String verMuneca = "SELECT MUNECA FROM NL_MEDIDAS WHERE ID_CLIENTE = ?";
    private static final String verPecho = "SELECT PECHO FROM NL_MEDIDAS WHERE ID_CLIENTE = ?";
    private static final String verCadera = "SELECT CADERA FROM NL_MEDIDAS WHERE ID_CLIENTE = ?";
    private static final String verCuello = "SELECT CUELLO FROM NL_MEDIDAS WHERE ID_CLIENTE = ?";
    private static final String verPeso = "SELECT PESO FROM NL_MEDIDAS WHERE ID_CLIENTE = ?";
    private static final String verAltura = "SELECT ALTURA FROM NL_MEDIDAS WHERE ID_CLIENTE = ?";
    private static final String verFecha = "SELECT FECHA FROM NL_MEDIDAS WHERE ID_CLIENTE = ?";
    private static final String verMedidasPorId = ",FECHA FROM NL_MEDIDAS WHERE ID_CLIENTE = ? ORDER BY ID_MEDIDA";
    private static final String verTodosIdMedidasCliente = "SELECT ID_MEDIDA FROM NL_MEDIDAS WHERE ID_CLIENTE = ?";
    private static final String verUltimasMedidasPorId = "SELECT * FROM NL_MEDIDAS WHERE ID_MEDIDA = ?";
    
    public MedidasDAO(Conexion conexion) {
        this.conexion = conexion;
    }
    
    public void agregarMedida(ObjetoMedidas medidas) throws SQLException {
        PreparedStatement pst = conexion.prepareStatement(agregarMedidas);
        pst.setDouble(1, medidas.getCintura());
        pst.setDouble(2, medidas.getMuneca());
        pst.setDouble(3, medidas.getPecho());
        pst.setDouble(4, medidas.getCadera());
        pst.setString(5, medidas.getFecha());
        pst.setDouble(6, medidas.getCuello());
        pst.setDouble(7, medidas.getPeso());
        pst.setDouble(8, medidas.getAltura());
        pst.setInt(9, medidas.getIdCliente());
        pst.executeUpdate();
        pst.close();
    }
    
    public void agregarMedidas(ArrayList<ObjetoMedidas> lista) throws SQLException {
        for (ObjetoMedidas medida : lista) {
            agregarMedida(medida);
        }
    }
    
    public ArrayList<ObjetoMedidas> verMedidas() throws SQLException{
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(verMedidas);
        ArrayList<ObjetoMedidas> lista = new ArrayList<>();
        ObjetoMedidas medida = null;
        while(rs.next()){
            medida = new ObjetoMedidas();
            medida.setIdMedida(rs.getInt("ID_MEDIDA"));
            medida.setAltura(rs.getDouble("ALTURA"));
            medida.setCadera(rs.getDouble("CADERA"));
            medida.setCintura(rs.getDouble("CINTURA"));
            medida.setCuello(rs.getDouble("CUELLO"));
            medida.setFecha(rs.getString("FECHA"));
            medida.setIdCliente(rs.getInt("ID_CLIENTE"));
            medida.setMuneca(rs.getDouble("MUNECA"));
            medida.setPecho(rs.getDouble("PECHO"));
            medida.setPeso(rs.getDouble("PESO"));
            lista.add(medida);
        }
        rs.close();
        st.close();
        return lista;
    }
    
    public ObjetoMedidas verMedidasDeCliente(int idCliente) throws SQLException{
        PreparedStatement pst = conexion.prepareStatement(verMedidasDeCliente);
        pst.setInt(1, idCliente);
        ResultSet rs = pst.executeQuery();
        ObjetoMedidas medidas = null;
        if (rs.next()) {
            medidas = new ObjetoMedidas();
            medidas.setAltura(rs.getDouble("ALTURA"));
            medidas.setCadera(rs.getDouble("CADERA"));
            medidas.setCintura(rs.getDouble("CINTURA"));
            medidas.setCuello(rs.getDouble("CUELLO"));
            medidas.setFecha(rs.getString("FECHA"));
            medidas.setIdCliente(rs.getInt("ID_CLIENTE"));
            medidas.setIdMedida(rs.getInt("ID_MEDIDA"));
            medidas.setMuneca(rs.getDouble("MUNECA"));
            medidas.setPecho(rs.getDouble("PECHO"));
            medidas.setPeso(rs.getDouble("PESO"));
        }
        rs.close();
        pst.close();
        return medidas;
    }
    
    public int verCintura(int idCliente) throws SQLException{
        PreparedStatement pst = conexion.prepareStatement(verCintura);
        pst.setInt(1, idCliente);
        ResultSet rs = pst.executeQuery();
        int cintura = -1;
        if (rs.next()) {
            cintura = rs.getInt("CINTURA");
        }
        rs.close();
        pst.close();
        return cintura;
    }
    
    public int verMuneca(int idCliente) throws SQLException{
        PreparedStatement pst = conexion.prepareStatement(verMuneca);
        pst.setInt(1, idCliente);
        ResultSet rs = pst.executeQuery();
        int muneca = -1;
        if (rs.next()) {
            muneca = rs.getInt("MUNECA");
        }
        rs.close();
        pst.close();
        return muneca;
    }
    
    public int verPecho(int idCliente) throws SQLException{
        PreparedStatement pst = conexion.prepareStatement(verPecho);
        pst.setInt(1, idCliente);
        ResultSet rs = pst.executeQuery();
        int pecho = -1;
        if (rs.next()) {
            pecho = rs.getInt("PECHO");
        }
        rs.close();
        pst.close();
        return pecho;
    }
    
    public int verCadera(int idCliente) throws SQLException{
        PreparedStatement pst = conexion.prepareStatement(verCadera);
        pst.setInt(1, idCliente);
        ResultSet rs = pst.executeQuery();
        int cadera = -1;
        if (rs.next()) {
            cadera = rs.getInt("CADERA");
        }
        rs.close();
        pst.close();
        return cadera;
    }
    
    public int verCuello (int idCliente) throws SQLException{
        PreparedStatement pst = conexion.prepareStatement(verCuello);
        pst.setInt(1, idCliente);
        ResultSet rs = pst.executeQuery();
        int cuello = -1;
        if (rs.next()) {
            cuello = rs.getInt("CUELLO");
        }
        rs.close();
        pst.close();
        return cuello;
    }
    
    public int verPeso(int idCliente) throws SQLException{
        PreparedStatement pst = conexion.prepareStatement(verPeso);
        pst.setInt(1, idCliente);
        ResultSet rs = pst.executeQuery();
        int peso = -1;
        if (rs.next()) {
            peso = rs.getInt("PESO");
        }
        rs.close();
        pst.close();
        return peso;
    }
    
    public int verAltura(int idCliente) throws SQLException{
        PreparedStatement pst = conexion.prepareStatement(verAltura);
        pst.setInt(1, idCliente);
        ResultSet rs = pst.executeQuery();
        int altura = -1;
        if (rs.next()) {
            altura = rs.getInt("ALTURA");
        }
        rs.close();
        pst.close();
        return altura;
    }
    
    public String verFecha(int idCliente) throws SQLException{
        PreparedStatement pst = conexion.prepareStatement(verFecha);
        pst.setInt(1, idCliente);
        ResultSet rs = pst.executeQuery();
        String fecha = null;
        if (rs.next()) {
            fecha = rs.getString("FECHA");
        }
        rs.close();
        pst.close();
        return fecha;
    }
    
    public ArrayList<ObjetoMedidaFecha> verMedidasPorId(String medida, int idCliente) throws SQLException {
        PreparedStatement pst = conexion.prepareStatement("SELECT " + medida + verMedidasPorId);
        pst.setInt(1, idCliente);
        ResultSet rs = pst.executeQuery();
        ArrayList<ObjetoMedidaFecha> medidas = new ArrayList();
        ObjetoMedidaFecha medidaFecha = null;
        while (rs.next()) {
            medidaFecha = new ObjetoMedidaFecha(rs.getDouble(medida), rs.getString("FECHA"));
            medidas.add(medidaFecha);
        }
        rs.close();
        pst.close();
        return medidas;
    }
    
    public ObjetoMedidas verUltimaMedidaCliente(int idCliente) throws SQLException {
        PreparedStatement pst = conexion.prepareStatement(verTodosIdMedidasCliente);
        pst.setInt(1, idCliente);
        ResultSet rs = pst.executeQuery();
        int idUltimo = 0;
        while (rs.next()) {
            idUltimo = rs.getInt(1);
        }
        pst = conexion.prepareStatement(verUltimasMedidasPorId);
        pst.setInt(1, idUltimo);
        rs = pst.executeQuery();
        ObjetoMedidas medidas = null;
        if (rs.next()) {
            medidas = new ObjetoMedidas();
            medidas.setAltura(rs.getDouble("ALTURA"));
            medidas.setCadera(rs.getDouble("CADERA"));
            medidas.setCintura(rs.getDouble("CINTURA"));
            medidas.setCuello(rs.getDouble("CUELLO"));
            medidas.setFecha(rs.getString("FECHA"));
            medidas.setIdCliente(rs.getInt("ID_CLIENTE"));
            medidas.setIdMedida(rs.getInt("ID_MEDIDA"));
            medidas.setMuneca(rs.getDouble("MUNECA"));
            medidas.setPecho(rs.getDouble("PECHO"));
            medidas.setPeso(rs.getDouble("PESO"));
        }
        rs.close();
        pst.close();
        return medidas;
    }
    
}
