package com.proyectoLiquidacion.ProyectoLiquidacion.services.Implementacion;

import com.proyectoLiquidacion.ProyectoLiquidacion.models.Empleado;
import com.proyectoLiquidacion.ProyectoLiquidacion.repositories.IEmpleadoRepository;
import com.proyectoLiquidacion.ProyectoLiquidacion.services.Interfaces.IEmpleadoservices;
import com.proyectoLiquidacion.ProyectoLiquidacion.services.Interfaces.ILiquidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService implements IEmpleadoservices {

    @Autowired
    private IEmpleadoRepository iEmpleadoRepository;
    @Autowired
    private ILiquidacionService liquidacionService;

    public List<Empleado> buscarTodos(){
        List<Empleado> empleadoList = iEmpleadoRepository.findAll();
        return empleadoList;
    }

    @Override
    public void guardar(Empleado empleado) {
        iEmpleadoRepository.save(empleado);
        liquidacionService.crearLiquidacion(empleado.getIdEmpleado());
    }

   @Override
    public void eliminar(Integer idEmpleado) {
        iEmpleadoRepository.deleteById(idEmpleado);
    }

    @Override
    public void actualizar(Empleado empleado) {
        iEmpleadoRepository.save(empleado);
    }


}
