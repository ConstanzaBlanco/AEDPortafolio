package org.example.UT5_PD7.tests;

import org.example.UT5_PD7.codigoydatospd7.src.tdas.TAbonado;
import org.example.UT5_PD7.codigoydatospd7.src.tdas.TArbolTrieTelefonos;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class tests {

    @Test
    public void testInsertar() {
        TArbolTrieTelefonos trie = new TArbolTrieTelefonos();
        trie.insertar(new TAbonado("Juan Perez", "59893123456"));
        trie.insertar(new TAbonado("Ana Lopez", "59893111222"));
        trie.insertar(new TAbonado("Pedro Gomez", "59892222222"));
        LinkedList<TAbonado> todos = trie.buscarTelefonos("598", "");
        assertEquals(3, todos.size(), "Debe haber 3 abonados insertados");
    }

    @Test
    public void testBusquedaCodigo93() {
        TArbolTrieTelefonos trie = new TArbolTrieTelefonos();
        trie.insertar(new TAbonado("Juan Perez", "59893123456"));
        trie.insertar(new TAbonado("Ana Lopez", "59893111222"));
        trie.insertar(new TAbonado("Pedro Gomez", "59892222222"));
        LinkedList<TAbonado> encontrados = trie.buscarTelefonos("598", "93");
        assertEquals(2, encontrados.size(), "Debe encontrar 2 abonados para 598-93");
    }

    @Test
    public void testBusquedaCodigo92() {
        TArbolTrieTelefonos trie = new TArbolTrieTelefonos();
        trie.insertar(new TAbonado("Juan Perez", "59893123456"));
        trie.insertar(new TAbonado("Ana Lopez", "59893111222"));
        trie.insertar(new TAbonado("Pedro Gomez", "59892222222"));
        LinkedList<TAbonado> encontrados = trie.buscarTelefonos("598", "92");
        assertEquals(1, encontrados.size(), "Debe encontrar 1 abonado para 598-92");
        assertEquals("Pedro Gomez", encontrados.get(0).getNombre(), "El nombre debe ser Pedro Gomez");
    }

    @Test
    public void testOrdenAlfabetico() {
        TArbolTrieTelefonos trie = new TArbolTrieTelefonos();
        trie.insertar(new TAbonado("Juan Perez", "59893123456"));
        trie.insertar(new TAbonado("Ana Lopez", "59893111222"));
        trie.insertar(new TAbonado("Pedro Gomez", "59892222222"));
        LinkedList<TAbonado> encontrados = trie.buscarTelefonos("598", "93");
        encontrados.sort((a, b) -> a.getNombre().compareTo(b.getNombre()));
        assertEquals("Ana Lopez", encontrados.get(0).getNombre(), "El primero en orden alfabético debe ser Ana Lopez");
        assertEquals("Juan Perez", encontrados.get(1).getNombre(), "El segundo debe ser Juan Perez");
    }

    @Test
    public void testFormatoSalida() {
        TArbolTrieTelefonos trie = new TArbolTrieTelefonos();
        trie.insertar(new TAbonado("Juan Perez", "59893123456"));
        trie.insertar(new TAbonado("Ana Lopez", "59893111222"));
        trie.insertar(new TAbonado("Pedro Gomez", "59892222222"));
        LinkedList<TAbonado> encontrados = trie.buscarTelefonos("598", "93");
        encontrados.sort((a, b) -> a.getNombre().compareTo(b.getNombre()));
        String salida = encontrados.get(0).getNombre() + "," + encontrados.get(0).getTelefono();
        assertEquals("Ana Lopez,59893111222", salida);
    }
}
