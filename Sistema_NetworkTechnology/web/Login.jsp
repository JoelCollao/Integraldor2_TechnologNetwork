<%@page import="Modelo.Cliente"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.ClienteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"> 
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="Estilos/estilos.css"/>
        <script type="text/javascript" src="Js/codigo.js"></script> 
        <title>Technology Networks</title>
    </head>
    
      <header class="page-header">
       <%
            if(request.getAttribute("contador")==null){
                request.setAttribute("contador", 0);
            }
            /*else{
                request.setAttribute("contador", request.getAttribute("contador"));
            }   */        
       %> 
        <%
            HttpSession sesion = request.getSession();
            if (sesion.getAttribute("cliente") == null) {
        %>
        <%
        } else {%><%= sesion.getAttribute("cliente")%>
        <%}%> 
    </header>
    
    <body>
        <div class="container mt-4 col-lg-4">
            <div class="card col-sm-10">
                <div class="card-body text-center">
                    <form class ="form-sign" action="Control?accion=login" method="POST">
                        <div class="form-group text-center">
                            <h3>Bienvenidos a</h3> 
                            <img src="Img/3.jpeg" alt="300" width="500"/>
                            
                        </div>
                        <div class="form-group text-left">
                            <label>Usuario:</label>
                            <input type="text" placeholder="Introduce Su Usuario..." name="txtlogin" class="form-control" required="">
                        </div>
                        <div class="form-group text-left">
                            <label>Password:</label>
                            <input type="password" placeholder="Introduce Su Contraseña ..." name="txtpassword"  id="txtpassword" class="form-control" required="">
                        </div>
                        <input type="submit" name="accion" value="Login" class="btn btn-primary btn-blog">
                        <div>
                            <a class="dropdown-item" data-toggle="modal" data-target="#ventana3" href="#">¿Olvidaste tu contraseña?</a>
                        </div>
                    </form>
                </div>
            </div>
            
             <div class="modal fade" id="ventana3">
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
                        </div>
                        
                       
                        <div>
                        <label>Antigua Contraseña</label>
                            <div class="form-row">
                                <div class="col">
                        <input class="form-control" type="password" name="password" id="password">
                            </div>
                        <div class="col">
                          <button class="btn btn-primary" type="button" onclick="mostrarContrasena()">Mostrar Contraseña</button>
                        </div>
                            </div>
                        </div>
                        
                         <div>
                        <label>Nueva Contraseña</label>
                            <div class="form-row">
                                <div class="col">
                        <input class="form-control" type="password" name="password" id="password">
                            </div>
                        <div class="col">
                          <button class="btn btn-primary" type="button" onclick="mostrarContrasena()">Mostrar Contraseña</button>
                        </div>
                            </div>
                        </div>
                                <!-- PARA SEGUIR CON MOSTRAR CONTRASEÑA -->
                               <!-- https://www.baulphp.com/3-formas-para-mostrar-y-ocultar-contrasenas/ -->               
                        <div>
                        <label>Repita Contraseña</label>
                            <div class="form-row">
                                <div class="col">
                        <input class="form-control" type="password" name="password" id="password">
                            </div>
                        <div class="col">
                          <button class="btn btn-primary" type="button" onclick="mostrarContrasena()">Mostrar Contraseña</button>
                        </div>
                            </div>
                        </div>
                        <input type="submit" value="Enviar"  class="btn btn-info">
                    </form>                         
                </div>
            </div>
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
