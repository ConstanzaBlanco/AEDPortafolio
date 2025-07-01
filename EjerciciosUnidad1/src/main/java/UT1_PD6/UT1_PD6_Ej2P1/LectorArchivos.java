package UT1_PD6.UT1_PD6_Ej2P1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorArchivos {
    public static void main(String[] args) {
        LectorArchivos lec = new LectorArchivos();
        lec.leerEntradaArchivo("src/main/java/UT1_PD6/UT1_PD6_Ej2P1/archivoEjP1.txt");

    }
    public void leerEntradaArchivo(String rutaArchivo){
        FileReader fr;
        int cantLines = 0;
        int entero=0;
        float decimal=0;
        String nombre="";
        try {
            fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr);
            String lineaActual = br.readLine();
            int i=0;
            while (lineaActual != null){

                if(i==0){
                    entero = Integer.parseInt(lineaActual);
                }
                if(i==1){
                    decimal = Float.parseFloat(lineaActual);
                }
                if(i==2){
                    nombre = lineaActual;
                }
                i++;
                lineaActual = br.readLine();
            }
            System.out.println("El entero leido es: "+entero);
            System.out.println("El numero de punto flotante es: "+decimal);
            System.out.println("La cadena leida es: "+"“"+nombre+"”");
            System.out.println("¡Hola "+nombre+"! La suma de "+entero+" y "+decimal+" es: "+(entero+decimal));
            if(entero<decimal){
                int decimal2=(int)decimal;
                float result=decimal2/entero;
                int result2=Math.round(result);
                float resto = decimal % entero;
                resto = Math.round(resto * 100) / 100.0f;
                System.out.println("La división entera de "+entero+" y "+decimal+" es "+result2+" y su resto es "+resto);
            }
            else{
                int decimal2=(int)decimal;
                float result=entero/decimal2;
                int result2=Math.round(result);
                float resto = decimal % entero;
                resto = Math.round(resto * 100) / 100.0f;
                System.out.println("La división entera de "+decimal+" y "+entero+" es "+result2+" y su resto es "+resto);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo "+rutaArchivo);
            e.printStackTrace();
        } catch (IOException e)
        {
            System.out.println("Error al leer el archivo "+rutaArchivo);
            e.printStackTrace();
        }
        System.out.println("Archivo leido satisfactoriamente");
    }

}
