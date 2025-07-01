package UT3_PD4;

import utils.ManejadorArchivosGenerico;

public class MainDef {
    public static void main(String[] args) {
       Almacen almacen=new Almacen("dd","jasnjak","jhdhjsnaj");
        ManejadorArchivosGenerico manejadorArchivosGenerico=new ManejadorArchivosGenerico();
        String[] arreglo=manejadorArchivosGenerico.leerArchivo("src/main/java/UT3_PD4/ArchivosPrueba/altasPrueba.txt");
        for(int i=0;i<arreglo.length;i++){
            String linea= arreglo[i];
            String[] infoProducto=new String[4];
            String palabra="";
            int contador=0;
            for(int j=0;j<linea.length();j++){
                if(linea.charAt(j)!=',') {
                    palabra+=linea.charAt(j);
                }
                else{
                    infoProducto[contador]=palabra;
                    contador++;
                    palabra="";
                }
            }
            infoProducto[contador]=palabra;
            almacen.insertarProducto(new Producto(infoProducto[0],infoProducto[1],Integer.parseInt(infoProducto[2]),Integer.parseInt(infoProducto[3])));
        }

        almacen.listarOrdenadoPorNombre();

    }
}
