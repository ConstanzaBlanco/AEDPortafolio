package TA8;

import PD1.GeneradorDatosGenericos;
import TA7.TClasificador;


public class MainTA8 {

    public static void main(String[] args) {
        TClasificador clasif = new TClasificador();
        GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();

        int[] tamanios = {300, 3000, 30000};
        int[] metodos = {
                TClasificador.METODO_CLASIFICACION_BURBUJA,
                TClasificador.METODO_CLASIFICACION_QUICKSORT,
                TClasificador.METODO_CLASIFICACION_HEAP,
        };

        String[] nombresMetodos = {"Burbuja", "Quicksort", "Heapsort"};

        for (int n : tamanios) {
            int[] aleatorio = gdg.generarDatosAleatorios(n);
            int[] ascendente = gdg.generarDatosAscendentes(n);
            int[] descendente = gdg.generarDatosDescendentes(n);

            System.out.println("\n\n--- Tamaño: " + n + " ---");

            for (int m = 0; m < metodos.length; m++) {
                int metodo = metodos[m];
                String nombre = nombresMetodos[m];

                ejecutarYMedir(clasif, aleatorio.clone(), "Aleatorio", metodo, nombre);
                ejecutarYMedir(clasif, ascendente.clone(), "Ascendente", metodo, nombre);
                ejecutarYMedir(clasif, descendente.clone(), "Descendente", metodo, nombre);
            }
        }
    }

    private static void ejecutarYMedir(TClasificador clasif, int[] datos, String tipoDatos, int metodo, String nombreMetodo) {
        long inicio = System.nanoTime();
        int[] resultado = clasif.clasificar(datos, metodo);
        long fin = System.nanoTime();
        double tiempoMs = (fin - inicio) / 1e6;

        boolean ordenado = TClasificador.estaOrdenado(resultado);
        System.out.printf("-10s | -10s | Tiempo: 8.3f ms | Ordenado: s\n",
                nombreMetodo, tipoDatos, tiempoMs, ordenado ? "Sí" : "No");
    }
}
