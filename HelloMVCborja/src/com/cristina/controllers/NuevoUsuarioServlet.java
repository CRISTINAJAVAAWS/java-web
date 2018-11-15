package com.cristina.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.borja.database.BBDD;
import com.borja.models.Usuario;


@WebServlet("/nuevousuario")
public class NuevoUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/nuevousuario.jsp").forward(request, response);
		System.out.println();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Habitacion> habitaciones = BBDD.getInstance().habitaciones;
		request.setAttribute("lasHabitaciones", habitaciones);
		request.getRequestDispatcher("/nuevousuario.jsp").forward(request, response);
		
		
		String nombrerecib = request.getParameter("nombre");
		String emailrecib = request.getParameter("email");
		String passrecib = request.getParameter("password");
		String passconfrecib = request.getParameter("passwordconfirmation");
		
		Usuario nuevoUser = new Usuario(0, nombrerecib, emailrecib, passrecib, null);
		
		System.out.println("email: "+emailrecib);
		
		if(nuevoUser.esValido(passconfrecib) ) {
			//CONTINUAR E INTRODUCir USUARIO EN bbdd
			BBDD db = BBDD.getInstance();
			db.insertaUsuario(nuevoUser);
			
			
			//redirijo a lista de usuarios.
			response.sendRedirect("listausuarios");
			
		}else {
			request.setAttribute("mensajeerror","Datos Incorrectos");
			request.setAttribute("newusuario",nuevoUser);
			this.doGet(request, response); 
		}
	}
}
			
		//if(emailrecib!=null && !emailrecib.equals("") && emailrecib.indexOf("@")>0 ) {
			//continuar e introducir el usuario en BBDD
		
		
		//System.out.println("nombre: "+nombrerecib);
		//System.out.println("email: "+emailrecib);
		//System.out.println("password: "+passrecib);
		//System.out.println("passwordconfirmation: "+passconfrecib);
	


