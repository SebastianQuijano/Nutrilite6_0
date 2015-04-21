/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Objetos.ObjetoCliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sebastian
 * 
 * pendiente por checar verCliente... solo regresaria el primero de la lista con los %%
 */
public class ClienteDAO {

    private Conexion conexion;
    private static final String agregarCliente = "INSERT INTO NL_CLIENTE(ID_CLIENTE,NOMBRE,APELLIDO_PATERNO,APELLIDO_MATERNO,NOMBRE_COMPLETO,FECHA_NACIMIENTO,DIRECCION,SEXO,TELEFONO,CORREO,ID_ESTADO,ID_SOCIO)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String modificarCliente = "UPDATE NL_CLIENTE SET NOMBRE = ?,APELLIDO_PATERNO = ?,"
            + "APELLIDO_MATERNO = ?,NOMBRE_COMPLETO = ?,FECHA_NACIMIENTO = ?,DIRECCION = ?,SEXO = ?,"
            + "TELEFONO = ?,CORREO = ?,ID_ESTADO = ?,ID_SOCIO = ? WHERE ID_CLIENTE = ?";
    private static final String modificarClienteVer = "UPDATE NL_CLIENTE SET DIRECCION = ?, TELEFONO = ?, CORREO = ?, ID_ESTADO = ? WHERE ID_CLIENTE = ?";
    private static final String eliminarCliente = "DELETE FROM NL_CLIENTE WHERE ID_CLIENTE = ?";
    private static final String eliminarClientePorSocio = "DELETE FROM NL_CLIENTE WHERE ID_SOCIO = ?";
    private static final String verTodosClientes = "SELECT * FROM NL_CLIENTE";
    private static final String verClientes = "SELECT * FROM NL_CLIENTE WHERE ID_SOCIO = ?";
    private static final String contarClientes = "SELECT COUNT(*) FROM NL_CLIENTE WHERE ID_SOCIO = ?";
    private static final String verCliente = "SELECT * FROM NL_CLIENTE WHERE NOMBRE_COMPLETO LIKE ?  AND ID_SOCIO = ?";
    private static final String existeIDCliente = "SELECT COUNT(*) FROM NL_CLIENTE WHERE ID_CLIENTE = ?";
    
    public ClienteDAO(Conexion conexion) {
        this.conexion = conexion;
    }
    
    /*Agrega un cliente a la base de datos, obtiene un objeto cliente con todos sus parametros*/
    public int agregarCliente(ObjetoCliente objetoCliente) throws SQLException {
        
        PreparedStatement pst = conexion.prepareStatement(agregarCliente);
        pst.setInt(1, obtenerNuevaIdCliente(objetoCliente.getIdSocio()));
        pst.setString(2, objetoCliente.getNombre());
        pst.setString(3, objetoCliente.getApellidoPaterno());
        pst.setString(4, objetoCliente.getApellidoMaterno());
        pst.setString(5, objetoCliente.getNombreCompleto());
        pst.setString(6, objetoCliente.getFechaNacimiento());
        pst.setString(7, objetoCliente.getDireccion());
        pst.setString(8, objetoCliente.getSexo());
        pst.setString(9, objetoCliente.getTelefono());
        pst.setString(10, objetoCliente.getCorreo());
        pst.setInt(11, objetoCliente.getIdEstado());
        pst.setInt(12, objetoCliente.getIdSocio());
        int estado = pst.executeUpdate();
        pst.close();

        return estado;
    }
    
    /*Agrega todos los clientes de un ArrayList a la Tabla Cliente. Usada para llenar la BD*/
    public void agregarClientes(ArrayList<ObjetoCliente> lista) throws SQLException {
        for (ObjetoCliente cliente : lista) {
            agregarCliente(cliente);
        }
    }
    
