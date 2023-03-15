package com.proyectoLiquidacion.ProyectoLiquidacion.models;

import javax.persistence.*;

@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpleado;


    private String nombreEmpleado;
    private String apellidoEmpleado;
    private int sueldoEmpleado;

    private int diasLaborados;


    //constructor vacio
    public Empleado() {
    }

    public Empleado(int idEmpleado, String nombreEmpleado, String apellidoEmpleado, int sueldoEmpleado, int diasLaborados) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
        this.sueldoEmpleado = sueldoEmpleado;
        this.diasLaborados = diasLaborados;
    }

    //se añaden los getter y setter//


    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public int getSueldoEmpleado() {
        return sueldoEmpleado;
    }

    public void setSueldoEmpleado(int sueldoEmpleado) {
        this.sueldoEmpleado = sueldoEmpleado;
    }

    public int getDiasLaborados() {
        return diasLaborados;
    }

    public void setDiasLaborados(int diasLaborados) {
        this.diasLaborados = diasLaborados;
    }
}
