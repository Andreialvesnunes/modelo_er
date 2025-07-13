package service;

import excecao.CpfDublicadoException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cliente {
    private String nomeCliente;
    private int idade;
    private String cpf;
    private String respostaUsuario;
    private static final Map<String, String> cliente = new HashMap<>();

    private final Scanner scanner = new Scanner(System.in);


    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void cadastarCliente(){
        cadastrarCpfENome();
        cadastarIdade();
    }

    private void cadastrarCpfENome(){
        System.out.println("Digite seu cpf: ");
        this.cpf = scanner.next();
        setCpf(this.cpf);

        if (cliente.containsKey(cpf)){
            throw new CpfDublicadoException(cpf);
        }

        scanner.nextLine();
        System.out.println("Digite seu nome: ");
        this.nomeCliente = scanner.nextLine();
        setNomeCliente(nomeCliente);

        cliente.putIfAbsent(this.cpf, this.nomeCliente);
    }

    private void cadastarIdade(){
        System.out.println("Olá " + this.nomeCliente + " digite sua idade: ");
        this.idade = scanner.nextInt();
        setIdade(idade);
    }
}
