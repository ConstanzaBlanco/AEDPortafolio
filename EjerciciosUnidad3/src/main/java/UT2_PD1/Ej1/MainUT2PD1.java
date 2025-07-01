package UT2_PD1.Ej1;

import utils.ManejadorArchivosGenerico;

import static UT2_PD1.Ej1.Elemento.ContadorIF;


public class MainUT2PD1 {
    public static void main(String[] args) {
        ManejadorArchivosGenerico manejadorArchivosGenerico=new ManejadorArchivosGenerico();
        String[] arreglo=manejadorArchivosGenerico.leerArchivo("src/main/java/UT2_PD1/numeros.txt");
        int cantidadElementos=Integer.parseInt(arreglo[0]);
        Elemento[] arregloElementos=new Elemento[arreglo.length-1];
        for(int i=0;i<arreglo.length-1;i++){
            arregloElementos[i]=new Elemento();
            arregloElementos[i].clave=Integer.parseInt(arreglo[i+1]);
        }
        System.out.println("Largo del arreglo: "+cantidadElementos);
        System.out.println("Contador "+ContadorIF(arregloElementos));
        System.out.println("Primer Numero: "+arregloElementos[0].clave);
        System.out.println("Ultimo Numero: "+arregloElementos[arregloElementos.length-1].clave);
    }
}
