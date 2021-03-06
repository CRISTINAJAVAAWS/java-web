package com.jose.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jose.database.BBDD;
import com.jose.models.Room;
import com.jose.models.Usuario;

@WebServlet("/nuevousuario")
public class Nuevousuarioservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Room> habitaciones = BBDD.getinstancia().habitaciones;

		request.setAttribute("lashabitaciones", habitaciones);
		request.getRequestDispatcher("/nuevousuario.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombrerecibido = request.getParameter("nombre"); // El nombre del parametro se corresponde con el name
																// del input
		String emailrecibido = request.getParameter("email");
		String passwordrecibido = request.getParameter("password");
		String passwordrecibidoconfirmado = request.getParameter("confirmarpassword");
		String habitacionelegida = request.getParameter("habitacion");

		int habitacionelegidaId = 0;   // Para poder pasar la habitacionelegida como
										// par�metro en el m�todo gethabitacion en el ue
										// el parametro debe ser de tipo int
		try {
			habitacionelegidaId = Integer.parseInt(habitacionelegida);
		} catch (Exception e) { // e es una variable local de tipo Exception que contiene la excepcion

			System.out.println("Excepcion!!" + e.getMessage());

		}

		Usuario nuevouser = new Usuario(0, nombrerecibido, emailrecibido, passwordrecibido,
				BBDD.getinstancia().gethabitacion(habitacionelegidaId)); // apuntamos al metodo que hay en la base de
																			// datos que nos indica la habitacion por su
																			// identifcador, hay que transformar el
																			// par�metro en un int
		BBDD bd =BBDD.getinstancia();

		
		//boolean existeEmail = bd.existeEmail(emailrecibido); 
		
		if (nuevouser.esValido(passwordrecibidoconfirmado)&& !bd.existeEmail(emailrecibido)) { // Hemos creado u n metodo paracomprobar si el usuario es
																// valido// si es diferente de null y no es vacio //En
																// un if solo puedes poner booleanos,
			// por eso el programa sabe al crear el m�todo que es de tipo boolean

			// continuar e intrudcir nuevouser en base de datos

			BBDD db = BBDD.getinstancia();
			db.insertaUsuario(nuevouser);
			// redirijo a listadeusuarios
			response.sendRedirect("listausuarios"); // Va al navegador y de ahi hace la peticion al servlet
													// listadeusuarios (mirar esquema de slack)
		} else {
			request.setAttribute("mensajeerror", "Datos incorrectos");
			request.setAttribute("newusuario", nuevouser);
			this.doGet(request, response);
		}
	}

}
