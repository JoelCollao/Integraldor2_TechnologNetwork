
package Modelo;

import java.io.InputStream;


public class Producto {
    private String pro_codigo;
    private String pro_descripcion;
    private double pro_precio_unitario;
    private int pro_stock;
    private int cat_codigo;
    private InputStream pro_img;

    public Producto(String pro_codigo, String pro_descripcion, double pro_precio_unitario, int pro_stock, int cat_codigo, InputStream pro_img) {
        this.pro_codigo = pro_codigo;
        this.pro_descripcion = pro_descripcion;
        this.pro_precio_unitario = pro_precio_unitario;
        this.pro_stock = pro_stock;
        this.cat_codigo = cat_codigo;
        this.pro_img = pro_img;
    }

    public Producto() {
    }

    public String getPro_codigo() {
        return pro_codigo;
    }

    public void setPro_codigo(String pro_codigo) {
        this.pro_codigo = pro_codigo;
    }

    public String getPro_descripcion() {
        return pro_descripcion;
    }

    public void setPro_descripcion(String pro_descripcion) {
        this.pro_descripcion = pro_descripcion;
    }

    public double getPro_precio_unitario() {
        return pro_precio_unitario;
    }

    public void setPro_precio_unitario(double pro_precio_unitario) {
        this.pro_precio_unitario = pro_precio_unitario;
    }

    public int getPro_stock() {
        return pro_stock;
    }

    public void setPro_stock(int pro_stock) {
        this.pro_stock = pro_stock;
    }

    public int getCat_codigo() {
        return cat_codigo;
    }

    public void setCat_codigo(int cat_codigo) {
        this.cat_codigo = cat_codigo;
    }

    public InputStream getPro_img() {
        return pro_img;
    }

    public void setPro_img(InputStream pro_img) {
        this.pro_img = pro_img;
    }

    
    
    
    
}
