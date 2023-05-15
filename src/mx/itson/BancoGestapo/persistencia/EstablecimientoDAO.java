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
import mx.itson.BancoGestapo.entidades.Establecimiento;

/**
 * Es un DATA ACCESS OBJECT, que acede a los datos de la tabla EstablecimientoDAO
 * @author pyatq
 */
public class EstablecimientoDAO {
    
    /**
     * Obtiene los datos creados desde la Base de Datos
     * @return 
     */
        public static List<Establecimiento> obtener(){
        List<Establecimiento> establecimientos = new ArrayList<>();
        
        try{
            
            Connection conexion = Conexion.get();
            
            Statement statement = conexion.createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT * FROM vw_establecimiento");
            
            while(rs.next()){
                Establecimiento e = new Establecimiento();
                
                e.setId(rs.getInt(1));
                e.setNombre(rs.getString(2));
                e.setDireccion(rs.getString(3));
                
               establecimientos.add(e);
            }
            
        }catch(Exception ex){
            System.err.print("Ocurrio un error en la lista de Establecimiento" + ex.getMessage());
        }
        return establecimientos;
    }
     
        /**
         * Guarda nuevos registros creados
         * @param nombre Guarda nombre
         * @param direccion Guarda direccion
         * @return Guarda los registros creados
         */
        public static boolean guardar(String nombre, String direccion){
        boolean resultado = false;        
        try{
            
            String query ="INSERT INTO establecimiento(nombre, direccion) VALUES (?, ?)";
            Connection conexion = Conexion.get();
            
            
            PreparedStatement statement = conexion.prepareStatement(query);
            
             statement.setString(1, nombre);
             statement.setString(2, direccion);
            
            ResultSet rs = statement.executeQuery(query);
            resultado = true;
              
        }catch(Exception ex){
            System.err.print("Ocurrio un error" + ex.getMessage());
        }
        return resultado;
    }
        
        /**
         * Editar los datos de la tabla Establecimiento
         * @param id editar id
         * @param nombre editar nombre
         * @param apellido editar apellido
         * @param telefono editar telefono
         * @param numeroTarjeta editar numero de tarjeta
         * @return Es para indicar si el Guardado fue concretado de lo contrario retorna false
         */
        
          public static boolean editar(int id, String nombre, String apellido, String telefono, int numeroTarjeta){
        boolean resultado = false;        
        try{
            
            String query ="UPDATE cliente SET nombre = ?, apellido = ?, telefono = ?, idTarjeta = ? WHERE = ?)";
            Connection conexion = Conexion.get();
            
            
            PreparedStatement statement = conexion.prepareStatement(query);
            
             statement.setString(1, nombre);
             statement.setString(2, apellido);
             statement.setString(3, telefono);
             statement.setInt(4, numeroTarjeta);
             statement.setInt(5, id);
            
            ResultSet rs = statement.executeQuery(query);
            resultado = true;
              
        }catch(Exception ex){
            System.err.print("Ocurrio un error" + ex.getMessage());
        }
        return resultado;
    }
          /**
           * Obtener los datos de Establecimiento desde su id
           * @param id Obtener los datos 
           * @return Retorna Establecimiento
           */
        public static Establecimiento buscarId(int id){
        Establecimiento establecimiento = new Establecimiento();
        
        try{
            String query ="SELECT * FROM tarjeta WHERE = ?";
            Connection conexion = Conexion.get();
            
            PreparedStatement statement = conexion.prepareStatement(query);
            
            statement.setInt(1, id);
            
            ResultSet rs = statement.executeQuery(query);
            
           
                Establecimiento t = new Establecimiento();
                
                t.setNombre(rs.getString(1));
                t.setDireccion(rs.getString(2));;
               establecimiento = t;

            
        }catch(Exception ex){
            System.err.print("Ocurrio un error" + ex.getMessage());
        }
        return establecimiento;
    }
}
