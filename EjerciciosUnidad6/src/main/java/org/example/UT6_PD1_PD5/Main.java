package org.example.UT6_PD1_PD5;

import org.example.UT6_PD1_PD5.tdas.PD1.Medible;
import org.example.UT6_PD1_PD5.tdas.PD1.Medicion;
import org.example.UT6_PD1_PD5.tdas.PD1.MedicionBuscarTrie;
import org.example.UT6_PD1_PD5.tdas.PD1.TTrieHashMap;
import org.example.utils.ManejadorArchivosGenerico;

import java.util.LinkedList;

public class Main {

    private static final int REPETICIONES = 1;

    public static void main(String[] args){
        TTrieHashMap trie = new TTrieHashMap();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("src/main/java/org/example/UT6_PD1_PD5/tas/palabras.txt");

        // Inserto las palabras
        for (String p : palabrasclave) {
            trie.insertar(p);
        }

        trie.imprimir();

        System.out.println("Prefijo casa: ");
        LinkedList lista = trie.predecir("casa");
        for (Object o : lista) {
            System.out.println(o);
        }

        System.out.println("Prefijo p: ");
        LinkedList lista2 = trie.predecir("p");
        for (Object o : lista2) {
            System.out.println(o);
        }

        System.out.println("Prefijo vacio: ");
        LinkedList lista3 = trie.predecir("");
        for (Object o : lista3) {
            System.out.println(o);
        }

        //Medir la busqueda
        TTrieHashMap trieMedible= new TTrieHashMap();
        String[] palabrasInsertar= ManejadorArchivosGenerico.leerArchivo("src/main/java/org/example/UT6_PD1_PD5/tas/palabras.txt");
        for (String p : palabrasclave) {
            trieMedible.insertar(p);
        }

        Medible[] medibles = new Medible[1];
        medibles[0]=new MedicionBuscarTrie(trieMedible);

        Medicion mi;
        int i=0;
        Object[] params = {REPETICIONES, palabrasInsertar};
        String[] lineas = new String[3];
        lineas[i++] = "algoritmo,tiempo,memoria";
        mi= medibles[0].medir(params);
        System.out.println(mi.toString());
        lineas[i++] = mi.getTexto()+","+mi.getTiempoEjecucion().toString()+","+mi.getMemoria().toString();
//        Con Hash:
//        Medicion: MedicionBuscarTrie - Consumo de memoria=2102 Bytes , tiempo de ejecución =3482500 nanosecs
//        Sin Hash:
//        Medicion: MedicionBuscarTrie - Consumo de memoria=10450655 Bytes , tiempo de ejecución =777600 nanosecs

        //Implementando Trie con HasMap consume mucha menos memoria, pero demora mucho mas al buscar claves
    }



}
