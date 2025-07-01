package UT3_PD3;

public class MainListaYNodo {
    public static void main(String[] args) {
        Lista l=new Lista();
        System.out.println("Es vacia?");
        System.out.println(l.esVacia());
        l.insertar("nodo 1","123");
        l.insertar("nodo 2","456");
        l.insertar("nodo 3","789");
        System.out.println("Elementos actuales");
        System.out.println(l.imprimir());
        System.out.println("Cantidad de elementos:"+l.cantElementos());
        System.out.println("Elimino un elemento que existe:");
        System.out.println(l.eliminar("nodo 2"));
        System.out.println("Elimino un elemento que no existe:");
        System.out.println(l.eliminar("nodo 4"));
        System.out.println("Elementos actuales");
        System.out.println(l.imprimir());
        System.out.println("Cantidad de elementos:"+l.cantElementos());
        System.out.println("Busco un elemento que existe:");
        System.out.println(l.buscar("nodo 1").getEtiqueta());
        System.out.println("inserto un nuevo elemento:");
        l.insertar("nodo 4","1011");
        System.out.println("Elementos actuales");
        System.out.println(l.imprimir());
        System.out.println("Cantidad de elementos:"+l.cantElementos());
        System.out.println("Es vacia?");
        System.out.println(l.esVacia());
    }
}
