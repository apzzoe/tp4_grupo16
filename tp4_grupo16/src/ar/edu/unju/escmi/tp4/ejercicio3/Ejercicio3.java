package ar.edu.unju.escmi.tp4.ejercicio3;

import java.util.TreeSet;
import java.util.Iterator;
import java.util.Scanner;
public class Ejercicio3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcion;
		TreeSet<Paciente> pacientes = new TreeSet<>();
		
		do {
		System.out.println(
				"---------------------\n"
				+ "****** MENU ******\n"
				+ "1- Alta de paciente\n"
				+ "2- Mostrar todos los pacientes\n"
				+ "3- Mostrar el paciente que se encuentra en la mitad de la lista\n"
				+ "4– Mostrar el primer paciente de la lista\n"
				+ "5– Mostrar el ultimo paciente de la lista\n"
				+ "6- Filtrar por historia clinica\n "
				+ "7- Salir\n "
				+"-----------------------------------------------------------\n"
				+"Ingrese su opción: ");
		
		opcion=sc.nextInt();
		
		switch(opcion){
		case 1: 
				
				System.out.println("Ingrese dni del paciente: ");
				int dni = sc.nextInt();
				System.out.println("Ingrese nombre del paciente: ");
				String nombre = sc.next();
				System.out.println("Ingrese el apellido del paciente: ");
				String apellido = sc.next();
				System.out.println("Ingrese numero de la historia clinica del paciente: ");
				int numHistoriaClinica = sc.nextInt();
				System.out.println("Ingrese obra social del paciente: ");
				String obrasocial = sc.next();
				
				
				Paciente paciente = new Paciente(dni,nombre,apellido,numHistoriaClinica,obrasocial);
				pacientes.add(paciente);
				
			break;
			
		case 2:
			if(!pacientes.isEmpty()) {
				pacientes.stream().forEach(System.out::println);
			}
			else {
				System.out.println("Debe registrar un paciente");
			}
			break;
			
			
		case 3:
			
			if(!pacientes.isEmpty()) {
				int posicionMedio = pacientes.size() / 2;
 
				Iterator<Paciente> it = pacientes.iterator();
				Paciente pacienteMedio = null;
 
				for (int i = 0; i <= posicionMedio; i++) {
					pacienteMedio = it.next();
				}
 
				System.out.println("El paciente que se encuentra en la mitad de la lista es: ");
				System.out.println(pacienteMedio);
			}
			else {
				System.out.println("Debe registrar un paciente");
			}
 
			break;
			
			
		case 4: 
			if(!pacientes.isEmpty()) {
				System.out.println("El primer paciente de la lista es: ");
				System.out.println(pacientes.first());
			}
			else {
				System.out.println("Debe registrar un paciente");
			}
		break;
		
		case 5: 
			if(!pacientes.isEmpty()) {
				System.out.println("El último paciente de la lista es: ");
				System.out.println(pacientes.last());
			}
			else {
				System.out.println("Debe registrar un paciente");
			}
 
		break;
		case 6:
		if(!pacientes.isEmpty()) {
			System.out.println("Ingrese número de historia clínica: ");
			int nroHC = sc.nextInt();

			System.out.println("Pacientes con historia clínica superior a " + nroHC + ": ");
			pacientes.stream()
					.filter(p -> p.getHistoriaClinica() > nroHC)
					.forEach(System.out::println);
		}
		else {
			System.out.println("Debe registrar un paciente");
		}
	break;
		
		case 7: 
			System.out.println("Saliendo...");
			break;
			
		default: 
			System.out.println("Ingrese una opción válida.");
			break;
		}
		
		} while(opcion !=7);
		
		sc.close();

	}

}
