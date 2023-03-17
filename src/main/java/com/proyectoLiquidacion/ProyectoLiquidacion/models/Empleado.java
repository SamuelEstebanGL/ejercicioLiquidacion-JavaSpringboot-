package com.proyectoLiquidacion.ProyectoLiquidacion.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;

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

    //le añadi esta  relacion de uno a uno con la liquidacion para asi poder guardar el empleado con su liquidacion
    @JsonIgnore //esta etiqueta me sirvio ya que tenia un error con la relacion, la cargue con diferentes foreign key ambas y se me dañaba o se desconectaba el proceso y me sirvio para que siga el proceso
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_liquidacion")
    private Liquidacion liquidacion;

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

    public Liquidacion getLiquidacion() {
        return liquidacion;
    }

    public void setLiquidacion(Liquidacion liquidacion) {
        this.liquidacion = liquidacion;
    }
}
