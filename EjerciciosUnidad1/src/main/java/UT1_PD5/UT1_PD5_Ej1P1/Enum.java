package UT1_PD5.UT1_PD5_Ej1P1;

import UT1_PD5.UT1_PD5_Ej1P1.Colours;

public class Enum {
    Colours.Colour colour;

    public Enum(Colours.Colour colour) {
        this.colour=colour;
    }
    public void tellItLikeItIs() {
        switch(colour){
            case RED: System.out.println("Roses are red");break;
            case YELLOW: System.out.println("Sun is yellow");break;
            case BLUE: System.out.println("Ocean is blue");break;
            case GREEN: System.out.println("Grass is green");break;
            case BLACK: System.out.println("Ants are black");break;
            case WHITE: System.out.println("Snow is white");break;
            case PURPLE: System.out.println("Lavenders are purple");break;
            case PINK: System.out.println("Pigs are pink");break;
        }
    }
}
