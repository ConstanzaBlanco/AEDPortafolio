package UT3_PD4;

public class Producto implements IProducto {

    private Comparable etiqueta;
    private Integer precio;
    private Integer stock;
    private String nombre;

    public Producto(Comparable etiqueta, String nombre, Integer precio, Integer stock){
        this.etiqueta = etiqueta;
        this.precio = precio;
        this.stock = stock;
        this.nombre = nombre;
    }
    /**
     * Retorna el codigo del Producto.
     *
     * @return codigo del Producto.
     */
    public Comparable getEtiqueta(){
        return this.etiqueta;
    }

    /**
     * Retorna el precio unitario del Producto.
     *
     * @return precio del Producto.
     */
    public Integer getPrecio(){
        return this.precio;
    }

    public void setPrecio(Integer precio){
        this.precio = precio;
    }

    /**
     * Retorna el stock del Producto.
     *
     * @return stock del Producto.
     */
    public Integer getStock(){
        return this.stock;
    }

    public void setStock(Integer stock){
        this.stock = stock;
    }



    /**
     * Retorna la descripcion/nombre del Producto.
     *
     * @return descripci�n del Producto.
     */
    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
