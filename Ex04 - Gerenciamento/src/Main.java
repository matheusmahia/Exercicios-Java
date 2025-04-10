import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-> Sistema de Gerenciamento de Jogadores <-");

        System.out.print("Informe o nome do jogador: ");
        String nome = scanner.nextLine();

        System.out.print("Informe a pontuação inicial: ");
        int pontuacao = scanner.nextInt();

        System.out.print("Informe o nível inicial: ");
        int nivel = scanner.nextInt();

        Jogador jogador = new Jogador(nome, pontuacao, nivel);

        boolean executar = true;
        while (executar) {
            System.out.println("\nEscolha uma ação:");
            System.out.println("1 - Exibir informações do jogador");
            System.out.println("2 - Aumentar pontuação");
            System.out.println("3 - Subir de nível");
            System.out.println("4 - Sair");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    jogador.exibirInfo();
                    break;
                case 2:
                    System.out.print("Quantos pontos deseja adicionar? ");
                    int pontos = scanner.nextInt();
                    jogador.aumentarPontuacao(pontos);
                    break;
                case 3:
                    jogador.subirDeNivel();
                    break;
                case 4:
                    System.out.println("Sistema encerrado.");
                    executar = false;
                    break;
                default:
                    System.out.println("Opção inválida!!  Tente novamente!");
            }
        }
        scanner.close();
    }
}