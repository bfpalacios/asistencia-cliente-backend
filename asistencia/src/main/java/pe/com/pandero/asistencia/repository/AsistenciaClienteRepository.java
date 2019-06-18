package pe.com.pandero.asistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.pandero.asistencia.model.AsistenciaCliente; 

@Repository
public interface AsistenciaClienteRepository extends JpaRepository<AsistenciaCliente, Long>{

 
}
