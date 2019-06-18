package pe.com.pandero.asistencia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario {
	
	private long idFuncionario; 
    private String nombre;
    private String email;
    private String dni;
    private String tipoServicio;
    private String estado;

 
    public Funcionario(){}


	public Funcionario(long idFuncionario, String nombre, String email, String dni, String tipoServicio,
			String estado) {
		super();
		this.idFuncionario = idFuncionario;
		this.nombre = nombre;
		this.email = email;
		this.dni = dni;
		this.tipoServicio = tipoServicio;
		this.estado = estado;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public long getIdFuncionario() {
		return idFuncionario;
	}


	public void setIdFuncionario(long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "dni", nullable = false)
	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}

	@Column(name = "tipo_servicio", nullable = false)
	public String getTipoServicio() {
		return tipoServicio;
	}


	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	@Column(name = "estado", nullable = false)
	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
    
	
    
    
}
