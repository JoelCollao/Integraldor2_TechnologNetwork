<%@page import="java.text.DecimalFormat"%>
<%@page import="Modelo.Cliente"%>
<%@page import="ModeloDAO.ClienteDAO"%>
<%@page import="Modelo.Producto"%>
<%@page import="ModeloDAO.ProductoDAO"%>
<%@page import="Modelo.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.CategoriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Tecnology Networt</title>
    </head>

    <body>

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <img src="Img/logo_techcology_web" alt="300" width="300"/>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <!-- para ver toda la lista de catalogos -->
                    <li class="nav-item dropdown">
                        <a class="nav-link" href="Control?accion=home">Home<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Nosotros
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Misión</a>
                            <a class="dropdown-item" href="#">Visión</a>

                        </div>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Categorías
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">


                            <%
                                CategoriaDAO c = new CategoriaDAO();
                                ArrayList<Categoria> lista = c.listarTodoCategoria();
                                Categoria cat;
                                for (int i = 0; i < lista.size(); i++) {
                                    cat = new Categoria();
                                    cat = lista.get(i);
                            %> 
                            <p><a href="Control?accion=<%=cat.getCat_codigo()%>"><%=cat.getCat_nombre()%></a></p>
                                <%
                                    }
                                %>
                            <p><a href="Control?accion=-1">Ver todo</a></p>
                        </div>
                    </li>                   
                    <li class="nav-item dropdown">
                        <%
                            if (sesion.getAttribute("cliente") == null) {%>
                            <a class="nav-link" data-toggle="modal" data-target="#ventana1" href="#"><i class="fas fa-cart-plus"></i><span class="sr-only">(current)</span>( <%= request.getAttribute("contador") %> ) Carrito</a>  
                             
                        <%
                        } else {%>
                            <a class="nav-link" href="Control?accion=carrito"><i class="fas fa-cart-plus"></i><span class="sr-only">(current)</span>( <%= request.getAttribute("contador") %> ) Carrito</a>
                        <%}%>
                        </li>
                </ul>
                <div>        
                    <style type="text/css">
                        #logeo{
                            color: white;
                        }
                    </style>

                    <a id = "logeo" class="nav-link"><span class="sr-only">(current)</span>
                        <%
                            if (sesion.getAttribute("cliente") == null) {
                        %> 
                        <%
                        } else {%>Bienvenido <%= sesion.getAttribute("cliente")%>
                        <%}%> 
                    </a>
                </div>
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Sesión
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <%
                                 try {
                                     if (sesion.getAttribute("cliente") == null) {%>
                                    <a class="dropdown-item" data-toggle="modal" data-target="#ventana1" href="#">Iniciar Sesion</a>
                                    <a class="dropdown-item" data-toggle="modal" data-target="#ventana2" href="#">Registrarse</a>
                                    <%}%>
                        <%if (sesion.getAttribute("cliente") != null) {%>
                        <a class="dropdown-item" data-toggle="modal" data-target="#ventana3" href="#">Actualizar Datos</a>
                        <a class="dropdown-item" href="Control?accion=logout">Cerrar Sesion</a>
                        <%}
                                } catch (Exception e) {
                                }%> 
                        <a class="dropdown-item" href="Control?accion=ir_a_carrito">Ir al carrito</a>
                    </div>
                </div>
            </div>
                        
            <div class="modal fade" id="ventana1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="Control?accion=login" method="POST">   
                        <div class="modal-body">
                            <label>Usuario</label>
                            <input type="text" placeholder="Usuario" name="txtlogin" id="txtlogin" class="form-control">

                            <label>Contraseña</label>
                            <input type="password" placeholder="Contraseña" name="txtpassword" id="txtpassword" class="form-control">

                        </div>
                        <div class="modal-body">   
                        <button type="submit" value="Login"  class="btn btn-info">Login</button>
                        <button class="btn btn-danger btn-large" data-dismiss="modal" aria-hidden="true">Salir</button>
                        </div>
                    </form>                           
                </div>
            </div>
        </div>
                           
         
           <div class="modal fade" id="ventana2">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="Control?accion=registrarCliente" method="POST">   
                        <div class="modal-body">
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
                            <input type="text"  readonly="readonly" name="txtCod_Cli" id="txtCod_Cli" value="<%= codCliente%> " class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" placeholder="Ingrese su nombre" name="txtNom_Cli" id="txtNom_Cli" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Apellido Paterno</label>
                            <input type="text" placeholder="Ingrese su apellido paterno" name="txtApepat_Cli" id="txtApepat_Cli" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Apellido Materno</label>
                            <input type="text" placeholder="Ingrese su apellido materno" name="txtApemat_Cli" id="txtApemat_Cli" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Documento Identidad</label>
                            <input type="text" placeholder="Ingrese su documento de identidad" name="txtDoi" id="txtDoi" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Dirección</label>
                            <input type="text" placeholder="Ingrese su direccion" name="txtDirec" id="txtDirec" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Distrito</label>
                            <input type="text" placeholder="Ingrese su distrito" name="txtDist" id="txtDist" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Teléfono</label>
                            <input type="text" placeholder="Ingrese su telefono" name="txtTelef" id="txtTelef" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Correo Electronico</label>
                            <input type="text" placeholder="example@domain.com" name="txtEmail" id="txtEmail" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Contraseña</label>
                            <input type="password" placeholder="Contraseña" name="txtPassword" id="txtPassword" class="form-control">
                        </div>
                
                        <input type="submit" value="Agregar"  class="btn btn-info">
                    </form>
                </div>
            </div>
        </div>
                            
        </nav>
        <div class="container mt-4">   
            <div class="row">
                <%
                    try {
                        int cat_cod;
                        if (request.getAttribute("cod_categoria") == null || Integer.parseInt(request.getAttribute("cod_categoria").toString()) == -1) {
                            //request.setAttribute("cod_categoria", -1);
                            cat_cod=-1;
                            ProductoDAO pDAO = new ProductoDAO();
                            ArrayList<Producto> listarProductos = pDAO.listar();
                            Producto p = new Producto();
                            for (int j = 0; j < listarProductos.size(); j++) {
                                p = listarProductos.get(j);
                %>
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-header">
                            <labels><%= p.getPro_descripcion()%> </labels>
                        </div>
                        <div class="card-body">
                            <i><%= p.getPro_precio_unitario()%> </i>
                            <img src="ControladorImg?parametro=<%= p.getPro_codigo()%> " width="200" height="200">
                            <label>Cantidad disponible: <%= p.getPro_stock() %> unidades</label>
                        </div>
                        <div class="card-footer text-center">
                            <label>Descripción del Producto</label>
                            <div>
                                <a href="Control?accion=agregarCarrito&codigo=<%= p.getPro_codigo() %>&cod_cat=<%=cat_cod%>" class="btn btn-outline-info">Agregar a Carrito</a>
                                <a href="Control?accion=carrito" class="btn btn-primary">Comprar</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%
                    }
                } else {
                    cat_cod = Integer.parseInt(request.getAttribute("cod_categoria").toString());
                    //   }
                    if (cat_cod > 0) {
                        request.setAttribute("cod_categoria", cat_cod);
                        ProductoDAO pDAO = new ProductoDAO();
                        ArrayList<Producto> proCategoria = pDAO.listarProductosporCategoria(cat_cod);
                        Producto pro = new Producto();
                %>   
                <%
                    for (int k = 0; k < proCategoria.size(); k++) {
                        pro = proCategoria.get(k);
                %>
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-header">
                            <labels><%= pro.getPro_descripcion()%> </labels>
                        </div>
                        <div class="card-body">
                            <i><%= pro.getPro_precio_unitario()%> </i>
                            <img src="ControladorImg?parametro=<%= pro.getPro_codigo()%> " width="200" height="200">
                            <label>Cantidad disponible: <%= pro.getPro_stock() %> unidades</label>
                        </div>
                        <div class="card-footer text-center">
                            <label>Descripción del Producto</label>
                            <div>
                                <a href="Control?accion=agregarCarrito&codigo=<%= pro.getPro_codigo() %>&cod_cat=<%= pro.getCat_codigo() %>" class="btn btn-outline-info">Agregar a Carrito</a>
                                <a href="Control?accion=carrito" class="btn btn-primary">Comprar</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%  }%>  
                <%
                            }
                        }
                    } catch (NumberFormatException ex) {
                    }
                %>
                <!-- IRIA UN FOREACG  RECORRE LA IMAGENES -->
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>