package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Maximo {
	private static int n;
    private static int valorMaximo;
    private static int lsegmento;
	private static Vector<Integer> vector;
	private static Object o1 = new Object();

	
	private static void inicializar(){
		vector = new Vector<>();
        vector.add(5);
        vector.add(3);
        vector.add(27);
        vector.add(2);
        vector.add(7);
        vector.add(11);
        vector.add(12);
        vector.add(29);
        
        n=2;
        
        lsegmento=vector.size()/n;
      
	}
		
	
    public static void actualizarMaximo(int maxLocal) {
        synchronized (o1) {
            if (maxLocal > valorMaximo) {
                valorMaximo = maxLocal;
            }
            
        }
        
    }

    public static void main(String[] args) {inicializar();
    List<T> threads = new ArrayList<>();

    int startIndex = 0;
    int endIndex = lsegmento - 1;

    for (int i = 0; i < n; i++) {
        int segmentEnd = (i == n - 1) ? vector.size() - 1 : endIndex;
        T thread = new T(startIndex, segmentEnd, vector);
        threads.add(thread);
        thread.start();
        startIndex = endIndex + 1;
        endIndex += lsegmento;
    }

    try {
        for (T thread : threads) {
            thread.join();
        }
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    System.out.println("Valor máximo: " + valorMaximo);
}



}
