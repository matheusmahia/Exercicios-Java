import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Pizza("Margherita", 60.00, List.of("Tomate", "Queijo", "Manjericão")));
        pizzas.add(new Pizza("Pepperoni", 70.00, List.of("Queijo", "Pepperoni", "Molho de tomate")));
        pizzas.add(new Pizza("Frango com Catupiry", 50.00, List.of("Frango", "Catupiry", "Orégano")));

        List<Pedido> pedidos = new ArrayList<>();

        boolean executar = true;
        while (executar) {
            System.out.println("\n-> Menu da Pizzaria <-");
            System.out.println("1 | Pizzas disponíveis");
            System.out.println("2 | Fazer um pedido");
            System.out.println("3 | Adicionar sabor");
            System.out.println("4 | Cancelar pedido");
            System.out.println("5 | Exibir relatório de pedidos");
            System.out.println("6 | Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.println("\nPizzas disponíveis:");
                    for (int i = 0; i < pizzas.size(); i++) {
                        System.out.println((i + 1) + " - " + pizzas.get(i));
                    }
                    break;
                case 2:
                    System.out.println("\nEscolha uma pizza:");
                    for (int i = 0; i < pizzas.size(); i++) {
                        System.out.println((i + 1) + " - " + pizzas.get(i).getNome());
                    }
                    int pizzaEscolhida = scanner.nextInt() - 1;

                    if (pizzaEscolhida < 0 || pizzaEscolhida >= pizzas.size()) {
                        System.out.println("Escolha inválida!");
                        break;
                    }

                    System.out.print("Escolha o tamanho (Pequeno, Médio, Grande): ");
                    String tamanho = scanner.next();

                    System.out.print("Informe o endereço de entrega: ");
                    scanner.nextLine();
                    String endereco = scanner.nextLine();

                    Pedido novoPedido = new Pedido(pizzas.get(pizzaEscolhida), tamanho, endereco);
                    pedidos.add(novoPedido);
                    System.out.println("\nPedido realizado:\n" + novoPedido);
                    break;
                case 3:
                    System.out.print("Informe o nome da nova pizza: ");
                    String novoNome = scanner.nextLine();

                    System.out.print("Informe o valor da nova pizza: ");
                    double novoValor = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Informe os ingredientes: ");
                    String ingredientes = scanner.nextLine();
                    List<String> listaIngredientes = List.of(ingredientes.split(",\\s*"));

                    pizzas.add(new Pizza(novoNome, novoValor, listaIngredientes));
                    System.out.println("Novo sabor de pizza adicionado!");
                    break;
                case 4:
                    System.out.println("\nPedidos realizados:");
                    for (int i = 0; i < pedidos.size(); i++) {
                        System.out.println((i + 1) + " - " + pedidos.get(i));
                    }
                    System.out.print("Informe o número do pedido para cancelar: ");
                    int pedidoCancelar = scanner.nextInt() - 1;

                    if (pedidoCancelar < 0 || pedidoCancelar >= pedidos.size()) {
                        System.out.println("Escolha inválida!");
                    } else {
                        pedidos.remove(pedidoCancelar);
                        System.out.println("Pedido cancelado com sucesso!");
                    }
                    break;
                case 5:
                    System.out.println("\nRelatório de pedidos:");
                    double total = 0;
                    for (Pedido pedido : pedidos) {
                        System.out.println(pedido);
                        total += pedido.getValorTotal();
                    }
                    System.out.println("Total de pedidos: " + pedidos.size());
                    System.out.println("Valor médio: R$ " + (pedidos.isEmpty() ? 0 : total / pedidos.size()));
                    break;
                case 6:
                    System.out.println("Sistema encerrado!");
                    executar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }
}