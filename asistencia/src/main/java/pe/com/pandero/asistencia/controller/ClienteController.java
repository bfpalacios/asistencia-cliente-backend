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
import pe.com.pandero.asistencia.repository.ClienteRepository;
 
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v1")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/cliente")
    public List<Cliente> getAllCliente() {
        return clienteRepository.findAll();
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable(value = "id") Long clienteId)
        throws ResourceNotFoundException {
        Cliente cliente = clienteRepository.findById(clienteId)
          .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado para el id: ==>" + clienteId));
        return ResponseEntity.ok().body(cliente);
    }
    
    @PostMapping("/cliente")
    public Cliente createCliente(@Valid @RequestBody Cliente cliente) {
    	
    System.out.print("cliente id "+ cliente.getIdCliente());
        return clienteRepository.save(cliente);
    }

    @PutMapping("/cliente/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable(value = "id") Long clienteId,
         @Valid @RequestBody Cliente clienteDetails) throws ResourceNotFoundException {
    	Cliente cliente = clienteRepository.findById(clienteId)
        .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado para el id ==>" + clienteId));

        cliente.setNombre(clienteDetails.getNombre());
        cliente.setCategoriaCrediticia(clienteDetails.getCategoriaCrediticia());
        cliente.setEdad(clienteDetails.getEdad());
        cliente.setEmail(clienteDetails.getEmail());
        cliente.setIdProducto(clienteDetails.getIdProducto());
        cliente.setNombre(clienteDetails.getNombre());
        cliente.setDni(clienteDetails.getDni());
        
        final Cliente updatedCliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(updatedCliente);
    }

    @DeleteMapping("/cliente/{id}")
    public Map<String, Boolean> deleteCliente(@PathVariable(value = "id") Long clienteId)
         throws ResourceNotFoundException {
    	Cliente cliente = clienteRepository.findById(clienteId)
       .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado para el id ==> " + clienteId));

    	clienteRepository.delete(cliente);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

