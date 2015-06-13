

import ufc.cc.so.quickSortMain.QuickSortOrdenacao;

public class ThreadMatrizPraVetor extends Thread {
    
    private int linhaInicial;
    private int linhaFinal;
    private int coluna;
    //coloquei public para acessar do
    private Integer[][] matrizA;
    
    public ThreadMatrizPraVetor(Integer[][] matrizPraVet) {
        matrizA = matrizPraVet;
    }
    
    public ThreadMatrizPraVetor(int linhaInicial, int linhaFinal, Integer[][] matrizA) {
        
        this.linhaFinal = linhaFinal;
        this.matrizA = matrizA;
        this.linhaInicial = linhaInicial;
        this.coluna = matrizA.length;
    }
    
    @Override
    public void run() {
        for (int i = linhaInicial; i < linhaFinal; i++) {
            Integer[] vetorDaMatriz = converteM(matrizA, i);
            QuickSortOrdenacao.sort(vetorDaMatriz);
        }
    }
    
    public static Integer[] converteM(Integer matrizA[][], int linha) {
        Integer vet[] = new Integer[9];
        int d = 0;
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA.length; j++) {
                vet[d] = matrizA[i][j];
                d++;
          //      System.out.println(vet[d]);
            }
        }
        return vet;
    }
}
