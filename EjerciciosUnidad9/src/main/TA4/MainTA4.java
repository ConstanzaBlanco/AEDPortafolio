package TA4;

import PD1.GeneradorDatosGenericos;
import PD1.TClasificador;

public class MainTA4 {

    static int profundidadActual = 0;
    static int maximaProfundidad = 0;

    public static void main(String[] args) {
        TClasificador clasif = new TClasificador();
        GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();

        int[] tamanios = {300, 10000};

        for (int n : tamanios) {
            int[] aleatorio = gdg.generarDatosAleatorios(n);
            int[] ascendente = gdg.generarDatosAscendentes(n);
            int[] descendente = gdg.generarDatosDescendentes(n);

            System.out.println("\n=======================");
            System.out.println("Tamaño del vector: " + n);

            probarQuickSort(clasif, aleatorio.clone(), "Aleatorio", "Media");
            probarQuickSort(clasif, aleatorio.clone(), "Aleatorio", "2Prim");
            probarQuickSort(clasif, aleatorio.clone(), "Aleatorio", "Central");

            probarQuickSort(clasif, ascendente.clone(), "Ascendente", "Media");
            probarQuickSort(clasif, ascendente.clone(), "Ascendente", "2Prim");
            probarQuickSort(clasif, ascendente.clone(), "Ascendente", "Central");

            probarQuickSort(clasif, descendente.clone(), "Descendente", "Media");
            probarQuickSort(clasif, descendente.clone(), "Descendente", "2Prim");
            probarQuickSort(clasif, descendente.clone(), "Descendente", "Central");
        }
    }

    private static void probarQuickSort(TClasificador clasif, int[] datos, String tipo, String pivote) {
        profundidadActual = 0;
        maximaProfundidad = 0;

        long inicio = System.nanoTime();
        quicksort(clasif, datos, 0, datos.length - 1, pivote);
        long fin = System.nanoTime();

        double tiempoMs = (fin - inicio) / 1e6;
        boolean ordenado = clasif.estaOrdenado(datos);
        int log = (int) (Math.log(datos.length) / Math.log(2));

        System.out.printf("-11s con pivote -7s -> Ordenado: 5s | Tiempo: 8.3f ms | Profundidad: 3d (log2=2d)\n",
                tipo, pivote, ordenado, tiempoMs, maximaProfundidad, log);
    }

    private static void quicksort(TClasificador clasif, int[] entrada, int i, int j, String pivoteMetodo) {
        int izquierda = i;
        int derecha = j;

        int posicionPivote;
        if (pivoteMetodo.equals("2Prim")) {
            posicionPivote = clasif.encuentraPivote2Prim(izquierda, derecha, entrada);
        } else if (pivoteMetodo.equals("Central")) {
            posicionPivote = clasif.encuentraPivoteElemCentral(izquierda, derecha, entrada);
        } else { // "Media"
            posicionPivote = clasif.encuentraPivoteMedia(izquierda, derecha, entrada);
        }

        if (posicionPivote >= 0) {
            int pivote = entrada[posicionPivote];
            while (izquierda < derecha) {
                while ((entrada[izquierda] < pivote) && (izquierda < j)) izquierda++;
                while ((pivote < entrada[derecha]) && (derecha > i)) derecha--;
                if (izquierda <= derecha) {
                    clasif.intercambiar(entrada, derecha, izquierda);
                    izquierda++;
                    derecha--;
                }
            }
            profundidadActual++;
            maximaProfundidad = Math.max(maximaProfundidad, profundidadActual);
            if (i < derecha) quicksort(clasif, entrada, i, derecha, pivoteMetodo);
            if (izquierda < j) quicksort(clasif, entrada, izquierda, j, pivoteMetodo);
            profundidadActual--;
        }
    }
}

