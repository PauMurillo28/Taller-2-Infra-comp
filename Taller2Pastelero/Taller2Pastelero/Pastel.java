package Taller2Pastelero;

import java.util.Random;

public class Pastel {
    Random randi = new Random();
    private int alto;
    private int radio;
    private String sabor;
    private String color;
    private enum Colores{
        AMARILLO,AZUL,ROJO,BLANCO,NEGRO
    }
    private enum Sabores{
        VAINILLA, RED_VELVET,MORAZUL,CHOCOLATE, FRESA
    }

    public Pastel() {
        this.alto = randi.nextInt(20)+1;
        this.radio = randi.nextInt(10)+1;
        this.sabor = "chiocolate";
        this.color = "amarillo";
    }

    public synchronized int consultaPedido() {


        if (alto == 0 && radio == 0 && sabor == "" && color == "") {
            return -2;
        } else {
            return 1;
        }
    }

    public synchronized void hacerPedido() {

        this.alto = 5;
        this.radio = 7;
        this.sabor = "Chocolate";
        this.color = "Amarillo";


    }

    
}
