package com.proyectoLiquidacion.ProyectoLiquidacion.models;

import javax.persistence.*;


@Entity
@Table(name = "liquidacion")
public class Liquidacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int totalLiquidacion;

    private int prima;
    private int cesantia;
    private double interesCesantia;
    private int vaciones;


    //getter y setter//

    public int getTotal() {
        return totalLiquidacion;
    }

    public void setTotal(int total) {
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

}


