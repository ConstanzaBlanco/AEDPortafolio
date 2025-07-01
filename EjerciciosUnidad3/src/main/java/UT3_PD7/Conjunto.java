package UT3_PD7;

import UT3_PD3.Nodo;

public class Conjunto<T> extends ListaOrdenada<T> implements IConjunto<T> {

    public Conjunto() {

    }

    public void insertar(Nodo<T> nodo) {
        super.insertar(nodo);
    }

    public IConjunto<T> union(IConjunto<T> otroConjunto) {
        IConjunto nuevoConjunto = new Conjunto<>();
        Nodo<T> ele0 = this.getPrimero();
        while (ele0 != null) {
            Nodo<T> nuevo = new Nodo<>();
            nuevo.setDato(ele0.getDato());
            nuevo.setEtiqueta(ele0.getEtiqueta());
            nuevoConjunto.insertar(nuevo);
            ele0 = ele0.getSiguiente();
        }
        Nodo<T> ele1 = otroConjunto.getPrimero();
        while (ele1 != null) {
            Nodo<T> nuevo = new Nodo<>();
            nuevo.setDato(ele1.getDato());
            nuevo.setEtiqueta(ele1.getEtiqueta());
            nuevoConjunto.insertar(nuevo);
            ele1 = ele1.getSiguiente();
        }
        return nuevoConjunto;
    }


    public IConjunto<T> interseccion(IConjunto<T> otroConjunto) {
        IConjunto nuevoConjunto = new Conjunto<>();
        Nodo<T> ele0 = otroConjunto.getPrimero();

        while (ele0 != null) {
            Nodo<T> clonado = new Nodo<>();
            clonado.setDato(ele0.getDato());
            clonado.setEtiqueta(ele0.getEtiqueta());
            if (this.buscar(ele0.getEtiqueta()) != null) {
                nuevoConjunto.insertar(clonado);
            }
            ele0 = ele0.getSiguiente();
        }
        return nuevoConjunto;
    }
}
