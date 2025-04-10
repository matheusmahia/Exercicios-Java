import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Produto[] estoque = new Produto[0];
    static int universalId = 1;



    static void MostrarMenu() {
        System.out.println("[1] Novo Produto");
        System.out.println("[2] Editar Produto");
        System.out.println("[3] Remover Produto");
        System.out.println("[4] Pesquisar Produto");
        System.out.println("[5] Exibir Relatório");
        System.out.println("[6] Sair");
    }

    static void MostrarMenuPesquisa() {
        System.out.println("[1] Nome");
        System.out.println("[2] Id");
        System.out.println("[3] Preço");
        System.out.println("[4] Quantidade");
        System.out.println("");
    }

    static void MostrarEstoquePorId() {
        for (Produto produto : estoque) {
            System.out.println("[" + produto.Id + "] " + produto.Nome);
            System.out.println("Preço: " + produto.Preco);
            System.out.println("Quantidade: " + produto.Quantidade);
        }
    }

    static void MostrarRelatorio() {
        int quantidadeTotal = 0;
        float precoTotal = 0;
        for (Produto prod : estoque) {
            System.out.println("Nome: " + prod.Nome);
            System.out.println("Id: " + prod.Id);
            System.out.println("Preço: " + prod.Preco);
            System.out.println("Quantidade: " + prod.Quantidade);
            System.out.println("");

            quantidadeTotal += prod.Quantidade;
            precoTotal += (prod.Preco * prod.Quantidade);
        }

        System.out.println("Quantidade de produtos: " + quantidadeTotal);
        System.out.println("Valor total: " + precoTotal);
        System.out.println("Preço médio por produto: " + (precoTotal / quantidadeTotal));
    }

    static int PesquisarPorNome(String nome) {
        for (int i = 0; i < estoque.length; i++) {
            if (estoque[i].Nome.equals(nome)) {
                return i;
            }
        }
        return -1;
    }

    static int PesquisarPorId(int id) {
        for (int i = 0; i < estoque.length; i++) {
            if (estoque[i].Id == id) {
                return i;
            }
        }
        return -1;
    }

    static Produto[] PesquisarPorPreco(float preco) {
        Produto[] callback = new Produto[0];
        for (int i = 0; i < estoque.length; i++) {
            if (estoque[i].Preco == preco) {
                callback = Arrays.copyOfRange(callback, 0, callback.length + 1);
                callback[callback.length - 1] = estoque[i];
            }
        }
        return callback;
    }

    static Produto[] PesquisarPorQuantidade(int quant) {
        Produto[] callback = new Produto[0];
        for (int i = 0; i < estoque.length; i++) {
            if (estoque[i].Quantidade == quant) {
                callback = Arrays.copyOfRange(callback, 0, callback.length + 1);
                callback[callback.length - 1] = estoque[i];
            }
        }
        return callback;
    }

    static int PesquisarProduto(Scanner listener) {
        System.out.println("Como deseja identificar o produto?");
        MostrarMenuPesquisa();
        int option = Integer.parseInt(listener.nextLine());

        int prodIndex = -1;
        switch (option) {
            case 1:
                System.out.println("Insira o nome do produto.");
                prodIndex = PesquisarPorNome(listener.nextLine());
                break;
            case 2:
                MostrarEstoquePorId();
                System.out.println("Insira o id do produto.");
                prodIndex = PesquisarPorId( Integer.parseInt( listener.nextLine() ) );
                break;
            case 3:
                System.out.println("Insira o preço do produto.");
                Produto[] opcoes1 = PesquisarPorPreco( Float.parseFloat( listener.nextLine() ) );

                if (opcoes1.length != 0) {
                    for (int i = 0; i < opcoes1.length; i++) {
                        Produto prod = opcoes1[i];
                        System.out.println("[" + (i + 1) + "] " + prod.Nome);
                    }

                    System.out.println("Digite o número do produto que deseja editar.");
                    int index1 = Integer.parseInt( listener.nextLine() );

                    if (index1 < 1 || index1 > estoque.length) {
                        System.out.println("Produto não encontrado");
                    } else {
                        for (int i = 0; i < estoque.length; i++) {
                            if (opcoes1[index1 - 1] == estoque[i]) {
                                prodIndex = i;
                                break;
                            }
                        }
                    }
                } else {
                    System.out.println("Nenhum produto encontrado neste preço");
                }

                break;
            case 4:
                System.out.println("Insira a quantidade do produto.");
                Produto[] opcoes2 = PesquisarPorQuantidade( Integer.parseInt( listener.nextLine() ) );

                if (opcoes2.length != 0) {
                    for (int i = 0; i < opcoes2.length; i++) {
                        Produto prod = opcoes2[i];
                        System.out.println("[" + (i + 1) + "] " + prod.Nome);
                    }

                    System.out.println("Digite o número do produto que deseja editar.");
                    int index2 = Integer.parseInt( listener.nextLine() );

                    if (index2 < 1 || index2 > estoque.length) {
                        System.out.println("Produto não encontrado");
                    } else {
                        for (int i = 0; i < estoque.length; i++) {
                            if (opcoes2[index2 - 1] == estoque[i]) {
                                prodIndex = i;
                                break;
                            }
                        }
                    }
                } else {
                    System.out.println("Nenhum produto encontrado neste preço");
                }

                break;

            default:
                System.out.println("Opção inválida.");
                break;
        }

        return prodIndex;
    }


    static void EditarProdutoEscolhido(Scanner listener, int prodIndex) {
        System.out.println("O que deseja editar neste produto?");
        System.out.println("[1] Nome");
        System.out.println("[2] Preço");
        System.out.println("[3] Quantidade");

        String escolha = listener.nextLine();

        Produto prod = estoque[prodIndex];
        switch (escolha.toLowerCase()) {
            case "1":
                System.out.println("Insira o novo nome.");
                prod.Nome = listener.nextLine();
                System.out.println("Produto editado com sucesso.");
                break;
            case "2":
                System.out.println("Insira o preço nome.");
                prod.Preco = Float.parseFloat(listener.nextLine());
                System.out.println("Produto editado com sucesso.");
                break;
            case "3":
                System.out.println("Insira a nova quantidade.");
                prod.Quantidade = Integer.parseInt(listener.nextLine());
                System.out.println("Produto editado com sucesso.");
                break;
            default:
                System.out.println("Opção não existe.");
                break;
        }

    }


    static void CriarProduto(Scanner listener) {
        System.out.println("Digite o nome do produto.");
        String nome = listener.nextLine();

        System.out.println("Digite a quantidade a adicionar.");
        int quant = Integer.parseInt(listener.nextLine());

        int prodIndex = PesquisarPorNome(nome);

        if (prodIndex == -1) { // Novo produto

            System.out.println("Digite o preço do produto.");
            float preco = Float.parseFloat(listener.nextLine());

            estoque = Arrays.copyOfRange(estoque, 0, estoque.length + 1);
            estoque[estoque.length - 1] = new Produto(nome, universalId, preco, quant);
            universalId += 1;

        } else { // Somente aumenta a quantidade

            estoque[prodIndex].Quantidade += quant;

        }
    }

    static void EditarProduto(Scanner listener) {
        boolean continuar = false;
        do {
            int prodIndex = PesquisarProduto(listener);

            if (prodIndex == -1) {

                System.out.println("Produto não encontrado, deseja tentar novamente?");
                System.out.println("[1] Sim");
                System.out.println("[2] Não");

                String escolha = listener.nextLine();
                if (escolha.equals("1")) { // Deseja continuar então tenta novamente
                    continuar = true;
                } else if (escolha.equals("2")) { // Deseja parar então volta ao menu
                    continuar = false;
                } else { // Respondeu errado então volta ao menu
                    System.out.println("Resposta invadida, consideraremos isso como um 'Não'.");
                    continuar = false;
                }

            } else {

                EditarProdutoEscolhido(listener, prodIndex);

            }
        } while (continuar);
    }

    static void RemoverProduto(Scanner listener) {
        MostrarEstoquePorId();

        boolean removido = false;
        do {
            System.out.println("Digite o número do produto que deseja remover.");
            int index = Integer.parseInt(listener.nextLine());

            if (index < 0 || index > estoque.length - 1) {
                System.out.println("Insira um número válido.");
            } else {
                index -= 1;
                for (int i = 0; i < estoque.length; i++) {
                    if (i <= index) { continue; }
                    System.out.println("SHIFTED " + i);
                    estoque[i - 1] = estoque[i];
                }
                estoque = Arrays.copyOfRange(estoque, 0, estoque.length - 1);
                removido = true;
                System.out.println("Produto removido!");
            }
        } while (!removido);
    }

    public static void main(String[] args) {
        Scanner listener = new Scanner(System.in);

        String input;
        boolean stop = false;
        while (!stop) {
            MostrarMenu();
            input = listener.nextLine();

            switch (input) {
                case "1":
                    CriarProduto(listener);
                    break;
                case "2":
                    EditarProduto(listener);
                    break;
                case "3":
                    RemoverProduto(listener);
                    break;
                case "4":
                    int prodIndex = PesquisarProduto(listener);
                    if (prodIndex != -1) {
                        estoque[prodIndex].ExibirInfo();
                    }
                    break;
                case "5":
                    MostrarRelatorio();
                    break;
                case "6":
                    stop = true;
                    break;
                default:
                    System.out.println("Número escolhido não condiz com nenhuma opção.");
                    break;
            }
        }

        listener.close();
    }
}
