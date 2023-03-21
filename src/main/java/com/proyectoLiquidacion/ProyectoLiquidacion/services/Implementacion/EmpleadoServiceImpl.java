package com.proyectoLiquidacion.ProyectoLiquidacion.services.Implementacion;

import com.proyectoLiquidacion.ProyectoLiquidacion.dto.EmpleadoDTO;
import com.proyectoLiquidacion.ProyectoLiquidacion.models.Empleado;
import com.proyectoLiquidacion.ProyectoLiquidacion.repositories.IEmpleadoRepository;
import com.proyectoLiquidacion.ProyectoLiquidacion.services.Interfaces.IEmpleadoservices;
import com.proyectoLiquidacion.ProyectoLiquidacion.services.Interfaces.ILiquidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoServiceImpl implements IEmpleadoservices {

    @Autowired
    private IEmpleadoRepository iEmpleadoRepository;
    @Autowired
    private ILiquidacionService liquidacionService;

    public List<EmpleadoDTO> buscarTodos(){
        List<Empleado> empleadoList = iEmpleadoRepository.findAll();
        List<EmpleadoDTO> empleadoDTOList = new ArrayList<>();
        if(!empleadoList.isEmpty()){
            empleadoList.forEach(empleado -> {
                EmpleadoDTO empleadoDTO = new EmpleadoDTO();
                empleadoDTO.setIdEmpleado(empleado.getIdEmpleado());
                empleadoDTO.setNombreEmpleado(empleado.getNombreEmpleado());
                empleadoDTO.setApellidoEmpleado(empleado.getApellidoEmpleado());
                empleadoDTO.setSueldoEmpleado(empleado.getSueldoEmpleado());
                empleadoDTO.setDiasLaborados(empleado.getDiasLaborados());
                empleadoDTOList.add(empleadoDTO);
            });
        }
        return empleadoDTOList;
    }

    @Override
    public void guardar(EmpleadoDTO empleadodto) {
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(empleadodto.getIdEmpleado());
        empleado.setNombreEmpleado(empleadodto.getNombreEmpleado());
        empleado.setApellidoEmpleado(empleadodto.getApellidoEmpleado());
        empleado.setSueldoEmpleado(empleadodto.getSueldoEmpleado());
        empleado.setDiasLaborados(empleadodto.getDiasLaborados());
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
