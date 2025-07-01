package service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Avaliar {
    private Map<Integer, Integer> avaliacoes = new HashMap<>();
    private String respostaUsuario;

    public String getRespostaUsuario() {
        return respostaUsuario;
    }

    public void setRespostaUsuario(String respostaUsuario) {
        this.respostaUsuario = respostaUsuario;
    }

    public void avaliacao(){
        Scanner input = new Scanner(System.in);

        System.out.println("Desesa avaliar nosso produto: ");
        respostaUsuario = input.next();

        if (respostaUsuario.equalsIgnoreCase("sim")){
            
        }

    }
}
