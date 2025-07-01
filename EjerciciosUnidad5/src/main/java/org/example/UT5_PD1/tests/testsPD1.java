package org.example.UT5_PD1.tests;

import org.example.UT5_PD1.tdas.TArbolTrie;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class testsPD1<T> {

    @Test
    public void insertarArbolVacio(){
        TArbolTrie<T> arbol=new TArbolTrie<>();
        arbol.insertar("Universidad","");
        assertEquals("Universidad",arbol.getRaiz().getEtiqueta());
    }

    @Test
    public void insertarArbolNoVacioEtiquetaPadreVacio(){
        TArbolTrie<T> arbol=new TArbolTrie<>();
        arbol.insertar("Universidad","");
        assertFalse(arbol.insertar("Informatica",""));
    }

    @Test
    public void buscarArbolVacio(){
        TArbolTrie<T> arbol=new TArbolTrie<>();
        assertFalse(arbol.buscar("algo"));
    }

    @Test
    public void buscarArbolNoVacioBuscadoEsta(){
        TArbolTrie<T> arbol=new TArbolTrie<>();
        arbol.insertar("Universidad","");
        assertTrue(arbol.buscar("Universidad"));
    }

    @Test
    public void buscarArbolNoVacioBuscadoNoEsta(){
        TArbolTrie<T> arbol=new TArbolTrie<>();
        arbol.insertar("Universidad","");
        assertFalse(arbol.buscar("Inexistente"));
    }

    @Test
    public void buscarArbolNoVacioBuscadoEstaNivelProfundo(){
        TArbolTrie<T> arbol=new TArbolTrie<>();
        arbol.insertar("Universidad","");
        arbol.insertar("Ingenieria","Universidad");
        arbol.insertar("Informatica","Ingenieria");
        assertTrue(arbol.buscar("Informatica"));
    }

    @Test
    public void insertarArbolNoVacioEtiquetaPadreVaciaEnElArbol(){
        TArbolTrie<T> arbol=new TArbolTrie<>();
        arbol.insertar("Universidad","");
        assertFalse(arbol.insertar("Ingenieria",""));
        assertFalse(arbol.buscar("Ingenieria"));
    }

    @Test
    public void insertarArbolNoVacioEtiquetaPadreNoVaciaEnElArbol(){
        TArbolTrie<T> arbol=new TArbolTrie<>();
        arbol.insertar("Universidad","");
        assertTrue(arbol.insertar("Ingenieria","Universidad"));
        assertTrue(arbol.buscar("Ingenieria"));
    }

    @Test
    public void insertarArbolNoVacioEtiquetaPadreNoVaciaNoEstaEnElArbol(){
        TArbolTrie<T> arbol=new TArbolTrie<>();
        arbol.insertar("Universidad","");
        assertFalse(arbol.insertar("Ingenieria","Facultad"));
        assertFalse(arbol.buscar("Ingenieria"));
    }

}
