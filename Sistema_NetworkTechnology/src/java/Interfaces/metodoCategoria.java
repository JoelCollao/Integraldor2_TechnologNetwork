/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Categoria;
import java.util.ArrayList;

/**
 *
 * @author mrang
 */
public interface metodoCategoria {
    public boolean agregar(Categoria categoria); //public boolean agregar(Producto idProducto);
    public boolean editar(int cat_codigo);
    public boolean eliminar(int cat_codigo);
    public Categoria listar(Categoria categoria);
    public ArrayList<Categoria>listarTodoCategoria();
    
}
