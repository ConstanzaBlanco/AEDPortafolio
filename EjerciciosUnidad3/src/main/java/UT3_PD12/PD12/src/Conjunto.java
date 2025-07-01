package UT3_PD12.PD12.src;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 * @param <T>
 */
public class Conjunto<T> extends ListaOrdenada<T> implements IConjunto<T> {
// MEJOR: public class Conjunto<T> extends ListaOrdenada<T> implements IConjunto {
    @Override
    public IConjunto union(IConjunto otroConjunto) {
        IConjunto<T> resultado = new Conjunto();

        Nodo<T> auxiliar = this.getPrimero();
        while(auxiliar!=null){
            Nodo<T> nuevo=new Nodo<>(auxiliar.getEtiqueta(), auxiliar.getDato());
            resultado.insertar(nuevo);
            auxiliar = auxiliar.getSiguiente();
        }

        auxiliar=otroConjunto.getPrimero();
        while(auxiliar!=null){
            Nodo<T> nuevo=new Nodo<>(auxiliar.getEtiqueta(), auxiliar.getDato());
            resultado.insertar(nuevo);
            auxiliar = auxiliar.getSiguiente();
        }
        return resultado;
    }

    @Override
    public IConjunto interseccion(IConjunto otroConjunto) {
        IConjunto<T> resultado = new Conjunto();

        Nodo<T> actual=this.getPrimero();
        while(actual!=null){
            if(otroConjunto.buscar(actual.getEtiqueta())!=null){
                Nodo<T> nuevo=new Nodo<>(actual.getEtiqueta(), actual.getDato());
                resultado.insertar(nuevo);
            }
            actual=actual.getSiguiente();
        }
        return resultado;
    }

    public void insertar(Nodo<T> unNodo){
        super.insertar(unNodo);
    }
    public Nodo<T> buscar(Comparable etiqueta){
        return super.buscar(Comparable.class.cast(etiqueta));
    }

    public Nodo<T> getPrimero(){
        return super.getPrimero();
    }
    public void setPrimero(Nodo<T> nodo){
        super.setPrimero(nodo);
    }

    public int cantElementos(){
        return super.cantElementos();
    }

    public String imprimir(){
        return super.imprimir();
    }
}
