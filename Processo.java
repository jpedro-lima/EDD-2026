import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Processo {
	private int protocolo;
	private String nomeSolicitante;
	private String tipoServico;
	private int urgencia;
	private LocalDateTime  criadoEm;
	
	public Processo(String solicitante, String servico, int urgencia, int protocolo) {
		this.protocolo = protocolo;
		this.nomeSolicitante = solicitante;
		this.tipoServico = servico;
		this.urgencia = urgencia;
		this.criadoEm = LocalDateTime.now();
	}
	
	@Override
	public String toString() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return String.format(
			"[#%d | %s | %s | Prioridade: %s | Aberto em: %s]",
			protocolo, nomeSolicitante, tipoServico,
			urgencia, criadoEm.format(fmt)
		);
	}
	
	public int getProtocolo() {	return protocolo;}
	
	public void setProtocolo(int protocolo) { this.protocolo = protocolo;	}
	
	public String getNomeSolicitante() { return nomeSolicitante; }
	
	public void setNomeSolicitante(String nomeSolicitante) { this.nomeSolicitante = nomeSolicitante; }
	
	public String getTipoServico() { return tipoServico; }
	
	public void setTipoServico(String tipoServico) { this.tipoServico = tipoServico;	}
	
	public int getUrgencia() { return urgencia;	}
	
	public void setUrgencia(int urgencia) { this.urgencia = urgencia; }
	
	public LocalDateTime getCriadoEm() {return criadoEm; }
	
	public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm;	}
}
