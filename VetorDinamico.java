public class VetorDinamico {
	private Processo[] processos;
	private int topo;
	private int capacidade;
	
	public VetorDinamico(int capacidade) {
		this.capacidade = capacidade;
		this.topo = 0;
		this.processos = new Processo[capacidade];
	}
	
	public VetorDinamico() {
		this(4);
	}
	
	public void push(Processo p) {
		if (topo == capacidade) 
			redimensionar(capacidade * 2);
		
		processos[topo++] = p;
	}
	
	public Processo pop() {
		if (topo == 0) return null;
		
		Processo removido = processos[--topo];
		processos[topo] = null;
		
		if (topo < processos.length / 4) 
			redimensionar(capacidade / 2);
		
		return removido;
	}
	
	public Processo peek() {
		if (topo == 0) return null;
		return processos[topo - 1];
	}
	
	private void redimensionar(int novaCapacidade) {
		Processo[] novo = new Processo[novaCapacidade];
		for(int i = 0; i < topo; i++) {
			novo[i] = processos[i];
		}
		processos = novo;
		capacidade = novaCapacidade;
	}
	
	public void listar() {
		if (estaVazio()) {
			System.out.println("Vetor vazio");
			return;
		}
		
		for (int i = 0; i < topo; i++) {
			System.out.println((i + 1) + " - " + processos[i]);
		}
	}
	
	public int buscarPorProtocolo(int protocolo) {
		for (int i = 0; i < topo; i++) {
			if (processos[i].getProtocolo() == protocolo) {
				return i;
			}
		}
		return -1;
	}
	
	public int				getTopo() {return topo;}
	public int				getCapacidade() {return capacidade;}
	public Processo[]	getProcessos() { return processos; }
	public boolean		estaCheio() {return capacidade == topo;}
	public boolean		estaVazio() {return topo == 0;}
}
