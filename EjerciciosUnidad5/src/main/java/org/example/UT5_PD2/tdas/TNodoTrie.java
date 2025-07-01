package org.example.UT5_PD2.tdas;

import org.example.UT5_PD3.tdas.ResultadoBusqueda;

import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    private LinkedList<String> paginas;
    private char etiqueta;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
        paginas=null;
        etiqueta=' ';
    }

    public void setEtiqueta(char unaEtiqueta){
        etiqueta=unaEtiqueta;
    }

    public String normalizar(String unaPalabra) {
        unaPalabra = unaPalabra.toLowerCase();

        // Reemplazo acentos
        unaPalabra = unaPalabra.replace('á', 'a')
                .replace('é', 'e')
                .replace('í', 'i')
                .replace('ó', 'o')
                .replace('ú', 'u');

        // Remuevo todo lo que no sea letras a-z o ñ
        unaPalabra = unaPalabra.replaceAll("[^a-zñ]", "");

        return unaPalabra;
    }

    @Override
    public void insertar(String unaPalabra, String pag) {
        TNodoTrie nodo = this;
        unaPalabra = normalizar(unaPalabra);
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
                TNodoTrie nuevo= nodo.hijos[indice];
                nuevo.setEtiqueta(unaPalabra.charAt(c));
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
        if (nodo.paginas == null) {
            nodo.paginas = new LinkedList<>();
        }
        nodo.paginas.add(pag);
    }

    public LinkedList<String> buscarPaginas(String unaPalabra) {
        TNodoTrie nodo = this;
        unaPalabra = normalizar(unaPalabra);

        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                return null;
            }
            nodo = nodo.hijos[indice];
        }

        if (nodo.esPalabra) {
            return nodo.paginas; // Devuelve las páginas donde aparece la palabra
        } else {
            return null;
        }
    }

    public void imprimirIndice() {
        imprimirIndiceAux(new StringBuilder());
    }

    private void imprimirIndiceAux(StringBuilder palabra) {
        if (esPalabra) {
            System.out.print(palabra.toString() + ": ");
            if (paginas != null) {
                for (String pagina : paginas) {
                    System.out.print(pagina + " ");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < CANT_CHR_ABECEDARIO; i++) {
            if (hijos[i] != null) {
                palabra.append((char) (i + 'a'));
                hijos[i].imprimirIndiceAux(palabra);
                palabra.deleteCharAt(palabra.length() - 1);  // backtrack
            }
        }
    }

    public ResultadoBusqueda buscar(String unaPalabra) {
        unaPalabra = normalizar(unaPalabra);
        TNodoTrie nodo = this;
        int comparaciones = 0;

        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            comparaciones++;  // Cuenta esta comparación
            if (nodo.hijos[indice] == null) {
                return new ResultadoBusqueda(false, comparaciones, null, unaPalabra);
            }
            nodo = nodo.hijos[indice];
        }

        if (nodo.esPalabra) {
            return new ResultadoBusqueda(true, comparaciones, nodo.paginas, unaPalabra);
        } else {
            return new ResultadoBusqueda(false, comparaciones, null, unaPalabra);
        }
    }
}
