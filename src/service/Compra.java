package service;

import enumeracao.MetodoPagamento;
import enumeracao.StatusPedido;

import java.util.List;
import java.util.Scanner;

public class Compra {
    private Long id;
    private Pedidos pedidos;
    private Cliente cliente;
    private Endereco endereco;
    private String dataDaCompra;
    private StatusPedido statusPedido;
    private MetodoPagamento pagamento;


    private final Scanner scanner = new Scanner(System.in);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getDataDaCompra() {
        return dataDaCompra;
    }

    public void setDataDaCompra(String dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }

    public void verificarStatusDoPedido(){
        System.out.print("Digite o número do pedido: ");
        int numeroPedido = scanner.nextInt();

        if (Pedidos.listaDePedidos.containsKey(numeroPedido)){
            switch (Pedidos.statusPedido){
                case ENVIADO:
                    System.out.println("Produto já entregue");
                    break;
                case ENVIANDO:
                    System.out.println("A caminho");
                    break;
                case AGUARDANDO_PAGAMENTO:
                    System.out.println("Aguardando pagamento");
                    break;
                case CANCELADO:
                    System.out.println("Pedido cancelado");
                break;
            }
        } else {
            System.out.println("Esse pedido não existe");
        }
    }

    private void selecionarMetodoDePagamento(){
        System.out.println("Forma de Pagamento");
        System.out.println("PIX, CRÉDITO, DÉBITO, BOLETO");

        System.out.println("Escolha a forma de pagamento: ");
        String respostaUsuario = scanner.next();

        if (respostaUsuario.equalsIgnoreCase("pix")){
            pagamento = MetodoPagamento.PIX;
        } else if (respostaUsuario.equalsIgnoreCase("crédito")) {
            pagamento = MetodoPagamento.CREDITO;
        } else if (respostaUsuario.equalsIgnoreCase("débito")) {
            pagamento = MetodoPagamento.DEBITO;
        } else if (respostaUsuario.equalsIgnoreCase("boleto")) {
            pagamento = MetodoPagamento.BOLETO;
        } else {
            System.out.println("Essa forma de pagamento não existe");
        }
    }

    private void pegarPedido(){
        Pedidos.listaDePedidos.get(1);
    }

    public void comprar(){
        selecionarMetodoDePagamento();
        switch (pagamento){
            case PIX:
                pagamentoViaPix();
            break;
            case BOLETO:
                pagamentoViaBoleto();
            break;
            case CREDITO:
                pagamentoViaCredito();
            break;
            case DEBITO:
                pagamentoViaDebito();
            break;
            default:
            System.out.println("Esse método de pagamento não exite");
        }
    }

    private void pagamentoViaPix(){          
        System.out.println("QR Code");
    }

    private void pagamentoViaBoleto(){
        System.out.println("Gerando boleto");
    }

    private void pagamentoViaCredito(){
        System.out.println("Numero do cartao de credito");
    }

    private void pagamentoViaDebito(){
        System.out.println("numero do cartão de debito");
    }
}
