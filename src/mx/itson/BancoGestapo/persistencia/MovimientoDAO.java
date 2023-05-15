/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.BancoGestapo.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import mx.itson.BancoGestapo.entidades.Cliente;
import mx.itson.BancoGestapo.entidades.Establecimiento;
import mx.itson.BancoGestapo.entidades.Movimiento;
import mx.itson.BancoGestapo.entidades.Tarjeta;

/**
 *
 * @author pyatq
 */
public class MovimientoDAO {
    
    public static List<Movimiento> obtener(){
        List<Movimiento> movimientos = new ArrayList<>();
        
        try{
            
            Connection conexion = Conexion.get();
            
            Statement statement = conexion.createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT * FROM vw_historial");
            
            while(rs.next()){
                Movimiento h = new Movimiento();
                Cliente c = new Cliente();
                Tarjeta t = new Tarjeta();
                Establecimiento e = new Establecimiento();
                
                c.setNombre(rs.getString(1));
                c.setApellido(rs.getString(2));
                t.setNombre(rs.getString(3));
                t.setNumero(rs.getString(4));
                h.setFecha(rs.getString(5));
                e.setNombre(rs.getString(6));
                e.setDireccion(rs.getString(7));
                h.setDescripcion(rs.getString(8));
                h.setTipo(rs.getString(9));
                h.setMonto(rs.getDouble(10));
                h.setCorte(CorteDAO.buscarId(rs.getInt(11)));
                
               h.setCliente(c);
               h.setTarjeta(t);
               h.setEstablecimiento(e);
               movimientos.add(h);
            }
            
        }catch(Exception ex){
            System.err.print("Ocurrio un error en la lista de Cliente" + ex.getMessage());
        }
        return movimientos;
    }
    
    public static Movimiento buscarId(int id){
        Movimiento movimientos = new Movimiento();
        
        try{
            String query ="SELECT * FROM movimiento WHERE = ?";
            Connection conexion = Conexion.get();
            
            PreparedStatement statement = conexion.prepareStatement(query);
            
            statement.setInt(1, id);
            
            ResultSet rs = statement.executeQuery(query);
            
           
                Movimiento m = new Movimiento();
                
                m.setCliente(ClienteDAO.buscarId(rs.getInt(1)));
                m.setTarjeta(TarjetaDAO.buscarId(rs.getInt(2)));;
                m.setFecha(rs.getString(3));
                m.setEstablecimiento(EstablecimientoDAO.buscarId(rs.getInt(4)));
                m.setDescripcion(rs.getString(5));
                m.setTipo(rs.getString(6));
                m.setMonto(rs.getDouble(7));
                m.setCorte(CorteDAO.buscarId(rs.getInt(8)));
                
                movimientos = m;

            
        }catch(Exception ex){
            System.err.print("Ocurrio un error" + ex.getMessage());
        }
        return movimientos;
    }
}
