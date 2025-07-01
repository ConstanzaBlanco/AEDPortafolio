
public class Lista<T> implements ILista<T> {

    protected class Nodo {
        private final Comparable etiqueta;
        private T dato;
        private Nodo siguiente = null;

        public Nodo(Comparable etiqueta, T dato) {
            this.etiqueta = etiqueta;
            this.dato = dato;
        }
        public T getDato() {
            return dato;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

    }


    private Nodo primero;

    public void SetPrimero(Nodo nuevo){
        primero = nuevo;
    }

    public Nodo getPrimero() {
        return primero;
    }
    public Comparable getCodigoPrimero(){
        return this.primero.etiqueta;
    }
    public Comparable getCodigo(Nodo nodo){
        return nodo.etiqueta;
    }

    public java.util.List<T> obtenerElementos() {
        java.util.List<T> elementos = new java.util.ArrayList<>();
        Nodo actual = primero;
        while (actual != null) {
            elementos.add(actual.getDato());
            actual = actual.siguiente;
        }
        return elementos;
    }
    public Lista() {
        primero = null;
    }

    @Override
    public void insertar(T dato, Comparable clave) {
        Nodo nuevo = new Nodo(clave, dato);
        if (primero == null) {
            primero = nuevo;
        } else {
            Nodo actual = primero;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    @Override
    public T buscar(Comparable clave) {
        Nodo actual = primero;
        while (actual != null) {
            if (actual.etiqueta.equals(clave)) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public T pop() {
        if (primero == null) {
            return null;
        }
        T temp= primero.dato;
        primero= primero.siguiente;
        return temp;
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
            Nodo actual = primero;
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
        return imprimir("\n");
    }

    @Override
    public String imprimir(String separador) {
        if (primero == null) {
            return "";
        }
        StringBuilder resultado = new StringBuilder();
        Nodo actual = primero;
        while (actual != null) {
            resultado.append(actual.etiqueta);
            if (actual.siguiente != null) {
                resultado.append(separador);
            }
            actual = actual.siguiente;
        }
        System.out.println(resultado.toString());
        return resultado.toString();
    }

    @Override
    public int cantElementos() {
        int contador = 0;
        Nodo actual = primero;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }


    @Override
    public boolean esVacia() {
        return primero == null;
    }


}
