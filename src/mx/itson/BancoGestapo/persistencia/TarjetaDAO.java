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
import mx.itson.BancoGestapo.entidades.Tarjeta;

/**
 * Es un DATA ACCESS OBJECT, que acede a los datos de la tabla TarjetaDAO
 * @author pyatq
 */
public class TarjetaDAO {
    
        public static List<Tarjeta> obtener(){
        List<Tarjeta> tarjetas = new ArrayList<>();
        
        try{
            
            Connection conexion = Conexion.get();
            
            Statement statement = conexion.createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT * FROM tarjeta");
            
            while(rs.next()){
                Tarjeta t = new Tarjeta();
                
                t.setId(rs.getInt(1));
                t.setNombre(rs.getString(2));
                t.setNumero(rs.getString(3));
                t.setInteres(rs.getInt(4));
                t.setCredito(rs.getInt(5));
                
               tarjetas.add(t);
            }
            
        }catch(Exception ex){
            System.err.print("Ocurrio un error en la lista de Tarjeta" + ex.getMessage());
        }
        return tarjetas;
    }
        /**
         * Guarda los datos creados 
         * @param nombre Guarda nombre
         * @param numeroTarjeta Guarda numero de tarjeta
         * @param interes Guarda intereses
         * @param credito Guarda credito
         * @return Es para indicar si el Guardado fue concretado de lo contrario retorna false
         */
        public static boolean guardar(String nombre, String numeroTarjeta, int interes, int credito){
        boolean resultado = false;        
        try{
            
            String query ="INSERT INTO tarjeta(nombre, numero_tarjeta, interes, credito) VALUES (?, ?, ?, ?)";
            Connection conexion = Conexion.get();
            
            
            PreparedStatement statement = conexion.prepareStatement(query);
            
             statement.setString(1, nombre);
             statement.setString(2, numeroTarjeta);
             statement.setInt(3, interes);
             statement.setInt(4, credito);
            
            ResultSet rs = statement.executeQuery(query);
            resultado = true;
              
        }catch(Exception ex){
            System.err.print("Ocurrio un error" + ex.getMessage());
        }
        return resultado;
    }
        
        /**
         * Obtener los datos de Tarjeta desde su ID
         * @param id Obtener los datos 
         * @return Retorna Tarjeta
         */
        
         public static Tarjeta buscarId(int id){
        Tarjeta tarjeta = new Tarjeta();
        
        try{
            String query ="SELECT * FROM tarjeta WHERE = ?";
            Connection conexion = Conexion.get();
            
            PreparedStatement statement = conexion.prepareStatement(query);
            
            statement.setInt(1, id);
            
            ResultSet rs = statement.executeQuery(query);
            
            
                Tarjeta t = new Tarjeta();
                
                t.setNombre(rs.getString(1));
                t.setNumero(rs.getString(2));
                t.setInteres(rs.getInt(3));
                t.setCredito(rs.getInt(4));
                

               tarjeta = t;
            
            
        }catch(Exception ex){
            System.err.print("Ocurrio un error" + ex.getMessage());
        }
        return tarjeta;
    }
}
