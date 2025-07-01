package UT1_PD5_Ej1P2;

import java.util.ArrayList;

import static java.lang.Character.isLetter;

public class ContadorPalabras {
        public void ContarPalabras(String frase) {
            boolean result = false;
            int vocales=0;
            int consonantes=0;
            int suma = 0;

            for (int i = 0; i < frase.length(); i++) {
                char letra = frase.charAt(i);

                if (isLetter(letra)) {
                    result = true;

                    if (isVocal(letra)) {
                        vocales++;
                    }
                    else{
                        consonantes++;
                    }
                }

                if (letra == ' ' && result) {
                    suma++;
                    result=false;
                }
            }
            if (result) {
                ++suma;
            }
            System.out.println("Cantidad de palabras: "+suma);
            System.out.println("Cantidad de vocales: "+vocales);
            System.out.println("Cantidad de consonantes: "+consonantes);
        }

        public boolean isVocal(char letra) {
            String let=letra+"";
            boolean result = false;
            Vocales.Vocal vocales[]= Vocales.Vocal.values();
            for (int i = 0; i < vocales.length; i++) {
                String vocal= String.valueOf(vocales[i]);
                if (vocal.equals(let)) {
                    result = true;
                }
            }
            return result;
        }
    }

