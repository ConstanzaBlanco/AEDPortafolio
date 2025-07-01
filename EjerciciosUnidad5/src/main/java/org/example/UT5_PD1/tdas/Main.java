package org.example.UT5_PD1.tdas;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TArbolTrie arbol=new TArbolTrie();
        arbol.insertar("Universidad","");
        arbol.insertar("Ingenieria","Universidad");
        arbol.insertar("Informatica","Ingenieria");
        arbol.insertar("Derecho","Universidad");
        arbol.insertar("Electronica","Ingenieria");
        arbol.insertar("Escribania","Derecho");
        arbol.insertar("Mecatrónica","Ingenieria");
        arbol.insertar("Abogacía","Derecho");

        arbol.listarIndentado();
        /*
        Universidad
            Ingenieria
                Informatica
                Electronica
                Mecatrónica
            Derecho
                Escribania
                Abogacía
         */
        }
    }
