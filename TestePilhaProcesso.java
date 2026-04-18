public class TestePilhaProcesso {
	public static void main(String[] args) {

		PilhaProcesso pilha = new PilhaProcesso(4);

		System.out.println("=== PUSH ===");

		for (int i = 0; i < 5; i++) {
			Processo p = new Processo("User" + i, "Servico" + i, i % 3);
			pilha.push(p);
			System.out.println("Push: " + p);
		}

		System.out.println("\n=== IMPRIMIR ===");
		pilha.imprimir();

		System.out.println("\n=== PEEK ===");
		try {
			System.out.println("Topo atual: " + pilha.peek());
		} catch (PilhaVaziaException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n=== POP ===");

		while (!pilha.estaVazia()) {
			Processo removido = pilha.pop();
			System.out.println("Pop: " + removido);
		}

		System.out.println("\n=== POP EM PILHA VAZIA ===");

		try {
			pilha.pop();
		} catch (PilhaVaziaException e) {
			System.out.println("Erro esperado: " + e.getMessage());
		}

		System.out.println("\n=== PEEK EM PILHA VAZIA ===");

		try {
			pilha.peek();
		} catch (PilhaVaziaException e) {
			System.out.println("Erro esperado: " + e.getMessage());
		}
	}
}