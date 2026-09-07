package ar.edu.unju.escmi.tp4.ejercicio1;

public class Jugador {
	private int dni;
	private String nombre;
	private String equipo;
	private String nacionalidad;
	private double estatura;
	
	
	public Jugador(){
		this.dni=0;
		this.nombre="";
		this.equipo="";
		this.nacionalidad="";
		this.estatura=0;
		
	}


	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEquipo() {
		return equipo;
	}


	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}


	public String getNacionalidad() {
		return nacionalidad;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	public double getEstatura() {
		return estatura;
	}


	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}
	
	
	public void mostrarDatos() {
		    System.out.println("DNI: " + dni);
	        System.out.println("Nombre: " + nombre);
	        System.out.println("Equipo: " + equipo);
	        System.out.println("Nacionalidad: " + nacionalidad);
	        System.out.println("Estatura: " + estatura);
	}
}

