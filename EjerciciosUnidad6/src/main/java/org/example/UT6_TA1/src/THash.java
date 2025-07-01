package org.example.UT6_TA1.src;


public class THash<K, V> implements IHash<K, V> {

    // Implementación de la tabla hash
    // Aquí se pueden definir los atributos necesarios, como un array de buckets, etc.

    private static class ElementoHash<K, V> {
        K clave;
        V valor;

        ElementoHash(K clave, V valor) {
            this.clave = clave;
            this.valor = valor;
        }

        private V getValor(){
            return this.valor;
        }

        private K getClave(){
            return this.clave;
        }
    }

    private ElementoHash<K, V>[] tabla;
    private float carga;
    private int ocupados;

    public THash(int tamanio, float carga) {
        this.carga=carga;
        tabla=new ElementoHash[tamanio];
        ocupados=0;
    }

    @Override
    public V buscar(K unaClave) {
        int posicion=funcionHashing(unaClave);
        while(tabla[posicion]!=null){
            if (tabla[posicion].getClave().equals(unaClave)) {
                return tabla[posicion].getValor();
            }
            posicion=(posicion+1) % tabla.length;
        }
        return null;
    }

    public int buscarComparaciones(K unaClave){
        int comparaciones=0;
        int posicion=funcionHashing(unaClave);
        while(tabla[posicion]!=null){
            comparaciones++;
            if (tabla[posicion].getClave().equals(unaClave)) {
                tabla[posicion].getValor();
                return comparaciones;
            }
            posicion=(posicion+1) % tabla.length;
        }
        comparaciones++;
        return comparaciones;
    }

    @Override
    public boolean insertar(K unaClave,V unValor) {
        redimensionar();
        int posicion=funcionHashing(unaClave);
        if((float)ocupados/tabla.length<carga) {
            while (tabla[posicion] != null) {
                if (tabla[posicion].getClave().equals(unaClave)) {
                    return false;
                    //Evito elementos duplicados
                }
                posicion = (posicion + 1) % tabla.length;
            }
            tabla[posicion] = new ElementoHash<>(unaClave, unValor);
            ocupados++;
            return true;
        }
        return false;
    }

    public int insertarComparaciones(K unaClave,V unValor) {
        int comparaciones = 0;
        redimensionar();
        int posicion = funcionHashing(unaClave);
        if ((float) ocupados / tabla.length < carga) {
            while (tabla[posicion] != null) {
                comparaciones++;
                if (tabla[posicion].getClave().equals(unaClave)) {
                    return comparaciones;
                }
                posicion = (posicion + 1) % tabla.length;
            }
            tabla[posicion] = new ElementoHash<>(unaClave, unValor);
            ocupados++;
            comparaciones++;
            return comparaciones;
        }
        return comparaciones;
    }

    /**
     * Función de hashing que convierte una clave en un índice de la tabla hash.
     *
     * @param unaClave la clave a convertir en índice.
     * @return el índice correspondiente a la clave.
     */
    protected int funcionHashing(K unaClave) {
        int posicion= unaClave.hashCode() % tabla.length;
        if(posicion<0){
            return posicion*(-1);
        }
        return posicion;
    }

    public void imprimirTabla(){
        for(ElementoHash elementoHash: tabla){
            if(elementoHash!=null){
                System.out.println(elementoHash.getValor().toString());
            }
        }
    }

    public ElementoHash<K,V>[] getElementos(){
        return tabla;
    }

    private void redimensionar(){
        if ((float)ocupados/tabla.length >= carga) {
            int nuevoTam = tabla.length * 2;
            ElementoHash<K, V>[] nuevaTabla = (ElementoHash<K, V>[]) new ElementoHash[nuevoTam];

            for (ElementoHash<K, V> elemento : tabla) {
                if (elemento != null) {
                    //No uso funcionHashing pq implementa el tamaño de la tabla anterior
                    int nuevaPos = elemento.getClave().hashCode() % nuevoTam;
                    if (nuevaPos < 0) nuevaPos = -nuevaPos;

                    while (nuevaTabla[nuevaPos] != null) {
                        nuevaPos = (nuevaPos + 1) % nuevoTam;
                    }

                    nuevaTabla[nuevaPos] = elemento;
                }
            }

            tabla = nuevaTabla;
        }

    }
}
