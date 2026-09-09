package ar.edu.unju.escmi.tp4.ejercicio4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int opcion;
		Set<Cliente> clientes = new HashSet<>();
		
		do {
		System.out.println(
				"---------------------\n"
				+ "****** MENU ******\n"
				+ "1- Crear cliente\n"
				+ "2- Mostrar los datos de un cliente.\n"
				+ "3- Mostrar todos los clientes.\n"
				+ "4– Mostrar todos los clientes ocasionales y la cantidad.\n"
				+ "5– Mostrar todos los clientes frecuentes y la cantidad.\n"
				+ "6- Salir\n "
				+"-----------------------------------------------------------\n"
				+"Ingrese su opción: ");
		
		opcion=sc.nextInt();
		
		switch(opcion){
		case 1: 
				
				System.out.println("Ingrese dni del cliente: ");
				int dni = sc.nextInt();
				System.out.println("Ingrese nombre del cliente: ");
				String nombre = sc.next();
				String tipoCliente;
				do {
					System.out.println("Ingrese tipo de cliente (ocasional o frecuente): ");
					tipoCliente = sc.next();
					if (!tipoCliente.equals("ocasional") && !tipoCliente.equals("frecuente")) {
						System.out.println("Ingrese un tipo de cliente válido.");
					}
				}while(!tipoCliente.equals("ocasional") && !tipoCliente.equals("frecuente"));
				
				Cliente cliente = new Cliente(dni,nombre,tipoCliente);
				clientes.add(cliente);
				
			break;
			
		case 2:
			if(!clientes.isEmpty()) {
				System.out.println("Ingrese el dni del cliente a buscar: ");
				int dniBuscado = sc.nextInt();
				boolean encontrado = false;
				
				Iterator<Cliente> it = clientes.iterator();
			    while (it.hasNext()) {
			        Cliente clienteBuscado = it.next();
			        if (clienteBuscado.getDni() == dniBuscado) {
			            System.out.println(clienteBuscado);
			            encontrado = true;
			        }
			    }
			    if(!encontrado) {
			    	System.out.println("No se encontró el dni.");
			    }
			    encontrado = false;
			}
			else {
				System.out.println("Debe crear por lo menos un cliente.");
			}
			break;
			
		case 3:
			if(!clientes.isEmpty()) {
				clientes.stream().forEach(System.out::println);
			}
			else {
				System.out.println("Debe crear por lo menos un cliente.");
			}
			break;
			
		case 4: 
			if(!clientes.isEmpty()) {
				long cantOcasionales = clientes.stream().filter(c -> c.getTipoCliente().equals("ocasional")).count();

			    if (cantOcasionales > 0) {
			        clientes.stream().filter(c -> c.getTipoCliente().equals("ocasional")).forEach(System.out::println);
			    	System.out.println("cantidad de clientes ocasionales: " + cantOcasionales);
			    } else {
			        System.out.println("No hay clientes ocasionales.");
			    }
			}
			else {
				System.out.println("Debe crear por lo menos un cliente.");
			}
			break;
	
		case 5: 
			if(!clientes.isEmpty()) {
				long cantFrecuentes = clientes.stream().filter(c -> c.getTipoCliente().equals("frecuente")).count();

			    if (cantFrecuentes > 0) {
			        clientes.stream().filter(c -> c.getTipoCliente().equals("frecuente")).forEach(System.out::println);
			        System.out.println("cantidad de clientes frecuentes: " + cantFrecuentes);
			    } else {
			        System.out.println("No hay clientes frecuentes.");
			    }
			}
			else {
				System.out.println("Debe crear por lo menos un cliente.");
			}
			break;
			
		case 6: 
			System.out.println("Saliendo...");
			break;
			
		default: 
			System.out.println("Ingrese una opción válida.");
			break;
		}
		
		} while(opcion !=6);
		
		sc.close();
	}

}
