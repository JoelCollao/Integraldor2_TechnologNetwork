/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.InputStream;

/**
 *
 * @author mrang
 */
public class Carrito {
    private int item;
    private String codigo_producto;
    private String descripcion_producto;
    private double precio_unitario_producto;
    private int cantidad;
    private double subtotal;
    private InputStream foto;

    public Carrito() {
    }

    public Carrito(int item, String codigo_producto, String descripcion_producto, double precio_unitario_producto, int cantidad, double subtotal, InputStream foto) {
        this.item=item;
        this.codigo_producto = codigo_producto;
        this.descripcion_producto = descripcion_producto;
        this.precio_unitario_producto = precio_unitario_producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.foto = foto;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public double getPrecio_unitario_producto() {
        return precio_unitario_producto;
    }

    public void setPrecio_unitario_producto(double precio_unitario_producto) {
        this.precio_unitario_producto = precio_unitario_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }
    
    
}
