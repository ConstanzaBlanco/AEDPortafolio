package org.example.UT6_PD7;

public class Alumno {
    private int ID;
    private String fullName;
    private String email;

    public Alumno(int ID, String fullName, String email) {
        this.ID = ID;
        this.fullName = fullName;
        this.email = email;
    }

    public boolean equals(Object obj) {
        if (obj == null ){
            return false;
        }
        if (this == obj){
            return true;
        }

        Alumno otro = (Alumno) obj;
        return (ID == otro.ID && fullName.equals(otro.fullName) && email.equals(otro.email));
    }

    public int hashCode() {
        int resultado = Integer.hashCode(ID);
        if(fullName!=null){
            resultado=31* resultado+ fullName.hashCode();
        }
        else{
            resultado=31* resultado;
        }
        if(email!=null){
            resultado=31* resultado+ email.hashCode();
        }
        else{
            resultado=31* resultado;
        }
        return resultado;
    }
}
