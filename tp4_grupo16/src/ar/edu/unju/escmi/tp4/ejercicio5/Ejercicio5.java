package ar.edu.unju.escmi.tp4.ejercicio5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class Ejercicio5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Producto> productos = new TreeMap<>();
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int opcion;

        do {
            System.out.println("--- MENU ---");
            System.out.println("1 - Alta de producto");
            System.out.println("2 - Mostrar productos");
            System.out.println("3 - Buscar un producto");
            System.out.println("4 - Eliminar un producto");
            System.out.println("5 - Salir");
            System.out.print("Ingrese una opcion: ");

            while (!sc.hasNextInt()) {
                System.out.println("Error, solo se admiten números enteros.");
                System.out.print("Ingrese una opcion nuevamente: ");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la clave del producto: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Error, la clave debe ser un número entero.");
                        System.out.print("Ingrese la clave nuevamente: ");
                        sc.next();
                    }
                    int claveAlta = sc.nextInt();
                    sc.nextLine();

                    if (productos.containsKey(claveAlta)) {
                        System.out.println("Error: Ya existe un producto registrado con esa clave.");
                    } else {
                        System.out.print("Ingrese descripción: ");
                        String descripcion = sc.nextLine();

                        System.out.print("Ingrese precio: ");
                        while (!sc.hasNextDouble()) {
                            System.out.println("Error, solo se admiten números decimales.");
                            System.out.print("Ingrese precio nuevamente: ");
                            sc.next();
                        }
                        double precio = sc.nextDouble();
                        sc.nextLine();

                        LocalDate fechaVencimiento = null;
                        boolean fechaValida = false;
                        while (!fechaValida) {
                            System.out.print("Ingrese fecha de vencimiento (dd/mm/aaaa): ");
                            String fechaStr = sc.nextLine();
                            try {
                                fechaVencimiento = LocalDate.parse(fechaStr, formateador);
                                fechaValida = true;
                            } catch (DateTimeParseException e) {
                                System.out.println("Formato de fecha inválido. Intente nuevamente.");
                            }
                        }

                        Producto nuevoProducto = new Producto(descripcion, precio, fechaVencimiento);
                        productos.put(claveAlta, nuevoProducto);
                        System.out.println("Producto registrado correctamente.");
                    }
                    break;

                case 2:
                    if (productos.isEmpty()) {
                        System.out.println("La lista de productos está vacía.");
                    } else {
                        Iterator<Integer> it = productos.keySet().iterator();
                        System.out.println("\n--- LISTADO DE PRODUCTOS (Orden Natural) ---");
                        while (it.hasNext()) {
                            Integer claveActual = it.next();
                            System.out.println("Clave: " + claveActual + " -> Valor: " + productos.get(claveActual));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingrese la clave del producto a buscar: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Error, la clave debe ser un número entero.");
                        System.out.print("Ingrese la clave nuevamente: ");
                        sc.next();
                    }
                    int claveBuscar = sc.nextInt();
                    sc.nextLine();

                    if (productos.containsKey(claveBuscar)) {
                        System.out.println("Producto encontrado:");
                        System.out.println("Clave: " + claveBuscar + " -> Valor: " + productos.get(claveBuscar));
                    } else {
                        System.out.println("No se encontró ningún producto con la clave ingresada.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese la clave del producto a eliminar: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Error, la clave debe ser un número entero.");
                        System.out.print("Ingrese la clave nuevamente: ");
                        sc.next();
                    }
                    int claveEliminar = sc.nextInt();
                    sc.nextLine();

                    if (productos.containsKey(claveEliminar)) {
                        productos.remove(claveEliminar);
                        System.out.println("Producto eliminado correctamente.");
                    } else {
                        System.out.println("No se puede eliminar: La clave ingresada no existe.");
                    }
                    break;

                case 5:
                    System.out.println("Fin del programa.");
                    break;

                default:
                    System.out.println("Esta opción no es correcta. Seleccione una opción del 1 al 5.");
            }
        } while (opcion != 5);

        sc.close();
    }
}
