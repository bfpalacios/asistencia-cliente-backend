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
import pe.com.pandero.asistencia.model.Producto; 
import pe.com.pandero.asistencia.repository.ProductoRepository;
 
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v1")
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/producto")
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable(value = "id") Long productoId)
        throws ResourceNotFoundException {
    	Producto producto = productoRepository.findById(productoId)
          .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado para el id: ==>" + productoId));
        return ResponseEntity.ok().body(producto);
    }
    
    @PostMapping("/producto")
    public Producto createProducto(@Valid @RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @PutMapping("/producto/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable(value = "id") Long productoId,
         @Valid @RequestBody Producto productoDetails) throws ResourceNotFoundException {
    	Producto producto = productoRepository.findById(productoId)
        .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado para el id ==>" + productoId));

    	producto.setDescripcion(productoDetails.getDescripcion());
    	producto.setDisponible(productoDetails.getDisponible());
    	producto.setFuncionarioIdFuncionario(productoDetails.getFuncionarioIdFuncionario());
    	producto.setTipo(productoDetails.getTipo());
    	producto.setValor(productoDetails.getValor());
        
        
        final Producto updatedProducto = productoRepository.save(producto);
        return ResponseEntity.ok(updatedProducto);
    }

    @DeleteMapping("/producto/{id}")
    public Map<String, Boolean> deleteProducto(@PathVariable(value = "id") Long productoId)
         throws ResourceNotFoundException {
    	Producto producto = productoRepository.findById(productoId)
       .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado para el id ==> " + productoId));

    	productoRepository.delete(producto);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

