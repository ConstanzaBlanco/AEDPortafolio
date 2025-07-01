package org.example.UT6_PD7;

import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Ejercicio 2
        Integer hola= "Hola".hashCode();
        Integer holaMundo= "HolaMundo".hashCode();
        Integer hashMap= "HashMap".hashCode();
        Integer colecciones="Colecciones".hashCode();
        System.out.println(hola); // 2255068
        System.out.println(holaMundo); // -1191400619
        System.out.println(hashMap); // -1932803762
        System.out.println(colecciones); // -1872965711

        //El tamaño por defecto de un hashMap es 16, por lo tanto hay 0-15 posiciones

        hola=Math.abs(hola%15);
        holaMundo=Math.abs(holaMundo%15);
        hashMap=Math.abs(hashMap%15);
        colecciones=Math.abs(colecciones%15);

        System.out.println(hola); // 13
        System.out.println(holaMundo); // 14
        System.out.println(hashMap); // 2
        System.out.println(colecciones); // 11

        /*
        Índice   Contenido
        -------------------
          0      [null]
          1      [null]
          2      HashMap
          3      [null]
          4      [null]
          5      [null]
          6      [null]
          7      [null]
          8      [null]
          9      [null]
         10      [null]
         11      Colecciones
         12      [null]
         13      Hola
         14      HolaMundo
         */

    }
}