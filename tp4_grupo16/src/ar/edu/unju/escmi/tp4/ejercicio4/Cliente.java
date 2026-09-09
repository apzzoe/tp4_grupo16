package ar.edu.unju.escmi.tp4.ejercicio4;

public class Cliente {
	private int dni;
	private String nombre;
	private String tipoCliente;
	
	public Cliente(int dni, String nombre, String tipoCliente) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.tipoCliente = tipoCliente;
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

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
	@Override
	public String toString() {
		return "Cliente [dni= " + dni + ", nombre= " + nombre + ", tipoCliente= " + tipoCliente + "]\n";
	}
	
	
}
