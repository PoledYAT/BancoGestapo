/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.BancoGestapo.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.itson.BancoGestapo.entidades.Cliente;
import mx.itson.BancoGestapo.entidades.Corte;
import mx.itson.BancoGestapo.entidades.Movimiento;
import mx.itson.BancoGestapo.entidades.Tarjeta;

/**
 * Es un DATA ACCESS OBJECT, que acede a los datos de la tabla CorteDAO
 * @author pyatq
 */
public class CorteDAO {
    
    /**
     * Obtiene los datos creado en la Base de Datos
     * @return 
     */
    public static List<Corte> obtener(){
        List<Corte> corte = new ArrayList<>();
        
        try{
            
            Connection conexion = Conexion.get();
            
            Statement statement = conexion.createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT * FROM cortes");
            
            while(rs.next()){
                Corte c = new Corte();
                
                c.setCliente(ClienteDAO.buscarId(rs.getInt(1)));
                c.setTarjeta(TarjetaDAO.buscarId(rs.getInt(2)));
                c.setFechaInicio(rs.getDate(3));
                c.setTotal(rs.getDouble(4));
                c.setFehchaFinal(rs.getDate(5));
                corte.add(c);
            }
            
        }catch(Exception ex){
            System.err.print("Ocurrio un error en la lista de Corte" + ex.getMessage());
        }
        return corte;
    }
    
    /**
     * Guarda los registros de la clase Corte
     * @param idCliente Guarda los datos de Cliente desde su id
     * @param idTarjeta Guarda los datos de Tarjeta desde su id
     * @param total Guarda el total 
     * @return Es para indicar si el Guardado fue concretado de lo contrario retorna false
     */
    
    public static boolean guardar(int idCliente, int idTarjeta, double total){
        boolean resultado = false;        
        try{
            
            String query ="INSERT INTO corte (idCliente, idTarjeta, total) VALUES (?, ?, ?, ?)";
            Connection conexion = Conexion.get();
            
            
            PreparedStatement statement = conexion.prepareStatement(query);
            
             statement.setInt(1, idCliente);
             statement.setInt(2, idTarjeta);
             statement.setDouble(3, total);
            
            ResultSet rs = statement.executeQuery(query);
            resultado = true;
              
        }catch(Exception ex){
            System.err.print("Ocurrio un error" + ex.getMessage());
        }
        return resultado;
    }
    
    /**
     * Obtener los datos de Corte por su Id
     * @param id Obtener los datos 
     * @return Retorna Corte 
     */
    public static Corte buscarId(int id){
        Corte corte = new Corte();
        
        try{
            String query ="SELECT * FROM corte WHERE = ?";
            Connection conexion = Conexion.get();
            
            PreparedStatement statement = conexion.prepareStatement(query);
            
            statement.setInt(1, id);
            
            ResultSet rs = statement.executeQuery(query);
            
            
                Corte c = new Corte();
                Cliente cl = new Cliente();
                Tarjeta t = new Tarjeta();
                
                cl.setId(rs.getInt(1));
                t.setId(rs.getInt(2));
                t.setNombre(rs.getString(4));
                c.setTotal(rs.getDouble(5));
                
               c.setTarjeta(t);
               c.setCliente(cl);
               c.setFehchaFinal(rs.getDate(6));
               c.setFechaInicio(rs.getDate(3));
               corte = c;
            
            
        }catch(Exception ex){
            System.err.print("Ocurrio un error" + ex.getMessage());
        }
        return corte;
    }
    
}
