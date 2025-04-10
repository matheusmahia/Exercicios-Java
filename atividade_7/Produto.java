public class Produto {
    String Nome;
    int Id;
    float Preco;
    int Quantidade;

    Produto(String nome, int id, float preco, int quantidade) {
        this.Nome = nome;
        this.Id = id;
        this.Preco = preco;
        this.Quantidade = quantidade;
    }

    void ExibirInfo() {
        System.out.println("Nome: " + this.Nome);
        System.out.println("Id: " + this.Id);
        System.out.println("Preço: " + this.Preco);
        System.out.println("Quantidade: " + this.Quantidade);
    }
}