/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Cdetalle;
import java.util.ArrayList;

/**
 *
 * @author mrang
 */
public interface metodoCdetalle {
    
    public ArrayList<Cdetalle>detalle(String comprobante_cabe_numero);
    public ArrayList<Cdetalle> listar();
    public void agregar(Cdetalle cdetalle);
    
}
