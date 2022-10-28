<%-- 
    Document   : adminUpdate
    Created on : 10/11/2021, 01:23:54 AM
    Author     : mrang
--%>

<%@page import="Modelo.Administrador"%>
<%@page import="ModeloDAO.AdministradorDAO"%>
<%@page import="Modelo.Empresa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.EmpresaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"> 
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


        <!-- <link rel="stylesheet" type="text/css" href="Estilos/estilos.css"/>-->
        <link rel="stylesheet" type="text/css" href="Estilos/estilosindex.css"/>
        <script type="text/javascript" src="Js/codigo.js"></script> 
        <title>Technology Networks</title>
    </head>
    <body>
        
      
        
        <div>
            <div class="d-flex">
                <div class="card col-sm-2">
                    <form action="Control?accion=actualizarAdministrador" method="POST">
                        <%
                        String admin_cod= request.getParameter("admin_cod");
                        AdministradorDAO adminDAO = new AdministradorDAO();
                        Administrador admin = adminDAO.listar(admin_cod);
                        %>
                        <div class="form-group">
                            <label>Codigo</label>
                            <input type="text" readonly="readonly" name="txtCod_Admi" value="<%= admin_cod%>" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" placeholder="Nombres" name="txtNom_Admi" value="<%= admin.getAdmin_nombre() %>" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Apellido paterno</label>
                            <input type="text" placeholder="Apellido Paterno" name="txtApe_Pat_Admi" value="<%= admin.getAdmin_apepat() %>" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Apellido materno</label>
                            <input type="text" placeholder="Apellido Materno" name="txtApe_Mat_Admi" value="<%= admin.getAdmin_apemat() %>" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Fecha de Ingreso</label>
                            <input type="text" placeholder="yyyy-mm-dd" name="txtFechaIngreso" value="<%= admin.getAdmin_fec_ing()%>" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Locacion</label>                            
                            <select name="txtLoc">
                           <%
                           EmpresaDAO empDAO = new EmpresaDAO();
                           ArrayList<Empresa>listarempresas = empDAO.listarEmpresas();
                           for(int k=0; k<listarempresas.size();k++){%>
                           <option value="<%= listarempresas.get(k).getLocacion() %>"><%= listarempresas.get(k).getLocacion() %></option>
                            <%}%>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>Contraseña</label>
                            <input type="password" placeholder="Nueva contraseña" name="txtpass" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Estado</label>
                            <select name="txtEstado">
                                <option value="A">Activo</option>
                                <option value="I">Inactivo</option>
                            </select>
                        </div>

                        <input type="submit" value="Actualizar"  class="btn btn-info">

                    </form>
                </div>
            </div>
        </div>
        
        
        
        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
