<%@page import="Modelo.Empresa"%>
<%@page import="ModeloDAO.EmpresaDAO"%>
<%@page import="ModeloDAO.EmpresaDAO"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="Modelo.Administrador"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.AdministradorDAO"%>
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
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script type="text/javascript" src="Js/codigo.js"></script> 
        <title>Technology Networks</title>
    </head>
    <body>
        <div>
            <div class="d-flex">
                <div class="card col-sm-2">
                    <form action="Control?accion=registrarAdministrador" method="POST">
                        <%
                            AdministradorDAO adminDAO = new AdministradorDAO();
                            ArrayList<Administrador> listarAdministradores = adminDAO.listarTodoAdministrador();
                            int totalAdministradores = listarAdministradores.size() + 1;
                            String formato = "0000";
                            DecimalFormat objf = new DecimalFormat(formato);
                            String codAdmin = "A" + objf.format(totalAdministradores);
                            System.out.println("Administrador nuevo" + codAdmin);
                        %>
                        <div class="form-group">
                            <label>Codigo</label>
                            <input type="text" readonly="readonly" name="txtCod_Admi" value="<%=codAdmin%>" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" placeholder="Nombres" name="txtNom_Admi" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Apellido paterno</label>
                            <input type="text" placeholder="Apellido Paterno" name="txtApe_Pat_Admi" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Apellido materno</label>
                            <input type="text" placeholder="Apellido Materno" name="txtApe_Mat_Admi" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Fecha de Ingreso</label>
                            <input type="text" placeholder="yyyy-mm-dd" name="txtFechaIngreso" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Locacion</label>                            
                            <select name="txtLoc">
                                <%
                                    EmpresaDAO empDAO = new EmpresaDAO();
                                    ArrayList<Empresa> listarempresas = empDAO.listarEmpresas();
                                    for (int k = 0; k < listarempresas.size(); k++) {%>
                                <option value="<%= listarempresas.get(k).getLocacion()%>"><%= listarempresas.get(k).getLocacion()%></option>
                                <%}%>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>Contraseña</label>
                            <input type="password" placeholder="Contraseña" name="txtpass" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Estado</label>
                            <select name="txtEstado">
                                <option value="A">Activo</option>
                                <option value="I">Inactivo</option>
                            </select>
                        </div>

                        <input type="submit" value="Agregar"  class="btn btn-info">

                    </form>
                </div>

                <div class="col-sm-10">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>CODIGO</th>
                                <th>NOMBRE</th>
                                <th>PATERNO</th>
                                <th>MATERNO</th>
                                <th>FECHA INGRESO</th>
                                <th>LOC</th>
                                <th>CONTRASEÑA</th>
                                <th>ESTADO</th>

                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (int j = 0; j < listarAdministradores.size(); j++) {
                            %>
                            <tr>
                                <td><label name="lblbadmincod" id="lblbadmincod"><%= listarAdministradores.get(j).getAdmin_cod()%></label></td>
                                <td><label name="lbladminnom" id="lbladminnom"><%= listarAdministradores.get(j).getAdmin_nombre()%></label></td>
                                <td><label name="lbladminapepat" id="lbladminapepat"><%= listarAdministradores.get(j).getAdmin_apepat()%></label></td>
                                <td><label name="lbladminapemat" id="lbladminapemat"><%= listarAdministradores.get(j).getAdmin_apemat()%></label></td>
                                <td><label name="lbladminfecing" id="lbladminfecing"><%= listarAdministradores.get(j).getAdmin_fec_ing()%></label></td>
                                <td><label name="lbladminloc" id="lbladminloc"><%= listarAdministradores.get(j).getAdmin_LOC()%></label></td>
                                <td><label name="lblpasswd" id="lblpasswd"><%= listarAdministradores.get(j).getAdmin_password()%></label></td>
                                <td><label name="lblestado" id="lblestado"><%= listarAdministradores.get(j).getAdmin_estado()%></label></td>
                                <td>
                                    <a class="btn btn-success" data-toggle="modal" data-target="#ventana1" onclick="modalAdmin('<%= listarAdministradores.get(j).getAdmin_cod()%>','<%= listarAdministradores.get(j).getAdmin_nombre()%>','<%= listarAdministradores.get(j).getAdmin_apepat()%>','<%= listarAdministradores.get(j).getAdmin_apemat()%>','<%= listarAdministradores.get(j).getAdmin_fec_ing()%>','<%= listarAdministradores.get(j).getAdmin_password()%>')">Editar</a>
                                    <a class="btn btn-danger"  data-toggle="modal" data-target="#ventana2">Eliminar</a>
                                </td>
                            </tr>
                            <%}%>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <div class="modal fade" id="ventana1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="Control?accion=actualizarAdministrador" method="POST">   
                        <div class="modal-body">
                            <label>Codigo</label>
                            <input type="text" readonly="readonly" name="txtCod_Admi" id="txtCod_Admi" class="form-control">

                            <label>Nombre</label>
                            <input type="text" placeholder="Nombres" name="txtNom_Admi" id="txtNom_Admi" class="form-control">

                            <label>Apellido paterno</label>
                            <input type="text" placeholder="Apellido Paterno" name="txtApe_Pat_Admi" id="txtApe_Pat_Admi" class="form-control">

                            <label>Apellido materno</label>
                            <input type="text" placeholder="Apellido Materno" name="txtApe_Mat_Admi" id="txtApe_Mat_Admi" class="form-control">

                            <label>Fecha de Ingreso</label>
                            <input type="text" placeholder="yyyy-mm-dd" name="txtFechaIngreso" id="txtFechaIngreso"  class="form-control">

                            <div class="modal-body">
                                <label>Locacion</label>                            
                                <select name="txtLoc" id="txtLoc">
                                <%
                                    EmpresaDAO eDAO = new EmpresaDAO();
                                    ArrayList<Empresa> listarempresa = eDAO.listarEmpresas();
                                    for (int k = 0; k < listarempresa.size(); k++) {%>
                                <option value="<%= listarempresa.get(k).getLocacion()%>"><%= listarempresa.get(k).getLocacion()%></option>
                                <%}%>
                            </select>
                            </div>

                            <label>Contraseña</label>
                            <input type="password" placeholder="Nueva contraseña" name="txtpass" id="txtpass" class="form-control">

                            <div class="modal-body">
                                <label>Estado</label>
                                <select name="txtEstado" id="txtEstado">
                                    <option value="A">Activo</option>
                                    <option value="I">Inactivo</option>
                                </select>
                            </div>

                        </div>
                       <div class="modal-body">   
                        <button type="submit" value="Actualizar"  class="btn btn-info">Actualizar</button>
                        <button class="btn btn-danger btn-large" data-dismiss="modal" aria-hidden="true">Salir</button>
                        </div>
                        
                    </form>                           
                </div>
            </div>
        </div>
                            
         
           <div class="modal fade" id="ventana2">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="card-body text-center">
                        <label>Desea Eliminar Usuario</label><br>
                        <button class="btn btn-danger btn-large" data-dismiss="modal" aria-hidden="true">Si</button>
                        <button class="btn btn-warning btn-large" data-dismiss="modal" aria-hidden="true">No</button>
                     </div>
                </div>
            </div>
        </div>                 
                            
                            

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
