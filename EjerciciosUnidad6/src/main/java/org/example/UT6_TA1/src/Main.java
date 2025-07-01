/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.UT6_TA1.src;

import org.example.utils.ManejadorArchivosGenerico;

/**
 * @author jechague
 */
public class Main {

    /**
     * @param args the command line arguments
     */


    public static void main(String[] args) {

        // Crear una tabla de tipo THash e insertar las claves del archivo "claves_insertar.txt"
        THash<String, String> tabla = new THash<>(200, 0.7f);
        String[] elementos = ManejadorArchivosGenerico.leerArchivo("src/main/java/org/example/UT6_TA1/src/claves_insertar.txt");
        for (String elemento : elementos) {
            tabla.insertar(elemento, elemento);
        }
        System.out.println("Imprimo la tabla:");
        tabla.imprimirTabla();

        // Buscar en la tabla creada anteriormente las claves indicadas en el archivo "claves_buscar.txt"
        System.out.println("Busco los elementos:");
        String[] buscadas = ManejadorArchivosGenerico.leerArchivo("src/main/java/org/example/UT6_TA1/src/claves_buscar.txt");
        String[] resultados = new String[buscadas.length];
        for (int i = 0; i < buscadas.length; i++) {
            String elemento = buscadas[i];
            if (elemento != null && elemento != "") {
                String resultado = tabla.buscar(elemento);
                if (resultado != null) {
                    String linea = "true: " + elemento;
                    resultados[i] = linea;
                    System.out.println(linea);
                } else {
                    String linea = "false: " + elemento;
                    resultados[i] = linea;
                    System.out.println(linea);
                }
            }
        }
        ManejadorArchivosGenerico.escribirArchivo("resultadosBusqueda", resultados);

        //THash com comparaciones
        int cantClaves = ManejadorArchivosGenerico.leerArchivo("src/main/java/org/example/UT6_TA1/src/claves_insertar.txt").length;
        THash<String, String> tablaComp = new THash<>(cantClaves, 0.99f);

        String[] clavesInsertar = ManejadorArchivosGenerico.leerArchivo("src/main/java/org/example/UT6_TA1/src/claves_insertar.txt");

        int totalComparacionesInsertar = 0;
        for (String clave : clavesInsertar) {
            totalComparacionesInsertar += tablaComp.insertarComparaciones(clave, clave);
        }

        //buscarComparaciones
        String[] clavesBuscar = ManejadorArchivosGenerico.leerArchivo("src/main/java/org/example/UT6_TA1/src/claves_buscar.txt");

        int totalComparacionesExitosas = 0;
        int cantExitosas = 0;
        int totalComparacionesNoExitosas = 0;
        int cantNoExitosas = 0;

        for (String clave : clavesBuscar) {
            int comparaciones = tablaComp.buscarComparaciones(clave);
            String resultado = tablaComp.buscar(clave);
            if (resultado != null) {
                cantExitosas++;
                totalComparacionesExitosas += comparaciones;
                System.out.println("true: " + clave);
            } else {
                cantNoExitosas++;
                totalComparacionesNoExitosas += comparaciones;
                System.out.println("false: " + clave);
            }
        }

        System.out.println("Promedio comparaciones al insertar: " +
                (totalComparacionesInsertar / (float) clavesInsertar.length));

        float promedioExitosas = 0;
        if (cantExitosas > 0) {
            promedioExitosas = totalComparacionesExitosas / (float) cantExitosas;
        }
        System.out.println("Promedio comparaciones búsquedas exitosas: " + (promedioExitosas));

        float promedioNoExitosas = 0;
        if (cantNoExitosas > 0) {
            promedioNoExitosas = totalComparacionesNoExitosas / (float) cantNoExitosas;
        }
        System.out.println("Promedio comparaciones búsquedas no exitosas: " + (promedioNoExitosas));
    }

}
