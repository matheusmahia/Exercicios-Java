import java.util.List;

public class Pizza {
    private String nome;
    private double valor;
    private List<String> ingredientes;

    public Pizza(String nome, double valor, List<String> ingredientes) {
        this.nome = nome;
        this.valor = valor;
        this.ingredientes = ingredientes;
    }
    public String getNome() {
        return nome;
    }
    public double getValor() {
        return valor;
    }
    public List<String> getIngredientes() {
        return ingredientes;
    }
    public String toString() {
        return "Pizza: " + nome + "\nValor: R$ " + valor + "\nIngredientes: " + ingredientes;
    }
}