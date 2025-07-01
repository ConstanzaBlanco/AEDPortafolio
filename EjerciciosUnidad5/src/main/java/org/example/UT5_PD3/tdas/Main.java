package org.example.UT5_PD3.tdas;

import org.example.utils.ManejadorArchivosGenerico;

import java.util.LinkedList;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrie arbol= new TArbolTrie();
        String[] indice= ManejadorArchivosGenerico.leerArchivo("src/main/java/org/example/UT5_PD3/tas/PalabrasIndice.txt");
        for(String palabra: indice){
            arbol.insertar(palabra,"");
        }
        arbol.indizarLibro("src/main/java/org/example/UT5_PD3/tas/libro.txt");
        arbol.imprimirIndice();
    }
}