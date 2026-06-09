import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Processo {
	private int protocolo;
	private String nomeSolicitante;
	private String tipoServico;
	private int prioridade;
	private String dataHora;

	private static int contadorProtocolos = 0;
	
	public Processo(String solicitante, String tipoServico, int prioridade) {
		this.protocolo = ++contadorProtocolos;
		this.nomeSolicitante = solicitante;
		this.tipoServico = tipoServico;
		this.prioridade = prioridade;
		this.dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
	}
	
	@Override
	public String toString() {
		return String.format(
			"[#%d | %s | %s | Prioridade: %s | Aberto em: %s]",
			protocolo, nomeSolicitante, tipoServico,
			prioridade, dataHora
		);
	}
	
	public int		getProtocolo() {	return protocolo;}
	public void		setProtocolo(int protocolo) { this.protocolo = protocolo;	}
	
	public String	getNomeSolicitante() { return nomeSolicitante; }
	public void		setNomeSolicitante(String nomeSolicitante) { this.nomeSolicitante = nomeSolicitante; }
	
	public String	getTipoServico() { return tipoServico; }
	public void		setTipoServico(String tipoServico) { this.tipoServico = tipoServico;	}
	
	public int		getPrioridade() { return prioridade;	}
	public void		setPrioridade(int prioridade) { this.prioridade = prioridade; }
	
	public String	getDataHora() {return dataHora; }
	public void		setDataHora(String dataHora) { this.dataHora = dataHora;	}
}
