
package Interfaces;

import Modelo.Cliente;
import java.util.ArrayList;


public interface metodoCliente {
    
    public void agregar(Cliente cli); //public boolean agregar(Producto idProducto);
    public boolean editar(String cli_codigo);
    public boolean eliminar(String cli_codigo);
    public Cliente listar(String email, String passw);
    public Cliente recuperarClave(String email);
    public int recuperarId(String email);
    public ArrayList<Cliente>listarTodoCliente();
    public int nuevoCliente();
    public ArrayList<Cliente> listarClientes();
    
}
