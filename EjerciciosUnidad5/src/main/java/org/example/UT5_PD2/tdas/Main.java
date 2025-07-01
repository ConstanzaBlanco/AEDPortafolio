package org.example.UT5_PD2.tdas;
import org.example.utils.ManejadorArchivosGenerico;

import java.util.LinkedList;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();
        trie.insertar("Ala","1");
        trie.insertar("Ala","3");
        trie.insertar("Ala","88");
        trie.insertar("Alimana","11");
        trie.insertar("Alimana","22");
        trie.insertar("Alabastro","4");
        trie.insertar("Perro","5");
        trie.insertar("Perro","8");
        trie.insertar("Pera","7");
        trie.insertar("Pera","12");
        trie.insertar("Alimento","9");
        trie.insertar("Casa","11");
        trie.insertar("Casa","13");
        trie.insertar("Casada","1");
        trie.insertar("Cazar","33");
        trie.insertar("Programa","22");
        trie.insertar("Programa","67");
        trie.insertar("Programación","15");
        trie.insertar("Programar","15");
        trie.insertar("Programar","16");
        LinkedList<String> lista=trie.buscarPaginas("ala");
        if(lista!=null) {
            for (String p : lista) {
                System.out.println(p);
            }
        }

        LinkedList<String> lista2=trie.buscarPaginas("gato");
        if(lista2!=null){
            for(String p: lista2){
                System.out.println(p);
            }
        }

        /*
        3. Responde las siguientes preguntas:
            • ¿Cuántas comparaciones realiza el algoritmo de búsqueda si el argumento es “Programa”?
                    8 comparaciones, una por cada letra.
            • ¿Cuántas comparaciones realiza el algoritmo de búsqueda si el argumento es “Proselitismo?
                    4 comparaciones, en la letra 4 ( la s) como no hay hijo s entonces ahí para la búsqueda
            • ¿Cuántas comparaciones se realizan para insertar la palabra “cazadores”?
                    Comparaciones totales va a ser el número de letras ya existentes, que es 4, despues
                    ya inserta el resto de letras
            • ¿cuál es la altura del árbol trie resultante?
                    Su altura es el largo de la palabra más larga, la cual es Programación con 12 letras
                    por lo tanto su altura es 12.
            • ¿cuál es su tamaño?
                    Su tamaño es de 46 nodos
         */
    }
}