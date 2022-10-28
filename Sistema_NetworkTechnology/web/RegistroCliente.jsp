<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.ClienteDAO"%>
<%@page import="Modelo.Cliente"%>
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
                <div class="card col-sm-6">
                    <form action="Control?accion=registrarCliente" method="POST">
                        <div class="form-group">
                            <%
//                            Cliente cli = new Cliente();
                            ClienteDAO cliDAO = new ClienteDAO();
                            ArrayList<Cliente>listaCliente = cliDAO.listarClientes();
                            int totalClientes= listaCliente.size()+1;
                            String formato="0000";
                            DecimalFormat objf= new DecimalFormat(formato);
                            String codCliente = "C"+objf.format(totalClientes);
                            System.out.println("Cliente nuevo"+codCliente);
                            %>
                            
                            <label>Codigo</label>
                            <input type="text"  readonly="readonly" name="txtCod_Cli" value="<%= codCliente%> " class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" placeholder="Ingrese su nombre" name="txtNom_Cli" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Apellido Paterno</label>
                            <input type="text" placeholder="Ingrese su apellido paterno" name="txtApepat_Cli" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Apellido Materno</label>
                            <input type="text" placeholder="Ingrese su apellido materno" name="txtApemat_Cli" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Documento Identidad</label>
                            <input type="text" placeholder="Ingrese su documento de identidad" name="txtDoi" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Dirección</label>
                            <input type="text" placeholder="Ingrese su direccion" name="txtDirec" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Distrito</label>
                            <input type="text" placeholder="Ingrese su distrito" name="txtDist" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Teléfono</label>
                            <input type="text" placeholder="Ingrese su telefono" name="txtTelef" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Correo Electronico</label>
                            <input type="text" placeholder="example@domain.com" name="txtEmail" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Contraseña</label>
                            <input type="password" placeholder="Contraseña" name="txtPassword" class="form-control">
                        </div>
                
                        <input type="submit" value="Agregar"  class="btn btn-info">
                        
                        </div>
                    </form>
                </div>
            </div>
        </div>
         <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
