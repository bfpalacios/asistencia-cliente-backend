package pe.com.pandero.asistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.pandero.asistencia.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

 
}
