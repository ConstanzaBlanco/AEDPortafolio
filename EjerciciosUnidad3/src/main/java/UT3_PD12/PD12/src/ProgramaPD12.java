package UT3_PD12.PD12.src;

import utils.ManejadorArchivosGenerico;

import java.io.IOException;

public class ProgramaPD12 {

    public static void main(String[] args) throws IOException {
        ManejadorArchivosGenerico manejadorArchivosGenerico = new ManejadorArchivosGenerico();
        IConjunto<Alumno> BasicoIng = new Conjunto<>();
        // cargar alumnos del curso BasicoIng desde el archivo “basico-ing.txt”
        for (String alumno : manejadorArchivosGenerico.leerArchivo("src/main/java/UT3_PD12/PD12/src/basico-ing.txt")) {
            String[] info = alumno.split(",");
            Alumno alumno1 = new Alumno(Integer.parseInt(info[0]), info[1]);
            Nodo<Alumno> nodo = new Nodo<>(alumno1.getCodigo(), alumno1);
            BasicoIng.insertar(nodo);
        }


        IConjunto<Alumno> BasicoEmp = new Conjunto<>();
        // cargar alumnos del curso BasicoEmp desde el archivo “basico-emp.txt”
        for (String alumno : manejadorArchivosGenerico.leerArchivo("src/main/java/UT3_PD12/PD12/src/basico-emp.txt")) {
            String[] info = alumno.split(",");
            Alumno alumno1 = new Alumno(Integer.parseInt(info[0]), info[1]);
            Nodo<Alumno> nodo = new Nodo<>(alumno1.getCodigo(), alumno1);
            BasicoEmp.insertar(nodo);
        }

        // generar el curso "integrador101" con los alumnos que están en condiciones de cursarlo
        IConjunto<Alumno> Integrador101 = BasicoIng.union(BasicoEmp);
        System.out.println(Integrador101.imprimir());
        // guardar en un archivo "integrador101.txt"  - IDEALMENTE ordenados por código de alumno -
        Nodo<Alumno> nodo = Integrador101.getPrimero();
        String[] lineas = new String[Integrador101.cantElementos()];
        int contador = 0;
        while (nodo != null) {
            String linea = "";
            linea += nodo.getDato().getCodigo() + "," + nodo.getDato().getNombre();
            lineas[contador] = linea;
            contador++;
            nodo = nodo.getSiguiente();
        }
        manejadorArchivosGenerico.escribirArchivo("src/main/java/UT3_PD12/PD12/src/integrador101.txt", lineas);


        IConjunto<Alumno> Exigente102 = Integrador101.interseccion(BasicoEmp);
        System.out.println(Exigente102.imprimir());
        // generar el curso "exigente102" con los alumnos que están en condiciones de cursarlo
        // guardar en un archivo "exigente102.txt" - IDEALMENTE ordenados por código de alumno -
        Nodo<Alumno> nodo1 = Exigente102.getPrimero();
        String[] lineas2 = new String[Exigente102.cantElementos()];
        int contador2 = 0;
        while (nodo1 != null) {
            String linea2 = "";
            linea2 += nodo1.getDato().getCodigo() + "," + nodo1.getDato().getNombre();
            lineas2[contador2] = linea2;
            contador2++;
            nodo1 = nodo1.getSiguiente();
        }
        manejadorArchivosGenerico.escribirArchivo("src/main/java/UT3_PD12/PD12/src/Exigente102.txt", lineas2);
    }

}
