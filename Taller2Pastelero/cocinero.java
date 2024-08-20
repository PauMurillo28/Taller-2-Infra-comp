import java.util.Random;

public class cocinero extends Thread{

    Pastel pastel;

    public cocinero(pastel pastel){
        this.pastel = pastel;
    }

    @Override
    public void run(){

        boolean flag = true;
        while(flag){

            System.out.println(hora() + " Pastelero: Estamos revisando su pedido.");


            if(pastel.consultaPedido() == -2){

                System.out.println(hora() + " Pastelero: No hay ningun pedido para preparar, espera 5 segundos");
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            else{
                
                flag = false;
            }
        }

        Random random = new Random();
        System.out.println(hora() + " Estamos preparando el pastel.");
        try {
            int tPreparacion = 5000 + random.nextInt(10000); 
            System.out.println("Tiempo de preparación del pastel: " + tPreparacion/1000 + " segundos");
            Thread.sleep(tPreparacion);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println(hora() + "El pastel listo.");
        synchronized(pastel){
            pastel.notify();
        }

    }

    public String hora(){
        return java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

}
