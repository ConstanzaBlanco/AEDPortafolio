package UT1_PD6.UT1_PD6_Ej4;

import java.util.Hashtable;

public class MultiplicacionVectores {
    public static void main(String[] args) {
        int[] a={0,1,2,3};
        int[] b={0,1,2,3};
        System.out.print(HacerMultiplicacion(a,b));

    }

    public static int HacerMultiplicacion(int[] a,int[] b){
        int suma=0;
        if(a.length!=b.length){
            System.out.print("Ambos vectores deben tener la misma cantidad de elementos");
            return -1;
        }
        else{
            for(int i=0;i<a.length;i++){
                int multi=a[i]*b[i];
                suma+=multi;
            }
            return suma;
        }
    }
}
/*Laoperacion seria de esta forma:
Se tiene un arrray con los elementos {a0,a1,a2} y otro array con los elementos {b0,b1,b2}. Cada elemento de a se va a multiplicar con 1
elemento de b, segun su posicion: el elemento de indice 0 con el otro de indice 0, es decir a0*b0, el elemento de indice 2 por el de
indice 1 delotro array: a1*b1, y asi sucesivamete hasta multiplicar los ultimos 2 elementos. Luego de tener todos los resultados estos se
suman quedando algo asi: resultado=a0*b0 + a1*b1 + a2*b2...
La unica condicion que deben cumplir es que ambos array tengan la misma cantidad de elementos.
 */