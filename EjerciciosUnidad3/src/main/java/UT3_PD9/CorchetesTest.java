package UT3_PD9;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CorchetesTest {

    private Corchetes corchetes;

    @Before
    public void setUp() {
        corchetes = new Corchetes();
    }

    @Test
    public void testCorchetesCorrectos() {
        String[] lista = {"{", "{", "{", "}", "}", "}"};
        assertTrue(corchetes.controlCorchetes(lista));
    }

    @Test
    public void testCorchetesConFaltanteDeCierre() {
        String[] lista = {"{", "{", "{"};
        assertFalse(corchetes.controlCorchetes(lista));
    }

    @Test
    public void testCorchetesConFaltanteDeApertura() {
        String[] lista = {"}", "}"};
        assertTrue(corchetes.controlCorchetes(lista));
    }

    @Test
    public void testCorchetesDesbalanceados() {
        String[] lista = {"{", "}", "{", "{"};
        assertFalse(corchetes.controlCorchetes(lista));
    }

    @Test
    public void testCorchetesBalanceadosSimple() {
        String[] lista = {"{", "}"};
        assertTrue(corchetes.controlCorchetes(lista));
    }

    @Test
    public void testCadenaVacia() {
        String[] lista = {};
        assertTrue(corchetes.controlCorchetes(lista));
    }

    @Test
    public void testConElementosNoCorchete() {
        String[] lista = {"{", "x", "}", "y"};
        assertTrue(corchetes.controlCorchetes(lista));
    }
}