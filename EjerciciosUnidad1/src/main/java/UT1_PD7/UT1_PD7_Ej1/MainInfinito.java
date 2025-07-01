package UT1_PD7.UT1_PD7_Ej1;

public class MainInfinito {
    public static void main(String[] args) {
        String s = "1";
        while (s != "1000") {
            s += "0";
            System.out.println("a");
        }
    }
}
/*
El buce es infinito, ya que debido a que los String son inmutables (no pueden cambiar) con cada iteracion que se le
agrega un 0 a s, en realidad no se esta modificando el s original sino que con cada iteracions apunta a un nuevo objeto,
y la comparacion s!="1000" verifica que amos objetos estan en la misma referencia de memoria en vez de
revisar sus contenidos.
En el caso de c# si compara elcontenido de las cadenas.
 */
