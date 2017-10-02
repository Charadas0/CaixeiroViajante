package caixeiroviajante;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/*
Trabalho de Inteligência Artificial 2017/2 - Algoritmos Genéticos
Alunos Rafael Feiten e Ramires Lara
Professor: Dr. Marcelo Azambuja
*/

public class CaixeiroViajante {

    public static void main(String[] args) {

        List cidades = Inicializador.getCidades();
        int idCidadeOrigem = 0;
        
        if (cidades != null) {
            System.out.println("Escolha a cidade de origem:");
            
            for (int i = 0; i < cidades.size(); i++) {
                Cidade cidade = (Cidade)cidades.get(i);
                System.out.println(cidade.idCidade + " - " + cidade.nomeCidade);
            }
            
            do {
                try {
                    Scanner reader = new Scanner(System.in);
                    idCidadeOrigem = reader.nextInt();

                    if (idCidadeOrigem == 0 || idCidadeOrigem > 26) {
                        throw new InputMismatchException();
                    }
                }
                catch (InputMismatchException e) {
                    System.out.println("Cidade inválida, escolha uma cidade");
                }
                
            } while (idCidadeOrigem == 0 || idCidadeOrigem > 26);
            
            // Chamada do algoritmo
        }
    }
}
