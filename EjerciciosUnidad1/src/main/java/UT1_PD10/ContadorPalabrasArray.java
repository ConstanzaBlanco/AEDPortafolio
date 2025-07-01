package UT1_PD10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContadorPalabrasArray {
    public String[] PalabrasEnComun(String[] a, String[] b) {
        List<String> resultado = new ArrayList<String>();
        for (int i = 0; i < a.length; i++) {
            String palabra = a[i];
            for (int x = 0; x < b.length; x++) {
                String palabra2 = b[x];
                if (palabra.equals(palabra2) && !resultado.contains(palabra)) {
                    resultado.add(palabra);
                }
            }
        }
        for(int y = 0; y < resultado.size(); y++){
            System.out.println(resultado.get(y));
        }
        return resultado.toArray(new String[resultado.size()]);
    }
    /*Lo primero que hace es crear una lista vacia para almacenar las coincidencias ahi.
Posteriormente recorre el priner array palabra por palabra, y cada palaabra la compara
con cada palabra del segundo array recibido, si hay una coincidencia y a su vez esa
palabra no se encuentra ya guardada en la lista, entonces esta palabra es agregada a la
lista creada al inicio.
Luego de recorrer ambos array recibidos, convierte la lista en un array para imprimir
cada uno de sus objetos posteriormente y finalmente retornar un array con los elementos
repetidos de ambos array recibidos.
*/

    public String[] leerArchivo(String nombreCompletoArchivo){
        FileReader fr;
        List<String> resultado = new ArrayList<String>();
        try {
            fr = new FileReader(nombreCompletoArchivo);
            BufferedReader br = new BufferedReader(fr);
            String lineaActual = br.readLine();
            while (lineaActual != null){
                resultado.add(lineaActual);
                System.out.println(lineaActual);
                lineaActual = br.readLine();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo "+nombreCompletoArchivo);
            e.printStackTrace();
        } catch (IOException e)
        {
            System.out.println("Error al leer el archivo "+nombreCompletoArchivo);
            e.printStackTrace();
        }
        System.out.println("Archivo leido satisfactoriamente");
        List<String> resultadoPalabras = new ArrayList<String>();
        for (int i = 0; i < resultado.size(); i++) {
            String linea = resultado.get(i);
            String palabra="";

            for (int y=0; y < linea.length(); y++) {
                char letra=linea.charAt(y);
                if (letra==' ' || letra==',' || letra=='.') {
                    resultadoPalabras.add(palabra.toLowerCase());
                    palabra="";
                }
                else {
                    palabra+=letra;
                }

            }
            resultadoPalabras.add(palabra.toLowerCase());

        }
        return resultadoPalabras.toArray(new String[resultadoPalabras.size()]);
    }
}

/*
En el metodo  leer Archivo lo que recibe es el nombre de un archvo de texto, en base a ese archivo
va guardando linea por linea en una Lista de tipo String, lo que hice fue poner un for para recorrer cada elemento de
la lista de lineas, y dentro de ese for puse otro for anidado para recorrer cada letra de esa linea.
Considero el fin de una palabra cuando es el final de la linea, hay un espacio, un punto o una coma.
Al finalizar la palabra la agrego a una nueva lista (pero antes le hago un Lower para que todas las palaras esten escritas en minusculas)
en la cual tiene como elementos las palabras de cada linea  y reseteo la variabe palabra para concatenar letra por letra nuevamente.
A su vez dentro del segundo for que recorre letra por letra, a esta letra si no es el fin de una palabra, la concateno a la varaible
palabra, formando de esta forma a la palabra letra porletra para cuando la tenga completa agregarla a la nueva lista de solo palabras.
 */
