package UT1_PD1.UT1_PD1_Ej4;

public class Alumno {
    private String nombre;
    public Alumno () {
        //nombre = null;
        //CORRECION
        nombre="";
    }
    public String getNombreAdmiracion() {
        return nombre.concat("!");
    }
    public static void main (String[] args) {
        Alumno alumno = new Alumno();
        System.out.println(alumno.getNombreAdmiracion());
    }
    public static int recorrer (String cadena) {
        int res = 0;
        //for (int i = 1; i <= cadena.length(); i++) {
        //CORRECION
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) != ' ') {
                res++;
            }
        }
        return res;
    }
    public static int getValor() {
        int vector[] = { 6, 16, 26,36,46,56,66,76 };
        //int idx = 8;
        //CORRECCION
        int idx=7;
        return vector[idx];
    }
    public static char getPrimerCaracter(String palabra) {
        String string[] = new String[5];
        string[1]="Hola Mundo";
        return (string[1].charAt(1));
    }
    public static String paraAString(int a) {
        Object x1 = new Integer(a);
        //return (String) (x1) ;
        //CORRECION
        return String.valueOf(x1);
    }
}


/*
Primero que nada los metodos  paraAString, getPrimerCaracter, getValor y recorrer se encontraan fuera de la clase Alumno
a) Indicar el error al ejecutar la clase Alumno y corregirlo. ¿cómo lo detectaste?
Error NullPointerException en getNombreAdmiracion. En el constructor se incializa la variable nombre
con null, luego en el metodo getNombreAdmiracion(), se intenta ejecyar nombre.concat("!"), y como el
nombre es null, se lanza la excepcion.

b) Error en el método_recorrer
En el bucle for se recorre la cadena desde i hasta el largo total de la cadena, pero los indices
comienzan en 0, por lo que en un punto cuando i llegue al largo de la cadena, esto va a causar una
excepcion StringIndexOutOfBoundsException

c) Error en el método_getValor
El vector tiene 8 elementos, pero como comienza en 0 el primer elemento, el ultimo elemento va a ser
el 7 por lo que intentar acceder al index 8, va a dar el error ArrayIndexOutOfBoundsException.

d) Error en el método_getPrimerCaracter
Cuando se declara el array String se hace con 5 elementos, pero todos se encuentran vacios, por lo que
al intentar string[1].charAt(1), como la posicion 1 esta null, se crea la excepcion NullPointerException

e) Error en el método_paraAString
Se intenta castear de forma incorrecta un Integer a un String, por lo que se lanza la excepcion ClassCastException
 */
