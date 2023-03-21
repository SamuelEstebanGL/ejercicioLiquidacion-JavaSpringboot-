package com.proyectoLiquidacion.ProyectoLiquidacion.dto;

import com.proyectoLiquidacion.ProyectoLiquidacion.models.Liquidacion;

import java.io.Serializable;

public class LiquidacionDTO implements Serializable {
    private int idLiquidacion;

    private int totalLiquidacion;
    private int prima;
    private int cesantia;
    private double interesCesantia;
    private int vaciones;

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
}
