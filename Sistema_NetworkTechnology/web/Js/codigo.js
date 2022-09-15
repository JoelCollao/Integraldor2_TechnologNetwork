function ver(n) {
	var x = document.getElementById("subseccion"+n);
	x.style.display="block";
	}
function ocultar(n) {
	var x = document.getElementById("subseccion"+n);
	x.style.display="none";
}
function historia(n){
	alert("Aqui una breve historia");
}
function mision(n){
	alert("Mision del negocio");
}
function vision(n){
	alert("Vision del negocio");
}
function login(){
	//window.open("");Aquí direccionar al formulario login.php
	alert("No exite aún formulario de ingreso");
	}

function modalAdmin(admcod,admnom,admapepat,admapemat,admfecing,admpassw){
    document.getElementById("txtCod_Admi").value=admcod;
    document.getElementById("txtNom_Admi").value=admnom;
    document.getElementById("txtApe_Pat_Admi").value=admapepat;
    document.getElementById("txtApe_Mat_Admi").value=admapemat;
    document.getElementById("txtFechaIngreso").value=admfecing;
    document.getElementById("txtpass").value=admpassw;
}

function modalProducto(procod,prodesc,proprecunit,prostock,procateg){
    document.getElementById("txtCod_Prod").value=procod;
    document.getElementById("txtDesc_Prod").value=prodesc;
    document.getElementById("txtPrecio_Prod").value=proprecunit;
    document.getElementById("txtCant_Prod").value=prostock;
    document.getElementById("Cat_Prod").value=procateg;
}

function foto(n) {
	var cat="CAT00"+n;
	var ruta="";
	var i;
	if (n<10) {
	for (i = 1; i < 10; i++) {
		ruta="imagenes/"+cat+"/P00"+n+"00"+i+".jpg";
		document.images["img"+i].src=ruta;
		}
	if (i>=10) {
		ruta="imagenes/"+cat+"/P00"+n+"0"+i+".jpg";
		document.images["img"+i].src=ruta;
	}
	}
	if (n>=10 && n<100) {
		cat="CAT0"+n;
	for (i = 1; i < 10; i++) {
		ruta="imagenes/"+cat+"/P0"+n+"00"+i+".jpg";
		document.images["img"+i].src=ruta;
		}
	if (i>=10 && n<100) {
		ruta="imagenes/"+cat+"/P0"+n+"0"+i+".jpg";
		document.images["img"+i].src=ruta;
	}
	}
}
