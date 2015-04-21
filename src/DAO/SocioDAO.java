/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Objetos.ObjetoSocio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sebastian
 * 
 * Checar el eliminarSocio()
 * 
 * Al dar de alta, el adm agregara una contraseña temporal
 */
public class SocioDAO {

    private Conexion conexion;
    private static final String insertarSocio = "INSERT INTO NL_SOCIO"
            + "(ID_SOCIO,NOMBRE,APELLIDO_PATERNO,APELLIDO_MATERNO,NOMBRE_COMPLETO,SEXO,FECHA_NACIMIENTO,TELEFONO,DIRECCION,CORREO,PASSWORD,ID_ESTADO)"
            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String eliminarSocio = "DELETE FROM NL_SOCIO WHERE ID_SOCIO =?";
    private static final String modificarSocio = "UPDATE NL_SOCIO SET NOMBRE = ?,APELLIDO_PATERNO = ?,"
            + "APELLIDO_MATERNO = ?,NOMBRE_COMPLETO = ?,SEXO = ?,FECHA_NACIMIENTO = ?,TELEFONO = ?,"
            + "DIRECCION = ?,CORREO = ?,PASSWORD = ?,ID_ESTADO = ? WHERE ID_SOCIO = ?";
    private static final String verSocio = "SELECT * FROM NL_SOCIO WHERE ID_SOCIO = ?";
    private static final String darDeAltaSocio = "INSERT INTO NL_SOCIO(ID_SOCIO, PASSWORD, ESTADO) VALUES(?,?,1)";
    private static final String existeSocio = "SELECT COUNT(*) FROM NL_SOCIO WHERE ID_SOCIO = ? AND PASSWORD = ? AND ESTADO = 1";
    private static final String verPasswordSocio = "SELECT PASSWORD FROM NL_SOCIO WHERE CORREO = ?";
    private static final String existeCorreo = "SELECT COUNT(*) FROM NL_SOCIO WHERE CORREO = ?";
    
    
    public SocioDAO(Conexion conexion) {
        this.conexion = conexion;
    }
    
    /*Agrega un socio a la BD, obtiene la informacion de un objeto socio y retorna estado de transaccion*/
    public int insertarSocio(ObjetoSocio objetoSocio) throws SQLException {
        
        PreparedStatement pst = conexion.prepareStatement(insertarSocio);
        pst.setInt(1, objetoSocio.getIdSocio());
        pst.setString(2, objetoSocio.getNombre());
        pst.setString(3, objetoSocio.getApellidoPaterno());
        pst.setString(4, objetoSocio.getApellidoMaterno());
        pst.setString(5, objetoSocio.getNombreCompleto());
        pst.setString(6, objetoSocio.getSexo());
        pst.setString(7, objetoSocio.getFechaNacimiento());
        pst.setString(8, objetoSocio.getTelefono());
        pst.setString(9, objetoSocio.getDireccion());
        pst.setString(10, objetoSocio.getCorreo());
        pst.setString(11, objetoSocio.getPassword());
        pst.setInt(12, objetoSocio.getIdEstado());
        int estado = pst.executeUpdate();
        pst.close();
        
        return estado;
    }

    /*Elimina a un socio por su id, obtiene idSocio y retorna estado de transaccion*/
    public int eliminarSocio(int idSocio) throws SQLException {
        new ClienteDAO(conexion).eliminarClientePorSocio(idSocio);
        PreparedStatement pst = conexion.prepareStatement(eliminarSocio);
        pst.setInt(1, idSocio);
        int estado = pst.executeUpdate();
        pst.close();
        
        return estado;
    }

