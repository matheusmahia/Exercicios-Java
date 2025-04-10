public class ContaBancaria {
    private String numConta;
    private String nome;
    private double saldoAtual;

    public ContaBancaria(String numConta, String nome, double saldoInicial) {
        this.numConta = numConta;
        this.nome = nome;
        this.saldoAtual = saldoInicial;
    }

    public void depositar(double valorDeposito) {
        if (valorDeposito > 0) {
            saldoAtual += valorDeposito;
            System.out.println("Depósito realizado com sucesso! Valor: R$ " + valorDeposito);
        } else {
            System.out.println("Erro: O valor do depósito deve ser maior que zero.");
        }
    }

    public void sacar(double valorSaque) {
        if (valorSaque > 0 && valorSaque <= saldoAtual) {
            saldoAtual -= valorSaque;
            System.out.println("Saque realizado com sucesso! Valor: R$ " + valorSaque);
        } else if (valorSaque > saldoAtual) {
            System.out.println("Erro: Saldo insuficiente.");
        } else {
            System.out.println("Erro: O valor do saque deve ser maior que zero.");
        }
    }

    public double obterSaldo() {
        return saldoAtual;
    }

    public void mostrarDetalhes() {
        System.out.println("Número da Conta: " + numConta);
        System.out.println("Titular: " + nome);
        System.out.println("Saldo Atual: R$ " + saldoAtual);
    }
}