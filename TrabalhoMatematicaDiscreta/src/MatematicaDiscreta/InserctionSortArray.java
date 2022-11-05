/*

Wesley Assis

*/
package MatematicaDiscreta;

public class InserctionSortArray {

    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK

    public static int Trocas = 0;
    public static int Comparacao = 0;

    public static void main(String[] args) {
        int[] v = new int[16];
        long inicio = 0;
        long fim = 0;
        int troca;
        int[] arr = {12, 72, 26, 54, 98, 73, 0, 59, 30, 25, 60, 10, 66, 32, 1, 2};

        inicio = System.currentTimeMillis();//tempo inicial

        System.out.println("InserctionSort -> ENTRADA:" + YELLOW_BOLD + "{12,72,26,54,98,73,0,59,30,25,60,10,66,32,1,2} \n");
        ordena(arr, 0);
        System.out.println(GREEN_BOLD + "Trocas: " + Trocas);
        System.out.println(YELLOW_BOLD + "Comparação: " + Comparacao);

        fim = System.currentTimeMillis();//tempo final
        System.out.println(GREEN_BOLD + "O tempo para ordenar foi de: " + (fim - inicio) + " milisegundos \n");

        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + "\n");

        }

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
                Trocas++;
            }

            Comparacao++;  //condição de loop verdadeira
        }
        ordena(v, ++i);
        Comparacao++; // verificando a condição do loop quando false

    }

}

