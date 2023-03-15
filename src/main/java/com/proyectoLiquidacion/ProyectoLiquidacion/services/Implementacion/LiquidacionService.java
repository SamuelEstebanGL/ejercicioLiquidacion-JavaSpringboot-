package com.proyectoLiquidacion.ProyectoLiquidacion.services.Implementacion;

import com.proyectoLiquidacion.ProyectoLiquidacion.Utils.Constantes;
import com.proyectoLiquidacion.ProyectoLiquidacion.models.Empleado;
import com.proyectoLiquidacion.ProyectoLiquidacion.repositories.ILiquidacionRepository;
import com.proyectoLiquidacion.ProyectoLiquidacion.services.Interfaces.ILiquidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LiquidacionService implements ILiquidacionService {

  // private int cesantias;
    @Autowired
   private ILiquidacionRepository liquidacionRepository;


    @Override
    public int prima(int idEmpleado) {
       Optional<Empleado> empleado = liquidacionRepository.findByIdEmpleado(idEmpleado);
       if (empleado.isPresent()){
           int prima = (empleado.get().getSueldoEmpleado() + Constantes.auxilioTrasporte * empleado.get().getDiasLaborados()/Constantes.año);
           return prima;
       }
       else {
           return 0;
       }

    }

    @Override
    public int cesantia(int idEmpleado) {
        Optional<Empleado> empleado = liquidacionRepository.findByIdEmpleado(idEmpleado);
        if (empleado.isPresent()){
           cesantias = (empleado.get().getSueldoEmpleado() * empleado.get().getDiasLaborados()/Constantes.año);
            return cesantias;
        }
        else {
            return 0;
        }

    }
    int cesantias;

    @Override
    public int interesesCesantias(int idEmpleado) {
        Optional<Empleado> empleado = liquidacionRepository.findByIdEmpleado(idEmpleado);
        if (empleado.isPresent()){
            double porciento = 0.12;
            int interesesCesantias = (int) (( cesantias * porciento)/empleado.get().getDiasLaborados());
            return interesesCesantias;
        }else {
            return 0;
        }


    }

    @Override
    public int vacaciones(int idEmpleado) {
        Optional<Empleado> empleado = liquidacionRepository.findByIdEmpleado(idEmpleado);
        if(empleado.isPresent()){
            int dosAños = Constantes.año + Constantes.año;
            int vacacionesE = empleado.get().getSueldoEmpleado() * empleado.get().getDiasLaborados()/dosAños;
            return vacacionesE;
        }else{
            return 0;
        }

    }

}
