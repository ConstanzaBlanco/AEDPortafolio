package org.example.UT6_PD1_PD5.tdas.PD5ConPD7U5;

import java.util.HashMap;
import java.util.LinkedList;

public class TNodoTrieTelefonos implements INodoTrieTelefonos {

    private HashMap<Integer, TNodoTrieTelefonos> hijos;
    private TAbonado abonado;


    public TNodoTrieTelefonos() {
        hijos = new HashMap<>();
        abonado = null;    }

    @Override
    public void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonados) {
        TNodoTrieTelefonos nodoActual = this;

        for (int i = 0; i < primerosDigitos.length(); i++) {
            int digito = Character.getNumericValue(primerosDigitos.charAt(i));
            if (nodoActual.hijos.get(digito)==null) {
                return;
            }
            nodoActual=nodoActual.hijos.get(digito);
        }
        //LLego hasta el nodo que tiene el ultimo numero del prefijo
        nodoActual.recolectarAbonados(abonados);
    }

    private void recolectarAbonados(LinkedList<TAbonado> abonados) {
        if (this.abonado != null) {
            abonados.add(this.abonado);
        }

        for (TNodoTrieTelefonos hijo : hijos.values()) {
            if (hijo != null) {
                hijo.recolectarAbonados(abonados);
            }
        }
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        TNodoTrieTelefonos nodoActual = this;
        String telefono = unAbonado.getTelefono();

        for (int i = 0; i < telefono.length(); i++) {
            //Convierto a numero
            int digito = Character.getNumericValue(telefono.charAt(i));
            if (nodoActual.hijos.get(digito)==null) {
                nodoActual.hijos.put(digito,new TNodoTrieTelefonos());
            }
            nodoActual=nodoActual.hijos.get(digito);
        }
        nodoActual.abonado = unAbonado;
    }


    
}
