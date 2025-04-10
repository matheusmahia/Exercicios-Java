import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-> Biblioteca <-");

        System.out.println("Informe o Título do Livro: ");
        String titulo = scanner.nextLine();

        System.out.println("Informe o autor: ");
        String autor = scanner.nextLine();

        System.out.println("Informe o Ano de Publicação: ");
        int ano = scanner.nextInt();

        Livro livro = new Livro(titulo, autor, ano);

        System.out.println("\nInformações do Livro:");
        livro.exibirInfo();

        scanner.close();
    }
}