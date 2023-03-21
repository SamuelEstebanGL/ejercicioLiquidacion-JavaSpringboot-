package com.proyectoLiquidacion.ProyectoLiquidacion.Controllers;

import com.proyectoLiquidacion.ProyectoLiquidacion.dto.EmpleadoDTO;
import com.proyectoLiquidacion.ProyectoLiquidacion.models.Empleado;
import com.proyectoLiquidacion.ProyectoLiquidacion.repositories.IEmpleadoRepository;
import com.proyectoLiquidacion.ProyectoLiquidacion.services.Interfaces.IEmpleadoservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpleadoController {

    @Autowired
    private IEmpleadoservices service;


    @GetMapping("/buscarEmpleados")
    public List<EmpleadoDTO> buscarTodos(){
        List<EmpleadoDTO> empleadoList = service.buscarTodos();
        return empleadoList;
    }

    @PostMapping("/guardarEmpleado")
    public EmpleadoDTO guardar(@RequestBody EmpleadoDTO empleadodto){
        service.guardar(empleadodto);
        return empleadodto;
    }

    @DeleteMapping("/eliminar-Empleado/{id}")
    public String eliminar(@PathVariable("id")Integer idEmpleado){
        service.eliminar (idEmpleado);
            return "SE ELIMINO CORRECTAMENTE";
    }

    @PutMapping("/actualizarEmpleados")
    public Empleado actualizar(@RequestBody Empleado empleado) {
        service.actualizar(empleado);
        return empleado;
    }


}
