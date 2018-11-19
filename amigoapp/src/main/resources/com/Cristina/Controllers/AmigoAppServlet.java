package com.Cristina.Controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.borja.database.BBDD;
import com.borja.models.Habitacion;
import com.borja.models.Usuario;

@WebServlet("/amigo")

public class amigoapp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public amigoapp() {
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	String amigo=request.getParameter("amigo");
	
    request.setAttribute("amigo", amigo);
    
	request.getRequestDispatcher("./addamigo.jsp").forward(request,response);
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String emailrec = request.getParameter("email");
		String nombrerec = request.getParameter("nombre");
		String passrec = request.getParameter("pass");
		String confpassrec = request.getParameter("reppass");
		String datosrecId = 
		try {
			datosrecId = Integer.parseInt(habitacionrec);
		} catch (Exception e) {
			System.out.println("Data!!!!!: " + e.getMessage());
		}
		

		Usuario nuevoUser = new Usuario(
				0,
				nombrerec,
				emailrec,
				passrec,
				BBDD.getInstance().d
			);

		if (nuevoUser.esValido(confpassrec) && !db.existeEmail(emailrec)) {
			// continuar e introducir el usuario en BBDD
			
			db.insertaUsuario(nuevoUser);


		} else {
			request.setAttribute("mensajeerror", "Datos incorrectos");
			request.setAttribute("newusuario", nuevoUser);
			this.doGet(request, response);
		}

	}

}

