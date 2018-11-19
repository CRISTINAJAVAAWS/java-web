document.getElementById('validform').onclick=(function(){
	
	evnt.preventDefault();   
    document.querySelectorAll('.error').forEach(elem => {
        elem.classList.add('hide');
    });

    let validarform = document.getElementById('registerform').checkValidity();
    
    if (validarform) {
        // enviar
        $.ajax({
            method: "POST",
            url: "http://www.mocky.io/v2/5bd973492f0000810006d12d", // true
        
            data: {
                nombreyapellidos: document.getElementById('nombre').value,
                email: document.getElementById('email').value,
                password: document.getElementById('password').value,
                confirmarpassword: document.getElementById('confirmarpassword').value
            }
        }).done(function (data) {
            console.log(data);
            if (data.result) {
                window.location.href = 'listausuarios';
            } else {
                document.getElementById('errormensaje').classList.remove('hide'); // mensaje
																					// de
																					// error
            }
        });

    } else {

        if (!document.getElementById('nombre').checkValidity()) {
            document.getElementById('errornombre').classList.remove('hide');
        }
        if (!document.getElementById('email').checkValidity()) {
            document.getElementById('erroremail').classList.remove('hide');
        }
        if (!document.getElementById('password').checkValidity()) {
            document.getElementById('errorpassword').classList.remove('hide');
        }
        if (!document.getElementById('confirmarpassword').checkValidity()) {
            document.getElementById('errorconfirmar').classList.remove('hide');
        }
    }
});
	


