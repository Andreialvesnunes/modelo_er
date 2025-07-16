package service;

import enumeracao.StatusPedido;

import java.util.*;

public class Pedidos {
    Scanner input = new Scanner(System.in);

    private int quantidadePedido;
    private int id;
    private Produto produto;
    private Cliente cliente;
    static StatusPedido statusPedido;

    protected static List<Produto> produtos = new ArrayList<>();
    protected static Map<Integer, Enum> listaDePedidos = new HashMap<>();

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
            int quantidade = input.nextInt();

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
        double total = quantidade * Produto.precosProdutos.get(id);
        System.out.println("O valor do pedido: " + total);
    }

    private void quantidadeAtualizada(int id, int quantidade){
        int quantidadeEstoque = Estoque.quantidades.get(1-id) - quantidade;

        Estoque.quantidades.add(1-id, quantidadeEstoque);
    }

    public void realizarPedido(){

        String respostaUsuario;
        do {
            adicionarProdutoParaPedido();
            System.out.print("Deseja adicionar algum produto: ");
            respostaUsuario = input.next();
        } while (respostaUsuario.equalsIgnoreCase("sim"));

        finalizarPedido();
    }

    private void finalizarPedido(){
        Random numeroAleatorio = new Random();

        int numeroDoPedido = numeroAleatorio.nextInt(1000, 100000);

        if (listaDePedidos.containsKey(numeroDoPedido)){
           do {
               numeroDoPedido = numeroAleatorio.nextInt(1000,100000);
           } while (listaDePedidos.containsKey(numeroDoPedido));
        }

        System.out.println("Finalizando pedido...");
        System.out.println("Número do pedido: " + numeroDoPedido);

        statusPedido = StatusPedido.AGUARDANDO_PAGAMENTO;
        listaDePedidos.put(numeroDoPedido, statusPedido);
    }


}
