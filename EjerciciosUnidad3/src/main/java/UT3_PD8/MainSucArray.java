package UT3_PD8;

import UT3_PD6.DirectorioSucursales;
import utils.ManejadorArchivosGenerico;

public class MainSucArray {
    public static void main(String[] args) {
        DirectorioSucursales8 directorioSucursales = new DirectorioSucursales8();
        ManejadorArchivosGenerico manejadorArchivosGenerico = new ManejadorArchivosGenerico();

        for (String direccion : manejadorArchivosGenerico.leerArchivo("src/main/java/UT3_PD6/suc1.txt")) {
            Sucursales8 sucursal1 = new Sucursales8(direccion);
            directorioSucursales.agregarSucursal(sucursal1);
        }

        System.out.println("La cantidad de elementos de suc1 es: " + directorioSucursales.cantSucursales());//La respuesta es la d.105
        directorioSucursales.eliminarSucursal("Chicago");
        Sucursales8 suc = directorioSucursales.buscarSucursal("Hong Kong");
        System.out.println("La ciudad siguiene a Hong Kong es: " +directorioSucursales.getSiguiente(suc).getDireccion() );//La respuesta es la c.Shenzen

        DirectorioSucursales8 directorioSucursales2 = new DirectorioSucursales8();
        for (String direccion2 : manejadorArchivosGenerico.leerArchivo("src/main/java/UT3_PD6/suc2.txt")) {
            Sucursales8 sucursal2 = new Sucursales8(direccion2);
            directorioSucursales2.agregarSucursal( sucursal2);
        }
        directorioSucursales2.eliminarSucursal("Shenzhen");
        directorioSucursales2.eliminarSucursal("Tokio");
        System.out.println("La cantidad de elementos es: "+directorioSucursales2.cantSucursales());//La respuesta es la d.Lo que ocurre es que queda 1 ciudad

        DirectorioSucursales8 directorioSucursales3 = new DirectorioSucursales8();
        for (String direccion3 : manejadorArchivosGenerico.leerArchivo("src/main/java/UT3_PD6/suc3.txt")) {
            Sucursales8 sucursal3 = new Sucursales8(direccion3);
            directorioSucursales3.agregarSucursal(sucursal3);
        }
        System.out.println(directorioSucursales3.ImprimirSucursalesSeparador(";_"));//Imprime la d. Montreal;_Caracas;_Tulsa;_Mobile;_Vancouver;_

    }
}
