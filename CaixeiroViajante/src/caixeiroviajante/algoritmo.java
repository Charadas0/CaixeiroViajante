package caixeiroviajante;

import java.util.Random;

/*
Trabalho de Inteligência Artificial 2017/2 - Algoritmos Genéticos
Alunos Rafael Feiten e Ramires Lara
Professor: Dr. Marcelo Azambuja
 */
public class algoritmo {

    public static int NUMERO_CIDADES = 26;
    public static int NUMERO_POPULACAO = 10;

    public static void main(String[] args) {

        // definicoes iniciais
        boolean mostrarEvolucao = true;
        float taxaMortalidade = (float) 0.5;
        int numeroEvolucoes = 3000;

        // matriz de adjacencia
        int[][] mapa = {
            {0, 2079, 1578, 6000, 1652, 2765, 2775, 2595, 2892, 1183, 1848, 611, 294, 5215, 788, 1662, 3296, 4230, 501, 4763, 1855, 356, 1578, 2187, 1142, 1408},
            {2079, 0, 2824, 6083, 2120, 2942, 2941, 3193, 3500, 1610, 2017, 2161, 2173, 5298, 2108, 1283, 3852, 4397, 2074, 4931, 3250, 2100, 806, 2933, 947, 3108},
            {1578, 2824, 0, 4736, 716, 1453, 1594, 1004, 1301, 2528, 906, 2171, 1854, 3951, 2348, 1690, 1712, 3050, 2061, 3584, 434, 1372, 2738, 586, 2302, 524},
            {6000, 6083, 4736, 0, 4275, 3836, 3142, 4821, 5128, 6548, 4076, 6593, 6279, 785, 6770, 4926, 5348, 1686, 6483, 2230, 5159, 5794, 6120, 4756, 6052, 5261},
            {1652, 2120, 716, 4275, 0, 1134, 1133, 1366, 1673, 2200, 209, 2245, 1930, 3490, 2422, 973, 2027, 2589, 2135, 3123, 1148, 1446, 2157, 1015, 1789, 1239},
            {2765, 2942, 1453, 3836, 1134, 0, 694, 991, 1298, 3407, 935, 3357, 3040, 3051, 3534, 1785, 1518, 2150, 3247, 2684, 1444, 2569, 2979, 1014, 2911, 1892},
            {2775, 2941, 1594, 3142, 1133, 694, 0, 1679, 1986, 3406, 934, 3366, 3049, 2357, 2543, 1784, 2206, 1456, 3255, 1990, 2017, 2566, 2978, 1614, 2910, 2119},
            {2595, 3193, 1004, 4821, 1366, 991, 1679, 0, 300, 3541, 1186, 3188, 2871, 4036, 3365, 2036, 711, 3135, 3078, 3669, 852, 2385, 3230, 408, 3143, 1300},
            {2892, 3500, 1301, 5128, 1673, 1298, 1986, 300, 0, 3838, 1493, 3485, 3168, 4443, 3662, 2336, 476, 3442, 3375, 3976, 1144, 2682, 3537, 705, 3450, 1597},
            {1183, 1610, 2528, 6548, 2200, 3407, 3406, 3541, 3838, 0, 2482, 688, 1075, 5763, 537, 2035, 4242, 4862, 800, 5396, 2805, 1389, 1070, 3127, 634, 2397},
            {1848, 2017, 906, 4076, 209, 935, 934, 1186, 1493, 2482, 0, 2442, 2125, 3291, 2618, 874, 1847, 2390, 2332, 2924, 1338, 1643, 2054, 926, 1986, 1428},
            {611, 2161, 2171, 6593, 2245, 3357, 3366, 3188, 3485, 688, 2442, 0, 395, 5808, 185, 2253, 3889, 4822, 120, 5356, 2448, 949, 1660, 2770, 1224, 2001},
            {294, 2173, 1854, 6279, 1930, 3040, 3049, 2871, 3168, 1075, 2125, 395, 0, 5491, 572, 1851, 3572, 4505, 285, 5039, 2131, 632, 1672, 2453, 1236, 1684},
            {5215, 5298, 3951, 785, 3490, 3051, 2357, 4036, 4443, 5763, 3291, 5808, 5491, 0, 5985, 4141, 4563, 901, 5698, 1445, 4374, 5009, 5335, 3971, 5267, 4476},
            {788, 2108, 2348, 6770, 2422, 3534, 3543, 3365, 3662, 537, 2618, 185, 572, 5985, 0, 2345, 4066, 4998, 297, 5533, 2625, 1126, 1607, 2947, 1171, 2178},
            {1662, 1283, 1690, 4926, 973, 1785, 1784, 2036, 2336, 2035, 874, 2253, 1851, 4141, 2345, 0, 2747, 2970, 2058, 3764, 2124, 1454, 1386, 1776, 1401, 1401},
            {3296, 3852, 1712, 5348, 2027, 1518, 2206, 711, 476, 4242, 1847, 3889, 3572, 4563, 4066, 2747, 0,3662,3779, 4196, 1553, 3090, 3891, 1109, 3804, 2001},
            {4230, 4397, 3050, 1686, 2589, 2150, 1456, 3135, 3442, 4862, 2390, 4822, 4505, 901, 4998, 2970, 3662, 0, 4712, 544, 3473, 4023, 4434, 3070, 4366, 3575},
            {501, 2074, 2061, 6483, 2135, 3247, 3255, 3078, 3375, 800, 2332, 120, 285, 5698, 297, 2058, 3779, 4712, 0, 5243, 2338, 839, 1573, 2660, 1137, 1831},
            {4763, 4931, 3584, 2230, 3123, 2684, 1990, 3669, 3976, 5396, 2924, 5356, 5039, 1445, 5533, 3764, 4196, 544, 5243, 0, 4007, 4457, 4968, 3604, 4900, 4109},
            {1855, 3250, 434, 5159, 1148, 1444, 2017, 852, 1144, 2805, 1338, 2448, 2131, 4374, 2625, 2124, 1553, 3473, 2338, 4007, 0, 1649, 3015, 429, 2579, 521},
            {356, 2100, 1372, 5794, 1446, 2568, 2566, 2385, 2682, 1389, 1643, 949, 632, 5009, 1126, 1454, 3090, 4023, 839, 4457, 1649, 0, 1599, 1962, 1163, 1202},
            {1578, 806, 2738, 6120, 2157, 2979, 2978, 3230, 3537, 1070, 2054, 1660, 1672, 5335, 1607, 1386, 3891, 4434, 1573, 4968, 3015, 1599, 0, 2970, 446, 2607},
            {2187, 2933, 586, 4756, 1015, 1014, 1614, 408, 705, 3127, 926, 2770, 2453, 3971, 2947, 1776, 1109, 3070, 2660, 3604, 429, 1962, 2970, 0, 2792, 882},
            {1142, 947, 2302, 6052, 1789, 2911, 2910, 3143, 3450, 634, 1986, 1224, 1236, 5267, 1171, 1401, 3804, 4366, 1137, 4900, 2579, 1163, 446, 2792, 0, 2171},
            {1408, 3108, 524, 5261, 1239, 1892, 2119, 1300, 1597, 2397, 1428, 2001, 1684, 4476, 2178, 2214, 2001, 3575, 1831, 4109, 521, 1202, 2607, 882, 2171, 0}
        };

        String[] cidades = {"Aracajú", "Belém", "Belo Horizonte", "Boa Vista", "Brasília", "Campo Grande", "Cuiabá", "Curitiba", "Florianópolis", "Fortaleza", "Goiânia", "João Pessoa", "Maceió", "Manaus", "Natal", "Palmas", "Porto Alegre", "Porto Velho", "Recife", "Rio Branco", "Rio de Janeiro", "Salvador", "São Luis", "São Paulo", "Teresina", "Vitória"};

        int[][] cromossomos = new int[NUMERO_POPULACAO][NUMERO_CIDADES];
        int[] resultados = new int[NUMERO_POPULACAO];

        gerarCromossomosAleatoriamente(cromossomos);
        calcularResultado(cromossomos, resultados, mapa);
        ordenar(cromossomos, resultados);
        if (mostrarEvolucao) {
            imprimir(cromossomos, resultados, cidades);
        }

        int i;
        for (i = 0; i < numeroEvolucoes; i++) {
            renovarCromossomos(cromossomos, resultados, taxaMortalidade);
            calcularResultado(cromossomos, resultados, mapa);
            ordenar(cromossomos, resultados);
            if (mostrarEvolucao) {
                System.out.println("Geracao: " + (i + 1));
                imprimir(cromossomos, resultados, cidades);
            }
        }
        // mostrando resultado encontrado
        resultado(cromossomos, resultados, cidades);

    }

