package ufc.cc.so.quickSortThread;

import ufc.cc.so.arquivo.ManipulacaoArquivo;

public class ThreadVetor {

    public Integer[][] matrizX;
    private int numeroDeNucleos;
    private int dimensao;
    private int quantidadeElementos;
    public Integer vetorSalvacao[] = ThreadRun.vetor1;

    public ThreadVetor(Integer[][] matrizX) {
        this.matrizX = matrizX;
        this.dimensao = matrizX.length;
        setNumeroDeNucleos();
    }

    public ThreadVetor() {
        //    this.matrizX = matrizX;
        this.dimensao = matrizX.length;
        setNumeroDeNucleos();
    }

    public void setNumeroDeNucleos() {
        Runtime runTime = Runtime.getRuntime();
        numeroDeNucleos = runTime.availableProcessors();
        System.out.println("número de núcleo " + numeroDeNucleos);
    }

    public void executar() {
        ThreadRun[] vetorDeThreads = new ThreadRun[numeroDeNucleos];
        int contThread = 0;

        if (dimensao <= numeroDeNucleos) {
            for (int i = 0; i < dimensao; i++) {
                vetorDeThreads[contThread] = new ThreadRun(i, i, matrizX);
                vetorDeThreads[contThread].start();

                contThread++;
            }
        } else {
            int resto = 0;
            int linhaInicial;
            int linhaFinal = 0;
// 
            if (dimensao % numeroDeNucleos != 0) {
                //  pega de 3 em 3 threads e divide a matriz .quando resta menos que 0 é pq o resto é diferente de 3 nucleos faz o aalgoritmo acima
                resto = dimensao % numeroDeNucleos;
            }

            for (int i = 0; i < numeroDeNucleos; i++) {
                linhaInicial = linhaFinal;
                linhaFinal += dimensao / numeroDeNucleos;
// a divisao n é exata..suponha 10 elementos 1° linha do 0-2; resto dif0 logo sobra 1linha , eu pego a linha add o resto
                if (resto != 0) {
                    linhaFinal++;//2
                    resto--;
                }
                vetorDeThreads[contThread] = new ThreadRun(linhaInicial, linhaFinal, matrizX);
                vetorDeThreads[contThread].start();
                contThread++;
            }
        }
        try {
            //        Espera todas as threads terminarem
            //        System.out.println(contThread);
            for (int i = 0; i < contThread; i++) {
                vetorDeThreads[i].join();
            }
            //____________
 /*          
             //   vetorSalvacao = new Integer[10 * 100];
             for (int cont = 0; cont < 10; cont++) {
             for (int cont1 = 0; cont1 < 100; cont1++) {
             vetorSalvacao[cont * cont1] = matrizX[cont][cont1];

             System.out.print("c " + vetorSalvacao[cont * cont1]);
             }
             }
             */
            //      do {
            //          quantidadeElementos++;
            //      } while (quantidadeElementos < vetorSalvacao.length);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ManipulacaoArquivo.escrever(matrizX);   // não é obrigado !
        //    ManipulacaoArquivo.escrever(vetorSalvacao);
    }
}