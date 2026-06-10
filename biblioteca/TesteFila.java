public class TesteFila {
	public static void main(String[] args) {

		System.out.println("=== FILA DE Usuario (caso da biblioteca) ===");
		Fila<Usuario> espera = new Fila<Usuario>();
		System.out.println("Fila vazia? " + espera.filaVazia());

		espera.enfileira(new Usuario(1001, "Ana", "ana@email.com"));
		espera.enfileira(new Usuario(1002, "Bruno", "bruno@email.com"));
		espera.enfileira(new Usuario(1003, "Carla", "carla@email.com"));

		System.out.println("Fila: " + espera);
		System.out.println("Tamanho: " + espera.tamanho());
		System.out.println("Primeiro (sem remover): " + espera.primeiro());

		System.out.println("\n--- Atendendo em ordem (FIFO) ---");
		while (!espera.filaVazia()) {
			System.out.println("Atendido: " + espera.desenfileira() + "  | resta: " + espera);
		}

		System.out.println("\n=== DESENFILEIRA EM FILA VAZIA ===");
		try {
			espera.desenfileira();
		} catch (FilaVaziaException e) {
			System.out.println("Erro esperado: " + e.getMessage());
		}

		System.out.println("\n=== PRIMEIRO EM FILA VAZIA ===");
		try {
			espera.primeiro();
		} catch (FilaVaziaException e) {
			System.out.println("Erro esperado: " + e.getMessage());
		}

		System.out.println("\n=== MESMA Fila<T> COM OUTROS TIPOS (prova dos genéricos) ===");

		System.out.println("\n--- Fila<String> ---");
		Fila<String> palavras = new Fila<String>();
		palavras.enfileira("A");
		palavras.enfileira("B");
		palavras.enfileira("C");
		System.out.println("Fila: " + palavras);
		System.out.println("Desenfileira: " + palavras.desenfileira());
		System.out.println("Fila: " + palavras);

		System.out.println("\n--- Fila<Integer> ---");
		Fila<Integer> numeros = new Fila<Integer>();
		for (int i = 1; i <= 5; i++) {
			numeros.enfileira(i * 10);
		}
		System.out.println("Fila: " + numeros);
		System.out.println("Tamanho: " + numeros.tamanho());
		System.out.println("Soma desenfileirando: ");
		int soma = 0;
		while (!numeros.filaVazia()) {
			soma += numeros.desenfileira();
		}
		System.out.println("Soma total: " + soma);
		System.out.println("Fila final: " + numeros);
	}
}
