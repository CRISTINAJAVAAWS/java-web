package com.borja.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.borja.database.BBDD;
import com.borja.models.Habitacion;
import com.borja.models.Usuario;

@WebServlet("/nuevahabitacion")
public class NuevaHabitacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/nuevahabitacion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String callerecib = request.getParameter("calle");
		String metrosrecib = request.getParameter("metros");

		int metrosrecInt = 0;

		try {
			metrosrecInt = Integer.parseInt(metrosrecib);
		} catch (Exception e) {
			System.out.println("Excepción!!!!!!!!: " + e.getMessage());
		}

		// int metrosrecInt = Integer.parseInt(metrosrecib);

		System.out.println("habitacion:" + callerecib + ":" + metrosrecib);

		double metrosrecibInt;
		Habitacion nuevahabitacion = new Habitacion(0, callerecib, metrosrecInt);

		if (nuevahabitacion.esValid()) {
			// CONTINUAR E INTRODUCir hab EN bbdd
			BBDD db = BBDD.getInstance();
			db.insertaHabitacion(nuevahabitacion);

			// redirijo a lista de usuarios.
			response.sendRedirect("nuevousuarios");

		} else {
			request.setAttribute("mensajeerror", "Datos Incorrectos");
			request.setAttribute("nuevahabitacion", nuevahabitacion);
			this.doGet(request, response);
		}
	}

}
