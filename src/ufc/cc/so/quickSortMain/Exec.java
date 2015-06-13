package ufc.cc.so.quickSortMain;

import java.io.IOException;
import ufc.cc.so.arquivo.ManipulacaoArquivo;
import java.util.Arrays;
import ufc.cc.so.quickSortThread.ThreadVetor;

public class Exec {

    public static Integer[] vetorRandom(Integer[] vetor) {

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (1 + (Math.random() * 100));
        }

        for (int i = 0; i < vetor.length; i++) {
            QuickSortOrdenacao.sort(vetor);
        }
        System.out.println(Arrays.toString(vetor));
        ManipulacaoArquivo.escrever(Exec.vetorRandom(vetor));
        return vetor;
    }

    public static void main(String[] args) throws IOException {
        ManipulacaoArquivo arquivo = new ManipulacaoArquivo();
        ManipulacaoArquivo.criarArquivoDeMCom100elementosLinha(
                "crislanioAleatorio.txt", 1000);
        Integer[][] matriz = arquivo.leitura("crislanioAleatorio.txt"); //imprimi os numeros.


        ThreadVetor ord = new ThreadVetor(matriz);

        ManipulacaoArquivo.escrever(matriz);

        //  QuickSortOrdenacao s = new QuickSortOrdenacao();
        // s.imprimirOrdenacaoMatrizVet(matriz);

        ord.executar();

    }
}
