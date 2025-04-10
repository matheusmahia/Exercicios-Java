import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    public void adicionarContato(String nome, String telefone) {
        Contato contato = new Contato(nome, telefone);
        contatos.add(contato);
        System.out.println("Contato adicionado: " + nome);
    }

    public void buscarContatoPorNome(String nome) {
        System.out.println("Buscando contatos com o nome: " + nome);
        boolean encontrado = false;
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                System.out.println(contato);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum contato encontrado com o nome: " + nome);
        }
    }
    public void removerContatoPorNome(String nome) {
        System.out.println("Removendo contatos com o nome: " + nome);
        contatos.removeIf(contato -> contato.getNome().equalsIgnoreCase(nome));
        System.out.println("Se existiam contatos com o nome " + nome + ", eles foram removidos.");
    }

    public void exibirTodosContatos() {
        System.out.println("Lista de contatos:");
        for (Contato contato : contatos) {
            System.out.println(contato);
        }
    }
}