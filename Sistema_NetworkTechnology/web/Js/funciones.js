$(document).ready(function(){
    $("tr #btnDelete").click(function(){
       var idp=$(this).parent().find("#idp").val();
       eliminar(idp);
    });
    function eliminar(idp){
        var url="Control?accion=Delete";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idp="+idp,
            success: function (data,textStatus,jqXHR){
                alert("Registro Eliminado");
            }
        });
    }
});



