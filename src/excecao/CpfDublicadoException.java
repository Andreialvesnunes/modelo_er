package excecao;

public class CpfDublicadoException extends RuntimeException {

    public CpfDublicadoException(String cpf) {
        super(cpf);
    }

  @Override
  public String getMessage() {
    return "Esse Cpf já existe";
  }
}
