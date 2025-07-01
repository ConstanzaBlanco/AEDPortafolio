package org.example.UT6_PD1_PD5.tdas.PD1;

import java.io.Serializable;
import java.util.LinkedList;


public class TTrieHashMap implements IArbolTrie, Serializable {

    private TNodoTrieHashMap raiz;

    @Override
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrieHashMap();
        }
        raiz.insertar(palabra);
    }

    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    @Override
    public int buscar(String palabra) {
        return raiz.buscar(palabra);
    }

    @Override
    public LinkedList<String> predecir(String prefijo) {
        if (raiz != null) {
            LinkedList<String> palabras = new LinkedList<>();
            raiz.predecir(prefijo, palabras);
            return palabras;
        }
        return null;
    }
}
