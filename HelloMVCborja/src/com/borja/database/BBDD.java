package com.borja.database;

import java.util.ArrayList;

import com.borja.models.Habitacion;
import com.borja.models.Usuario;

public class BBDD {
	
	private static BBDD instance=null;
			//singleton empieza
	
	public ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	public ArrayList<Habitacion> Habitaciones = new ArrayList<Habitacion>();

	public static final BBDD getInstance() {
		if(instance==null) instance=new BBDD();
		
	
		
		return instance;
	}
	private BBDD() {
		//finaliza singleton
		this.fillUsuarios();
		this.fillHabitaciones();
		this.relacionaruserhab();
	}

	private boolean fillUsuarios() {

		usuarios.add(new Usuario(1, "luisa", "prp@gmail.com", "ppp", null));
		usuarios.add(new Usuario(2, "petra", "amaia@gmail.com","aaa", null));
		usuarios.add(new Usuario(3, "pedro", "ricardorsdp@gmail.com","rrr", null));

		return true;
	}

	private boolean fillHabitaciones() {
		Habitaciones.add(new Habitacion(3456, "cantarranas n3", 34));
		Habitaciones.add(new Habitacion(43432, "calle real n45", 200));
		Habitaciones.add(new Habitacion(1234, "cañada real n 9", 156));

		return true;
	}

	private boolean relacionaruserhab() {
		usuarios.get(0).setHabitacion(Habitaciones.get(2));
		usuarios.get(1).setHabitacion(Habitaciones.get(1));
		usuarios.get(2).setHabitacion(Habitaciones.get(0));

		return true;
		/*
		 * metodo que en funcion del id me devuelve un objeto usuario concreto si no
		 * existe devuelve null
		 */
	}

	public Usuario getUsuarioById(int id) {
		Usuario usuarioADevolver = null;
		// iteramos por cada usuario y comparamos su id con el que nos indica

		for (Usuario unUsuario : usuarios) {
			if (unUsuario.getId() == id) {
				usuarioADevolver = unUsuario;
				break;
			}

		}

		return usuarioADevolver;
	}

	public Habitacion dameHabitacionPorHid(int hid) {
		Habitacion habitacionADevolver = null;
		// iteramos por cada usuario y comparamos su id con el que nos indica.

		for (Habitacion unaHabitacion : Habitaciones) {

			if (unaHabitacion.getHid() == hid) {

				habitacionADevolver = unaHabitacion;
				break;
			}

		}

		return habitacionADevolver;
	}

	public boolean existeUsuarioPorEmailYPass(String emailrecib, String passrecib) {
		boolean existeUsuario = false;

		for (Usuario unUsuario : this.usuarios) {
			if (unUsuario.getEmail().equals(emailrecib) && unUsuario.getPass().equals(passrecib)) {
				existeUsuario = true;
				break;
			}

		}

		return existeUsuario;		
	}

	public int insertaUsuario(Usuario newUser) {
	int nuevoId=0;
	
	nuevoId=this.usuarios.size()+1;//simulamos que la base de datos se asigna id consecutivo siempre +1.
	newUser.setId(nuevoId);
	
	this.usuarios.add(newUser);
	
	return nuevoId;
	
	
		
	}
	public int insertaHabitacion(Habitacion nuevahabitacion) {
		int nuevoHid=0;
		
		nuevoHid=this.Habitaciones.size()+1;
		
		nuevahabitacion.setHid(nuevoHid);
		
		this.Habitaciones.add(nuevahabitacion);
		
		return nuevoHid;
		
	}

	
}





