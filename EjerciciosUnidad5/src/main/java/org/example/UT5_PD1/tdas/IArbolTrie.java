package org.example.UT5_PD1.tdas;

import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 */
public interface IArbolTrie<T> {

    boolean insertar(String unaEtiqueta,String etiquetaPadre);
    boolean buscar(String unaEtiqueta);
    void listarIndentado();
    public boolean modificarDatos(String etiqueta, T nuevosDatos);
    
}
