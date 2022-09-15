/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author mrang
 */
public class Comprobante {
    
    private String locacion;
    private String nro_comprobante;
    private String fecha;
    private String cod_cliente;
    private Double igv;
    private Double Total;

    public Comprobante() {
    }

    public Comprobante(String locacion, String nro_comprobante, String fecha, String cod_cliente, Double igv, Double Total) {
        this.locacion = locacion;
        this.nro_comprobante = nro_comprobante;
        this.fecha = fecha;
        this.cod_cliente = cod_cliente;
        this.igv = igv;
        this.Total = Total;
    }
    
    

    public String getLocacion() {
        return locacion;
    }

    public void setLocacion(String locacion) {
        this.locacion = locacion;
    }

    public String getNro_comprobante() {
        return nro_comprobante;
    }

    public void setNro_comprobante(String nro_comprobante) {
        this.nro_comprobante = nro_comprobante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(String cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double Total) {
        this.Total = Total;
    }

    
}
