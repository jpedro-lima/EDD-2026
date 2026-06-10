public class TesteGestor {
	public static void main(String[] args) {
		Catalogo catalogo = new Catalogo();
		GestorEmprestimos gestor = new GestorEmprestimos(catalogo);

		String isbn = "978-85-430-0067-8";
		catalogo.cadastrar(new Livro(isbn, "Estruturas de Dados", "Goodrich", 2013));

		Usuario ana = new Usuario(1001, "Ana", "ana@email.com");
		Usuario bruno = new Usuario(1002, "Bruno", "bruno@email.com");
		Usuario carla = new Usuario(1003, "Carla", "carla@email.com");

		System.out.println("=== 1) EMPRÉSTIMO DE LIVRO DISPONÍVEL ===");
		gestor.solicitarEmprestimo(isbn, ana);
		System.out.println("Estado: " + catalogo.buscar(isbn));

		System.out.println("\n=== 2) MESMO LIVRO EMPRESTADO (GERA FILA) ===");
		gestor.solicitarEmprestimo(isbn, bruno);
		gestor.solicitarEmprestimo(isbn, carla);
		gestor.listarFilaDeEspera(isbn);

		System.out.println("\n=== 3) DEVOLUÇÃO (ATENDE O PRÓXIMO DA FILA) ===");
		gestor.devolverLivro(isbn);
		System.out.println("Estado: " + catalogo.buscar(isbn));
		System.out.print("Fila após atender Bruno: ");
		gestor.listarFilaDeEspera(isbn);

		System.out.println("\n=== 4) SEGUNDA DEVOLUÇÃO (ATENDE CARLA, FILA ESVAZIA) ===");
		gestor.devolverLivro(isbn);
		System.out.println("Estado: " + catalogo.buscar(isbn));
		gestor.listarFilaDeEspera(isbn);

		System.out.println("\n=== 5) TERCEIRA DEVOLUÇÃO (FILA JÁ VAZIA) ===");
		gestor.devolverLivro(isbn);
		System.out.println("Estado: " + catalogo.buscar(isbn));
	}
}