    /*Modifica un clente de la base de datos, recibe un cliente y obtiene todos los datos, usa el idCliente para saber
     cual modificar y retorna estado de transaccion*/
    public int modificarCliente(ObjetoCliente objetoCliente) throws SQLException {

        PreparedStatement pst = conexion.prepareStatement(modificarCliente);
        pst.setString(1, objetoCliente.getNombre());
        pst.setString(2, objetoCliente.getApellidoPaterno());
        pst.setString(3, objetoCliente.getApellidoMaterno());
        pst.setString(4, objetoCliente.getNombreCompleto());
        pst.setString(5, objetoCliente.getFechaNacimiento());
        pst.setString(6, objetoCliente.getDireccion());
        pst.setString(7, objetoCliente.getSexo());
        pst.setString(8, objetoCliente.getTelefono());
        pst.setString(9, objetoCliente.getCorreo());
        pst.setInt(10, objetoCliente.getIdEstado());
        pst.setInt(11, objetoCliente.getIdSocio());
        pst.setInt(12, objetoCliente.getIdCliente());
        int estado = pst.executeUpdate();
        pst.close();

        return estado;
    }
    
    public int modificarClienteVer(ObjetoCliente objetoCliente) throws SQLException {

        PreparedStatement pst = conexion.prepareStatement(modificarClienteVer);
        pst.setString(1, objetoCliente.getDireccion());
        pst.setString(2, objetoCliente.getTelefono());
        pst.setString(3, objetoCliente.getCorreo());
        pst.setInt(4, objetoCliente.getIdEstado());
        pst.setInt(5, objetoCliente.getIdCliente());
        int estado = pst.executeUpdate();
        pst.close();

        return estado;
    }
    
    /*Obtiene el idCliente y elimina ese id de la BD y retorna estado de transaccion*/
    public int eliminarCliente(int idCliente) throws SQLException {

        PreparedStatement pst = conexion.prepareStatement(eliminarCliente);
        pst.setInt(1, idCliente);
        int estado = pst.executeUpdate();
        pst.close();

        return estado;
    }
    
    public void eliminarClientePorSocio(int idCliente) throws SQLException {
        PreparedStatement pst = conexion.prepareStatement(eliminarClientePorSocio);
        pst.setInt(1, idCliente);
        pst.executeUpdate();
        pst.close();
    }
    
    /*Hace una consulta para saber cuantos registros hay agregados a la tabla Clientes bajo el idSocio y retorna estado  de transaccion*/
    public int obtenerRegistros(int idSocio) throws SQLException {

        PreparedStatement pst = conexion.prepareStatement(contarClientes);
        pst.setInt(1, idSocio);
        ResultSet rs = pst.executeQuery();
        int registros = 0;
        if (rs.next()) {
            registros = rs.getInt(1);
        }
        rs.close();
        pst.close();

        return registros;
    }
    
