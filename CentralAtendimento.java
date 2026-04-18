public class CentralAtendimento {
	private PilhaProcesso pendentes;
	private PilhaProcesso historico;

	public CentralAtendimento() {
		this.pendentes = new PilhaProcesso();
		this.historico = new PilhaProcesso();
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
			System.out.println("Processo atendido: " + p);
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
		pendentes.imprimir();
	}

	public void listarHistorico() {
		System.out.println("\n=== HISTÓRICO DE ATENDIMENTOS ===");
		historico.imprimir();
	}
}