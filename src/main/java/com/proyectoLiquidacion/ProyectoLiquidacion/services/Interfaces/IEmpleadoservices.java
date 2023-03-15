package com.proyectoLiquidacion.ProyectoLiquidacion.services.Interfaces;

import com.proyectoLiquidacion.ProyectoLiquidacion.models.Empleado;

import java.util.List;

public interface IEmpleadoservices {
    List<Empleado> buscarTodos();

    void guardar(Empleado empleado);
    void eliminar(Integer idEmpleado);
    void actualizar(Empleado empleado);

}
