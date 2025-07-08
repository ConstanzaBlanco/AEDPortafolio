package PD1;

import java.util.Random;

public class GeneradorDatosGenericos {
    private static int TAMANIO_MAX = 32000;
    public int[] generarDatosAleatorios(Integer cantDatos) {
        if(cantDatos==null){
            cantDatos=32000;
        }
        Random rnd = new Random();
        int[] datosGenerados = new int[cantDatos];
        boolean[] datosUtilizados = new boolean[cantDatos];
        for (int i = 0; i < datosGenerados.length; i++) {
            int j = rnd.nextInt(cantDatos);
            while(datosUtilizados[j]){
                j = (j + 1) % cantDatos;
            }
            datosGenerados[j] = i;
            datosUtilizados[j] = true;
        }
        return datosGenerados;
    }

    public int[] generarDatosAscendentes(Integer cantDatos) {
        int [] copiaAscendente = new int[cantDatos];
        for (int i = 0; i < cantDatos; i++) {
            copiaAscendente[i] = i;
        }
        return copiaAscendente;
    }

    public int[] generarDatosDescendentes(Integer cantDatos) {
        int [] copiaDescendente = new int[cantDatos];
        for (int i = 1; i < cantDatos; i++) {
            copiaDescendente[i] = cantDatos - i;
        }
        return copiaDescendente;
    }

}
