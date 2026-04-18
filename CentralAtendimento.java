public class CentralAtendimento {
	private PilhaPrioridade pendentes;
	private PilhaPrioridade historico;

	public CentralAtendimento() {
		this.pendentes = new PilhaPrioridade();
		this.historico = new PilhaPrioridade();
	}

	public void abrirProcesso(Processo p) {
		pendentes.push(p);
		historico.limpar();
		System.out.println("Processo aberto:\n" + p);
	}

	public void atenderProximo() {
		try {
			Processo p = pendentes.pop();
			historico.push(p);
			System.out.println("Processo atendido:\n" + p);
		} catch (PilhaVaziaException e) {
			System.out.println("Erro: não há processos pendentes.");
		}
	}

	public void desfazerUltimoAtendimento() {
		try {
			Processo p = historico.pop();
			pendentes.push(p);
			System.out.println("Desfeito! Processo voltou para pendentes: " + p);
		} catch (PilhaVaziaException e) {
			System.out.println("Erro: não há histórico para desfazer.");
		}
	}

	public void listarPendentes() {
		System.out.println("\n=== PROCESSOS PENDENTES ===");
		pendentes.listar();
	}

	public void listarHistorico() {
		System.out.println("\n=== HISTÓRICO DE ATENDIMENTOS ===");
		historico.listar();
	}
}