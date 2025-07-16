package service;

import java.util.Scanner;

public class Endereco {
    private String rua;
    private int numeroDaCasa;
    private String nomeDaCidade;
    private String cep;
    private String respostaDoUsuario;
    private Scanner scanner = new Scanner(System.in);


    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumeroDaCasa() {
        return numeroDaCasa;
    }

    public void setNumeroDaCasa(int numeroDaCasa) {
        this.numeroDaCasa = numeroDaCasa;
    }

    public String getNomeDaCidade() {
        return nomeDaCidade;
    }

    public void setNomeDaCidade(String nomeDaCidade) {
        this.nomeDaCidade = nomeDaCidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void inserirNovoEndereco(){
        System.out.println("ENDEREÇO");
        System.out.print("Rua: ");
        rua = scanner.next();

        System.out.print("Número: ");
        numeroDaCasa = scanner.nextInt();

        System.out.println("CEP: ");
        cep = scanner.next();

        System.out.println("Cidade: ");
        nomeDaCidade = scanner.next();
    }
}
