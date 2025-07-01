package UT1_PD6.UT1_PD6_Ej3P2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrincipalEj3Parte2 {
    public static void main(String[] args) {
        PrincipalEj3Parte2 p=new PrincipalEj3Parte2();
        p.transformarTextoT9("src/main/java/UT1_PD6/UT1_PD6_Ej3P1/entrada.txt");

    }
    public static void transformarTextoT9(String rutaArchivo){
        HashMap<String,Integer> letras=new HashMap<>();
            letras.put(" ", 0);
            letras.put(".", 1);
            letras.put("a", 2);
            letras.put("b", 2);
            letras.put("c", 2);
            letras.put("d", 3);
            letras.put("e", 3);
            letras.put("f", 3);
            letras.put("g", 4);
            letras.put("h", 4);
            letras.put("i", 4);
            letras.put("j", 5);
            letras.put("k", 5);
            letras.put("l", 5);
            letras.put("m", 6);
            letras.put("n", 6);
            letras.put("o", 6);
            letras.put("p", 7);
            letras.put("q", 7);
            letras.put("r", 7);
            letras.put("s", 7);
            letras.put("t", 8);
            letras.put("u", 8);
            letras.put("v", 8);
            letras.put("w", 9);
            letras.put("x", 9);
            letras.put("y", 9);
            letras.put("z", 9);
            List<String> lista=leerEntradaArchivo(rutaArchivo);
            List<String> invertido=InvertirTodo(lista);
            lista=invertido;
            List<String> letrasEnT9= new ArrayList<>();
            for(String linea:lista){
                String nuevaLinea="";
                linea=linea.toLowerCase();

                for(char letra:linea.toCharArray()){

                    String letraStr=String.valueOf(letra);

                    Integer valor=letras.get(letraStr);
                    nuevaLinea+=valor;
                }
                letrasEnT9.add(nuevaLinea);
            }
            escribirArchivo("salida2.txt", letrasEnT9.toArray(new String[0]));
        }


        public static List<String> leerEntradaArchivo(String rutaArchivo) {
            FileReader fr;
            List<String> linea = new ArrayList<String>();
            try {
                fr = new FileReader(rutaArchivo);
                BufferedReader br = new BufferedReader(fr);
                String lineaActual = br.readLine();
                while (lineaActual != null) {
                    linea.add(lineaActual);
                    lineaActual = br.readLine();
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error al leer el archivo " + rutaArchivo);
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Error al leer el archivo " + rutaArchivo);
                e.printStackTrace();
            }
            System.out.println("Archivo leido satisfactoriamente");
            return linea;
        }

        public static void escribirArchivo(String nombreCompletoArchivo, String[] listaLineasArchivo) {
            FileWriter fw;
            try {
                fw = new FileWriter(nombreCompletoArchivo,true);
                BufferedWriter bw = new BufferedWriter(fw);
                for (int i = 0; i < listaLineasArchivo.length; i++){
                    String lineaActual = listaLineasArchivo[i];
                    bw.write(lineaActual);
                    bw.newLine();
                }
                bw.close();
                fw.close();
            } catch (IOException e) {
                System.out.println("Error al escribir el archivo "+nombreCompletoArchivo);
                e.printStackTrace();
            }
        }

        public static List<String> InvertirTodo(List<String> listaAInvertir){
        List<String> listaInvertida= new ArrayList<>();
        for(int i=listaAInvertir.size()-1;i>=0;i--){
            String linea=listaAInvertir.get(i);
            String nuevaLinea="";
            for(int j=linea.length()-1;j>=0;j--){
                String letra=linea.substring(j,j+1);
                nuevaLinea+=letra;
            }
            listaInvertida.add(nuevaLinea);
        }
        return listaInvertida;
        }
    }


