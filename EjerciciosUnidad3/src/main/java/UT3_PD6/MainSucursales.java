package UT3_PD6;

import utils.ManejadorArchivosGenerico;

public class MainSucursales {
    public static void main(String[] args) {
        DirectorioSucursales directorioSucursales = new DirectorioSucursales();
        ManejadorArchivosGenerico manejadorArchivosGenerico = new ManejadorArchivosGenerico();

        for (String direccion : manejadorArchivosGenerico.leerArchivo("src/main/java/UT3_PD6/suc1.txt")) {
            Sucursal sucursal1 = new Sucursal(direccion);
            directorioSucursales.insertar(direccion, sucursal1);
        }

        System.out.println("La cantidad de elementos de suc1 es: " + directorioSucursales.cantElementos());//La respuesta es la b.105
        directorioSucursales.eliminar("Chicago");
        System.out.println("La ciudad siguiene a Hong Kong es: " + directorioSucursales.buscar("Hong Kong").getSiguiente().getEtiqueta());//La respuesta es la c.Shenzen

        DirectorioSucursales directorioSucursales2 = new DirectorioSucursales();
        for (String direccion2 : manejadorArchivosGenerico.leerArchivo("src/main/java/UT3_PD6/suc2.txt")) {
            Sucursal sucursal2 = new Sucursal(direccion2);
            directorioSucursales2.insertar(direccion2, sucursal2);
        }
        directorioSucursales2.eliminar("Shenzhen");
        directorioSucursales2.eliminar("Tokio");
        System.out.println("La cantidad de elementos es: "+directorioSucursales2.cantElementos());//La respuesta es la d.Lo que ocurre es que quedan 0 ciudades

        DirectorioSucursales directorioSucursales3 = new DirectorioSucursales();
        for (String direccion3 : manejadorArchivosGenerico.leerArchivo("src/main/java/UT3_PD6/suc3.txt")) {
            Sucursal sucursal3 = new Sucursal(direccion3);
            directorioSucursales3.insertar(direccion3, sucursal3);
        }
        System.out.println(directorioSucursales3.imprimir(";_"));//La respuesta es la d. Queda Montreal;_Caracas;_Tulsa;_Mobile;_Vancouver;_


    }
}
