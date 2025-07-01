package org.example.UT5_PD2.tdas;

import java.util.LinkedList;


public class TArbolTrie implements IArbolTrie {

    private TNodoTrie raiz;

    @Override
    public void insertar(String palabra,String pag) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra,pag);
    }

    public LinkedList<String> buscarPaginas(String unaPalabra){
        if(raiz==null){
            System.out.println("El índice está vacío");
            return null;
        }
        LinkedList<String> list=raiz.buscarPaginas(unaPalabra);
        if(list==null){
            System.out.println("La palabra "+ unaPalabra+ " no está en el Libro");
            return null;
        }
        return list;
    }

    public LinkedList<String> predecir(String text) {
        return null;
    }
}