    /*Modifica a un socio, obtiene la informacion de un objetoSocio y retorna estado de transaccion*/
    public int modificarSocio(ObjetoSocio objetoSocio) throws SQLException {
        
        PreparedStatement pst = conexion.prepareStatement(modificarSocio);
        pst.setString(1, objetoSocio.getNombre());
        pst.setString(2, objetoSocio.getApellidoPaterno());
        pst.setString(3, objetoSocio.getApellidoMaterno());
        pst.setString(4, objetoSocio.getNombreCompleto());
        pst.setString(5, objetoSocio.getSexo());
        pst.setString(6, objetoSocio.getFechaNacimiento());
        pst.setString(7, objetoSocio.getTelefono());
        pst.setString(8, objetoSocio.getDireccion());
        pst.setString(9, objetoSocio.getCorreo());
        pst.setString(10, objetoSocio.getPassword());
        pst.setInt(11, objetoSocio.getIdEstado());
        pst.setInt(12, objetoSocio.getIdSocio());
        int estado = pst.executeUpdate();
        pst.close();
        
        return estado;
    }

    /*Busca un socio en especifico, obtiene su id y retorna un objetoSocio*/
    public ObjetoSocio verSocioConId(int idSocio) throws SQLException {
       
        PreparedStatement pst = conexion.prepareStatement(verSocio);
        pst.setInt(1, idSocio);
        ResultSet res = pst.executeQuery();
        ObjetoSocio socio = null;
        if (res.next()) {
            socio = new ObjetoSocio();
            socio.setIdSocio(res.getInt("ID_SOCIO"));
            socio.setNombre(res.getString("NOMBRE"));
            socio.setApellidoPaterno(res.getString("APELLIDO_PATERNO"));
            socio.setApellidoMaterno(res.getString("APELLIDO_MATERNO"));
            socio.setNombreCompleto(res.getString("NOMBRE_COMPLETO"));
            socio.setSexo(res.getString("SEXO"));
            socio.setFechaNacimiento(res.getString("FECHA_NACIMIENTO"));
            socio.setTelefono(res.getString("TELEFONO"));
            socio.setDireccion(res.getString("DIRECCION"));
            socio.setCorreo(res.getString("CORREO"));
            socio.setPassword(res.getString("PASSWORD"));
            socio.setIdEstado(res.getInt("ID_ESTADO"));
        }
        res.close();
        pst.close();
        
        return socio;
    }

    /*Da de alta a un nuevo socio con su idSocio, si se completo con exito retorna 1, si no retorna 0*/
    public int darDeAlta(int idSocio) throws SQLException {
        
        PreparedStatement pst = conexion.prepareStatement(darDeAltaSocio);
        pst.setInt(1, idSocio);
        pst.setString(2,idSocio + "");
        int resultado = pst.executeUpdate();
        pst.close();
        
        return resultado;
    }

    /*Reviso si existe el idSocio con la password, si es asi retorno el objeto socio, si no retorno un objetosocio vacio */
    public ObjetoSocio login(int idSocio, String password) throws SQLException {
        
        PreparedStatement pst = conexion.prepareStatement(existeSocio);
        pst.setInt(1, idSocio);
        pst.setString(2, password);
        ResultSet resultado = pst.executeQuery();
        ObjetoSocio socio = null;
        resultado.next();
        if (resultado.getInt(1) == 1) {
            socio = verSocioConId(idSocio);
        }
        pst.close();
        
        return socio;
    }
    
    public String verContraseña(String correo) throws SQLException {
        
        PreparedStatement pst = conexion.prepareStatement(verPasswordSocio);
        pst.setString(1, correo);
        ResultSet resultado = pst.executeQuery();
        String password = null;
        if (resultado.next()) {
            password = resultado.getString(1);
        }
        resultado.close();
        pst.close();
        return password;
        
    }
    
    public int existeCorreo(String correo) throws SQLException {
        
        PreparedStatement pst = conexion.prepareStatement(existeCorreo);
        pst.setString(1, correo);
        ResultSet resultado = pst.executeQuery();
        int existe = 0;
        if (resultado.next())
            existe = resultado.getInt(1);
        resultado.close();
        pst.close();
        return existe;
        
    }
    
}
