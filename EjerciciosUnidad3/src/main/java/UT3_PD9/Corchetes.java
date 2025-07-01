package UT3_PD9;

import java.util.Stack;

public class Corchetes {
    public boolean controlCorchetes(String[] cadena) {
        Stack pila = new Stack();
        for (String letra: cadena){
            if (letra.equals("{")){
                pila.push(letra);
            }
            else if (letra.equals("}") && !pila.isEmpty()){
                pila.pop();
            }
        }
        return pila.isEmpty();
    }
}
