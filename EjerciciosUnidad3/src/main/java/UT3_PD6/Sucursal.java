package UT3_PD6;

public class Sucursal implements Comparable<Sucursal>{
    private String direccion;

    public Sucursal(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return direccion;
    }
    @Override
    public int compareTo(Sucursal otra) {
        return this.direccion.compareTo(otra.direccion);
    }

    @Override
    public String toString() {
        return direccion;
    }
}
