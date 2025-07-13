package service;

import enumeracao.StatusPedido;

import java.util.*;

public class Pedidos {
    Scanner input = new Scanner(System.in);

    private int quantidadePedido;
    private int quantidade;
    private int numeroDoPedido;
    private int id;
    private double total;
    private String respostaUsuario;
    private Produto produto;
    private Cliente cliente;
    StatusPedido statusPedido;

    protected static List<Produto> produtos = new ArrayList<>();
    protected List<Integer> listaDePedidos = new ArrayList<>();

    protected void adicionarProduto(Produto produto){
        produtos.add(produto);
        Produto.pedidos.add(this);
    }

    private void adicionarProdutoParaPedido(){
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
    }

    private void calcularValorTotalDoPedido(int quantidade, int id){
        total = quantidade * Produto.precosProdutos.get(id);
        System.out.println("O valor do pedido: " + total);
    }

    private void quantidadeAtualizada(int id, int quantidade){
        int quantidadeEstoque = Estoque.quantidades.get(1-id) - quantidade;

        Estoque.quantidades.add(1-id, quantidadeEstoque);
    }

    public void realizarPedido(){

        do {
            adicionarProdutoParaPedido();
            System.out.print("Deseja adicionar algum produto: ");
            respostaUsuario = input.next();
        } while (respostaUsuario.equalsIgnoreCase("sim"));

        finalizarPedido();
    }

    private void finalizarPedido(){
        Random numeroAleatorio = new Random();

        numeroDoPedido = numeroAleatorio.nextInt(1000, 100000);

        if (listaDePedidos.contains(numeroDoPedido)){
           do {
               numeroDoPedido = numeroAleatorio.nextInt(1000,100000);
           } while (listaDePedidos.contains(numeroDoPedido));
        }
        listaDePedidos.add(numeroDoPedido);

        System.out.println("Finalizando pedido...");
        System.out.println("Número do pedido: " + numeroDoPedido);

        statusPedido = StatusPedido.AGUARDANDO_PAGAMENTO;
    }
}
