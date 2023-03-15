package com.proyectoLiquidacion.ProyectoLiquidacion.repositories;

import com.proyectoLiquidacion.ProyectoLiquidacion.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ILiquidacionRepository extends JpaRepository<Empleado, Integer> {
    @Transactional(readOnly = true)
    public Optional<Empleado> findByIdEmpleado(int idEmpleado);

}

