package org.example.UT5_PD1.tdas;

import java.util.LinkedList;


public class TArbolTrie<T> implements IArbolTrie<T> {

    TNodoTrie<T> raiz;

    public TNodoTrie<T> getRaiz(){
        return this.raiz;
    }

    @Override
    public boolean insertar(String unaEtiqueta, String etiquetaPadre) {
        if (raiz == null && etiquetaPadre == "") {
            raiz=new TNodoTrie<>(unaEtiqueta,(T) unaEtiqueta);
            return true;
        }
        if(etiquetaPadre != ""){
           return raiz.insertar(unaEtiqueta,etiquetaPadre);
        }
        return false;
    }

    @Override
    public boolean buscar(String unaEtiqueta) {
        if(raiz==null){
            return false;
        }
        TNodoTrie<T> nodo=raiz.buscar(unaEtiqueta);
        if(nodo==null){
            return false;
        }
        return true;

    }

    @Override
    public void listarIndentado() {
        if(raiz==null){
            System.out.println("El Arbol está vacío");
            return;
        }
        raiz.listarIndentado(0);
    }

    @Override
    public boolean modificarDatos(String etiqueta, T nuevosDatos) {
        if (raiz == null) return false;
        TNodoTrie<T> nodo = raiz.buscar(etiqueta);
        if (nodo != null) {
            nodo.setDatos(nuevosDatos);
            return true;
        }
        return false;
    }
}
