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
public class Empresa {
    private String locacion;
    private String ruc;
    private String razon_social;
    private String direccion;
    private String telefono;
    private String correo;
    private String cuenta;
    private String nro_cuenta;
    private String cci;
    
    public Empresa(){
        
    }

    public Empresa(String locacion, String ruc, String razon_social, String direccion, String telefono, String correo, String cuenta, String nro_cuenta, String cci) {
        this.locacion = locacion;
        this.ruc = ruc;
        this.razon_social = razon_social;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.cuenta = cuenta;
        this.nro_cuenta = nro_cuenta;
        this.cci = cci;
    }

    public String getCci() {
        return cci;
    }

    public void setCci(String cci) {
        this.cci = cci;
    }

    public String getLocacion() {
        return locacion;
    }

    public void setLocacion(String locacion) {
        this.locacion = locacion;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getNro_cuenta() {
        return nro_cuenta;
    }

    public void setNro_cuenta(String nro_cuenta) {
        this.nro_cuenta = nro_cuenta;
    }
    
    
    
}
