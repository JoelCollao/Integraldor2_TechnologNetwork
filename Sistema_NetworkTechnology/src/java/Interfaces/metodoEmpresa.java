/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Empresa;
import java.util.ArrayList;

/**
 *
 * @author mrang
 */
public interface metodoEmpresa {
    public void agregar();
    public ArrayList<Empresa>listarEmpresas();
    public ArrayList<Empresa> listarEmpresaporLocacion(String loc);
    
}
