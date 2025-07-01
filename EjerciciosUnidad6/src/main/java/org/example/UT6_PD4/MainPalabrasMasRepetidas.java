package org.example.UT6_PD4;

import org.example.utils.ManejadorArchivosGenerico;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class MainPalabrasMasRepetidas {
    public static void main(String[] args) {
        Map<String, Integer> map = InsertarFrecuenciasPalabras("src/main/java/org/example/UT6_PD4/libro.txt");
        for (String clave : map.keySet()) {
            System.out.println(clave + " : " + map.get(clave));
        }

        Map<String,Integer> mapNuevo=new HashMap(map);
        System.out.println("10 palabras mas repetidas: ");
        String[] palabrasOcurrentes = new String[10];
        for(int i=0; i<palabrasOcurrentes.length; i++){
            palabrasOcurrentes[i]=palabraMasRepetida(mapNuevo);
            System.out.println(i+"- "+palabrasOcurrentes[i]+":"+map.get(palabrasOcurrentes[i]));
        }

    }

    public static Map<String, Integer> InsertarFrecuenciasPalabras(String nombreArchivo) {
        Map<String, Integer> map= new HashMap<>();
        String[] lineas= ManejadorArchivosGenerico.leerArchivo(nombreArchivo);
        for(String linea: lineas){
            String[] palabras=linea.split(" ");
            for(String palabra: palabras){
                palabra=palabra.toLowerCase();
                if(map.get(palabra)==null){
                    map.put(palabra,1);
                }
                else{
                    Integer repeticiones= map.get(palabra);
                    map.put(palabra,repeticiones+1);
                }
            }
        }
        return map;
    }

    public static String palabraMasRepetida(Map<String, Integer> map) {
        String palabraMayor = null;
        int frecuenciaMax = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > frecuenciaMax) {
                frecuenciaMax = entry.getValue();
                palabraMayor = entry.getKey();
            }
        }
        if (palabraMayor != null) {
            map.remove(palabraMayor);
        }
        return palabraMayor;
    }

}
/*
    Justificacion de la estructura:
    Para contar las frecuencias de palabras, un Map es ideal porque asocia cada palabra
    (clave) con su frecuencia (valor) de forma eficiente. Usando un HashMap, podemos insertar
    y actualizar conteos rápidamente en tiempo constante promedio, lo que es fundamental al
    procesar textos grandes. Además, permite luego ordenar o filtrar fácilmente las palabras
    según su frecuencia. Por eso, un Map es la estructura más adecuada para esta tarea.
     */
