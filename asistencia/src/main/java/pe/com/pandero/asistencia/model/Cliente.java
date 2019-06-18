package pe.com.pandero.asistencia.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	private long idCliente;
    private String nombre;
    private String categoriaCrediticia;
    private int edad;
    private int idProducto;
    private String email;
    private String calificacion;
    
    public Cliente() {}
    
	 
	
	public Cliente(long idCliente, String nombre, String categoriaCrediticia, int edad, int idProducto, String email,
			String calificacion) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.categoriaCrediticia = categoriaCrediticia;
		this.edad = edad;
		this.idProducto = idProducto;
		this.email = email;
		this.calificacion = calificacion;
	}



	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	
	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Column(name = "categoria_crediticia", nullable = false)
	public String getCategoriaCrediticia() {
		return categoriaCrediticia;
	}



	public void setCategoriaCrediticia(String categoriaCrediticia) {
		this.categoriaCrediticia = categoriaCrediticia;
	}


	@Column(name = "edad", nullable = false)
	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}


	@Column(name = "producto_id_producto", nullable = false)
	public int getIdProducto() {
		return idProducto;
	}



	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}


	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}


	@Column(name = "calificacion", nullable = false)
	public String getCalificacion() {
		return calificacion;
	}



	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}
	
	 
    

}
