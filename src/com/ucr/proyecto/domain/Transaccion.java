package com.ucr.proyecto.domain;

import java.io.Serializable;

public class Transaccion implements Serializable {

    private Empleado empleado;
    private double cantidad;
    private String funcion;
    private Empleado empleadoDestino;
    private String detalle;
    private String fecha;

    public Transaccion(Empleado empleado, double cantidad, String funcion, Empleado empleadoDestino, String detalle) {
        this.empleado = empleado;
        this.cantidad = cantidad;
        this.funcion = funcion;
        this.empleadoDestino = empleadoDestino;
        this.detalle = detalle;
    }

    public Transaccion(Empleado empleado, double cantidad, String funcion, Empleado empleadoDestino, String detalle, String fecha) {
        this.empleado = empleado;
        this.cantidad = cantidad;
        this.funcion = funcion;
        this.empleadoDestino = empleadoDestino;
        this.detalle = detalle;
        this.fecha = fecha;
    }

    public Transaccion(Empleado empleado, double cantidad, String funcion, String detalle) {
        this.empleado = empleado;
        this.cantidad = cantidad;
        this.funcion = funcion;
        this.detalle = detalle;
    }

    public Transaccion(Empleado empleado, String funcion) {
        this.empleado = empleado;
        this.funcion = funcion;
    }

    //*****setter & getter
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public Empleado getEmpleadoDestino() {
        return empleadoDestino;
    }

    public void setEmpleadoDestino(Empleado empleadoDestino) {
        this.empleadoDestino = empleadoDestino;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Transaccion{" + "empleado=" + empleado + ", cantidad=" + cantidad + ", funcion=" + funcion + ", empleadoDestino=" + empleadoDestino + ", detalle=" + detalle + ", fecha=" + fecha + '}';
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
