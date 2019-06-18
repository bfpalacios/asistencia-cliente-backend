package pe.com.pandero.asistencia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
public class AsistenciaClientePk implements Serializable {
	 
	//default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    
    private long idCliente;
    private long idFuncionario;
    
    @Column(name = "id_cliente")
	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	@Column(name = "id_funcionario")
	public long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
    
    
}
