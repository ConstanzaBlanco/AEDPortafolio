package org.example.UT6_PD1_PD5;

import org.example.UT6_PD1_PD5.tdas.PD5ConPD7U5.TAbonado;
import org.example.UT6_PD1_PD5.tdas.PD5ConPD7U5.TArbolTrieTelefonos;
import org.example.utils.ManejadorArchivosGenerico;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainPD5 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TArbolTrieTelefonos trieAbonados = new TArbolTrieTelefonos();
        // a) CARGAR EN EL TRIE LOS TELÉFONOS Y NOMBRES A PARTIR DEL ARCHIVO ABONADOS.TXT
        String[] lineasAbonados = ManejadorArchivosGenerico.leerArchivo("src/main/java/org/example/UT6_PD1_PD5/tas/abonados.txt");
        for (String linea : lineasAbonados) {
            String[] partes = linea.split(",");
            if (partes.length == 2) {
                String telefono = partes[0].trim();
                String nombre = partes[1].trim();
                TAbonado abonado = new TAbonado(nombre, telefono);
                trieAbonados.insertar(abonado);
            }
        }

        // b) LEER LOS CÓDIGOS DE PAIS Y AREA DESDE EL ARCHIVO codigos.txt y buscar abonados
        String[] lineasCodigos = ManejadorArchivosGenerico.leerArchivo("src/main/java/org/example/UT6_PD1_PD5/tas/codigos1.txt");
        String codigoPais = "";
        String codigoArea = "";

        for (String lineaCodigo : lineasCodigos) {
            String[] partes = lineaCodigo.split(":");
            if (partes.length == 2) {
                String clave = partes[0].trim();
                String valor = partes[1].trim();
                if (clave.equalsIgnoreCase("CODIGO PAIS")) {
                    codigoPais = valor;
                } else if (clave.equalsIgnoreCase("CODIGO AREA")) {
                    codigoArea = valor;
                }
            }
        }
                // c) ORDENAR ALFABÉTICAMENTE POR NOMBRE
        LinkedList<TAbonado> abonadosEncontrados = trieAbonados.buscarTelefonos(codigoPais, codigoArea);

        // d) ORDENAR ALFABÉTICAMENTE POR NOMBRE
        //Ya se ordenan alfabeticamente dentro del metodo buscarTelefonos()
        for(TAbonado abonado: abonadosEncontrados){
            System.out.println(abonado.getNombre()+" +"+abonado.getTelefono());
        }

        // e) PREPARAR LA LISTA DE SALIDA
        ArrayList<String> salida = new ArrayList<>();
        for (TAbonado ab : abonadosEncontrados) {
            salida.add(ab.getNombre() + "," + ab.getTelefono());
        }

        // f) ESCRIBIR EL ARCHIVO salida.txt CON LOS ABONADOS
        ManejadorArchivosGenerico.escribirArchivo("src/main/java/org/example/UT6_PD1_PD5/tas/salida.txt", salida.toArray(new String[0]));
    }
}
