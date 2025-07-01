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
public interface INodoTrie<T> {

    public boolean insertar(String unaEtiqueta,String etiquetaPadre) ;
    public TNodoTrie<T> buscar(String unaEtiqueta);
    void listarIndentado(int nivel);


}
