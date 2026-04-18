public class PilhaPrioridade {
	private PilhaProcesso baixa;
	private PilhaProcesso normal;
	private PilhaProcesso urgente;

	public PilhaPrioridade() {
		this.baixa = new PilhaProcesso();
		this.normal = new PilhaProcesso();
		this.urgente = new PilhaProcesso();
	}

	public void push(Processo p) {
		switch (p.getPrioridade()) {
			case 1:
				baixa.push(p);
				break;
			case 2:
				normal.push(p);
				break;
			case 3:
				urgente.push(p);
				break;
			default:
				throw new IllegalArgumentException("Prioridade inválida: " + p.getPrioridade());
		}
	}

	public Processo pop() {
		if (!urgente.estaVazia()) return urgente.pop();
		if (!normal.estaVazia()) return normal.pop();
		if (!baixa.estaVazia()) return baixa.pop();

		throw new PilhaVaziaException("Nenhum processo disponível");
	}

	public Processo peek() {
		if (!urgente.estaVazia()) return urgente.peek();
		if (!normal.estaVazia()) return normal.peek();
		if (!baixa.estaVazia()) return baixa.peek();

		throw new PilhaVaziaException("Nenhum processo disponível");
	}

	public void limpar() {
		urgente.limpar();
		normal.limpar();
		baixa.limpar();
	}

	public int tamanho() {
		return urgente.getTopo() + normal.getTopo() + baixa.getTopo();
	}

	public void listar() {
		System.out.println("\n=== PRIORIDADE URGENTE (3) ===");
		urgente.imprimir();

		System.out.println("\n=== PRIORIDADE NORMAL (2) ===");
		normal.imprimir();

		System.out.println("\n=== PRIORIDADE BAIXA (1) ===");
		baixa.imprimir();
	}
}