package UT1_PD5.UT1_PD5_Ej6;

public class MainMetodosString {
    public static void main(String[] args) {
        String texto= "hola";
        String texto2= "hola como estamos";

        //SUBSTRING
        System.out.println(texto.substring(1));//imprime ola
        System.out.println(texto.substring(0,1));//imprime h

        //SPLIT
        String[] lista=texto.split("o");
        String val="";
        for(int i=0;i<lista.length;i++){
             val+=lista[i]+" ";
        }
        System.out.println(val);
        //Imrime "h la" porque o era el separador

        String[] lista2=texto2.split("o",4);
        String val2="";
        for(int i=0;i<lista2.length;i++){
            val2+=lista2[i]+" ";
        }
        System.out.println(val2);
        //Imprime "h la c m  estamos " porque separa hasta la tercera o


        //SUBSEQUENCE
        CharSequence sub=texto.subSequence(0,3);
        System.out.print(sub);// Imprime hol


        //TRIM
        String texto3 = "   Hola, mundo!   ";
        System.out.print(texto3.trim());// Imprime "Hola, mundo!"


        //LOWERCASE
        String texto4= "HOLA MUNDO";
        System.out.print(texto.toLowerCase());//Imprime hola mundo


        //UPPERCASE
        String texto5= "hola mundo";
        System.out.println(texto5.toUpperCase());//Imprime HOLA MUNDO


        //INDEXOF
        String texto6="El Codigo Enigma";
        System.out.println(texto6.indexOf('o'));//Imprime 4
        System.out.println(texto6.indexOf("o"));//Imprime 4
        System.out.println(texto6.indexOf('o',6));//Imrpime 8
        System.out.println(texto6.lastIndexOf('o'));//Imprime 8
        System.out.println(texto6.lastIndexOf('o',6));//Imprime 4


        //CONTAINS
        System.out.println("texto".contains("a"));//Imprime false
        System.out.println("texto".contains("e"));//Imprime true


        //REPLACE
        String texto7="Cambio las a por 4";
        System.out.println(texto7.replace("a","4"));// C4mbio l4s 4 por 4
        System.out.println(texto7.replace("por", "para"));// Cambio las a para 4


        //REPLACEALL
        System.out.println(texto7.replaceAll("a","4"));//C4mbio l4s 4 por 4
        System.out.print(texto7.replaceAll("por", "para"));//Cambio las a para 4


        //REPLACEFIRST
        System.out.println(texto7.replaceFirst("a","4"));//C4mbio  las a por 4
    }
}
