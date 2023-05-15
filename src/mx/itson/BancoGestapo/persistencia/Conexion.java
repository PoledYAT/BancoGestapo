/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.BancoGestapo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Es una Clase creada para la conexion de NetBeans a la Base de Datos MySQL
 * @author pyatq
 */
public class Conexion {

    public static Connection get(){
        Connection conexion = null;
        
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/bancodb?user=root&password=1708");
            
        }catch(Exception ex){
            System.err.print("Ocurrio un Error" + ex.getMessage());
        }
        return conexion;
    }
}
