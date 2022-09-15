/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Carrito;
import java.util.ArrayList;

/**
 *
 * @author mrang
 */
public interface metodoCarrito {
    public ArrayList<Carrito>listarCarrito();
    public void eliminarCarrito();
    public Carrito listarCarritoporDescripcion(String descripcion);
    public boolean buscarProducto(String descripcion);
    public void agregarCarrito(Carrito carrito);
    public boolean eliminarItem(int item);
    public boolean actualizarCantidad(String descripcion, int cantidad, double subtotal);
    
    
}
