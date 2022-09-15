/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author mrang
 */
public class Cdetalle {
    private int item;
    private String nro_comprobante;
    private String cod_producto;
    private int cantidad;
    private Double monto;

    public Cdetalle() {
    }

    public Cdetalle(int item,String nro_comprobante, String cod_producto, int cantidad, Double monto) {
        this.item= item;
        this.nro_comprobante = nro_comprobante;
        this.cod_producto = cod_producto;
        this.cantidad = cantidad;
        this.monto = monto;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getNro_comprobante() {
        return nro_comprobante;
    }

    public void setNro_comprobante(String nro_comprobante) {
        this.nro_comprobante = nro_comprobante;
    }

    public String getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(String cod_producto) {
        this.cod_producto = cod_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }
    
    
    
}
