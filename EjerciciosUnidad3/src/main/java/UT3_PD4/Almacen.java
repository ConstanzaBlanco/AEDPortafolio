package UT3_PD4;

public class Almacen implements IAlmacen{

    private String direccion;
    private String telefono;
    private String nombre;
    private Lista listaProductos;

    public Almacen(String direccion, String telefono, String nombre){
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombre = nombre;
        this.listaProductos = new Lista();
    }

    public String getDireccion(){
        return this.direccion;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public String getTelefono(){
        return this.telefono;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public String getNombre(){
        return this.nombre;
    }

    public Lista getListaProductos(){
        return this.listaProductos;
    }

    /**
     * Incorporar un nuevo producto al supermercado.
     *
     * @param unProducto
     */
    public void insertarProducto(Producto unProducto){
        Nodo<Producto> nodo = listaProductos.buscar(unProducto.getEtiqueta());
        if(nodo == null){
            listaProductos.insertar(unProducto.getEtiqueta(), unProducto);
        }
        else{
            agregarStock(unProducto.getEtiqueta(), unProducto.getStock());
        }

    }

    /**
     * Eliminar productos que ya no se venden (por no ser comercializados m�s).
     *
     * @param clave
     * @return
     */
    public boolean eliminar(Comparable clave){
        return listaProductos.eliminar(clave);
    }

    /**
     * Imprime la lista de productos
     *
     * @return
     */
    public String imprimirProductos(){

        return listaProductos.imprimir();
    }

    /**
     * Dado un separador ej.:",", ";", imprime los productos separados por tal
     * caracter
     *
     * @param separador
     * @return
     */
    public String imprimirSeparador(String separador){
        return listaProductos.imprimir(separador);
    }

    /**
     * Agregar stock a un producto existente.
     *
     * @param clave
     * @param cantidad
     * @return
     */
    public Boolean agregarStock(Comparable clave, Integer cantidad){
        Producto producto = buscarPorCodigo(clave);
        if(producto != null){
            producto.setStock(producto.getStock() + cantidad);
            return true;
        }
        return false;
    }

    /**
     * Simular la venta de un producto (reducir el stock de un producto
     * existente
     *
     * @param clave
     * @param cantidad
     * @return
     */
    public Integer restarStock(Comparable clave, Integer cantidad){
        Producto producto = buscarPorCodigo(clave);
        if(producto != null){
            producto.setStock(producto.getStock() - cantidad);
            if(producto.getStock() < 0){
                producto.setStock(0);
            }
        }
        else{
            return null;
        }
        return producto.getStock();
    }

    /**
     * Dado un código de producto, indicar las existencias del mismo en el
     * almac�n.
     *
     * @param clave
     * @return
     */
    public Producto buscarPorCodigo(Comparable clave){
        Nodo<Producto> nodo = listaProductos.buscar(clave);
        if(nodo != null){
            return nodo.getDato();
        }
        return null;
    }

    /**
     * Listar todos los productos registrados, ordenados por nombre, presentando
     * adem�s su stock. Imprime por consola la lista de todos los productos
     * registrados y su stock actual.
     */
    public void listarOrdenadoPorNombre(){
        Lista nuevaLista = new Lista();
        Nodo<Producto> actual=listaProductos.getPrimero();
        if(actual!=null){
            while(actual!=null){
                Producto productoActual=actual.getDato();
                Nodo<Producto> nuevoNodo = new Nodo<>(actual.getEtiqueta(), productoActual);
                if(nuevaLista.esVacia()){
                    nuevaLista.setPrimero(nuevoNodo);
                }
                else{
                    Nodo<Producto> aux1=nuevaLista.getPrimero();
                    Nodo<Producto> aux2=nuevaLista.getPrimero().getSiguiente();
                    //Caso en el que el nuevo va primero en la lista
                    if(productoActual.getNombre().compareTo(aux1.getDato().getNombre())<0){
                        nuevoNodo.setSiguiente(aux1);
                        nuevaLista.setPrimero(nuevoNodo);
                    }

                    else{
                        //Caso en el cual va en el medio
                        while(aux2!=null) {
                            if (aux2.getDato().getNombre().compareTo(nuevoNodo.getDato().getNombre()) >= 0) {
                                aux1.setSiguiente(nuevoNodo);
                                nuevoNodo.setSiguiente(aux2);
                                break;
                            }
                            aux1 = aux1.getSiguiente();
                            aux2 = aux2.getSiguiente();
                        }
                        //Caso en el cual va ultimo
                        if(aux2==null){
                            aux1.setSiguiente(nuevoNodo);
                        }
                    }

                }
                actual=actual.getSiguiente();
            }
            listaProductos=nuevaLista;
            Nodo<Producto> nodo=listaProductos.getPrimero();
            while(nodo!=null){
                System.out.println(nodo.getDato().getNombre()+" -Stock: "+nodo.getDato().getStock());
                nodo=nodo.getSiguiente();
            }
        }

    }

    /**
     * Busca un producto por su descripci�n.
     *
     * @param descripcion
     * @return
     */
    public Producto buscarPorDescripcion(String descripcion){
        Nodo<Producto> actual=listaProductos.getPrimero();
        while(actual!=null){
            if(actual.getDato().getNombre().equals(descripcion)){//La descripcion es el nombre del producto
                return actual.getDato();
            }
            actual=actual.getSiguiente();
        }
        return null;
    }

    /**
     * Retorna el tama�o del almacen: cantidad de productos. No es lo mismo que
     * el total de stock, sino que ser�a en definitiva el tama�o de la lista.
     *
     * @return
     */
    public int cantidadProductos(){
        return listaProductos.cantElementos();
    }
}
