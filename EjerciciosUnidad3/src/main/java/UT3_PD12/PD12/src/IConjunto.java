package UT3_PD12.PD12.src;

/**
 *
 * @author ernesto
 * @param <T>
 */
public interface IConjunto<T> {

    public void insertar(Nodo<T> unNodo);
    public Nodo<T> buscar(Comparable etiqueta);
    public Nodo<T> getPrimero();
    public void setPrimero(Nodo<T> nodo);
    public int cantElementos();
    public String imprimir();


    public IConjunto union (IConjunto otroConjunto);

    public IConjunto interseccion (IConjunto otroConjunto);
}
