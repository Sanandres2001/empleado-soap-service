package co.parameta.pruebatecnica.service;

import co.parameta.pruebatecnica.model.Empleado;
import co.parameta.pruebatecnica.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public Empleado buscarPorDocumento(String numeroDocumento) {
        return empleadoRepository.findByNumeroDocumento(numeroDocumento);
    }
}