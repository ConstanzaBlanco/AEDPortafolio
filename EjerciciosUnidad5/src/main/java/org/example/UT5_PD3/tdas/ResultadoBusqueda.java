package org.example.UT5_PD3.tdas;

import java.util.LinkedList;

public class ResultadoBusqueda {
    public boolean existe;
    public int comparaciones;
    public LinkedList<String> paginas;
    public String palabra;

    public ResultadoBusqueda(boolean existe, int comparaciones, LinkedList<String> paginas, String palabra) {
        this.existe = existe;
        this.comparaciones = comparaciones;
        this.paginas = paginas;
        this.palabra = palabra;
    }
}
