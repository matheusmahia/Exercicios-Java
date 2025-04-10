public class Jogador {
    private String nome;
    private int pontuacao;
    private int nivel;

    public Jogador(String nome, int pontuacao, int nivel) {
        this.nome = nome;
        this.pontuacao = pontuacao;
        this.nivel = nivel;
    }

    public void aumentarPontuacao(int pontos) {
        if (pontos > 0) {
            this.pontuacao += pontos;
            System.out.println(nome + " ganhou " + pontos + " pontos. Pontuação total: " + pontuacao);
        } else {
            System.out.println("Os pontos devem ser positivos!");
        }
    }

    public void subirDeNivel() {
        this.nivel++;
        System.out.println(nome + " subiu para o nível " + nivel);
    }

    public void exibirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Pontuação: " + pontuacao);
        System.out.println("Nível: " + nivel);
    }
}