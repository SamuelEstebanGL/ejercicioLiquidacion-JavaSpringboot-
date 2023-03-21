package com.proyectoLiquidacion.ProyectoLiquidacion.services.Implementacion;

import com.proyectoLiquidacion.ProyectoLiquidacion.Utils.Constantes;
import com.proyectoLiquidacion.ProyectoLiquidacion.dto.EmpleadoLiquidacionDTO;
import com.proyectoLiquidacion.ProyectoLiquidacion.models.Empleado;
import com.proyectoLiquidacion.ProyectoLiquidacion.models.Liquidacion;
import com.proyectoLiquidacion.ProyectoLiquidacion.repositories.IEmpleadoRepository;
import com.proyectoLiquidacion.ProyectoLiquidacion.repositories.ILiquidacionRepository;
import com.proyectoLiquidacion.ProyectoLiquidacion.repositories.ITotalLiquidacion;
import com.proyectoLiquidacion.ProyectoLiquidacion.services.Interfaces.ILiquidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class LiquidacionServiceImpl implements ILiquidacionService {

  // private int cesantias;
    @Autowired
   private ILiquidacionRepository liquidacionRepository;

    @Autowired
    private ITotalLiquidacion iTotalLiquidacion;

    @Autowired
    private IEmpleadoRepository iEmpleadoRepository;


    @Override
    public int prima(int idEmpleado) {
       Optional<Empleado> empleado = liquidacionRepository.findByIdEmpleado(idEmpleado);
       if (empleado.isPresent()){
           int prima = (empleado.get().getSueldoEmpleado() + Constantes.auxilioTrasporte * empleado.get().getDiasLaborados()/Constantes.año);
           this.actualizarValorPrima(empleado.get().getLiquidacion().getIdLiquidacion(),prima);
           return prima;
       }
       else {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No! hay registro de este empleado en la base de datos");
       }

    }

    @Override
    public int cesantia(int idEmpleado) {
        Optional<Empleado> empleado = liquidacionRepository.findByIdEmpleado(idEmpleado);
        if (empleado.isPresent()){
          int cesantias = (empleado.get().getSueldoEmpleado() * empleado.get().getDiasLaborados()/Constantes.año);
           this.actualizarValorCesantia(empleado.get().getLiquidacion().getIdLiquidacion(),cesantias);
           this.actualizarValorinteresesCesantias(empleado.get().getLiquidacion().getIdLiquidacion(),cesantias);
            return cesantias;
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No! hay registro de este empleado en la base de datos");
        }

    }

    @Override
    public int vacaciones(int idEmpleado) {
        Optional<Empleado> empleado = liquidacionRepository.findByIdEmpleado(idEmpleado);
        if(empleado.isPresent()){
            int dosAños = Constantes.año + Constantes.año;
            int vacacionesE = empleado.get().getSueldoEmpleado() * empleado.get().getDiasLaborados()/dosAños;
            this.actualizarValorvacaciones(empleado.get().getLiquidacion().getIdLiquidacion(),vacacionesE);
            return vacacionesE;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No! hay registro de este empleado en la base de datos");
        }

    }

    @Override
    public void crearLiquidacion(int idEmpleado) {
        Optional<Empleado> empleado = liquidacionRepository.findByIdEmpleado(idEmpleado);
        if (empleado.isPresent()){
            Liquidacion liquidacion = new Liquidacion();
            liquidacion.setEmpleado(empleado.get());
            iTotalLiquidacion.save(liquidacion);
            empleado.get().setLiquidacion(liquidacion);
           actualizarIdLiquidacionEmpleado(empleado.get());
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No! hay registro de este empleado en la base de datos");
        }
    }

    private void actualizarIdLiquidacionEmpleado(Empleado empleado){

        iEmpleadoRepository.save(empleado);
    }


    @Override
    public int actualizarValorPrima(int idLiquidacion, int prima) {
        Optional<Liquidacion> liquidacion = iTotalLiquidacion.findById(idLiquidacion);
        if (liquidacion.isPresent()){
            liquidacion.get().setPrima(prima);
            iTotalLiquidacion.save(liquidacion.get());
            return prima;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"La prima para este empleado no se genero, el empleado no se encontro en nuestra base de datos.");//esta exeption sirve para responder a la peticion con el mensaje escrito en pantalla
        }
    }

    @Override
    public int actualizarValorCesantia(int idLiquidacion, int cesantia) {
        Optional<Liquidacion> liquidacion = iTotalLiquidacion.findById(idLiquidacion);
        if (liquidacion.isPresent()){
            liquidacion.get().setCesantia(cesantia);
            iTotalLiquidacion.save(liquidacion.get());
            return cesantia;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"La cesantia para este empleado no se genero, el empleado no se encontro en nuestra base de datos.");//esta exeption sirve para responder a la peticion con el mensaje escrito en pantalla
        }
    }

    @Override
    public double actualizarValorinteresesCesantias(int idLiquidacion, int cesantias) {
        Optional<Liquidacion> liquidacion = iTotalLiquidacion.findById(idLiquidacion);
        Optional<Empleado> empleado = liquidacionRepository.findByIdEmpleado(liquidacion.get().getEmpleado().getIdEmpleado());
        if (liquidacion.isPresent() && empleado.isPresent()){
            double porciento = 0.12;
            double interesesCesantias = (cesantias * porciento)/empleado.get().getDiasLaborados();
            liquidacion.get().setInteresCesantia(interesesCesantias);
            iTotalLiquidacion.save(liquidacion.get());
            return interesesCesantias;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"El interes de cesantia para este empleado no se genero, el empleado no se encontro en nuestra base de datos.");//esta exeption sirve para responder a la peticion con el mensaje escrito en pantalla
        }
    }

    @Override
    public int actualizarValorvacaciones(int idLiquidacion, int vacaciones) {
        Optional<Liquidacion> liquidacion = iTotalLiquidacion.findById(idLiquidacion);
        if (liquidacion.isPresent()){
            liquidacion.get().setVaciones(vacaciones);
            iTotalLiquidacion.save(liquidacion.get());
            return vacaciones;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"las vacaciones para este empleado no se generaron, el empleado no se encontro en nuestra base de datos.");//esta exeption sirve para responder a la peticion con el mensaje escrito en pantalla
        }
    }

    @Override
    public EmpleadoLiquidacionDTO totalLiquidacionPorEmpleado(int idEmpleado) {
        Optional<Empleado> empleado = liquidacionRepository.findByIdEmpleado(idEmpleado);
        Optional<Liquidacion> liquidacion = iTotalLiquidacion.findById(empleado.get().getLiquidacion().getIdLiquidacion());
        EmpleadoLiquidacionDTO empleadoLiquidacionDTO = new EmpleadoLiquidacionDTO();
        empleadoLiquidacionDTO.setIdEmpleado(empleado.get().getIdEmpleado());
        empleadoLiquidacionDTO.setNombreEmpleado(empleado.get().getNombreEmpleado());
        empleadoLiquidacionDTO.setIdLiquidacion(liquidacion.get().getIdLiquidacion());
        int total = (int) (liquidacion.get().getPrima() + liquidacion.get().getCesantia() + liquidacion.get().getInteresCesantia() + liquidacion.get().getVaciones());
        empleadoLiquidacionDTO.setTotalLiquidacion(total);
        liquidacion.get().setTotalLiquidacion(total);
        iTotalLiquidacion.save(liquidacion.get());
        return empleadoLiquidacionDTO;
    }

}
