/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Comprobante;
import java.util.ArrayList;

/**
 *
 * @author mrang
 */
public interface metodoComprobante {
    public void agregarComprobante(Comprobante comprobante);
    public ArrayList<Comprobante>listaComprobante();
    public ArrayList<Comprobante> listaComprobante(String nro_comprobante);
    
}
