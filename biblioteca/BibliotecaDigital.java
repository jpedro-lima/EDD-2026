public class BibliotecaDigital {
	private Catalogo catalogo;
	private ListaDupla acervo;
	private GestorEmprestimos gestor;

	public BibliotecaDigital() {
		this.catalogo = new Catalogo();
		this.acervo = new ListaDupla();
		this.gestor = new GestorEmprestimos(catalogo);
	}

	public void cadastrarLivro(Livro livro) {
		if (catalogo.existe(livro.getIsbn())) {
			System.out.println("Já existe um livro cadastrado com o ISBN " + livro.getIsbn() + ".");
			return;
		}

		acervo.insereFim(livro);
		catalogo.cadastrar(livro);
		System.out.println("Livro cadastrado: " + livro.getTitulo());
	}

	public void buscarLivro(String isbn) {
		Livro livro = catalogo.buscar(isbn);
		if (livro == null) {
			System.out.println("Nenhum livro encontrado com o ISBN " + isbn + ".");
			return;
		}

		System.out.println("Encontrado: " + livro);
	}

	public void listarAcervoInicio() {
		System.out.println("=== ACERVO (início -> fim) ===");
		acervo.listarDoInicio();
	}

	public void listarAcervoFim() {
		System.out.println("=== ACERVO (fim -> início) ===");
		acervo.listarDoFim();
	}

	public void solicitarEmprestimo(String isbn, Usuario u) {
		gestor.solicitarEmprestimo(isbn, u);
	}

	public void devolverLivro(String isbn) {
		gestor.devolverLivro(isbn);
	}

	public void verFilaDeEspera(String isbn) {
		gestor.listarFilaDeEspera(isbn);
	}
}
