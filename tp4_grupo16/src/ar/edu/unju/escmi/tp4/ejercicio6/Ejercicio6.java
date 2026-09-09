package ar.edu.unju.escmi.tp4.ejercicio6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);

        ArrayList<Libro> libros = new ArrayList<>();

        int opcion;
        
        do {
        	System.out.println("MENU");
            System.out.println("1 - Alta de Libro");
            System.out.println("2 - Mostrar libros");
            System.out.println("3 - Buscar y mostrar un libro");
            System.out.println("4 - Ordenar libros");
            System.out.println("5 - Modificar datos de un libro");
            System.out.println("6 - Eliminar un libro");
            System.out.println("7 - Salir");
            System.out.print("ingrese una opcion: ");

            opcion = teclado.nextInt();
            
            switch(opcion) {
            case 1:
            	Libro libro = new Libro();
                System.out.print("ingrese ISBN: ");
                libro.setIsbn(teclado.next());
                System.out.print("ingrese titulo: ");
                libro.setTitulo(teclado.next());
                System.out.print("ingrese cantidad de paginas: ");
                libro.setCantidadPaginas(teclado.nextInt());
                System.out.print("ingrese autor: ");
                libro.setAutor(teclado.next());
                libros.add(libro);
                System.out.println("libro agregado correctamente");
                break;
                
            case 2:
            	for (Libro libroMostrar : libros) {
                    libroMostrar.mostrarDatos();
                }
            	break;
            	
            case 3:
            	System.out.print("ingrese el ISBN del libro: ");
                String isbnBuscar = teclado.next();
                boolean encontrado = false;
                for (Libro libroBuscar : libros) {
                    if (libroBuscar.getIsbn().equals(isbnBuscar)) {
                        libroBuscar.mostrarDatos();
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.out.println("libro no encontrado");
                }
                break;
                
            case 4:
            	Collections.sort(libros);
                System.out.println("Libros ordenados por titulo");
                break;
                
            case 5:
            	System.out.print("ingrese el ISBN del libro a modificar: ");
                String isbnModificar = teclado.next();
                boolean encontradoModificar = false;
                for (Libro libroModificar : libros) {
                    if (libroModificar.getIsbn().equals(isbnModificar)) {
                        libroModificar.mostrarDatos();
                        System.out.print("ingrese nuevo titulo: ");
                        libroModificar.setTitulo(teclado.next());
                        System.out.print("ingrese nueva cantidad de paginas: ");
                        libroModificar.setCantidadPaginas(teclado.nextInt());
                        System.out.print("ingrese nuevo autor: ");
                        libroModificar.setAutor(teclado.next());
                        encontradoModificar = true;
                        System.out.println("libro modificado correctamente");
                    }
                }
                if (!encontradoModificar) {
                    System.out.println("libro no encontrado");
                }
                break;
                
            case 6:
            	System.out.print("ingrese el ISBN del libro a eliminar: ");
                String isbnEliminar = teclado.next();
                Iterator<Libro> it = libros.iterator();
                boolean eliminado = false;
                while (it.hasNext()) {
                    Libro libroEliminar = it.next();
                    if (libroEliminar.getIsbn().equals(isbnEliminar)) {
                        it.remove();
                        eliminado = true;
                        System.out.println("libro eliminado correctamente");
                    }
                }
                if (!eliminado) {
                    System.out.println("libro no encontrado");
                }
                break;
                
            case 7:
            	System.out.println("programa finalizado");
                break;
                
            default:
                System.out.println("opcion incorrecta");
            }
        } while (opcion != 7);
        teclado.close();
	}
}