    private static void resultado(int[][] cromossomos, int[] resultados, String[] cidades) {
        int i, i2;
        i = 0;
        for (i2 = 0; i2 < NUMERO_CIDADES; i2++) {
            System.out.print(cidades[cromossomos[i][i2]] + " => ");
        }
        System.out.print(cidades[cromossomos[i][0]] + " ");
        System.out.println(" \n\nResultado: " + resultados[i]);

    }

    public static void renovarCromossomos(int[][] cromossomos, int[] resultados, float taxaMortalidade) {

        int inicioExcluidos = (int) (taxaMortalidade * 10);

        int i, i2 = 0;

        for (i = inicioExcluidos; i < 10; i++) {

            boolean valido = false;

            while (!valido) {

                int[] c_tmp = resetaCromossomo();

                // pegando 2 pais aleatoriamente
                int pai1, pai2;

                pai1 = new Random().nextInt(inicioExcluidos);
                do {
                    pai2 = new Random().nextInt(inicioExcluidos);
                } while ((pai1 == pai2) && (resultados[pai1] != resultados[pai2]));

                // pegando 3 caracteristicas do pai 1 aleatoriamente
                for (i2 = 0; i2 < (int) NUMERO_CIDADES / 4; i2++) {
                    int pos;
                    pos = new Random().nextInt(NUMERO_CIDADES);
                    c_tmp[pos] = cromossomos[pai1][pos];
                }
                // pegando restante do pai 2
                for (i2 = 0; i2 < (int) NUMERO_CIDADES / 4; i2++) {
                    int pos = new Random().nextInt(NUMERO_CIDADES);
                    if (c_tmp[pos] == -1) {
                        if (valorValidoNoCromossomo(cromossomos[pai2][pos], c_tmp)) {
                            c_tmp[pos] = cromossomos[pai2][pos];
                        }
                    }
                }

                // preenchendo o restante com aleatorios
                for (i2 = 0; i2 < NUMERO_CIDADES; i2++) {
                    if (c_tmp[i2] == -1) {
                        int crom_temp = valorValidoNoCromossomo(c_tmp);
                        c_tmp[i2] = crom_temp;
                    }
                }

                // verificando se é valido
                valido = cromossomoValido(c_tmp, cromossomos);
                if (valido) {
                    cromossomos[i] = c_tmp;
                }
            }
        }

    }

