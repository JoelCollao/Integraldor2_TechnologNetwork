<%@page import="net.sf.jasperreports.engine.JasperRunManager" %> 
<%@page import="net.sf.jasperreports.*"  %>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"  %>
<%@page import="java.util.*" %> 
<%@page import="java.io.File" %> 
<%@page import="java.sql.*" %>
<%@page import="ModeloDAO.ClienteDAO"%>
<%@page import="Modelo.Cliente"%>
<%@page import="Configuracion.Conexion"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reportes de la Empresa Technology Networks</title>
    </head>
    <body>
 <% /*Parametros para realizar la conexión*/ 
 
Conexion conexion= new Conexion();
//Class.forName("com.mysql.jdbc.Driver");
//conexion = DriverManager.getConnection("jdbc:mysql://localhost/bd_venta","root","");
                       
/*Establecemos la ruta del reporte*/ 
File reportFile = new File(application.getRealPath("Reporte/reportStockProducto.jasper")); 

/* No enviamos parámetros porque nuestro reporte no los necesita asi que escriba 
cualquier cadena de texto ya que solo seguiremos el formato del método runReportToPdf*/
Map parameters = new HashMap();

/*Enviamos la ruta del reporte, los parámetros y la conexión(objeto Connection)*/ 
byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(),parameters,conexion.getConnection()); 

/*Indicamos que la respuesta va a ser en formato PDF*/ 
response.setContentType("application/pdf");
response.setContentLength(bytes.length); 

ServletOutputStream ouputStream = response.getOutputStream();
response.getOutputStream();
ouputStream.write(bytes, 0, bytes.length); /*Limpiamos y cerramos flujos de salida*/ 
ouputStream.flush(); 
ouputStream.close(); 
 %>
        
    </body>
</html>
