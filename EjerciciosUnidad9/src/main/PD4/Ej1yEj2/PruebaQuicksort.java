package PD4.Ej1yEj2;

import java.util.Arrays;
import java.util.Random;

public class PruebaQuicksort {

    public static void main(String[] args) {
        final int N = 100_000;
        int[] arrRandom = generarArrayAleatorio(N);

        probar("Pivote Fijo", arrRandom, PruebaQuicksort::quicksortPivoteFijo);
        probar("Pivote Aleatorio", arrRandom, PruebaQuicksort::quicksortPivoteAleatorio);
        probar("Mediana de Tres", arrRandom, PruebaQuicksort::quicksortMedianaTres);

    }

    static void probar(String nombre, int[] original, ConsumerQS qs) {
        int[] copia = Arrays.copyOf(original, original.length);
        long inicio = System.nanoTime();
        qs.sort(copia, 0, copia.length - 1);
        long fin = System.nanoTime();
        System.out.printf("%-30s Tiempo: %.2f ms%n", nombre, (fin - inicio) / 1e6);
    }

    static void quicksortPivoteFijo(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int p = partitionFijo(a, lo, hi);
        quicksortPivoteFijo(a, lo, p - 1);
        quicksortPivoteFijo(a, p + 1, hi);
    }

    static void quicksortPivoteAleatorio(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int p = partitionAleatorio(a, lo, hi);
        quicksortPivoteAleatorio(a, lo, p - 1);
        quicksortPivoteAleatorio(a, p + 1, hi);
    }

    static void quicksortMedianaTres(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int p = partitionMedianaTres(a, lo, hi);
        quicksortMedianaTres(a, lo, p - 1);
        quicksortMedianaTres(a, p + 1, hi);
    }

    // Particiones

    static int partitionFijo(int[] a, int lo, int hi) {
        int pivot = a[lo];
        int i = lo + 1, j = hi;
        while (i <= j) {
            while (i <= hi && a[i] <= pivot) i++;
            while (a[j] > pivot) j--;
            if (i < j) swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

    static int partitionAleatorio(int[] a, int lo, int hi) {
        int r = new Random().nextInt(hi - lo + 1) + lo;
        swap(a, lo, r);
        return partitionFijo(a, lo, hi);
    }

    static int partitionMedianaTres(int[] a, int lo, int hi) {
        int mid = (lo + hi) / 2;
        int pivotIndex = medianaIndice(a, lo, mid, hi);
        swap(a, lo, pivotIndex);
        return partitionFijo(a, lo, hi);
    }

    static int medianaIndice(int[] a, int i, int j, int k) {
        int ai = a[i], aj = a[j], ak = a[k];
        if ((ai > aj) == (ai < ak)) return i;
        else if ((aj > ai) == (aj < ak)) return j;
        else return k;
    }

    static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    static int[] generarArrayAleatorio(int n) {
        Random r = new Random();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = r.nextInt(n);
        return a;
    }

    interface ConsumerQS {
        void sort(int[] arr, int lo, int hi);
    }

    public static class PruebaShellSort {

        public static void main(String[] args) {
            int n = 1000;
            int[] original = generarArregloAleatorio(n);

            probar("Ciura", original, generarCiura());
            probar("Tokuda", original, generarTokuda(n));
            probar("Sedgewick", original, generarSedgewick(n));
        }

        private static void probar(String nombre, int[] original, int[] incrementos) {
            int[] copia = Arrays.copyOf(original, original.length);
            // Mido tiempo en milisegundos, pasamos de lo teórico a lo experimental
            long start = System.nanoTime();
            shellSort(copia, incrementos);
            long end = System.nanoTime();
            System.out.printf("%-18s: %.3f ms%n", nombre, (end - start) / 1e6);
        }

        private static void shellSort(int[] arr, int[] gaps) {
            for (int gap : gaps) {
                for (int i = gap; i < arr.length; i++) {
                    int temp = arr[i];
                    int j = i;
                    while (j >= gap && arr[j - gap] > temp) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }

        private static int[] generarArregloAleatorio(int n) {
            Random rnd = new Random(48);
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = rnd.nextInt(10_000);
            return arr;
        }

        private static int[] generarCiura() {
            return new int[]{701, 301, 132, 57, 23, 10, 4, 1};
        }

        private static int[] generarTokuda(int n) {
            int[] gaps = new int[40];
            int k = 0;
            for (int i = 1;; i++) {
                int h = (int) Math.ceil((Math.pow(9.0 / 4, i) - 1) / (9.0 / 4 - 1));
                if (h >= n) break;
                gaps[k++] = h;
            }
            return invertir(gaps, k);
        }

        /**
         * Una joyita de secuencia
         * @param n: largo del array
         * @return secuencia de largo suficiente
         */
        private static int[] generarSedgewick(int n) {
            int[] gaps = new int[40];
            int k = 0;
            int i = 0;
            while (true) {
                int g1 = (int) (Math.pow(4, i + 1) + 3 * Math.pow(2, i) + 1);
                if (g1 >= n) break;
                gaps[k++] = g1;
                i++;
            }
            return invertir(gaps, k);
        }

        private static int[] generarGamma(int n, double gamma) {
            int[] gaps = new int[40];
            int k = 0;
            int g = 1;
            while (g < n) {
                gaps[k++] = g;
                g = (int) Math.floor(g * gamma);
            }
            return invertir(gaps, k);
        }

        private static int[] invertir(int[] original, int length) {
            int[] invertido = new int[length];
            for (int i = 0; i < length; i++) {
                invertido[i] = original[length - i - 1];
            }
            return invertido;
        }
    }
}
