package ufc.cc.so.arquivo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Random;

public class ManipulacaoArquivo {

    private BufferedReader bufferMatriz;
    public static final Random RND = new Random();
    public Integer[] vetorTeste = new Integer[1000];
    /*
     * ler um arquivo que foi criado no metodo criarArquivo.
     * Ler os número do arquivo e para ler a notação de : é ultilizado 
     * 
     * String[] linha = bufferMatriz.readLine().split(":");
     * Onde ler cada linha e onde encontrar : também será lido.
     * 
     * na hora de quebrar a linha ele ta de alguma forma pegando o espaço.
     */

    public Integer[][] leitura(String arquivo) throws IOException {
        Integer matriz[][] = new Integer[1000][100]; //[tanto faz o total de linhas que vai escrever no arquivo] [100 elementos]
        LeitorArquivo ler = new LeitorArquivo();
        String arquivoLido = LeitorArquivo.ler(arquivo);
        String aux[] = arquivoLido.split(";");
        String aux2[];
        for (int cont1 = 0; cont1 < aux.length; cont1++) {
            aux2 = aux[cont1].split(":");
            for (int cont = 0; cont < aux2.length; cont++) {
                //IMPRIMINDO OS NUMEROS NO ARQUIVO
                //      System.out.print(aux2[cont] + " ");
                matriz[cont1][cont] = Integer.parseInt(aux2[cont]);
            }
            //     System.out.println(""); DÁ 10 ESPAÇOS
        }

        return matriz;
    }
    /*
     * Método escreverNoArquivo recebe como parâmetro uma matriz na qual
     * será posta em forma que cada número será seguido de : 
     * 
     * Será feito um novo arquivo e o mesmo será criado com a notação citada acima.
     */

    public static void escrever(Integer[][] matriz) {

        FileWriter fw;
        try {
            File arquivo = new File("crislanioOrdenado.txt");

            fw = new FileWriter(arquivo, false);

            BufferedWriter bw = new BufferedWriter(fw);

            //  bw.write(matriz.length + ""); //imprimindo o total de linhas no arquivo.
            bw.newLine();
            // pega a linha.
            for (int i = 0; i < matriz.length; i++) {
                //    System.out.print(matriz.length / 100 + " matriz"); //imprimi matriz 0 o total de linhas da matriz.
                // coluna
                for (int j = 0; j < 100; j++) {
                    bw.write(matriz[i][j] + "");
                    // pra escrever na matriz o ultimo elemento com ;
                    if (j < 100 - 1) {
                        bw.write(":");
                    }
                }
                if (i < matriz.length - 1) {
                    bw.write(";");
                    bw.newLine();
                }

            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
     public static void escrever(Integer[] vetor) {

     FileWriter fw;
     try {
     File arquivo = new File("crislanioOrdenadoVETOR.txt");

     fw = new FileWriter(arquivo, false);

     BufferedWriter bw = new BufferedWriter(fw);
     bw.write(RND.nextInt(99) + "");


     bw.newLine();

     // pega a linha.
     for (int i = 0; i < vetor.length; i++) {
     if ((i != 0) && (i % 100) == 0) {
     bw.write(";");
     bw.newLine();
     } else {
     bw.write(vetor[i]);
     bw.write(":");
     }
     }
     bw.close();
     fw.close();
     } catch (IOException e) {
     e.printStackTrace();
     }
     }
     */

    public static void escrever(Integer[] vetor) {

        FileWriter fw;
        try {
            File arquivo = new File("crislanioOrdVETOR.txt");

            fw = new FileWriter(arquivo);

            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();

            for (int i = 1; i <=vetor.length; i++) {
                if ((i % 100) == 0) {
                    bw.write(vetor[i-1]);
                    bw.write(";\n");
                }else{
                    bw.write(vetor[i-1]);
                    bw.write(":");
                }
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Método criarArquivo recebe como parâmetro o nome do arquivo e o tamanho que será 
     * feito a organização do arquivo.
     * 
     * O nome arquivo criado terá uma notação como no método escrever.(número seguido de :)
     */
    public static void criarArquivoDeMCom100elementosLinha(String nomeArquivo, int tamanho) {

        FileWriter fw;

        try {
            File arquivo = new File(nomeArquivo);

            fw = new FileWriter(arquivo, false);

            BufferedWriter bw = new BufferedWriter(fw);

            //     bw.write(tamanho + "");
            // o caractere é o numero + o bw.newLine() tem que tirar tambem o /
            bw.newLine();
            for (int i = 0; i < tamanho; i++) {
                //coluna
                for (int j = 0; j < 100; j++) {
                    //pegando a coluna e :
                    bw.write(RND.nextInt(99) + "");
                    if (j < 100 - 1) {
                        bw.write(":");
                    }

                    //     if(j == 99) {
                    //       bw.write(";");
                    //      bw.newLine();
                    //      }

                }


                if (i < tamanho - 1) {
                    bw.write(";");
                    bw.newLine();
                }

            }

            //ultimo elemento com o for
            bw.write(";");
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
