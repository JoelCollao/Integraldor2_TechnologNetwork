
package Interfaces;

import Modelo.Administrador;
import java.util.ArrayList;


public interface metodoAdministrador {
    public Administrador listar(String admin_cod);
    public void agregar(Administrador admi); //public boolean agregar(Producto idProducto);
    public void editar(Administrador admin);
    public void eliminar(String admin_cod);
    public Administrador listar(String admin_cod, String admin_pass);
    public Administrador recuperarClave(String email);
    public int recuperarId(String email);
    public ArrayList<Administrador>listarTodoAdministrador();
    public int nuevoAdministrador();
}
