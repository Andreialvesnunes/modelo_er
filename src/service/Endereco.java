package service;

public class Endereco {
    private String rua;
    private int numeroDaCasa;
    private String nomeDaCidade;
    private String cep;

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
}
