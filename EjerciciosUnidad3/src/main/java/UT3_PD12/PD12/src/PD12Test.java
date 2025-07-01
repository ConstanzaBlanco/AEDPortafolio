package UT3_PD12.PD12.src;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class PD12Test {
    private IConjunto<Alumno> conjunto1;
    private IConjunto<Alumno> conjunto2;
    private IConjunto<Alumno> conjuntoVacío;

    @Before
    public void setUp() {
        // Inicializo los conjuntos
        conjunto1 = new Conjunto<>();
        conjunto2 = new Conjunto<>();
        conjuntoVacío = new Conjunto<>();


        Alumno alumno1 = new Alumno( 1234, "Sofia");
        Alumno alumno2 = new Alumno( 5678, "Mateo");
        Alumno alumno3 = new Alumno( 9101, "Lucia");
        Alumno alumno4 = new Alumno( 1213, "Luis");
        Alumno alumno5 = new Alumno( 1415, "Alejandra");

        Nodo<Alumno> nodo1 = new Nodo<>(alumno1.getCodigo(),alumno1);
        Nodo<Alumno> nodo2 = new Nodo<>(alumno2.getCodigo(),alumno2);
        Nodo<Alumno> nodo3 = new Nodo<>(alumno3.getCodigo(),alumno3);
        Nodo<Alumno> nodo4 = new Nodo<>(alumno4.getCodigo(),alumno4);
        Nodo<Alumno> nodo5 = new Nodo<>(alumno5.getCodigo(),alumno5);

        conjunto1.insertar(nodo1);
        conjunto1.insertar(nodo2);
        conjunto1.insertar(nodo3);

        conjunto2.insertar(nodo3);
        conjunto2.insertar(nodo4);
        conjunto2.insertar(nodo5);
    }

    // Prueba de unión
    @Test
    public void testUnion() {
        IConjunto<Alumno> union = conjunto1.union(conjunto2);

        // Verificar que la unión contenga a todos los alumnos sin repeticiones
        assertNotNull(union);
        assertNotNull(union.buscar(1234)); // Sofia
        assertNotNull(union.buscar(5678)); // Mateo
        assertNotNull(union.buscar(9101)); // Lucia
        assertNotNull(union.buscar(1213)); // Luis
        assertNotNull(union.buscar(1415)); // Alejandra

    }

    // Prueba de intersección
    @Test
    public void testInterseccion() {
        IConjunto<Alumno> interseccion = conjunto1.interseccion(conjunto2);

        // Verificar que la intersección solo contenga a los alumnos en comun
        assertNotNull(interseccion);
        assertNotNull(interseccion.buscar(9101)); // Luis (común)
        assertNull(interseccion.buscar(1234)); // Juan no está en conjunto2
        assertNull(interseccion.buscar(5678)); // Ana no está en conjunto2
        assertNull(interseccion.buscar(1213)); // Sofia no está en conjunto1
        assertNull(interseccion.buscar(1415)); // Mateo no está en conjunto1
    }

    // Prueba de unión con un conjunto vacío
    @Test
    public void testUnionConVacio() {
        IConjunto<Alumno> unionConVacio = conjuntoVacío.union(conjunto1);

        // Verificar que la unión con el conjunto vacío sea igual al conjunto original
        assertNotNull(unionConVacio);
        assertNotNull(unionConVacio.buscar(1234)); // Juan
        assertNotNull(unionConVacio.buscar(5678)); // Ana
        assertNotNull(unionConVacio.buscar(9101)); // Luis
    }

    // Prueba de intersección con un conjunto vacío
    @Test
    public void testInterseccionConVacio() {
        IConjunto<Alumno> interseccionConVacio = conjuntoVacío.interseccion(conjunto1);

        // Verificar que la intersección con el conjunto vacío sea un conjunto vacío
        assertNotNull(interseccionConVacio);
        assertNull(interseccionConVacio.buscar(1234)); // Juan no está en conjunto vacío
        assertNull(interseccionConVacio.buscar(5678)); // Ana no está en conjunto vacío
        assertNull(interseccionConVacio.buscar(9101)); // Luis no está en conjunto vacío
    }

    // Prueba de unión de conjuntos sin elementos comunes
    @Test
    public void testUnionSinElementosComunes() {
        IConjunto<Alumno> conjunto3 = new Conjunto<>();
        IConjunto<Alumno> conjunto4 = new Conjunto<>();

        // Insertamos alumnos sin elementos comunes
        Alumno alumno1 = new Alumno( 1234,"Juan");
        Alumno alumno2 = new Alumno( 5678, "Ana");
        Alumno alumno3 = new Alumno( 9101, "Luis");
        Alumno alumno4 = new Alumno( 1213, "Sofia");

        Nodo<Alumno> nodo1 = new Nodo<>(1234,alumno1);
        Nodo<Alumno> nodo2 = new Nodo<>(5678,alumno2);
        Nodo<Alumno> nodo3 = new Nodo<>(9101,alumno3);
        Nodo<Alumno> nodo4 = new Nodo<>(1213,alumno4);

        conjunto3.insertar(nodo1);
        conjunto3.insertar(nodo2);

        conjunto4.insertar(nodo3);
        conjunto4.insertar(nodo4);

        IConjunto<Alumno> union = conjunto3.union(conjunto4);


        assertNotNull(union);
        assertNotNull(union.buscar(1234));
        assertNotNull(union.buscar(5678));
        assertNotNull(union.buscar(9101));
        assertNotNull(union.buscar(1213));
    }
}
