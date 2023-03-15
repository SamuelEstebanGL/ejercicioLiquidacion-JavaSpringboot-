package com.proyectoLiquidacion.ProyectoLiquidacion.Controllers;


import com.proyectoLiquidacion.ProyectoLiquidacion.services.Interfaces.ILiquidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LiquidacionController {

    @Autowired
    private ILiquidacionService service;

    @GetMapping("/calcular-prima/{id}")
    public int prima(@PathVariable(name="id")Integer id){
        return service.prima(id);
    }


    @GetMapping("/calcular-cesantia/{id}")
    public int cesantia(@PathVariable(name = "id")Integer id){
        return service.cesantia(id);
    }

    @GetMapping("/calcular-interesesCesantias/{id}")
    public int interesesCesantias(@PathVariable(name = "id")Integer id){
        return service.interesesCesantias(id);
    }

    @GetMapping("/Calcular-vacaciones/{id}")
    public int vacaciones(@PathVariable(name = "id")Integer id){
        return service.vacaciones(id);
    }








}
