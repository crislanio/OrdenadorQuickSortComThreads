
import ufc.cc.so.quickSortThread.ThreadRun;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ImprimirNumeroDeNucleosCPU {
    /*
     * Método que imprimirá na tela em foram de matriz o número de núcleos do computador.
     * Ele será chamado no método execultar na classe ImprimirNumeroDeNucleosCPU
     */

    public static final Random RND = new Random();

    private static void swap(Object[] array, int i, int j) {
        Object tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static <E extends Comparable> int partition(E[] array, int begin, int end) {
        int nada = 0;
        //private static <E extends Comparable<? super E>> int partition(E[] array, int begin, int end) {
        int index = begin + RND.nextInt(end - begin + 1);
        E pivot = array[index];
        swap(array, index, end);
        for (int i = index = begin; i < end; ++i) {
            if (array[i].compareTo(pivot) <= 0) {
                swap(array, index++, i);
            }
        }
        swap(array, index, end);
        return (index);
    }

    //private static <E extends Comparable<? super E>> void qsort(E[] array, int begin, int end) {
    private static <E extends Comparable> void qsort(E[] array, int begin, int end) {
        if (end > begin) {
            int index = partition(array, begin, end);
            qsort(array, begin, index - 1);
            qsort(array, index + 1, end);
        }
    }

    //public static <E extends Comparable<? super E>> void sort(E[] array) {
    public static <E extends Comparable> void sort(E[] array) {
        qsort(array, 0, array.length - 1);
    }

    public static void imprimirOrdenacao(Integer[][] matriz, int tamanho) {
        Integer vet[] = new Integer[100];
        ThreadRun t = new ThreadRun(matriz);
        for (int i = 0; i < tamanho; i++) {
            //coluna
            for (int j = 0; j < 100; j++) {

//                System.arraycopy(matriz[tamanho], 0, vet, 0, 100);

                System.out.println(
                        "vet  start:" + Arrays.toString(vet));
            }
        }
    }
}
