/*
Wesley Assis
 */
package MatematicaDiscreta;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class InserctionSortMergeSort {

    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK

    private static long trocas = 0;
    private static long comparacao = 0;

    public static void main(String[] args) {
        int[] v = new int[50];
        long inicio = 0;
        long fim = 0;
        long troca;

        Set<Integer> numeros = new HashSet<>();
        Random gerador = new Random();
        inicio = System.currentTimeMillis();//tempo inicial

        while (numeros.size() < v.length) {
            int num = 0;
            num = gerador.nextInt();
            numeros.add(num);
        }
        for (int i = 0; i < v.length; i++) {
            v[i] = (int) numeros.toArray()[i];
        }
        System.out.println("");
        System.out.println("MergeSort Recursivo -> ENTRADA:" + YELLOW_BOLD + "10.000 \n");
        troca = mergeSortAndCount(v, 1, v.length - 1);
        System.out.println(YELLOW_BOLD + "troca: " + troca);

        fim = System.currentTimeMillis();//tempo final
        System.out.println(BLACK_BOLD + "O tempo para ordenar foi de: " + (fim - inicio) + " milisegundos \n");
        System.out.println(GREEN_BOLD + "O tempo para ordenar foi de: " + ((fim - inicio) / 1000) + " segundos \n");
        System.out.println(GREEN_BOLD + "O tempo para ordenar foi de: " + ((fim - inicio) / 60000) + " minutos \n");
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + "\n");

        }
        while (numeros.size() < v.length) {
            int num = 0;
            num = gerador.nextInt();
            numeros.add(num);
        }
        for (int i = 0; i < v.length; i++) {
            v[i] = (int) numeros.toArray()[i];
        }

        ordena(v, 0);
        System.out.println("InserctionSort Recursivo -> ENTRADA:" + YELLOW_BOLD + "10.000 \n");
        System.out.println(GREEN_BOLD + "Trocas: " + trocas);
        System.out.println(YELLOW_BOLD + "Comparação: " + comparacao);

        fim = System.currentTimeMillis();//tempo final

        System.out.println(BLACK_BOLD + "O tempo para ordenar foi de: " + (fim - inicio) + " milisegundos \n");
        System.out.println(RED_BOLD + "O tempo para ordenar foi de: " + ((fim - inicio) / 1000) + " segundos \n");
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + "\n");

        }
    }

    // Função para contar o número de inversões
    // durante o processo de mesclagem
    private static long mergeAndCount(int[] vetor, int a, int b, int c) {

        // Subarray esquerdo
        int[] esquerda = Arrays.copyOfRange(vetor, a, b + 1);

        // Subarray direito
        int[] direita = Arrays.copyOfRange(vetor, b + 1, c + 1);

        int i = 0, j = 0, k = a;
        long trocas = 0;

        while (i < esquerda.length && j < direita.length) {
            if (esquerda[i] <= direita[j]) {
                vetor[k++] = esquerda[i++];
            } else {
                vetor[k++] = direita[j++];
                trocas += (b + 1) - (a + i);
            }
        }
        while (i < esquerda.length) {
            vetor[k++] = esquerda[i++];
        }
        while (j < direita.length) {
            vetor[k++] = direita[j++];
        }
        return trocas;

    }

    //Função de ordenação de mesclagem
    private static long mergeSortAndCount(int[] vetor, int a,
            int c) {

        // Mantém o controle da contagem de inversão em um
        // nó particular da árvore de recursão
        long count = 0;

        if (a < c) {
            int b = (a + c) / 2;

            // Contagem total de inversão = contagem do subarray esquerdo
            // + contagem de submatriz direita + contagem de mesclagem
            // Contagem do subarray esquerdo
            count += mergeSortAndCount(vetor, a, b);

            // Contagem do subarray direito
            count += mergeSortAndCount(vetor, b + 1, c);

            // Contagem de mesclagem
            count += mergeAndCount(vetor, a, b, c);
        }

        return count;
    }

    public static void ordena(int[] v, int i) {

        if (i == v.length) {
            return;
        }

        for (int c = i; c > 0; c--) {
            if (v[c - 1] > v[c]) {
                int aux = v[c - 1];
                v[c - 1] = v[c];
                v[c] = aux;
                trocas++;
            }

            comparacao++;  //condição de loop verdadeira
        }
        ordena(v, ++i);
        comparacao++; // verificando a condição do loop quando false

    }
}
