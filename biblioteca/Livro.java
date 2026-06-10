public class Livro {
	private String isbn;
	private String titulo;
	private String autor;
	private int anoPub;
	private boolean disponivel;

	public Livro(String isbn, String titulo, String autor, int anoPub) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.anoPub = anoPub;
		this.disponivel = true;
	}

	@Override
	public String toString() {
		return String.format(
			"[%s] %s - %s (%d) [%s]",
			isbn, titulo, autor, anoPub,
			disponivel ? "DISPONIVEL" : "INDISPONIVEL"
		);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Livro outro = (Livro) obj;
		return isbn.equals(outro.isbn);
	}

	public String	getIsbn() { return isbn; }

	public String	getTitulo() { return titulo; }
	public void		setTitulo(String titulo) { this.titulo = titulo; }

	public String	getAutor() { return autor; }
	public void		setAutor(String autor) { this.autor = autor; }

	public int		getAnoPub() { return anoPub; }

	public boolean	isDisponivel() { return disponivel; }
	public void		setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
}
