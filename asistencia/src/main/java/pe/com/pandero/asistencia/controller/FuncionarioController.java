package pe.com.pandero.asistencia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.pandero.asistencia.exception.ResourceNotFoundException;
import pe.com.pandero.asistencia.model.Cliente;
import pe.com.pandero.asistencia.model.Funcionario;
import pe.com.pandero.asistencia.repository.ClienteRepository;
import pe.com.pandero.asistencia.repository.FuncionarioRepository;
 
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v1")
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping("/funcionario")
    public List<Funcionario> getAllCliente() {
        return funcionarioRepository.findAll();
    }

    @GetMapping("/funcionario/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable(value = "id") Long funcionarioId)
        throws ResourceNotFoundException {
    	Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
          .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado para el id: ==>" + funcionarioId));
        return ResponseEntity.ok().body(funcionario);
    }
    
    @PostMapping("/funcionario")
    public Funcionario createFuncionario(@Valid @RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @PutMapping("/funcionario/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable(value = "id") Long funcionarioId,
         @Valid @RequestBody Funcionario funcionarioDetails) throws ResourceNotFoundException {
    	Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
        .orElseThrow(() -> new ResourceNotFoundException("Funcionario no encontrado para el id ==>" + funcionarioId));

        funcionario.setDni(funcionarioDetails.getDni());
        funcionario.setEmail(funcionarioDetails.getEmail());
        funcionario.setEstado(funcionarioDetails.getEstado());
        funcionario.setNombre(funcionarioDetails.getNombre());
        funcionario.setTipoServicio(funcionarioDetails.getTipoServicio()); 
        
        final Funcionario updateFuncionario = funcionarioRepository.save(funcionario);
        return ResponseEntity.ok(updateFuncionario);
    }

    @DeleteMapping("/funcionario/{id}")
    public Map<String, Boolean> deletefuncionarioId(@PathVariable(value = "id") Long funcionarioId)
         throws ResourceNotFoundException {
    	Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
       .orElseThrow(() -> new ResourceNotFoundException("Funcionario no encontrado para el id ==> " + funcionarioId));

    	funcionarioRepository.delete(funcionario);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

