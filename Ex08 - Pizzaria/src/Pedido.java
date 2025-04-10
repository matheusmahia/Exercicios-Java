public class Pedido {
    private Pizza pizza;
    private String tamanho;
    private String enderecoEntrega;
    private double valorTotal;

    public Pedido(Pizza pizza, String tamanho, String enderecoEntrega) {
        this.pizza = pizza;
        this.tamanho = tamanho;
        this.enderecoEntrega = enderecoEntrega;
        this.valorTotal = calcularValorTotal();
    }
    private double calcularValorTotal() {
        double valorBase = pizza.getValor();
        switch (tamanho.toLowerCase()) {
            case "pequeno":
                return valorBase;
            case "médio":
                return valorBase * 1.5;
            case "grande":
                return valorBase * 2;
            default:
                throw new IllegalArgumentException("Tamanho inválido!");
        }
    }
    public String toString() {
        return "Pedido:\nPizza escolhida: " + pizza.getNome() +
                "\nTamanho: " + tamanho +
                "\nValor total: R$ " + valorTotal +
                "\nEndereço de entrega: " + enderecoEntrega;
    }
    public double getValorTotal() {
        return valorTotal;
    }
}