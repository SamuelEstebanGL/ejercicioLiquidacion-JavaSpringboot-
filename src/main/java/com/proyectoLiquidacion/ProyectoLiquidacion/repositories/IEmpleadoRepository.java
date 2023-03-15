package com.proyectoLiquidacion.ProyectoLiquidacion.repositories;

import com.proyectoLiquidacion.ProyectoLiquidacion.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpleadoRepository extends JpaRepository <Empleado,Integer>{
}
