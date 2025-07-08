package TA7;

import PD1.GeneradorDatosGenericos;

public class TClasificador {
    public static final int METODO_CLASIFICACION_INSERCION = 1;
    public static final int METODO_CLASIFICACION_SHELL = 2;
    public static final int METODO_CLASIFICACION_BURBUJA = 3;
    public static final int METODO_CLASIFICACION_QUICKSORT = 4;
    public static final int METODO_CLASIFICACION_HEAP = 5;
    public static final int METODO_CLASIFICACION_CUENTA = 6;


    /**
     * Punto de entrada al clasificador
     *
     * @param metodoClasificacion
     * @param orden
     * @param tamanioVector
     * @return Un vector del tam. solicitado, ordenado por el algoritmo solicitado
     */
    public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion) {
        switch (metodoClasificacion) {
            case METODO_CLASIFICACION_INSERCION:
                return ordenarPorInsercion(datosParaClasificar);
            case METODO_CLASIFICACION_SHELL:
                return ordenarPorShell(datosParaClasificar);
            case METODO_CLASIFICACION_BURBUJA:
                return ordenarPorBurbuja(datosParaClasificar);
            case METODO_CLASIFICACION_QUICKSORT:
                return ordenarPorQuickSort(datosParaClasificar);
            case METODO_CLASIFICACION_HEAP:
                return ordenarPorHeapSort(datosParaClasificar);
            case METODO_CLASIFICACION_CUENTA:
                return cuentaPorDistribucion(datosParaClasificar);
            default:
                System.err.println("Este codigo no deberia haberse ejecutado");
                break;
        }
        return datosParaClasificar;
    }

    public int[] ordenarPorQuickSort(int[] datosParaClasificar) {
        quicksort(datosParaClasificar, 0, datosParaClasificar.length - 1);
        return datosParaClasificar;
    }


    private void quicksort(int[] entrada, int i, int j) {
        int izquierda = i;
        int derecha = j;

        // TODO:Implementar encuentraPivote a criterio de cada equipo
        int posicionPivote = encuentraPivoteMedia(izquierda, derecha, entrada);
        if (posicionPivote >= 0) {
            int pivote = entrada[posicionPivote];
            while (izquierda < derecha) {
                while ((entrada[izquierda] < pivote) && (izquierda < j)) {
                    //izquierda --;
                    izquierda++;
                }

                while ((pivote < entrada[derecha]) && (derecha > i)) {
                    //derecha++;
                    derecha--;
                }

                if (izquierda <= derecha) {
                    intercambiar(entrada, derecha, izquierda);
                    izquierda++;
                    derecha--;
                }
            }

            if (i < derecha)
                //quicksort(entrada, i, izquierda );
                quicksort(entrada, i, derecha);
            if (izquierda < j)
                //quicksort(entrada, derecha, j);
                quicksort(entrada, izquierda, j);
        }
    }

    public static void setMetodoClasificacion(int metodoClasificacion) {
        METODO_CLASIFICACION = metodoClasificacion;
    }

    public static int getMetodoClasificacion() {
        return METODO_CLASIFICACION;
    }

    int encuentraPivoteElemCentral(int izq, int der, int[] entrada) {
        return (izq + der) / 2;
    }

    int encuentraPivote2Prim(int izq, int der, int[] entrada) {
        if (entrada[0] > entrada[1]) {
            return 0;
        } else {
            return 1;
        }

    }


    int encuentraPivoteMedia(int izq, int der, int[] entrada) {
        //Si hay 1 solo elemento no se da el pivote
        int medio = (der + izq) / 2;
        int central = entrada[medio];
        int izquierda = entrada[izq];
        int derecha = entrada[der];
        if (izquierda <= central && central <= derecha || derecha <= central && central <= izquierda) {
            return medio;
        }
        if (central <= izquierda && izquierda <= derecha || derecha <= izquierda && izquierda <= central) {
            return izquierda;
        }
        if (central <= derecha && derecha <= izquierda || izquierda <= derecha && derecha <= central) {
            return derecha;
        }
        return medio;
    }


    void intercambiar(int[] vector, int pos1, int pos2) {
        int temp = vector[pos2];
        vector[pos2] = vector[pos1];
        vector[pos1] = temp;
    }

    /**
     * @param datosParaClasificar
     * @return
     */
    public int[] ordenarPorShell(int[] datosParaClasificar) {
        int j, inc;
        int[] incrementos = new int[]{3223, 358, 51, 10, 3, 1};
        //int posIncrementoActual = 1 Se saltea el primer elemento
        for (int posIncrementoActual = 0; posIncrementoActual < incrementos.length; posIncrementoActual++) {
            inc = incrementos[posIncrementoActual];
            if (inc <= (datosParaClasificar.length / 2)) {
                for (int i = inc; i < datosParaClasificar.length; i++) {
                    j = i - inc;
                    //while (j > 0) Nunca modifica el primer elemento
                    while (j >= 0) {
                        if (datosParaClasificar[j] > datosParaClasificar[j + inc]) {
                            intercambiar(datosParaClasificar, j, j + inc);
                        } else {
                            break;
                        }
                        //j=j--;
                        j = j - inc;
                    }
                }
            }
        }
        return datosParaClasificar;
    }

    /**
     * @param datosParaClasificar
     * @return
     */
    public int[] ordenarPorInsercion(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            //Cambiamos el comeinzo de 2 a 1 en i
            for (int i = 1; i < datosParaClasificar.length; i++) {//Cmabie el comienzo de 2 a 1 en i
                int j = i - 1;
                //Queremos que el valor de la derecha sea mas grande que el de la izquierda, para ordenar los datos ascendentemente
                //por lo tanto el verificar que el de la izquierda es mas chico que el de la derecha no tendría sentido intercambiarlos
                //while ((j >= 0) && (datosParaClasificar[j + 1]>datosParaClasificar[j])
                while ((j >= 0) && (datosParaClasificar[j] > datosParaClasificar[j + 1])) {
                    intercambiar(datosParaClasificar, j, j + 1);
                    j--;
                }
            }
            return datosParaClasificar;
        }
        return null;
    }

    public int[] ordenarPorBurbuja(int[] datosParaClasificar) {
        //datosParaClasificar = null;
        //Esta mal porque no tiene sentido ordenar un array de datos vacio
        int n = datosParaClasificar.length - 1;
        for (int i = 0; i <= n; i++) {
            for (int j = n; j >= (i + 1); j--) {
                if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
                    intercambiar(datosParaClasificar, j - 1, j);
                }
            }
        }
        return datosParaClasificar;
    }

    public static boolean estaOrdenado(int[] lista) {
        for (int i = 0; i < lista.length - 1; i++) {
            if (lista[i] > lista[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public int[] ordenarPorHeapSort(int[] datosParaClasificar) {
        int n = datosParaClasificar.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            armaHeap(datosParaClasificar, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            intercambiar(datosParaClasificar, 0, i);

            armaHeap(datosParaClasificar, i, 0);
        }
        return datosParaClasificar;
    }

    private void armaHeap(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;


        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;


        if (largest != i) {
            intercambiar(arr, i, largest);


            armaHeap(arr, n, largest);
        }
    }

    public int[] cuentaPorDistribucion(int[] arr) {
        int n = arr.length;
        int rango = 10;
        int[] conteo = new int[rango];
        int[] salida = new int[n];

        for (int i = 0; i < n; i++) {
            conteo[arr[i]]++;
        }

        for (int i = 1; i < rango; i++) {
            conteo[i] += conteo[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            salida[conteo[arr[i]] - 1] = arr[i];
            conteo[arr[i]]--;
        }

        return salida;
    }


    public static int METODO_CLASIFICACION = METODO_CLASIFICACION_CUENTA;


    public static void main(String args[]) {
        TClasificador clasif = new TClasificador();
        GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();
        int[] vectorAleatorio = gdg.generarDatosAleatorios(10);
        int[] vectorAscendente = gdg.generarDatosAscendentes(10);
        int[] vectorDescendente = gdg.generarDatosDescendentes(10);

        int[] resAleatorio = clasif.clasificar(vectorAleatorio,
                METODO_CLASIFICACION);
        for (int i = 0; i < resAleatorio.length; i++) {
            System.out.print(resAleatorio[i] + " ");
        }
        System.out.println(resAleatorio);
        System.out.println(estaOrdenado(resAleatorio));
        int[] resAscendente = clasif.clasificar(vectorAscendente,
                METODO_CLASIFICACION);
        for (int i = 0; i < resAscendente.length; i++) {
            System.out.print(resAscendente[i] + " ");
        }
        System.out.println(resAscendente);
        System.out.println(estaOrdenado(resAscendente));
        int[] resDescendente = clasif.clasificar(vectorDescendente,
                METODO_CLASIFICACION);
        for (int i = 0; i < resDescendente.length; i++) {
            System.out.print(resDescendente[i] + " ");
        }
        System.out.println(resDescendente);
        System.out.println(estaOrdenado(resDescendente));
        //Para medir el tiempo
        long inicio = System.nanoTime();
        int[] resultado = clasif.clasificar(vectorAleatorio, METODO_CLASIFICACION);
        long fin = System.nanoTime();
        System.out.println("Tiempo en ns: " + (fin - inicio));
        //Burbuja: 1700
        //Shell: 1700
        //Insercion: 1300
    }
}

/*
1) ¿Cómo se genera un vector ascendente?
Con el método generarDatosAscendentes(). Básicamente mete los números del 0 hasta el tamaño que le pasás, uno detrás del otro.

2) ¿Y uno descendente?
Se usa generarDatosDescendentes(). Arranca desde el número más grande y va bajando. Ojo que empieza desde la posición 1, o sea el primer número queda en 0 (medio raro, se podría corregir).

3) ¿Cómo se generan datos aleatorios? ¿Puede haber repetidos? ¿Y cuánto tarda?
Usa el método generarDatosAleatorios().
Primero tiene todos los números del 0 hasta el que le digas, y los va metiendo en posiciones al azar que estén libres.
No, no hay repetidos.
El tiempo depende, en general es rápido (O(n)), pero si tiene muchas colisiones puede tardar más (O(n²) en el peor caso).

4) ¿Cuántos datos mete el generador? ¿Se puede cambiar eso?
Mete 32.000 por defecto si no le pasás nada.
Pero sí, se puede cambiar. Le pasás el número como parámetro.
Si querés hacerlo más flexible, podrías evitar usar ese valor fijo y manejarlo todo con el parámetro.

5) ¿Cómo se verifica si está ordenado? ¿Cuánto tarda?
Con el método estaOrdenado(). Compara cada número con el que sigue.
Si encuentra uno que es más grande que el de al lado, ya está: no está ordenado.
Es bastante rápido, porque solo lo recorre una vez. O sea, O(n).

 */
