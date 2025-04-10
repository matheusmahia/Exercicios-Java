import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.nextLine();

        System.out.print("Digite o nome do titular da conta: ");
        String nomeTitular = scanner.nextLine();

        System.out.print("Digite o saldo inicial da conta: R$ ");
        double saldoInicial = scanner.nextDouble();

        ContaBancaria minhaConta = new ContaBancaria(numeroConta, nomeTitular, saldoInicial);

        System.out.println("\nBem-vindo à sua conta bancária!");
        minhaConta.mostrarDetalhes();

        System.out.print("\nDigite o valor para depósito: R$ ");
        double valorDeposito = scanner.nextDouble();
        minhaConta.depositar(valorDeposito);

        System.out.print("\nDigite o valor para saque: R$ ");
        double valorSaque = scanner.nextDouble();
        minhaConta.sacar(valorSaque);

        System.out.println("\nSaldo atualizado: R$ " + minhaConta.obterSaldo());

        scanner.close();
    }
}