import java.util.*;

public class Produto {
    Scanner input = new Scanner(System.in);

    static int id;
    double valor;
    static int quantidadeProduto;
    String nomeProduto;
    String descricaoProduto;
    String respostaUsuario;

    static List<Pedidos> pedidos = new ArrayList<>();
    static Map<Integer, String> idENomeProduto = new HashMap<>();
    static List<String> descricoesProduto = new ArrayList<>();
    static List<Double> precosProdutos = new ArrayList<>();

    Estoque estoque;


    public void adicionarProduto(){
        adicionarIDENomeProduto();
        adicionarPreco();
        adicionarQuantidade();
        adicionarDescricoes();
    }

    private void adicionarIDENomeProduto(){
        System.out.print("Adicionar ID produto: ");
        id = input.nextInt();

        if (idENomeProduto.containsKey(id)){
            System.out.println("Produto já existe");
            do {
                System.out.print("Digite o produto novamente: ");
                id = input.nextInt();
            } while (idENomeProduto.containsKey(id));
        } else {
            idENomeProduto.put(id,nomeProduto);
        }

        input.nextLine();

        System.out.print("Nome do produto: ");
        nomeProduto = input.nextLine();

        if (idENomeProduto.containsValue(nomeProduto)){
            System.out.println("Já existe um produto com esse nome");

            System.out.print("Tem certeza que deseja cadastrar esse produto mesmo assim: ");
            respostaUsuario = input.next();

            if (respostaUsuario.equalsIgnoreCase("sim")){
                idENomeProduto.put(id, nomeProduto);
            } else {
                input.close();
            }
        } else {
            idENomeProduto.put(id, nomeProduto);
        }
    }

    private void adicionarDescricoes(){
        input.nextLine();
        System.out.print("Adicione descrição: ");
        descricaoProduto = input.nextLine();

        descricoesProduto.add(descricaoProduto);
    }

    private void adicionarPreco(){
        System.out.print("Digite valor: ");
        valor = input.nextDouble();

        precosProdutos.add(valor);
    }

    private void adicionarQuantidade(){
        System.out.print("Quantidade: ");
        quantidadeProduto = input.nextInt();

        quantidades.add(quantidadeProduto);

    }

    void adicionarPedido(Pedidos addPedidos){
        pedidos.add(addPedidos);
        Pedidos.produtos.add(this);
    }
}
