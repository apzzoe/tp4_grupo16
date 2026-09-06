package ar.edu.unju.escmi.tp4.ejercicio2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);

        HashMap<String, Empleado> empleados = new HashMap<>();

        int opcion;
        
        do {
        	System.out.println("MENU");
            System.out.println("1 - Alta de empleado");
            System.out.println("2 - Mostrar empleados");
            System.out.println("3 - Eliminar empleado");
            System.out.println("4 - Consultar los datos de un empleado");
            System.out.println("5 - Salir");
            System.out.print("ingrese una opcion: ");

            opcion = teclado.nextInt();

            switch (opcion) {
            case 1:
            	System.out.print("ingrese dni: ");
                int dni = teclado.nextInt();
                System.out.print("ingrese nombre: ");
                String nombre = teclado.next();
                System.out.print("ingrese apellido: ");
                String apellido = teclado.next();
                System.out.print("ingrese sueldo: ");
                double sueldo = teclado.nextDouble();
                System.out.print("ingrese categoria: ");
                char categoria = teclado.next().charAt(0);
                
                Empleado empleado = new Empleado(dni, nombre, apellido, sueldo, categoria);
                String clave = dni + "" + categoria;
                empleados.put(clave, empleado);
                System.out.println("empleado registrado correctamente");
            	break;
            	
            case 2:
            	Iterator<String> it = empleados.keySet().iterator();

                while (it.hasNext()) {
                    String claveEmpleado = it.next();
                    System.out.println("clave: " + claveEmpleado);
                    System.out.println("valor: " + empleados.get(claveEmpleado));
                }
            	break;
            	
            case 3:
            	System.out.print("ingrese la clave del empleado a eliminar: ");
                String claveEliminar = teclado.next();

                if (empleados.containsKey(claveEliminar)) {
                    empleados.remove(claveEliminar);
                    System.out.println("empleado eliminado correctamente");
                }
                else {
                    System.out.println("no existe un empleado con esa clave");
                }
            	break;
            	
            case 4:
            	System.out.print("ingrese la clave del empleado: ");
                String claveBuscar = teclado.next();

                if (empleados.containsKey(claveBuscar)) {
                    Empleado empleadoBuscado = empleados.get(claveBuscar);
                    System.out.println("datos del empleado:");
                    System.out.println(empleadoBuscado);
                }
                else {
                    System.out.println("no existe un empleado con esa clave");
                }
            	break;
            	
            case 5:
            	System.out.println("programa finalizado");
            	break;
            	
            default:
            	System.out.println("opcion incorrecta");
            }
        } while (opcion != 5);
        
        teclado.close();
	}

}
