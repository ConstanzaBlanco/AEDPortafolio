package UT3_PD6;
import UT3_PD3.Lista;
import UT3_PD3.Nodo;

public class DirectorioSucursales {
    private Lista<Sucursal> listaSucursales;

    public DirectorioSucursales() {
        listaSucursales = new Lista<>();
    }

    public void insertar(Nodo<Sucursal> sucursal) {
        listaSucursales.insertar(sucursal);
    }

    public void insertar(String direccion,Sucursal sucursal) {
        listaSucursales.insertar(direccion,sucursal);
    }

    public Nodo<Sucursal> buscar(String direccion) {
        return listaSucursales.buscar(direccion);
    }

    public boolean eliminar(String direccion) {
        return listaSucursales.eliminar(direccion);
    }

    public String imprimir(){
        return listaSucursales.imprimir();
    }

    public String imprimir(String separador){
        return listaSucursales.imprimir(separador);
    }

    public int cantElementos(){
        return listaSucursales.cantElementos();
    }

    public boolean esVacia(){
        return listaSucursales.esVacia();
    }

    public void setPrimero(Nodo<Sucursal> unNodo){
        listaSucursales.setPrimero(unNodo);
    }
}
