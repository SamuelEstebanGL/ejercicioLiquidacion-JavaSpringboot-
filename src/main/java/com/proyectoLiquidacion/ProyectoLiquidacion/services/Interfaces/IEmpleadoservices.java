package com.proyectoLiquidacion.ProyectoLiquidacion.services.Interfaces;

import com.proyectoLiquidacion.ProyectoLiquidacion.dto.EmpleadoDTO;
import com.proyectoLiquidacion.ProyectoLiquidacion.models.Empleado;

import java.util.List;

public interface IEmpleadoservices {
    List<EmpleadoDTO> buscarTodos();

    void guardar(EmpleadoDTO empleadodto);

    void eliminar(Integer idEmpleado);
    void actualizar(Empleado empleado);

}
