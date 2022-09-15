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
public class Categoria {
    protected int cat_codigo;
    protected String cat_nombre;

    public Categoria(int cat_codigo, String cat_nombre) {
        this.cat_codigo = cat_codigo;
        this.cat_nombre = cat_nombre;
    }

    public Categoria() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCat_codigo() {
        return cat_codigo;
    }

    public void setCat_codigo(int cat_codigo) {
        this.cat_codigo = cat_codigo;
    }

    public String getCat_nombre() {
        return cat_nombre;
    }

    public void setCat_nombre(String cat_nombre) {
        this.cat_nombre = cat_nombre;
    }
    
    
}
