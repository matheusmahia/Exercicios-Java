public class Carro {
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
    private int velocidadeAtual;

    public Carro(String marca, String modelo, int ano, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.velocidadeAtual = 0; 
    }

    public void acelerar(int incremento) {
        this.velocidadeAtual += incremento;
        System.out.println("Velocidade atual após acelerar: " + this.velocidadeAtual + " km/h");
    }

    public void frear(int decremento) {
        if (this.velocidadeAtual - decremento < 0) {
            this.velocidadeAtual = 0;
        } else {
            this.velocidadeAtual -= decremento;
        }
        System.out.println("Velocidade atual após frear: " + this.velocidadeAtual + " km/h");
    }

    public void exibirInfo() {
        System.out.println("Detalhes do Carro:");
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Ano: " + this.ano);
        System.out.println("Placa: " + this.placa);
        System.out.println("Velocidade atual: " + this.velocidadeAtual + " km/h");
    }
}