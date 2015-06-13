package ufc.cc.so.arquivo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeitorArquivo {
    // recebe o diretório do arquivo.

    public static String ler(String arquivo) throws FileNotFoundException {
        // essa classe ou StringBuffer vão armazenando em cache os valores.
        StringBuilder sb = new StringBuilder();
        //tente lê o arquivo.

        FileReader reader = new FileReader(arquivo);
        try {
            int c;
            do {
                //leia os valores.
                c = reader.read();
                if (c != -1) {
                    //se não for o final armazene cada valor em sb.
                    if (((char) c)=='\n'  ) {
                        
                    } else {
                        sb.append((char) c);
                    }
                }

            } while (c != -1);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //retorne os valores armazenados.
        return sb.toString();
    }

}