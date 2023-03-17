package com.proyectoLiquidacion.ProyectoLiquidacion.services.Interfaces;

import com.proyectoLiquidacion.ProyectoLiquidacion.models.Liquidacion;

import java.util.List;

public interface ILiquidacionService {

    //calcular valor de la prima, cesantia, interesesCesantia, vacaciones.
    public int prima(int idEmpleado);
    public int cesantia(int idEmpleado);

    public int vacaciones(int idEmpleado);

    public void crearLiquidacion(int idEmpleado);
    public int actualizarValorPrima(int idLiquidacion,int prima);

    public int actualizarValorCesantia(int idLiquidacion, int cesantia);
    public double actualizarValorinteresesCesantias(int idLiquidacion, int interesesCesantias);
    public int actualizarValorvacaciones(int idLiquidacion, int vacaciones);

    public int totalLiquidacion(int idEmpleado);


}
