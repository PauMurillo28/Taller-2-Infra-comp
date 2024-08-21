package Taller2Pastelero;

public class Controller {

    public static void main(String[] args) {
        Pastel cake= new Pastel();
        Cocinero chef = new Cocinero(cake);
        
        Cliente client= new Cliente(cake);

        chef.start();
        client.start();
    }
    
    
}
