package com.proyectoLiquidacion.ProyectoLiquidacion.services.Interfaces;

import com.proyectoLiquidacion.ProyectoLiquidacion.models.Empleado;

import java.util.List;

public interface ILiquidacionService {


    public int prima(int idEmpleado);
    public int cesantia(int idEmpleado);
    public int interesesCesantias(int idEmpleado);
    public int vacaciones(int idEmpleado);


}
