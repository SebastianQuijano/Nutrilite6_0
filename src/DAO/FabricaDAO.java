/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;

/**
 *
 * @author Erick
 */
public class FabricaDAO {
    
    private Conexion conexion;
    
    public FabricaDAO(Conexion conexion) {
        this.conexion = conexion;
    }
    
    public ClienteDAO getClienteDAO() {
        return new ClienteDAO(conexion);
    }
    
    public ComplementoDAO getComplementoDAO() {
        return new ComplementoDAO(conexion);
    }
    
    public EstadoDAO getEstadoDAO() {
        return new EstadoDAO(conexion);
    }
    
    public EstructuraDAO getEstuturaDAO() {
        return new EstructuraDAO(conexion);
    }
    
    public MacronutrientesDAO getMacronutrientesDAO() {
        return new MacronutrientesDAO(conexion);
    }
    
    public MedidasDAO getMedidasDAO() {
        return new MedidasDAO(conexion);
    }
    
    public PaisDAO getPaisDAO() {
        return new PaisDAO(conexion);
    }
    
    public PaqueteDAO getPaqueteDAO() {
        return new PaqueteDAO(conexion);
    }
    
    public SocioDAO getSocioDAO() {
        return new SocioDAO(conexion);
    }
    
    public TipoAlimentoDAO getTipoAlimentoDAO(){
        return new TipoAlimentoDAO(conexion);
    }
    
    public AlimentoDAO getAlimentoDAO(){
        return new AlimentoDAO(conexion);
    }
    
}
