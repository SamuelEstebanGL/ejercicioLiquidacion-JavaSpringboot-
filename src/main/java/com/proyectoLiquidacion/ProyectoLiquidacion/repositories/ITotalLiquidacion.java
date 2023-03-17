package com.proyectoLiquidacion.ProyectoLiquidacion.repositories;

import com.proyectoLiquidacion.ProyectoLiquidacion.models.Empleado;
import com.proyectoLiquidacion.ProyectoLiquidacion.models.Liquidacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ITotalLiquidacion extends JpaRepository<Liquidacion, Integer> {
}
