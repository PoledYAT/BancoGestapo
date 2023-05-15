/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.BancoGestapo.entidades;

import java.util.Date;

/**
 * Estidades de la clase Corte
 * @author pyatq
 */
public class Corte {
    
    private int id;
    private Cliente cliente;
    private Tarjeta tarjeta;
    private Date fechaInicio;
    private Date fehchaFinal;
    private double total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFehchaFinal() {
        return fehchaFinal;
    }

    public void setFehchaFinal(Date fehchaFinal) {
        this.fehchaFinal = fehchaFinal;
    }
}
