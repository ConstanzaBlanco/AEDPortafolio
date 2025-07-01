package org.example.UT6_PD1_PD5.tdas.PD5ConPD7U5;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;


public class TArbolTrieTelefonos implements IArbolTrieTelefonos {

    private TNodoTrieTelefonos raiz;

    @Override
    public LinkedList<TAbonado> buscarTelefonos(String pais, String area) {
        LinkedList<TAbonado> resultado = new LinkedList<>();

        if (raiz != null) {
            String prefijo = pais + area;
            raiz.buscarTelefonos(prefijo, resultado);
        }

        //Con esto se ordena la lista segun el nombre del abonado
        Collections.sort(resultado, Comparator.comparing(TAbonado::getNombre));
        return resultado;
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        if (raiz==null){
            raiz=new TNodoTrieTelefonos();
        }
        if(unAbonado.getTelefono().length()!=11){
            System.out.println("Numero de Telefono no valido");
            return;
        }
        raiz.insertar(unAbonado);
    }

 
    
}
