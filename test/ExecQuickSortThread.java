

import java.io.IOException;

import ufc.cc.so.arquivo.ManipulacaoArquivo;
import ufc.cc.so.quickSortThread.ThreadRun;
import java.util.Arrays;

public class ExecQuickSortThread {

    public static void main(String[] args) throws IOException {
        ManipulacaoArquivo arquivo = new ManipulacaoArquivo();
        //     Integer[][] matrizA = arquivo.leitura("A.txt");
        ManipulacaoArquivo.criarArquivoDeMCom100elementosLinha(
                "crislanioAleatorio.txt", 10);
        Integer[][] matrizA = arquivo.leitura("crislanioAleatorio.txt");

        ImprimirNumeroDeNucleosCPU.imprimirOrdenacao(matrizA, 10);
        //       está pegando valores nulos.
    //    ImprimirNumeroDeNucleosCPU.sort(ThreadRun
    //            .converteM(matrizA, 1));
        ManipulacaoArquivo.escrever(matrizA);

    }
}
