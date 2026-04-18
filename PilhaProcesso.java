public class PilhaProcesso {
	private VetorDinamico vetor;
	
	public PilhaProcesso() {
		this.vetor = new VetorDinamico();
	}
	
	public PilhaProcesso(int capacidade) {
		this.vetor = new VetorDinamico(capacidade);
	}
	
	public void push(Processo p) {
		vetor.push(p);
	}
	
	public Processo pop() {
		Processo p = vetor.pop();
		if (p == null) {
			throw new PilhaVaziaException("A pilha está vazia");
		}
		return p;
	}
	
	public Processo peek() {
		Processo p = vetor.peek();
		if (p == null) 
			throw new PilhaVaziaException("A pilha está vazia");
		
		return p;
	}
	
	public void imprimir() {
		if (vetor.estaVazio()) {
			System.out.println("Pilha vazia");
			return;
		}
		
		System.out.println("=== TOPO ===");
		for (int i = vetor.getTopo() - 1; i >= 0; i--) {
			System.out.println((i + 1) + " - " + vetor.getProcessos()[i]);
		}
		System.out.println("=== BASE ===");
	}
	
	public void limpar() {
		while (!estaVazia())
			pop();
	}
	
	public boolean estaVazia() {
		return vetor.estaVazio();
	}

	public int getTopo() {
		return vetor.getTopo();
	}

	public int getCapacidade() {
		return vetor.getCapacidade();
	}
}