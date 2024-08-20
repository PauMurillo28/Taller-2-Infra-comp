package ejercicios;

import java.util.Vector;

public class T extends Thread{
	private int start;
    private int end;
    private Vector<Integer> vector;
    
    public T(int start, int end, Vector<Integer> vector) {
        this.start = start;
        this.end = end;
        this.vector = vector;
    }

	
	public void run() {
		int maxLocal = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (vector.get(i) > maxLocal) {
                maxLocal = vector.get(i);
            }
        }
        Maximo.actualizarMaximo(maxLocal);
        System.out.println(maxLocal);
    
		
		
	}

	

}
