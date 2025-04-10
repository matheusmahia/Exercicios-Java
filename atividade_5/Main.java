public class Main {
    public static void main(String[] args) {

        Carro meuCarro = new Carro("volkwagen", "fusca", 1942, "Kill-0627");


        meuCarro.exibirInfo();
        meuCarro.acelerar(15);
        meuCarro.frear(12);
        meuCarro.exibirInfo();
    }
}