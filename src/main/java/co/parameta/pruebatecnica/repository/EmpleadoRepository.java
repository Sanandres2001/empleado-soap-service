package co.parameta.pruebatecnica.repository;

import co.parameta.pruebatecnica.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    Empleado findByNumeroDocumento(String numeroDocumento);
}