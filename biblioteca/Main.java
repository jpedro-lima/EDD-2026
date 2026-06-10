import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BibliotecaDigital biblioteca = new BibliotecaDigital();
		int opcao;

		do {
			System.out.println("\n=== BIBLIOTECA DIGITAL ===");
			System.out.println("1 - Cadastrar livro");
			System.out.println("2 - Buscar livro por ISBN");
			System.out.println("3 - Listar acervo (início -> fim)");
			System.out.println("4 - Listar acervo (fim -> início)");
			System.out.println("5 - Solicitar empréstimo");
			System.out.println("6 - Devolver livro");
			System.out.println("7 - Ver fila de espera de um livro");
			System.out.println("0 - Sair");
			System.out.print("Escolha: ");

			opcao = sc.nextInt();
			sc.nextLine();

			switch (opcao) {
				case 1:
					System.out.print("ISBN: ");
					String isbn = sc.nextLine();

					System.out.print("Título: ");
					String titulo = sc.nextLine();

					System.out.print("Autor: ");
					String autor = sc.nextLine();

					System.out.print("Ano de publicação: ");
					int ano = sc.nextInt();
					sc.nextLine();

					biblioteca.cadastrarLivro(new Livro(isbn, titulo, autor, ano));
					break;

				case 2:
					System.out.print("ISBN: ");
					biblioteca.buscarLivro(sc.nextLine());
					break;

				case 3:
					biblioteca.listarAcervoInicio();
					break;

				case 4:
					biblioteca.listarAcervoFim();
					break;

				case 5:
					System.out.print("Matrícula do usuário: ");
					int matricula = sc.nextInt();
					sc.nextLine();

					System.out.print("Nome: ");
					String nome = sc.nextLine();

					System.out.print("E-mail: ");
					String email = sc.nextLine();

					System.out.print("ISBN do livro: ");
					String isbnEmp = sc.nextLine();

					biblioteca.solicitarEmprestimo(isbnEmp, new Usuario(matricula, nome, email));
					break;

				case 6:
					System.out.print("ISBN: ");
					biblioteca.devolverLivro(sc.nextLine());
					break;

				case 7:
					System.out.print("ISBN: ");
					biblioteca.verFilaDeEspera(sc.nextLine());
					break;

				case 0:
					System.out.println("Encerrando...");
					break;

				default:
					System.out.println("Opção inválida.");
			}

		} while (opcao != 0);

		sc.close();
	}
}
