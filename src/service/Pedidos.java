package service;

import java.util.*;

public class Pedidos {
    Scanner input = new Scanner(System.in);

    int quantidadePedido;
    int quantidade;
    int numeroDoPedido;
    int id;
    double total;
    String respostaUsuario;
    Produto produto;
    Cliente cliente;

    protected static List<Produto> produtos = new ArrayList<>();
//    protected static Map<String, Map<Integer, String>> clientes = new HashMap<>();

    protected void adicionarProduto(Produto produto){
        produtos.add(produto);
        Produto.pedidos.add(this);
    }

    public void adicionarProdutoParaPedido(){
        System.out.println("ADICIONANDO PEDIDO");

        System.out.print("Digite o id do produto: ");
        id = input.nextInt();


        if (Produto.idENomeProduto.containsKey(id)){
            System.out.println("Quantidade disponível: " + Estoque.quantidades.get(1-id));

            System.out.print("Quantidade desejada: ");
            quantidade = input.nextInt();

            if (quantidade < Estoque.quantidades.get(1-id)){

                quantidadeAtualizada(id, quantidade);

                calcularValorTotalDoPedido(quantidade, 1-id);
            } else {
                System.out.println("Quantidade indisponível");

                System.out.println("Quantidade disponível: " + Estoque.quantidades.get(1-id));

                while (quantidade > Estoque.quantidades.get(1-id)){
                    System.out.print("Quantidade desejada: ");
                    quantidade = input.nextInt();

                    System.out.println("Quantidade indisponível");
                }
                quantidadeAtualizada(id, quantidade);
                calcularValorTotalDoPedido(quantidade, 1-id);
            }
        }
        finalizarPedido();
    }

    private void calcularValorTotalDoPedido(int quantidade, int id){
        total = quantidade * Produto.precosProdutos.get(id);
        System.out.println("O valor do pedido: " + total);
    }

    private void quantidadeAtualizada(int id, int quantidade){
        int quantidadeEstoque = Estoque.quantidades.get(1-id) - quantidade;

        Estoque.quantidades.add(1-id, quantidadeEstoque);
    }

    private void finalizarPedido(){
        System.out.print("Deseja adicionar mais algum produto: ");
        respostaUsuario = input.next();

        while (respostaUsuario.equalsIgnoreCase("sim")){
            adicionarProdutoParaPedido();
        }
    }
}
