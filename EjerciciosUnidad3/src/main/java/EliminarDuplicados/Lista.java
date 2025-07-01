package EliminarDuplicados;

public class Lista<T> implements ILista<T> {

    private class Nodo<T> {

        private final Comparable etiqueta;
        private T dato;
        private Nodo<T> siguiente = null;

        public Nodo(Comparable etiqueta, T dato ) {
            this.etiqueta = etiqueta;
            this.dato = dato;
        }
    }

    private Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    public void eliminarDuplicados(){
        Nodo<T> actual=primero;
       while(actual!=null){
           if(actual.siguiente!=null){
               Nodo<T> aux1=actual;
               Nodo<T> aux2=actual.siguiente;
               while(aux2!=null){
                   if(actual.etiqueta.equals(aux2.etiqueta)){
                       aux1.siguiente=aux2.siguiente;
                       aux2=aux2.siguiente;

                   }
                   else{
                       aux1=aux1.siguiente;
                       aux2=aux2.siguiente;
                   }
               }
           }
           actual=actual.siguiente;
       }
    }

    @Override
    public void insertar(T dato, Comparable clave) {

        Nodo<T> nuevo = new Nodo<> ( clave, dato );
        if ( primero == null ) {
            primero = nuevo;
        } else {
            Nodo<T> actual = primero;
            while ( actual.siguiente != null ) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    @Override
    public T buscar(Comparable clave) {
        if (primero == null) {return primero.dato;}
        if (primero.etiqueta.equals(clave)) {return primero.dato;}
        while (primero.siguiente != null) {
            if (primero.siguiente.etiqueta.equals(clave)) {return primero.siguiente.dato;}
            primero = primero.siguiente;
        }
        return primero.siguiente.dato;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (primero == null) {
            return false;
        }
        if (primero.etiqueta.equals(clave)) {
            primero = primero.siguiente;
            return true;
        } else {
            Nodo<T> actual = primero;
            while (actual.siguiente != null) {
                if (actual.siguiente.etiqueta.equals(clave)) {
                    actual.siguiente = actual.siguiente.siguiente;
                    return true;
                }
                actual = actual.siguiente;
            }
        }
        return false;
    }

    @Override
    public String imprimir() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'imprimir'");
    }

    @Override
    public String imprimir(String separador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'imprimir'");
    }

    @Override
    public int cantElementos() {
        int contador=1;
        if (primero == null) {
            return 0;
        }
        else
        {
            while (primero.siguiente != null) {
                contador++;
            }
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }
}
