package org.example.UT6_PD1_PD5.tdas.PD1;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

public class TNodoTrieHashMap implements INodoTrie, Serializable {

    private HashMap<Character, TNodoTrieHashMap> hijos;
    private boolean esPalabra;

    public TNodoTrieHashMap() {
        hijos = new HashMap<>();
        esPalabra = false;
    }

    public String normalizar(String unaPalabra) {
        unaPalabra = unaPalabra.toLowerCase();
        String nuevaPalabra = "";

        for (char letra : unaPalabra.toCharArray()) {
            switch (letra) {
                case 'á':
                    letra = 'a';
                    break;
                case 'é':
                    letra = 'e';
                    break;
                case 'í':
                    letra = 'i';
                    break;
                case 'ó':
                    letra = 'o';
                    break;
                case 'ú':
                    letra = 'u';
                    break;
            }
            nuevaPalabra += letra;
        }

        return nuevaPalabra;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrieHashMap nodoActual = this;
        for (char c : unaPalabra.toCharArray()) {
            nodoActual.hijos.putIfAbsent(c, new TNodoTrieHashMap());
            nodoActual = nodoActual.hijos.get(c);
        }
        nodoActual.esPalabra = true;
    }

    private void imprimir(String s, TNodoTrieHashMap nodo) {
        if (nodo.esPalabra) {
            System.out.println(s);
        }
        for (Character c : nodo.hijos.keySet()) {
            imprimir(s+c, nodo.hijos.get(c));
        }
    }



    @Override
    public void imprimir() {
        imprimir("", this);
    }
    
     private void predecirOtro(String s, LinkedList<String> palabras) {
        if(this.esPalabra){
            palabras.add(s.toString());
        }
        for(Character c: hijos.keySet()){
            hijos.get(c).predecirOtro(s + c,palabras);
        }
    }

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrieHashMap nodo = this;
        for (char c : prefijo.toCharArray()) {
            if(!nodo.hijos.containsKey(c)){
                return;
            }
            nodo= nodo.hijos.get(c);
        }
        nodo.predecirOtro(prefijo,palabras);
    }

    @Override
    public int buscar(String s) {
        int comparaciones=0;
        TNodoTrieHashMap nodo = this;
        String palabra = normalizar(s);
        for (int c = 0; c < palabra.length(); c++) {
            comparaciones++;
            if (nodo.hijos.get(c) == null) {
                return 0;
            }
            nodo = nodo.hijos.get(c);

        }
        if(nodo.esPalabra) {
            return comparaciones;
        }
        return 0;
    }
  
}
