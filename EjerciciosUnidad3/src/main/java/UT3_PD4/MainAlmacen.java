package UT3_PD4;
import utils.ManejadorArchivosGenerico;

import java.util.ArrayList;

import static java.lang.Character.isDigit;

public class MainAlmacen {

    public static void main(String[] args) {

        //EJERCICIO 1 ALTAS.TXT
        Almacen almacen = new Almacen("hola","123","Hola mundo");
        ManejadorArchivosGenerico manejadorArchivosGenerico=new ManejadorArchivosGenerico();
        String[] arreglo=manejadorArchivosGenerico.leerArchivo("src/main/java/UT3_PD4/ArchivosPrueba/altasPrueba.txt");
        int valorAgregado=0;
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
            valorAgregado+=Integer.parseInt(infoProducto[2])*Integer.parseInt(infoProducto[3]);
        }
        System.out.println("Valor total de los productos agregados: "+valorAgregado);



        almacen.listarOrdenadoPorNombre();
        System.out.println("¿Se pudo agregar stock? "+almacen.agregarStock("1000073",40));
        System.out.println("¿Se pudo eliminar stock? "+almacen.restarStock("1000073",1000));
        almacen.listarOrdenadoPorNombre();

        System.out.println("¿Metodo buscar por codigo funciona? "+almacen.buscarPorCodigo("1000073").getNombre().equals("GALLETAS CEREALITAS CLASICAS"));
        System.out.println(almacen.cantidadProductos());
        System.out.println("¿Metodo eliminar funciona? "+almacen.eliminar("1000073"));
        System.out.println(almacen.cantidadProductos());

        //Agrego el producto que elimine antes
        almacen.insertarProducto(new Producto("1000073","GALLETAS CEREALITAS CLASICAS",103,307));
        System.out.println("ANTES DE VENDER");
        almacen.listarOrdenadoPorNombre();

        String[] arregloVentas=manejadorArchivosGenerico.leerArchivo("src/main/java/UT3_PD4/ArchivosPrueba/ventasPrueba.txt");
        int valorVendido=0;
        for(int i=0;i<arregloVentas.length;i++){
            String linea= arregloVentas[i];
            String[] infoVenta=new String[2];
            String palabra2="";
            int contador2=0;
            for(int j=0;j<linea.length();j++){
                if(linea.charAt(j)!=',') {
                    palabra2+=linea.charAt(j);
                }
                else{
                    if(palabra2.matches("-?\\d+")) {//Aca verifico si es un numero, ya que aca me tendrian que da runicamente numeros
                        infoVenta[contador2] = palabra2;
                        contador2++;
                        palabra2 = "";
                    }
                }
            }
            infoVenta[contador2]=palabra2;
            if(infoVenta[0]!=null && infoVenta[1]!=null){
                try{
                    int cantidad=Integer.parseInt(infoVenta[1]);
                    almacen.restarStock(infoVenta[0],Integer.parseInt(infoVenta[1]));
                    Producto producto=almacen.buscarPorCodigo(infoVenta[0]);
                    valorVendido+=cantidad*producto.getPrecio();
                }
                catch (Exception e){
                    System.out.println("Error en la venta de "+infoVenta[0]);
                }
            }
        }
        System.out.println("Valor total de las ventas: "+valorVendido);
        System.out.println("DESPUES DE VENDER");
        almacen.listarOrdenadoPorNombre();

    }


}


