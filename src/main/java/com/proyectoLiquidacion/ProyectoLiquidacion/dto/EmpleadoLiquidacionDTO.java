package com.proyectoLiquidacion.ProyectoLiquidacion.dto;

import com.proyectoLiquidacion.ProyectoLiquidacion.models.Empleado;
import com.proyectoLiquidacion.ProyectoLiquidacion.models.Liquidacion;

import java.io.Serializable;

public class EmpleadoLiquidacionDTO implements Serializable {
    private int idEmpleado;
    private String nombreEmpleado;

    private int idLiquidacion;

    private int totalLiquidacion;

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
}
