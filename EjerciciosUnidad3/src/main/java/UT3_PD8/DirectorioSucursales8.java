package UT3_PD8;

import java.util.ArrayList;

public class DirectorioSucursales8 {
    ArrayList<Sucursales8> sucursales;
    public DirectorioSucursales8() {
        sucursales = new ArrayList<>();
    }
    public void agregarSucursal(Sucursales8 sucursal){
        if(buscarSucursal(sucursal.getDireccion())==null){
            sucursales.add(sucursal);
        }
    }
    public Sucursales8 buscarSucursal(String direccion){
        for(Sucursales8 sucursal: sucursales){
            if(sucursal.getDireccion().equals(direccion)){
                return sucursal;
            }
        }
        return null;
    }

    public boolean eliminarSucursal(String direccion){
        for(Sucursales8 sucursal: sucursales){
            if(sucursal.getDireccion().equals(direccion)){
                sucursales.remove(sucursal);
                return true;
            }
        }
        return false;
    }

    public String ImprimirSucursales(){
        StringBuilder cadena = new StringBuilder();
        if(estaVacio()){
             System.out.println("No hay sucursales registradas");
         }
         else{
             cadena.append("Lista de sucursales registradas: \n");
             for(Sucursales8 sucursal: sucursales){
                 cadena.append(sucursal.getDireccion()).append("\n");
             }
         }
         return cadena.toString();
    }
    public String ImprimirSucursalesSeparador(String separador){
        StringBuilder cadena = new StringBuilder();
        if(estaVacio()){
            System.out.println("No hay sucursales registradas");
        }
        else{
            cadena.append("Lista de sucursales registradas: \n");
            for(Sucursales8 sucursal: sucursales){
                cadena.append(sucursal.getDireccion()).append(separador);
            }
        }
        return cadena.toString();
    }

    public Sucursales8 getSiguiente(Sucursales8 sucursal){
        int indice = sucursales.indexOf(sucursal);
        return sucursales.get(indice+1);
    }

    public int cantSucursales(){
        return sucursales.size();
    }

    public boolean estaVacio(){
        return sucursales.isEmpty();
    }
}
