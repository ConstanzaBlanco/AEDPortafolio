package UT1_PD7.UT1_PD7_Ej1.UT1_PD7_Ej2;

public class MainPD7 {
    public static void main(String[] args) {
        MainPD7 main = new MainPD7();
        main.If1();
        main.If2();
        main.VersionCorrectaEj1();
    }
    public void If1(){
        String s1 = "Hola";
        String s2 = "Hola";
        if ( s1 == s2 ) {
            System.out.println( "True" );
        } else {
            System.out.println( "False" );
        }
    }
    public void If2(){
        String s1 = new String("Hola");
        String s2 = "Hola";
        if ( s1 == s2 ) {
            System.out.println( "True" );
        } else {
            System.out.println( "False" );
        }
    }
    public void VersionCorrectaEj1(){
        String s = "1";
        while (!s.equals("1000")) {
            s += "0";
            System.out.println("a");
        }
    }
}
/*
.intern() lo que hace es devolver la misma referencia si el String ya se encuentra en el pool de Strings.
En la sentencia 1 se ejecuta True, ya que s1 y s2 tienen la misma referencia en el pool de Strings, son literales de cadena
En la segunda sentecia se ejecuta False, debido a que al crear un nuevo string,este crea si o si un nuevo objeto en memoria heap,
por lo que ambos String tienen una referencia distina.

Bibliografia:
Stack Overflow. (n.d.). When should we use intern() method of String on String literals?
https://stackoverflow.com/questions/1855170/when-should-we-use-intern-method-of-string-on-string-literals
 */
