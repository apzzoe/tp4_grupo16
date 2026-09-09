package ar.edu.unju.escmi.tp4.ejercicio5;

import java.time.LocalDate;

public class Producto {
    private String descripcion;
    private double precio;
    private LocalDate fechaVencimiento;

    public Producto(String descripcion, double precio, LocalDate fechaVencimiento) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    @Override
    public String toString() {
        return "Producto [Descripción: " + descripcion + ", Precio: $" + precio + ", Vencimiento: " + fechaVencimiento + "]";
    }
}
