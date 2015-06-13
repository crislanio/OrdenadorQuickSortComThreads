package ufc.cc.so.quickSortThread;

import ufc.cc.so.quickSortMain.QuickSortOrdenacao;
import java.util.Arrays;

public class ThreadRun extends Thread {

    private boolean livre;
    private int linhaInicial;
    private int linhaFinal;
    private int coluna;
    //coloquei public para acessar do
    private Integer[][] matrizA;
    public Integer matrizV[][];
    public static Integer vetor1[];
    QuickSortOrdenacao qs = new QuickSortOrdenacao();

    public ThreadRun(Integer[][] matrizPraVet) {
        matrizA = matrizPraVet;
    }

    public ThreadRun(int linhaInicial, int linhaFinal, Integer[][] matrizA) {

        this.linhaFinal = linhaFinal;
        this.matrizA = matrizA;
        this.linhaInicial = linhaInicial;
        this.coluna = matrizA.length;
    }

    @Override
    public void run() {

        for (int i = linhaInicial; i < linhaFinal; i++) {
            QuickSortOrdenacao.sort(matrizA[i]);
            vetor1 = matrizA[i];
//            QuickSortOrdenacao.quick_FlipFlop(vetor1, linhaInicial, matrizA.length);
            Arrays.sort(vetor1);
      //      System.err.print(" v " + Arrays.toString(vetor1).trim());


        }
        QuickSortOrdenacao.sort(vetor1);
        //   System.err.print(" ve " + Arrays.toString(vetor1));

    }
}
