package pe.com.pandero.asistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.pandero.asistencia.model.Cliente;
import pe.com.pandero.asistencia.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

 
}
