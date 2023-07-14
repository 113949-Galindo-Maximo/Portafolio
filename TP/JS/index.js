$(document).ready(function () {
    $("#form").validate({
        rules: {
            nombre: {
                required: true             
            },
            email: { required: true, email: true },
            telefono: { required: true, digits: true },
            mensaje:{required:true, maxlength:200}

        },
        messages: {
            nombre:{ required:"Por favor, ingrese su nombre"},               
            email: { required: "Se requiere mail", email: "Formato no valido" },
            telefono: { required: "Se requiere numero de telefono", digits: "Formato no valido" },
            mensaje: { required: "Se requiere que escriba un mensaje", maxlength: "No se pueden escribir mas de 200 caracteres" }
        },
        errorClass: "text-danger pt-1 is-invalid"      
    });


});


$("#btnEnviar").click(function () {
    if ($("#form").valid()) {
        Swal.fire({
            icon: 'success',
            title: 'Formulario enviado con éxito',
            text: 'Gracias por comunicarte conmigo',
            confirmButtonText: 'OK'
        })
        form.reset();
        
    }
});