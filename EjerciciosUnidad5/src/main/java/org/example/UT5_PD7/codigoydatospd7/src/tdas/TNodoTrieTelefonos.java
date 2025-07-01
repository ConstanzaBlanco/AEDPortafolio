package org.example.UT5_PD7.codigoydatospd7.src.tdas;

import java.util.LinkedList;

public class TNodoTrieTelefonos implements INodoTrieTelefonos {

    private TNodoTrieTelefonos[] hijos = new TNodoTrieTelefonos[10];
    private TAbonado abonado;


    public TNodoTrieTelefonos() {
        hijos = new TNodoTrieTelefonos[10];
        abonado = null;    }

    @Override
    public void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonados) {
        TNodoTrieTelefonos nodoActual = this;

        for (int i = 0; i < primerosDigitos.length(); i++) {
            int digito = Character.getNumericValue(primerosDigitos.charAt(i));
            if (nodoActual.hijos[digito] == null) {
                return;
            }
            nodoActual = nodoActual.hijos[digito];
        }
        //LLego hasta el nodo que tiene el ultimo numero del prefijo
        nodoActual.recolectarAbonados(abonados);
    }

    private void recolectarAbonados(LinkedList<TAbonado> abonados) {
        if (this.abonado != null) {
            abonados.add(this.abonado);
        }

        for (TNodoTrieTelefonos hijo : hijos) {
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
            if (nodoActual.hijos[digito] == null) {
                nodoActual.hijos[digito] = new TNodoTrieTelefonos();
            }

            nodoActual = nodoActual.hijos[digito];
        }
        nodoActual.abonado = unAbonado;
    }


    
}
