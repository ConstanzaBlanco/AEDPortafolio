package UT2_PD1.Ej1;

public class Elemento {
    int clave;
    public static int ContadorIF(Elemento[] arreglo){
        int N=arreglo.length;
        int contador=0;
       for(int i=0;i<=N-1;i++){//inicie desde i=0 porque i=1 hace que no se toque el primer elemento del arreglo
           for(int j=N-1; j>i; j--){
               if(arreglo[j].clave < arreglo[j-1].clave){
                   Elemento auxiliar=arreglo[j];
                   arreglo[j] = arreglo[j - 1];
                   arreglo[j - 1] = auxiliar;
                   contador++;
               }
           }
       }
       return contador;
    }
}
