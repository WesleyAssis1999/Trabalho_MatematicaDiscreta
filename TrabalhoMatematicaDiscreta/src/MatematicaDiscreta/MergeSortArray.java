/*

Wesley Assis

*/
package MatematicaDiscreta;

public class MergeSortArray {

    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
     static int Cont = 0;

    public static void main(String[] args) {
        int[] v = new int[16];
        long inicio = 0;
        long fim = 0;
        int troca;
        int[] arr = {12, 72, 26, 54, 98, 73, 0, 59, 30, 25, 60, 10, 66, 32, 1, 2};

        inicio = System.currentTimeMillis();//tempo inicial

    
        System.out.println("MergeSort Recursivo -> ENTRADA:" + YELLOW_BOLD + "{12,72,26,54,98,73,0,59,30,25,60,10,66,32,1,2} \n");
        mergeSort(arr,arr.length);
        System.out.println(YELLOW_BOLD + "troca: " + Cont);

        fim = System.currentTimeMillis();//tempo final
        System.out.println(GREEN_BOLD + "O tempo para ordenar foi de: " + (fim - inicio) + " milisegundos \n");

        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + "\n");

        }

    }

    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }

        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
                Cont++;
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }

    }
}
