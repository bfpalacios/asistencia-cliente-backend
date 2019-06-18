package pe.com.pandero.asistencia.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.pandero.asistencia.exception.ResourceNotFoundException;
import pe.com.pandero.asistencia.model.AsistenciaCliente;
import pe.com.pandero.asistencia.model.Cliente;
import pe.com.pandero.asistencia.repository.AsistenciaClienteRepository;
import pe.com.pandero.asistencia.repository.ClienteRepository;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v1")
public class AsistenciaClienteController {
	
	
	 @Autowired
	    private AsistenciaClienteRepository asistenciaClienteRepository;

	    @GetMapping("/asistencia_cliente")
	    public List<AsistenciaCliente> getAllAsistencia() {
	        return asistenciaClienteRepository.findAll();
	    }

	    @GetMapping("/asistencia_cliente/{id}")
	    public ResponseEntity<AsistenciaCliente> getAsistenciaClienteByDni(@PathVariable(value = "dni") Long dni)
	        throws ResourceNotFoundException {
	    	AsistenciaCliente asistenciaCliente = asistenciaClienteRepository.findById(dni)
	          .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado para el dni: ==>" + dni));
	        return ResponseEntity.ok().body(asistenciaCliente);
	    }
	    
	    
	    //antes de realizar el registro de asistencia, se debe verificar la disponibilidad de un funcionario
	    @PostMapping("/asistencia_cliente")
	    public AsistenciaCliente registrarAsistencia(@Valid @RequestBody AsistenciaCliente asistenciaCliente) {
	        return asistenciaClienteRepository.save(asistenciaCliente);
	    }
}
