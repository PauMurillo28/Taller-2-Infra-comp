package Taller2Pastelero;
import java.util.Random;

public class Cliente extends Thread{

    Pastel pastel;

    public Cliente(Pastel pastel){
        this.pastel = pastel;

    }

    @Override
    public void run(){

        Random random = new Random();
        System.out.println( hora() + "Cliente: Estamos haciendo su pedido...");
        
        try {
            int tPedido = 3000 + random.nextInt(10000); 
            System.out.println("Tiempo de pedido: " + tPedido/1000 + " segundos");
            Thread.sleep(tPedido);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(hora() + " Su pedido esta listo.");
        pastel.hacerPedido();

        synchronized(pastel){
            try {
                pastel.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(hora() + "Pastel recibido y emtregado.");
    }

    public String hora(){
        return java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
