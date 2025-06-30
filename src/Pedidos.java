import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pedidos {
    Scanner input = new Scanner(System.in);

    int quantidadePedido;
    int quantidade;
    int numeroDoPedido;
    int id;
    double total;
    String respostaUsuario;
    Produto produto;

    protected static List<Produto> produtos = new ArrayList<>();

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
                adicionarProduto(produto);
            } else {
                System.out.println("Quantidade indisponível");

                System.out.println("Quantidade disponível: " + Estoque.quantidades.get(1-id));

                while (quantidade > Estoque.quantidades.get(1-id)){
                    System.out.print("Quantidade desejada: ");
                    quantidade = input.nextInt();

                    System.out.println("Quantidade indisponível");
                }
                adicionarProduto(produto);
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
        int quantidadeEstoque = quantidade - Estoque.quantidades.get(1-id);

        Estoque.quantidades.add(1-id, quantidadeEstoque);
    }
}
