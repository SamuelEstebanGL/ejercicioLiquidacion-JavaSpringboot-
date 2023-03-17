package com.proyectoLiquidacion.ProyectoLiquidacion.repositories;

import com.proyectoLiquidacion.ProyectoLiquidacion.models.Empleado;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IEmpleadoRepository extends JpaRepository <Empleado,Integer>{

}
