/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caixeiroviajante;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ramir
 */
public class Inicializador {
    
    public static List getCidades () {
        List cidades = new ArrayList<Cidade>();
        cidades.add(Inicializador.setCidade(1, "Aracajú"));
        cidades.add(Inicializador.setCidade(2, "Belém"));
        cidades.add(Inicializador.setCidade(3, "Belo Horizonte"));
        cidades.add(Inicializador.setCidade(4, "Boa Vista"));
        cidades.add(Inicializador.setCidade(5, "Brasília"));
        cidades.add(Inicializador.setCidade(6, "Campo Grande"));
        cidades.add(Inicializador.setCidade(7, "Cuiabá"));
        cidades.add(Inicializador.setCidade(8, "Curitiba"));
        cidades.add(Inicializador.setCidade(9, "Florianópolis"));
        cidades.add(Inicializador.setCidade(10, "Fortaleza"));
        cidades.add(Inicializador.setCidade(11, "Goiânia"));
        cidades.add(Inicializador.setCidade(12, "João Pessoa"));
        cidades.add(Inicializador.setCidade(13, "Maceió"));
        cidades.add(Inicializador.setCidade(14, "Manaus"));
        cidades.add(Inicializador.setCidade(15, "Natal"));
        cidades.add(Inicializador.setCidade(16, "Palmas"));
        cidades.add(Inicializador.setCidade(17, "Porto Alegre"));
        cidades.add(Inicializador.setCidade(18, "Porto Velho"));
        cidades.add(Inicializador.setCidade(19, "Recife"));
        cidades.add(Inicializador.setCidade(20, "Rio Branco"));
        cidades.add(Inicializador.setCidade(21, "Rio de Janeiro"));
        cidades.add(Inicializador.setCidade(22, "Salvador"));
        cidades.add(Inicializador.setCidade(23, "São Luis"));
        cidades.add(Inicializador.setCidade(24, "São Paulo"));
        cidades.add(Inicializador.setCidade(25, "Teresina"));
        cidades.add(Inicializador.setCidade(26, "Vitória"));
        
        for (int i = 0; i < cidades.size(); i++) {
            
        }
        
        return cidades;
    }
    
    public static List getDistancias(int idCidade) {
        List distancias = new ArrayList<DistanciaCidades>();
        
        switch(idCidade)
        {
            //distancias.add(setDistanciaCidade(idCidade, , ));
            case 1:
                distancias.add(setDistanciaCidade(idCidade, 2, 2079));
                distancias.add(setDistanciaCidade(idCidade, 3, 1578));
                distancias.add(setDistanciaCidade(idCidade, 4, 6000));
                distancias.add(setDistanciaCidade(idCidade, 5, 1652));
                distancias.add(setDistanciaCidade(idCidade, 6, 2765));
                distancias.add(setDistanciaCidade(idCidade, 7, 2775));
                distancias.add(setDistanciaCidade(idCidade, 8, 2595));
                distancias.add(setDistanciaCidade(idCidade, 9, 2892));
                distancias.add(setDistanciaCidade(idCidade, 10, 1183));
                distancias.add(setDistanciaCidade(idCidade, 11, 1848));
                distancias.add(setDistanciaCidade(idCidade, 12, 611));
                distancias.add(setDistanciaCidade(idCidade, 13, 294));
                distancias.add(setDistanciaCidade(idCidade, 14, 5215));
                distancias.add(setDistanciaCidade(idCidade, 15, 788));
                distancias.add(setDistanciaCidade(idCidade, 16, 1662));
                distancias.add(setDistanciaCidade(idCidade, 17, 3296));
                distancias.add(setDistanciaCidade(idCidade, 18, 4230));
                distancias.add(setDistanciaCidade(idCidade, 19, 501));
                distancias.add(setDistanciaCidade(idCidade, 20, 4763));
                distancias.add(setDistanciaCidade(idCidade, 21, 1855));
                distancias.add(setDistanciaCidade(idCidade, 22, 356));
                distancias.add(setDistanciaCidade(idCidade, 23, 1578));
                distancias.add(setDistanciaCidade(idCidade, 24, 2187));
                distancias.add(setDistanciaCidade(idCidade, 25, 1142));
                distancias.add(setDistanciaCidade(idCidade, 26, 1408));
                break;
            case 2:
                distancias.add(setDistanciaCidade(idCidade, 1, 2079));
                distancias.add(setDistanciaCidade(idCidade, 3, 2824));
                distancias.add(setDistanciaCidade(idCidade, 4, 6083));
                distancias.add(setDistanciaCidade(idCidade, 5, 2120));
                distancias.add(setDistanciaCidade(idCidade, 6, 2942));
                distancias.add(setDistanciaCidade(idCidade, 7, 2941));
                distancias.add(setDistanciaCidade(idCidade, 8, 3193));
                distancias.add(setDistanciaCidade(idCidade, 9, 3500));
                distancias.add(setDistanciaCidade(idCidade, 10, 1610));
                distancias.add(setDistanciaCidade(idCidade, 11, 2017));
                distancias.add(setDistanciaCidade(idCidade, 12, 2161));
                distancias.add(setDistanciaCidade(idCidade, 13, 2173));
                distancias.add(setDistanciaCidade(idCidade, 14, 5298));
                distancias.add(setDistanciaCidade(idCidade, 15, 2108));
                distancias.add(setDistanciaCidade(idCidade, 16, 1283));
                distancias.add(setDistanciaCidade(idCidade, 17, 3852));
                distancias.add(setDistanciaCidade(idCidade, 18, 4397));
                distancias.add(setDistanciaCidade(idCidade, 19, 2074));
                distancias.add(setDistanciaCidade(idCidade, 20, 4931));
                distancias.add(setDistanciaCidade(idCidade, 21, 3250));
                distancias.add(setDistanciaCidade(idCidade, 22, 2100));
                distancias.add(setDistanciaCidade(idCidade, 23, 806));
                distancias.add(setDistanciaCidade(idCidade, 24, 2933));
                distancias.add(setDistanciaCidade(idCidade, 25, 947));
                distancias.add(setDistanciaCidade(idCidade, 26, 3108));
                break;
        }
        
        return distancias;
    }
    
    public static Cidade setCidade(int id, String nome) {
        Cidade cidade = new Cidade();
        cidade.idCidade = id;
        cidade.nomeCidade = nome;
        
        return cidade;
    }
    
    public static DistanciaCidades setDistanciaCidade(int idCidade, int idCidadeDestino, int distancia) {
        DistanciaCidades distanciaCidades = new DistanciaCidades();
        distanciaCidades.idCidadeOrigem = idCidade;
        distanciaCidades.idCidadeDestino = idCidadeDestino;
        distanciaCidades.distancia = distancia;
        
        return distanciaCidades;
    }
}
