
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class NumerosAleatorios {

    public static void main(String[] args) {
        /*  
         Set<Integer> numeros = new HashSet<Integer>();
         while (numeros.size() < 100) {
         numeros.add(1 + (int) (Math.random() * 100));
         }

         System.out.println("Números" + numeros);
    
         }
         */
        /*
         ArrayList<Integer> myList = new ArrayList<Integer>();
         for (int i = 1; i <= 100; i++) {
         myList.add(i);
         }
         Collections.shuffle(myList);
         System.out.println("Números" + myList);
         */
        Integer[] vetor = new Integer[100];

        for (int i = 0; i < 100; i++) {
            vetor[i] = (int) (1 + (Math.random() * 100));
        }
        for (int i = 0; i < 100; i++) {
            System.out.print(vetor[i]+" ");
        }
        ImprimirNumeroDeNucleosCPU.sort(vetor);
         System.out.println(" ");
         System.out.println(Arrays.toString(vetor));
    }
}
