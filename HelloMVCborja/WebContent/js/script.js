console.log("Hola!");

document.getElementById('volverBtn').onclick=function(){
	window.history.back()
}

$('#enviarBtn').click(function(e){
	e.preventDefault();
	console.log("Validando!!");
});