package view;

import service.*;

public class Usuario {
    public static void main(String[] args) {
        Produto produto = new Produto();
        Produto produto1 = new Produto();
        Produto produto2 = new Produto();

        Pedidos pedidos = new Pedidos();
        Compra compra = new Compra();

        produto.adicionarProduto();
        pedidos.realizarPedido();
        compra.verificarStatusDoPedido();
        compra.comprar();



    }
}
