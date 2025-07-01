package UT1_PD5.UT1_PD5_Ej11;

public class ComputerResult {
    public static void main(String[] args) {
        String original = "este es el curso de Programación 2";
        StringBuilder result = new StringBuilder("hola");
        int index = original.indexOf('a');//index 25
        /*1*/ result.setCharAt(0, original.charAt(0));// cambio "hola" por "eola"
        /*2*/ result.setCharAt(1, original.charAt(original.length()-1));
        //length de original es: 34, 34-1=33, y el char numero 33 de orginal es: 2. Cambio "eola" por  "e2la"
        /*3*/ result.insert(1, original.charAt(4));
        //character en la posicion 4 de original es un espacio, y como se inserta en el 1 de result,
        // por lo tanto "e2la", pasa a ser "e 2la". No se eliminan letras solo se desplazan.
        /*4*/ result.append(original.substring(1,4));
        //el substring de original que se indica es: ste. Y como es un append se agrea al final, por lo que
        // "e 2la pasa" a ser "e 2laste"
        /*5*/ result.insert(3, (original.substring(index, index+2) + " "));
        //Este substring de origianl va desde 25 hasta 27(sin incluir el 27) y le agrega un espacio, por lo que el substring sera:
        //"am ". Result pasa de ser "e 2laste" a ser "e 2am laste"
        System.out.println(result);
        //result=e 2am laste;
    }
}

