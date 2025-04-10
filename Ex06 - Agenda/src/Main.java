import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();

        boolean executar = true;
        while (executar) {
            System.out.println("\n-> Menu da Agenda <-");
            System.out.println("1 | Adicionar contato");
            System.out.println("2 | Buscar contato por nome");
            System.out.println("3 | Remover contato por nome");
            System.out.println("4 | Exibir todos os contatos");
            System.out.println("5 | Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Informe o nome do contato: ");
                    String nome = scanner.nextLine();
                    System.out.print("Informe o telefone do contato: ");
                    String telefone = scanner.nextLine();
                    agenda.adicionarContato(nome, telefone);
                    break;
                case 2:
                    System.out.print("Informe o nome para buscar: ");
                    String nomeBusca = scanner.nextLine();
                    agenda.buscarContatoPorNome(nomeBusca);
                    break;
                case 3:
                    System.out.print("Informe o nome para remover: ");
                    String nomeRemover = scanner.nextLine();
                    agenda.removerContatoPorNome(nomeRemover);
                    break;
                case 4:
                    agenda.exibirTodosContatos();
                    break;
                case 5:
                    System.out.println("Sistema encerrado.");
                    executar = false;
                    break;
                default:
                    System.out.println("Opção inválida!!");
            }
        }
        scanner.close();
    }
}