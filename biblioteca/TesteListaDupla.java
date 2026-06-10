public class TesteListaDupla {
	public static void main(String[] args) {
		ListaDupla acervo = new ListaDupla();

		System.out.println("=== INSERÇÃO NO FIM ===");
		acervo.insereFim(new Livro("978-85-430-0067-8", "Estruturas de Dados", "Goodrich", 2013));
		acervo.insereFim(new Livro("978-85-216-1907-6", "Algoritmos", "Cormen", 2012));
		acervo.insereFim(new Livro("978-85-352-3034-1", "Use a Cabeca Java", "Sierra", 2010));
		acervo.listarDoInicio();
		System.out.println("Tamanho: " + acervo.tamanho());

		System.out.println("\n=== INSERÇÃO NO INÍCIO ===");
		acervo.insereInicio(new Livro("978-85-742-2718-2", "Clean Code", "Martin", 2008));
		acervo.insereInicio(new Livro("978-85-508-1196-5", "O Programador Pragmatico", "Hunt", 2010));
		acervo.listarDoInicio();
		System.out.println("Tamanho: " + acervo.tamanho());

		System.out.println("\n=== LISTAGEM DO FIM AO INÍCIO ===");
		acervo.listarDoFim();

		System.out.println("\n=== BUSCA POR ISBN ===");
		String alvo = "978-85-216-1907-6";
		Livro encontrado = acervo.buscarPorIsbn(alvo);
		System.out.println("Buscando " + alvo + ": " + encontrado);

		String inexistente = "000-00-000-0000-0";
		System.out.println("Buscando " + inexistente + ": " + acervo.buscarPorIsbn(inexistente));

		System.out.println("\n=== REMOÇÃO NAS DUAS PONTAS ===");
		System.out.println("Removido do início: " + acervo.removePrimeiro());
		System.out.println("Removido do fim: " + acervo.removeUltimo());
		System.out.println("\nApós remoções:");
		acervo.listarDoInicio();
		System.out.println("Tamanho: " + acervo.tamanho());

		System.out.println("\n=== ESVAZIANDO A LISTA ===");
		while (!acervo.estaVazia()) {
			System.out.println("Removido: " + acervo.removePrimeiro());
		}

		System.out.println("\n=== REMOÇÃO EM LISTA VAZIA ===");
		System.out.println("removePrimeiro(): " + acervo.removePrimeiro());
		System.out.println("removeUltimo(): " + acervo.removeUltimo());
		System.out.println("Tamanho: " + acervo.tamanho());
	}
}
