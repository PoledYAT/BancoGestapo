/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.BancoGestapo.ui;

import mx.itson.BancoGestapo.entidades.Cliente;
import mx.itson.BancoGestapo.entidades.Establecimiento;
import mx.itson.BancoGestapo.entidades.Tarjeta;
import mx.itson.BancoGestapo.persistencia.ClienteDAO;
import mx.itson.BancoGestapo.persistencia.EstablecimientoDAO;
import mx.itson.BancoGestapo.persistencia.TarjetaDAO;

/**
 * 
 * @author pyatq
 */
public class main {
    
    public static void main(String[] args){
        //Tarjeta t = new Tarjeta();
        
        //TarjetaDAO.obtener();
        
        //Cliente c = new Cliente();
        
        //ClienteDAO.obtener();
        
        Establecimiento e = new Establecimiento();
        
        EstablecimientoDAO.obtener();
    }
}