    private static int[][] gerarCromossomosAleatoriamente(int[][] cromossomos) {

        // inicializando cromossomos aleatoriamente
        int[] c_tmp = new int[NUMERO_CIDADES];

        int i, i2;
        for (i = 0; i < NUMERO_POPULACAO; i++) {
            boolean crom_valido = false;
            while (!crom_valido) {
                crom_valido = true;
                c_tmp = resetaCromossomo();

                // gerando cromossomo - ok
                for (i2 = 0; i2 < NUMERO_CIDADES; i2++) {
                    c_tmp[i2] = valorValidoNoCromossomo(c_tmp); // monta uma sequencia aleatoria de cidades
                }
                crom_valido = cromossomoValido(c_tmp, cromossomos);
            }
            cromossomos[i] = c_tmp;
        }
        return cromossomos;
    }

    private static int[] resetaCromossomo() {
        int[] c = new int[NUMERO_CIDADES];
        int i;
        for (i = 0; i < NUMERO_CIDADES; i++) {
            c[i] = -1;
        }
        return c;
    }

    private static int valorValidoNoCromossomo(int[] c_tmp) {
        int crom_temp;
        boolean valido;
        do {
            crom_temp = new Random().nextInt(NUMERO_CIDADES);
            valido = true;
            for (int ii = 0; ii < NUMERO_CIDADES; ii++) {
                if (c_tmp[ii] == crom_temp) {
                    valido = false;
                }
            }
        } while (!valido);
        return crom_temp;
    }

    private static boolean valorValidoNoCromossomo(int valor, int[] c_tmp) {
        int crom_temp = valor;
        boolean valido;

        valido = true;
        for (int ii = 0; ii < NUMERO_CIDADES; ii++) {
            if (c_tmp[ii] == crom_temp) {
                valido = false;
            }
        }

        return valido;
    }

    private static boolean cromossomoValido(int[] c_tmp, int[][] cromossomos) {
        int j, j2;
        boolean crom_valido = true;

        for (j = 0; j < NUMERO_POPULACAO; j++) {
            int n_iguais = 0;
            for (j2 = 0; j2 < NUMERO_CIDADES; j2++) {
                if (c_tmp[j2] == cromossomos[j][j2]) {
                    n_iguais++;
                }
            }

            if (n_iguais == NUMERO_CIDADES) {
                crom_valido = false;
            }
        }
        return crom_valido;
    }

    private static void imprimir(int[][] cromossomos, int[] resultados, String[] cidades) {
        int i, i2;
        for (i = 0; i < NUMERO_POPULACAO; i++) {
            for (i2 = 0; i2 < NUMERO_CIDADES; i2++) {
                System.out.print(cidades[cromossomos[i][i2]] + " => ");
            }
            System.out.print(cidades[cromossomos[i][0]] + " ");
            System.out.println(" Resultados: " + resultados[i]);
        }
    }

    private static void calcularResultado(int[][] cromossomos, int[] resultados, int[][] mapa) {
        int i, i2;
        // calculando o resultado
        for (i = 0; i < NUMERO_POPULACAO; i++) {
            int resTmp = 0;
            for (i2 = 0; i2 < NUMERO_CIDADES - 1; i2++) {
                resTmp += mapa[cromossomos[i][i2]][cromossomos[i][i2 + 1]];
            }
            resTmp += mapa[cromossomos[i][0]][cromossomos[i][i2]];
            resultados[i] = resTmp;
        }

    }
//

    private static void ordenar(int[][] cromossomos, int[] resultados) {
        // ordenando
        int i, i2;
        for (i = 0; i < 10; i++) {
            for (i2 = i; i2 < 10; i2++) {
                if (resultados[i] > resultados[i2]) {
                    int vTmp;
                    int[] vvTmp = new int[10];
                    vTmp = resultados[i];
                    resultados[i] = resultados[i2];
                    resultados[i2] = vTmp;

                    vvTmp = cromossomos[i];
                    cromossomos[i] = cromossomos[i2];
                    cromossomos[i2] = vvTmp;
                }
            }
        }
    }

}
