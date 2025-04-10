import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" ->Calculadora ");
        System.out.println("Teste as operações:");

        System.out.print("Digite o primeiro número: ");
        double num1 = scanner.nextDouble();

        System.out.print("Digite o segundo número: ");
        double num2 = scanner.nextDouble();

        System.out.println("Escolha uma operação:");
        System.out.println("->[1] | Soma");
        System.out.println("->[2] | Subtração");
        System.out.println("->[3] | Multiplicação");
        System.out.println("->[4] | Divisão");
        System.out.print("Digite sua escolha: ");
        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                System.out.println("Resultado da Soma: " + Calculadora.adicao(num1, num2));
                break;
            case 2:
                System.out.println("Resultado da Subtração: " + Calculadora.subtrair(num1, num2));
                break;
            case 3:
                System.out.println("Resultado da Multiplicação: " + Calculadora.multiplicar(num1, num2));
                break;
            case 4:
                if (num2 == 0) {
                    System.out.println("Divisão por zero não é permitida.");
                } else {
                    System.out.println("Resultado da Divisão: " + Calculadora.dividir(num1, num2));
                }
                break;
            default:
                System.out.println("Escolha entre 1 e 4.");
        }


        scanner.close();
    }
}