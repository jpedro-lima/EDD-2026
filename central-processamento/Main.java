import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CentralAtendimento central = new CentralAtendimento();
		int opcao;

		do {
			System.out.println("\n=== MENU ===");
			System.out.println("1 - Abrir processo");
			System.out.println("2 - Atender próximo");
			System.out.println("3 - Desfazer último atendimento");
			System.out.println("4 - Listar pendentes");
			System.out.println("5 - Listar histórico");
			System.out.println("0 - Sair");
			System.out.print("Escolha: ");

			opcao = sc.nextInt();
			sc.nextLine();

			switch (opcao) {
				case 1:
					System.out.print("Nome solicitante: ");
					String nome = sc.nextLine();

					System.out.print("Tipo serviço: ");
					String servico = sc.nextLine();

					System.out.print("Prioridade (1 = baixa, 2 = normal, 3 = urgente): ");
					int prioridade = sc.nextInt();
					sc.nextLine();

					if(prioridade < 1 || prioridade > 3) {
						System.out.println("Opção inválida.");
						break;
					}
					Processo p = new Processo(nome, servico, prioridade);
					central.abrirProcesso(p);
					break;

				case 2:
					central.atenderProximo();
					break;

				case 3:
					central.desfazerUltimoAtendimento();
					break;

				case 4:
					central.listarPendentes();
					break;

				case 5:
					central.listarHistorico();
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