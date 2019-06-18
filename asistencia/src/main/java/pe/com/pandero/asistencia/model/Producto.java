package pe.com.pandero.asistencia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
	
	private long idProducto;
    private float valor;
    private String descripcion;
    private String disponible;
    private String tipo;
    private String estado;
    private long funcionarioIdFuncionario;
    
    
    public Producto() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public long getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	@Column(name = "valor", nullable = false)
	public float getValor() {
		return valor;
	}


	public void setValor(float valor) {
		this.valor = valor;
	}

	@Column(name = "descripcion", nullable = false)
	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "disponible", nullable = false)
	public String getDisponible() {
		return disponible;
	}


	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}

	@Column(name = "tipo", nullable = false)
	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Column(name = "funcionario_id_funcionario", nullable = false)
	public long getFuncionarioIdFuncionario() {
		return funcionarioIdFuncionario;
	}


	public void setFuncionarioIdFuncionario(long funcionarioIdFuncionario) {
		this.funcionarioIdFuncionario = funcionarioIdFuncionario;
	}
	@Column(name = "estado", nullable = false)
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
    
    

}
