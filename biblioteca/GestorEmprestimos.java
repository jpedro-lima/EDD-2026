public class GestorEmprestimos {
	private Catalogo catalogo;
	private NossoHash<String, Fila<Usuario>> filasDeEspera;

	public GestorEmprestimos(Catalogo catalogo) {
		this.catalogo = catalogo;
		this.filasDeEspera = new NossoHash<String, Fila<Usuario>>();
	}

	public void solicitarEmprestimo(String isbn, Usuario u) {
		Livro livro = catalogo.buscar(isbn);
		if (livro == null) {
			System.out.println("Livro não encontrado: " + isbn);
			return;
		}

		if (livro.isDisponivel()) {
			livro.setDisponivel(false);
			System.out.println("Empréstimo registrado para " + u.getNome() + ": " + livro.getTitulo());
		} else {
			Fila<Usuario> fila = filasDeEspera.get(isbn);
			if (fila == null) {
				fila = new Fila<Usuario>();
				filasDeEspera.put(isbn, fila);
			}
			fila.enfileira(u);
			System.out.println(u.getNome() + " entrou na fila de espera de \"" + livro.getTitulo() + "\".");
		}
	}

	public void devolverLivro(String isbn) {
		Livro livro = catalogo.buscar(isbn);
		if (livro == null) {
			System.out.println("Livro não encontrado: " + isbn);
			return;
		}

		livro.setDisponivel(true);
		System.out.println("Livro devolvido: " + livro.getTitulo());

		Fila<Usuario> fila = filasDeEspera.get(isbn);
		if (fila != null && !fila.filaVazia()) {
			Usuario proximo = fila.desenfileira();
			livro.setDisponivel(false);
			System.out.println("Atendimento automático da fila -> empréstimo para " + proximo.getNome() + ".");
		}
	}

	public void listarFilaDeEspera(String isbn) {
		Fila<Usuario> fila = filasDeEspera.get(isbn);
		if (fila == null || fila.filaVazia()) {
			System.out.println("Não há fila de espera para o ISBN " + isbn + ".");
			return;
		}

		System.out.println("Fila de espera (" + isbn + "): " + fila);
	}
}
