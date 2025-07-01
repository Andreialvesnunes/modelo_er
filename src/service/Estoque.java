package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque {
    Scanner input = new Scanner(System.in);

    private int id;
    private int quantidade;
    private String nomeProduto;
    private String respostaUsuario;

    protected List<Produto> produtos = new ArrayList<>();
    protected static List<Integer> quantidades = new ArrayList<>();

    void atualizarQuantidadeDoProduto(){
        System.out.println("ATUALIZANDO QUANTIDADE DO PRODUTO");
        System.out.print("Digite o id do produto: ");
        id = input.nextInt();

        if (Produto.idENomeProduto.containsKey(id)){
            System.out.print("Nova quantidade: ");
            quantidade = input.nextInt();

            Produto.quantidadeProduto = quantidade;

            quantidades.add(Produto.quantidadeProduto);

            System.out.println("service.Produto Atualizado: " + Produto.idENomeProduto.get(id));
        } else {
            System.out.println("Id não encontrado");
            System.out.print("Deseja colocar o nome: ");
            respostaUsuario = input.next();

            if (respostaUsuario.equalsIgnoreCase("sim")){
                input.nextLine();
                System.out.print("Nome do produto: ");
                nomeProduto = input.nextLine();

                if (Produto.idENomeProduto.containsValue(nomeProduto)){

                    System.out.print("Nova quantidade: ");
                    quantidade = input.nextInt();

                    Produto.quantidadeProduto = quantidade;

                    System.out.println("service.Produto atualizado: " + nomeProduto);
                } else {
                    System.out.println("service.Produto não encontrado ):");
                }
            }
        }
    }

    void adicionarProduto(Produto produto){
        produtos.add(produto);
        produto.estoque = this;
    }

    void quantidadeDoProduto(){
        System.out.print("Adicione o id do produto: ");
        id = input.nextInt();

        System.out.println("Quantidade disponível: " + quantidades.get(1-id));
    }
}
