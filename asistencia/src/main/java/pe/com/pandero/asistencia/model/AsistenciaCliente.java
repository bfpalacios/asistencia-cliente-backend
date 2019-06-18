package pe.com.pandero.asistencia.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "asistencia_cliente")
public class AsistenciaCliente {
	
	
	private AsistenciaClientePk asistenciaClientePk; 
    private Date fechaIngreso;
    private Date fechaUltimaVisita; 
    
    public AsistenciaCliente() {}
    
	 
	 
	
	
	public AsistenciaCliente(AsistenciaClientePk asistenciaClientePk, Date fechaIngreso, Date fechaUltimaVisita) {
		super();
		this.asistenciaClientePk = asistenciaClientePk;
		this.fechaIngreso = fechaIngreso;
		this.fechaUltimaVisita = fechaUltimaVisita;
	}




	@EmbeddedId
	public AsistenciaClientePk getAsistenciaClientePk() {
		return asistenciaClientePk;
	}





	public void setAsistenciaClientePk(AsistenciaClientePk asistenciaClientePk) {
		this.asistenciaClientePk = asistenciaClientePk;
	}





	@Column(name = "fecha_ingreso", nullable = false)
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
 
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
 
	@Column(name = "fecha_ultima_visita", nullable = false)
	public Date getFechaUltimaVisita() {
		return fechaUltimaVisita;
	} 

	public void setFechaUltimaVisita(Date fechaUltimaVisita) {
		this.fechaUltimaVisita = fechaUltimaVisita;
	}
 

}
