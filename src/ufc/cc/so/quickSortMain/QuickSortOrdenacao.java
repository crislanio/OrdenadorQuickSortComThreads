package ufc.cc.so.quickSortMain;

import java.util.Arrays;
import java.util.Random;

public class QuickSortOrdenacao {
    /*
     * Método que imprimirá na tela em foram de matriz o número de núcleos do computador.
     * Ele será chamado no método execultar na classe QuickSortOrdenacao
     */

    public static final Random RND = new Random();
    public Integer vet[];

    /**
     * Recebe um objeto de array para depois quando fazer as manipulações não dá
     * erro em cast e referências.
     *
     * @param array
     * @param i
     * @param j
     */
    private static void troca(Object[] array, int i, int j) {
        Object tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * método extends a classe comparable que com isso não dará erro ao chamar o
     * método troca e pode manipular os outros métodos sem problemas.
     *
     * @param <E>
     * @param array
     * @param inicio
     * @param end
     * @return index
     */
    private static <E extends Comparable> int particao(E[] array, int inicio, int end) {

        int index = inicio + RND.nextInt(end - inicio + 1);
        E pivo = array[index];
        troca(array, index, end);
        for (int i = index = inicio; i < end; ++i) {
            if (array[i].compareTo(pivo) <= 0) {
                troca(array, index++, i);
            }
        }
        troca(array, index, end);
        return (index);
    }

    public static <E extends Comparable> void qsort(E[] array, int inicio, int end) {
        if (end > inicio) {
            int index = particao(array, inicio, end);
            qsort(array, inicio, index - 1);
            qsort(array, index + 1, end);
        }
    }

    public static <E extends Comparable> void sort(E[] array) {
        qsort(array, 0, array.length - 1);
    }

    public static void quick_FlipFlop(Integer v[], int p, int r) {
        int i, j, t, ff;
        if (p < r) {
            i = p;
            j = r;
            ff = -1;
            while (i < j) {
                if (v[i] > v[j]) {
                    t = v[i];
                    v[i] = v[j];
                    v[j] = t;
                    ff = -ff;
                }
                if (ff == -1) {
                    --j;
                } else {
                    ++i;
                }
            }
            quick_FlipFlop(v, p, i - 1);
            quick_FlipFlop(v, i + 1, r);
        }
    }

    public String imprimirOrdenacaoMatrizVet(Integer[][] matriz) {
        vet = new Integer[matriz.length];  ///alocar 
        Integer tmV = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < 100; j++) {
                Arrays.asList(vet);
                vet[tmV] = matriz[i][j];
                QuickSortOrdenacao.sort(matriz[i]);
                //      System.out.println(Arrays.toString(vet)); //ordenacao i ://(ta ordenando certo mas se coloco 2 linhas deixa 1 linha null se coloco 4 linhas deixa 3)
                Exec.vetorRandom(vet);
            }
        }
        return Arrays.toString(vet);// ta retornando nulo (endereços) mas é certo pois retorno um vetor.

    }
}
