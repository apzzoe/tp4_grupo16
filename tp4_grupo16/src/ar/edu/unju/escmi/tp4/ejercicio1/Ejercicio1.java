package ar.edu.unju.escmi.tp4.ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
       List<Jugador> jugadores = new ArrayList<>();
       
       Scanner sc = new Scanner(System.in); 
        int opcion;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Alta de jugador");
            System.out.println("2 - Modificar los datos de un jugador");
            System.out.println("3 - Eliminar un jugador");
            System.out.println("4 - Mostrar todos los jugadores");
            System.out.println("5 - Mostrar la cantidad de jugadores en la lista");
            System.out.println("6 - Limpiar toda la lista de jugadores");
            System.out.println("7 - Salir");
            System.out.print("Ingrese una opcion: ");
            
            while (!sc.hasNextInt()) {
                System.out.println("Error, solo se admiten números .");
                System.out.print("Ingrese una opcion nuevamente: ");
                sc.next();
            }
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    Jugador nuevo = new Jugador();
                   
                    System.out.print("Ingrese DNI: ");
                    while (!sc.hasNextInt()) {
                        System.out.println(" Solo se admiten números enteros.");
                        System.out.print("Ingrese DNI nuevamente: ");
                        sc.next();
                    }
                    nuevo.setDni(sc.nextInt());
                  
                    System.out.print("Ingrese nombre: ");
                    nuevo.setNombre(sc.next());
                   
                    System.out.print("Ingrese equipo: ");
                    nuevo.setEquipo(sc.next());
                 
                    System.out.print("Ingrese nacionalidad: ");
                    nuevo.setNacionalidad(sc.next());
                  
                    System.out.print("Ingrese estatura: ");
                    while (!sc.hasNextDouble()) {
                        System.out.println("Error,solo  números decimales");
                        System.out.print("Ingrese estatura nuevamente: ");
                        sc.next();
                    }
                    nuevo.setEstatura(sc.nextDouble());

                    jugadores.add(nuevo);
                    break;

                case 2:
                    System.out.print("Ingrese el DNI del jugador a modificar: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Error,solo números.");
                        System.out.print("Ingrese el DNI del jugador a modificar nuevamente: ");
                        sc.next();
                    }
                    int dniModificar = sc.nextInt();
                    boolean encontradoMod = false;

                    for (Jugador j : jugadores) {
                        if (j.getDni() == dniModificar) {
                            encontradoMod = true;
                            System.out.println("Jugador encontrado:");
                            j.mostrarDatos();
                            System.out.print("Ingrese nuevo nombre: ");
                            j.setNombre(sc.next());
                            System.out.print("Ingrese nuevo equipo: ");
                            j.setEquipo(sc.next());
                            System.out.print("Ingrese nueva nacionalidad: ");
                            j.setNacionalidad(sc.next());
                            System.out.print("Ingrese nueva estatura: ");
                            while (!sc.hasNextDouble()) {
                                System.out.println(" Solo se admiten números decimales");
                                System.out.print("Ingrese nueva estatura nuevamente: ");
                                sc.next();
                            }
                            j.setEstatura(sc.nextDouble());
                            System.out.println("Jugador modificado correctamente.");
                            break;
                        }
                    }

                    if (!encontradoMod) {
                        System.out.println("No se encuentra el jugador con el DNI ingresado.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el DNI del jugador a eliminar: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Error: Solo se admiten números enteros.");
                        System.out.print("Ingrese el DNI del jugador a eliminar nuevamente: ");
                        sc.next();
                    }
                    int dniEliminar = sc.nextInt();
                   Jugador jugadorEliminado = null;
                   for (Jugador j: jugadores) {
                	   if (j.getDni() == dniEliminar) {
                		   jugadorEliminado=j;
                		   break;
                		   
                	   }
                   }
                   if (jugadorEliminado != null) {
                	   jugadores.remove(jugadorEliminado);
                   }else {
                	   System.out.println("El dni nose encontró");
                   }
                    break;

                case 4:
                    if (jugadores.isEmpty()) {
                        System.out.println("La lista está vacía");
                    } else {
                        for (Jugador j : jugadores) {
                            j.mostrarDatos();
                        }
                    }
                    break;

                case 5:
                    
                    System.out.println("La cantidad de jugadores en lista es: " + jugadores.size());
                    break;

                case 6:
                    jugadores.clear();
                    System.out.println("La lista ha sido limpiada correctamente.");
                    break;

                case 7:
                    System.out.println("Fin del program.");
                    break;

                default:
                    System.out.println("esta opción no es correcta .");
            }
        } while (opcion != 7);

        sc.close();
    }
}