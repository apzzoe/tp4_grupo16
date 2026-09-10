package ar.edu.unju.escmi.tp4.ejercicio3;

public class Paciente implements Comparable<Paciente>{
	private int dni;
	private String nombre;
	private String apellido;
	private int HistoriaClinica;
	private String ObraSocial;
	
	
	public Paciente() {
		super();
	}
	
	public Paciente(int dni, String nombre, String apellido, int historiaClinica, String obraSocial) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		HistoriaClinica = historiaClinica;
		ObraSocial = obraSocial;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getHistoriaClinica() {
		return HistoriaClinica;
	}

	public void setHistoriaClinica(int historiaClinica) {
		HistoriaClinica = historiaClinica;
	}

	public String getObraSocial() {
		return ObraSocial;
	}

	public void setObraSocial(String obraSocial) {
		ObraSocial = obraSocial;
	}
	
	
	@Override
	public int compareTo(Paciente otroPaciente) {
		return Integer.compare(this.HistoriaClinica, otroPaciente.HistoriaClinica);
	}
 
	@Override
	public String toString() {
		return "Paciente [DNI=" + dni +
				", Nombre=" + nombre +
				", Apellido=" + apellido +
				", N° Historia Clinica=" + HistoriaClinica +
				", Obra Social=" + ObraSocial + "]";
	}
 

}

	

