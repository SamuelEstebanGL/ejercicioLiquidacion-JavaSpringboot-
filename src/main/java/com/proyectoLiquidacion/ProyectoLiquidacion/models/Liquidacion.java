package com.proyectoLiquidacion.ProyectoLiquidacion.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name = "liquidacion")
public class Liquidacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLiquidacion;

    private int totalLiquidacion;
    private int prima;
    private int cesantia;
    private double interesCesantia;
    private int vaciones;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    //getter y setter//

    public int getIdLiquidacion() {
        return idLiquidacion;
    }

    public void setIdLiquidacion(int idLiquidacion) {
        this.idLiquidacion = idLiquidacion;
    }

    public int getTotalLiquidacion() {
        return totalLiquidacion;
    }

    public void setTotalLiquidacion(int totalLiquidacion) {
        this.totalLiquidacion = totalLiquidacion;
    }

    public int getPrima() {
        return prima;
    }

    public void setPrima(int prima) {
        this.prima = prima;
    }

    public int getCesantia() {
        return cesantia;
    }

    public void setCesantia(int cesantia) {
        this.cesantia = cesantia;
    }

    public double getInteresCesantia() {
        return interesCesantia;
    }

    public void setInteresCesantia(double interesCesantia) {
        this.interesCesantia = interesCesantia;
    }

    public int getVaciones() {
        return vaciones;
    }

    public void setVaciones(int vaciones) {
        this.vaciones = vaciones;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}


