package org.example.UT5_PD1.tdas;

import java.util.LinkedList;

public class TNodoTrie<T> implements INodoTrie<T> {

    private String etiqueta;
    private T datos;
    private TNodoTrie<T> primerHijo;
    private TNodoTrie<T> hermanoDerecho;


    public T getDatos(){
        return datos;
    }

    public void setDatos(T datos){
        this.datos=datos;
    }
    public String getEtiqueta(){
        return this.etiqueta;
    }

    public TNodoTrie(String etiqueta,T datos){
        this.etiqueta=etiqueta;
        this.datos=datos;
        hermanoDerecho=null;
        primerHijo=null;
    }

    @Override
    public boolean insertar(String unaEtiqueta,String etiquetaPadre) {
        if(this.etiqueta.equals(etiquetaPadre)){
            TNodoTrie<T> nuevo= new TNodoTrie<>(unaEtiqueta,(T) etiquetaPadre);
            if (this.primerHijo == null) {
                this.primerHijo = nuevo;
                return true;
            }
            else {
                TNodoTrie<T> actual = this.primerHijo;
                while (actual.hermanoDerecho != null) {
                    actual = actual.hermanoDerecho;
                }
                actual.hermanoDerecho = nuevo;
                return true;
            }
        }
        TNodoTrie<T> actual=this.primerHijo;
        while(actual!=null){
            if (actual.insertar(unaEtiqueta, etiquetaPadre)) {
                return true;
            }
            actual = actual.hermanoDerecho;
        }
        return false;
    }

    @Override
    public TNodoTrie<T> buscar(String unaEtiqueta) {
        if (this.etiqueta.equals(unaEtiqueta)) {
            return this;
        }
        TNodoTrie<T> actual = this.primerHijo;
        while (actual != null) {
            TNodoTrie<T> resultado = actual.buscar(unaEtiqueta);
            if (resultado != null) {
                return resultado;
            }
            actual = actual.hermanoDerecho;
        }
        return null;
    }

    @Override
    public void listarIndentado(int nivel) {
        String indentacion="";
        int contador=0;
        while(contador<nivel){
            indentacion+="     ";
            contador++;
        }
        System.out.println(indentacion+this.etiqueta);
        TNodoTrie<T> actual=this.primerHijo;
        while(actual!=null){
            actual.listarIndentado(nivel+1);
            actual=actual.hermanoDerecho;
        }
    }
}

