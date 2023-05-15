/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.BancoGestapo.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import mx.itson.BancoGestapo.entidades.Cliente;
import mx.itson.BancoGestapo.entidades.Tarjeta;

/**
 *
 * @author pyatq
 */
public class ClienteDAO {
    
   public static List<Cliente> obtener(){
        List<Cliente> clientes = new ArrayList<>();
        
        try{
            
            Connection conexion = Conexion.get();
            
            Statement statement = conexion.createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT * FROM vw_cliente_tarjeta");
            
            while(rs.next()){
                Cliente c = new Cliente();
                Tarjeta t = new Tarjeta();
                c.setId(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setTelefono(rs.getString(4));
                t.setNombre(rs.getString(5));
                
               c.setTarjeta(t);
               clientes.add(c);
            }   
            
        }catch(Exception ex){
            System.err.print("Ocurrio un error en la lista de Cliente" + ex.getMessage());
        }
        return clientes;
    }
    
    public static boolean guardar(String nombre, String apellido, String telefono, int numeroTarjeta){
        boolean resultado = false;        
        try{
            
            String query ="INSERT INTO cliente(nombre, apellido, telefono, idTarjeta) VALUES (?, ?, ?, ?)";
            Connection conexion = Conexion.get();
            
            
            PreparedStatement statement = conexion.prepareStatement(query);
            
             statement.setString(1, nombre);
             statement.setString(2, apellido);
             statement.setString(3, telefono);
             statement.setInt(4, numeroTarjeta);
            
            ResultSet rs = statement.executeQuery(query);
            resultado = true;
              
        }catch(Exception ex){
            System.err.print("Ocurrio un error" + ex.getMessage());
        }
        return resultado;
    }
    
   public static Cliente buscarId(int id){
        Cliente clientes = new Cliente();
        
        try{
            String query ="SELECT * FROM cliente WHERE = ?";
            Connection conexion = Conexion.get();
            
            PreparedStatement statement = conexion.prepareStatement(query);
            
            statement.setInt(1, id);
            
            ResultSet rs = statement.executeQuery(query);
            
           
                Cliente c = new Cliente();
                Tarjeta t = new Tarjeta();
                
                c.setNombre(rs.getString(1));
                c.setApellido(rs.getString(2));
                c.setTelefono(rs.getString(3));
                t.setNombre(rs.getString(4));
                
               c.setTarjeta(t);
               clientes = c;
            
            
        }catch(Exception ex){
            System.err.print("Ocurrio un error" + ex.getMessage());
        }
        return clientes;
    }
}
