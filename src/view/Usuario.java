package view;

import service.Cliente;
import service.Estoque;
import service.Pedidos;
import service.Produto;

public class Usuario {
    public static void main(String[] args) {
        Produto produto = new Produto();
        Produto produto1 = new Produto();
        Produto produto2 = new Produto();

        Pedidos pedidos = new Pedidos();

        Estoque estoque = new Estoque();
        Cliente cliente = new Cliente();
        cliente.cadastarCliente();    
    }
}
