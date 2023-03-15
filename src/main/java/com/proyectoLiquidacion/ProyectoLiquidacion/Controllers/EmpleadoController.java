package com.proyectoLiquidacion.ProyectoLiquidacion.Controllers;

import com.proyectoLiquidacion.ProyectoLiquidacion.models.Empleado;
import com.proyectoLiquidacion.ProyectoLiquidacion.services.Interfaces.IEmpleadoservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpleadoController {

    @Autowired
    private IEmpleadoservices service;


    @GetMapping("/buscarEmpleados")
    public List<Empleado> buscarTodos(){
        List<Empleado> empleadoList = service.buscarTodos();
        return empleadoList;
    }

    @PostMapping("/guardarEmpleado")
    public Empleado guardar(@RequestBody Empleado empleado){
        service.guardar(empleado);
        return empleado;
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
