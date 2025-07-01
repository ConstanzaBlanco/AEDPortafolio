package org.example.UT6_PD3;

import org.example.utils.ManejadorArchivosGenerico;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Main {

    public static void main(String[] args) {
        //Ejercicio 1
        Map<String,String> map= new HashMap<>();
        map.values().removeIf(v -> v == null);

        //Ejercicio 3
        ListaOrdenada<String > lista= new ListaOrdenada<>();
        lista.insertar("hola","hola");
        lista.insertar("ola","ola");
        lista.insertar("palabra","palabra");
        lista.insertar("arbalap","arbalap");

        //Ejercicio 4
        System.out.println("Lineas aleatorias: ");
        imprimirLineasAleatorias("src/main/java/org/example/UT6_PD3/PalabrasRandom",3);



    }

    //Ejericio 2
    public Map<String,String> intercambiarClaveValor(Map<String,String> map){
        Map<String,String> nuevo= new HashMap<>();
        for(String key: map.keySet()){
            String value= map.get(key);
            nuevo.put( value,  key);
        }
        return nuevo;
    }

    //Ejercicio 4
    public static void imprimirLineasAleatorias(String nombreArchivo, int cantidadLineas){
        String[] lineas= ManejadorArchivosGenerico.leerArchivo(nombreArchivo);
        Random random = new Random();
        for(int i=0; i<cantidadLineas;i++){
            int numeroAleatorio = random.nextInt(lineas.length);
            System.out.println(lineas[numeroAleatorio]);
        }
    }

}
