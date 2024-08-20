public class Pastel {

    private int alto;
    private int radio;
    private String sabor;
    private String color;

    public pastel(int alto, int radio, String sabor, String color) {
        this.alto = alto;
        this.radio = radio;
        this.sabor = sabor;
        this.color = color;
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
