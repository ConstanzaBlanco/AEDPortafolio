package org.example.UT5_PD3.tdas;

import org.example.UT5_PD2.tdas.IArbolTrie;
import org.example.UT5_PD2.tdas.TNodoTrie;
import org.example.utils.ManejadorArchivosGenerico;

import java.util.LinkedList;


public class TArbolTrie implements IArbolTrie {

    private TNodoTrie raiz;

    @Override
    public void insertar(String palabra,String pag) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra,pag);
    }

    public LinkedList<String> buscarPaginas(String unaPalabra){
        if(raiz==null){
            System.out.println("El índice está vacío");
            return null;
        }
        LinkedList<String> list=raiz.buscarPaginas(unaPalabra);
        if(list==null){
            System.out.println("La palabra "+ unaPalabra+ " no está en el Libro");
            return null;
        }
        return list;
    }

    public void indizarLibro(String nombreLibro){
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(nombreLibro);
        int pagina = 1;
        int contadorLineas = 0;

        for (String linea : lineas) {
            // Normalizo
            linea = linea.toLowerCase().replaceAll("[^a-záéíóúñ ]", " ").trim();

            String[] palabras = linea.split("\\s+");
            for (String palabra : palabras) {
                if (raiz != null) {
                    if (!palabra.isEmpty() && raiz.buscarPaginas(palabra) != null) {
                        raiz.insertar(palabra, String.valueOf(pagina));
                    }
                }
                else{
                    raiz=new TNodoTrie();
                }
            }
            contadorLineas++;
            if (contadorLineas == 50) {
                pagina++;
                contadorLineas = 0;
            }
        }
    }

    public void imprimirIndice() {
        if (raiz != null) {
            raiz.imprimirIndice();
        } else {
            System.out.println("El índice está vacío.");
        }
    }

    public LinkedList<String> predecir(String text) {
        return null;
    }

    public ResultadoBusqueda buscar(String unaPalabra){
        if(raiz==null){
            return null;
        }
        return raiz.buscar(unaPalabra);
    }
}
