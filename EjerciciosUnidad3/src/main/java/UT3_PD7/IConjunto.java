package UT3_PD7;

import UT3_PD3.ILista;
import UT3_PD3.Nodo;

public interface IConjunto<T> extends ILista<T> {
    public void insertar(Nodo<T> unNodo);
    public IConjunto<T> union(IConjunto<T> otroConjunto);
    public IConjunto<T> interseccion(IConjunto<T> otroConjunto);

}
