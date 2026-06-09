public class TesteVetorDinamico {
	public static void main(String[] args) {
		VetorDinamico vetor = new VetorDinamico();

		System.out.println("=== INSERÇÃO EM MASSA ===");

		for (int i = 0; i < 12; i++) {
			Processo p = new Processo("User" + i, "Servico" + i, i % 3);
			vetor.push(p);

			System.out.println(
				"Push #" + p.getProtocolo() +
				" | Topo: " + vetor.getTopo() +
				" | Capacidade: " + vetor.getCapacidade()
			);
		}

		System.out.println("\n=== LISTAGEM ===");
		vetor.listar();

		System.out.println("\n=== BUSCA ===");
		int protocoloBusca = 5;
		int indice = vetor.buscarPorProtocolo(protocoloBusca);
		System.out.println("Protocolo " + protocoloBusca + " encontrado no índice: " + indice);

		System.out.println("\n=== REMOÇÃO EM MASSA ===");

		while (!vetor.estaVazio()) {
			Processo removido = vetor.pop();

			System.out.println(
				"Pop #" + removido.getProtocolo() +
				" | Topo: " + vetor.getTopo() +
				" | Capacidade: " + vetor.getCapacidade()
			);
		}

		System.out.println("\n=== FINAL ===");
		System.out.println("Topo: " + vetor.getTopo());
		System.out.println("Capacidade: " + vetor.getCapacidade());
	}
}