package org.example.UT6_PD3;

public class ListaOrdenada<T> extends Lista<T> {

    private Nodo primero;

    public ListaOrdenada(){
        this.primero=null;
    }

    @Override
    public void insertar(T dato, Comparable clave) {
        Nodo nuevoNodo = new Nodo(clave, dato);

        if (primero == null || comparar(clave, primero.getClave()) < 0) {
            nuevoNodo.setSiguiente(primero);
            primero = nuevoNodo;
        } else {
            Nodo actual = primero;
            while (actual.getSiguiente() != null &&
                    comparar(clave, actual.getSiguiente().getClave()) >= 0) {
                actual = actual.getSiguiente();
            }
            nuevoNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);
        }
    }

    private int comparar(Comparable c1, Comparable c2) {
        int lenDiff = c1.toString().length() - c2.toString().length();
        if (lenDiff != 0) return lenDiff;
        return c1.toString().compareTo(c2.toString());
    }

    private void setPrimero(Lista<T>.Nodo nuevoNodo) {
        this.primero=nuevoNodo;
    }

}