    /*Obtiene los clientes que esten registrados bajo el idSocio proporcionado, retorna un arreglo de objetoCliente*/
    public ArrayList<ObjetoCliente> verClientesSocio(int idSocio) throws SQLException {

        PreparedStatement pst = conexion.prepareStatement(verClientes);
        pst.setInt(1, idSocio);
        ResultSet rs = pst.executeQuery();
        ArrayList<ObjetoCliente> listaClientes = new ArrayList();
        ObjetoCliente cliente;
        while (rs.next()) {
            cliente = new ObjetoCliente();
            cliente.setIdCliente(rs.getInt("ID_CLIENTE"));
            cliente.setNombre(rs.getString("NOMBRE"));
            cliente.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
            cliente.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));
            cliente.setNombreCompleto(rs.getString("NOMBRE_COMPLETO"));
            cliente.setFechaNacimiento(rs.getString("FECHA_NACIMIENTO"));
            cliente.setDireccion(rs.getString("DIRECCION"));
            cliente.setSexo(rs.getString("SEXO"));
            cliente.setTelefono(rs.getString("TELEFONO"));
            cliente.setCorreo(rs.getString("CORREO"));
            cliente.setIdEstado(rs.getInt("ID_ESTADO"));
            cliente.setIdSocio(rs.getInt("ID_SOCIO"));
            listaClientes.add(cliente);
        }
        rs.close();
        pst.close();

        return listaClientes;
    }
    
    /*Obtiene todos los clientes de la BD, retorna un arreglo de objetoCliente*/
    public ArrayList<ObjetoCliente> verClientes() throws SQLException {

        PreparedStatement pst = conexion.prepareStatement(verTodosClientes);
        ResultSet rs = pst.executeQuery();
        ArrayList<ObjetoCliente> listaClientes = new ArrayList();
        ObjetoCliente cliente;
        while (rs.next()) {
            cliente = new ObjetoCliente();
            cliente.setIdCliente(rs.getInt("ID_CLIENTE"));
            cliente.setNombre(rs.getString("NOMBRE"));
            cliente.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
            cliente.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));
            cliente.setNombreCompleto(rs.getString("NOMBRE_COMPLETO"));
            cliente.setFechaNacimiento(rs.getString("FECHA_NACIMIENTO"));
            cliente.setDireccion(rs.getString("DIRECCION"));
            cliente.setSexo(rs.getString("SEXO"));
            cliente.setTelefono(rs.getString("TELEFONO"));
            cliente.setCorreo(rs.getString("CORREO"));
            cliente.setIdEstado(rs.getInt("ID_ESTADO"));
            cliente.setIdSocio(rs.getInt("ID_SOCIO"));
            listaClientes.add(cliente);
        }
        rs.close();
        pst.close();

        return listaClientes;
    }
    
    /*Busca a un cliente por un wildcrd de su nombre y el idSocio que tiene y devuelve un ObjetoCliente*/
    public ObjetoCliente verCliente(String nombre, int idSocio) throws SQLException {

        PreparedStatement pst = conexion.prepareStatement(verCliente);
        pst.setString(1, "%" + nombre + "%");
        pst.setInt(2, idSocio);
        ResultSet rs = pst.executeQuery();
        ObjetoCliente cliente = null;
        if (rs.next()) {
            cliente = new ObjetoCliente();
            cliente.setIdCliente(rs.getInt("ID_CLIENTE"));
            cliente.setNombre(rs.getString("NOMBRE"));
            cliente.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
            cliente.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));
            cliente.setNombreCompleto(rs.getString("NOMBRE_COMPLETO"));
            cliente.setFechaNacimiento(rs.getString("FECHA_NACIMIENTO"));
            cliente.setDireccion(rs.getString("DIRECCION"));
            cliente.setSexo(rs.getString("SEXO"));
            cliente.setTelefono(rs.getString("TELEFONO"));
            cliente.setCorreo(rs.getString("CORREO"));
            cliente.setIdEstado(rs.getInt("ID_ESTADO"));
            cliente.setIdSocio(rs.getInt("ID_SOCIO"));
        }
        rs.close();
        pst.close();
        return cliente;
    }
    
    /*Obtiene el idCliente que es el numero de registros del socio + 1 concatenado con el idSocio y lo devuelve*/
    public int obtenerNuevaIdCliente(int idSocio) throws SQLException {

        PreparedStatement pst = conexion.prepareStatement(contarClientes);
        pst.setInt(1, idSocio);
        ResultSet rs = pst.executeQuery();
        int registros = 0;
        if (rs.next()) {
            registros = rs.getInt(1) + 1;
            while (existeIDCliente(idSocio, registros)) {
                registros++;
            }
            registros = Integer.parseInt(idSocio + "" + registros);
        }
        rs.close();
        pst.close();

        return registros;
    }
    
    private boolean existeIDCliente(int idSocio, int idCliente) throws SQLException {
        
        PreparedStatement pst = conexion.prepareStatement(existeIDCliente);
        pst.setInt(1, Integer.parseInt(idSocio + "" + idCliente));
        ResultSet resultado = pst.executeQuery();
        boolean existe = false;
        resultado.next();
        if (resultado.getInt(1) != 0) {
            existe = true;
        }
        resultado.close();
        pst.close();
        return existe;
        
    }

}
