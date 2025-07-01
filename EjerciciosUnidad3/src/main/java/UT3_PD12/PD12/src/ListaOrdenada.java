/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3_PD12.PD12.src;

/**
 *
 * @author ernesto
 * @param <T>
 */
public class ListaOrdenada<T> extends Lista<T> {

    @Override
    public void insertar(Nodo<T> unNodo) {
        Nodo<T> aux1= this.getPrimero();
        if(aux1==null){
            this.setPrimero(unNodo);
        }

        else{
            if(this.buscar(unNodo.getEtiqueta())==null) {
                Nodo<T> nuevo=new Nodo<>(unNodo.getEtiqueta(), unNodo.getDato());
                Nodo<T> aux2 = aux1.getSiguiente();
                //Caso en el cual el nodo va antes del primero
                if (aux1.getEtiqueta().compareTo(unNodo.getEtiqueta()) > 0) {
                    nuevo.setSiguiente(aux1);
                    this.setPrimero(nuevo);
                }//Caso cuando el nodo va en medio
                else {
                    boolean insertado = false;
                    while (aux2 != null) {
                        if (aux2.getEtiqueta().compareTo(unNodo.getEtiqueta()) > 0) {
                            nuevo.setSiguiente(aux2);
                            aux1.setSiguiente(nuevo);
                            insertado = true;
                            break;
                        }
                        aux1 = aux2;
                        aux2 = aux2.getSiguiente();
                    }
                    if (!insertado) {
                        aux1.setSiguiente(nuevo);
                    }

                }
            }
        }
    }
}