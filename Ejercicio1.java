package hilos_ejercicios;

class HiloHerencia extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("HiloHerencia (Thread): " + i);
            try {
                Thread.sleep(500); // Pausa de 500ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class HiloInterfaz implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("HiloInterfaz (Runnable): " + i);
            try {
                Thread.sleep(500); // Pausa de 500ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Ejercicio1 {
    public static void main(String[] args) {
        System.out.println("Inicio del programa principal");
        
        // Creación e inicio de hilos
        HiloHerencia hilo1 = new HiloHerencia();
        Thread hilo2 = new Thread(new HiloInterfaz());
        
        hilo1.start();
        hilo2.start();
        
        System.out.println("Fin del programa principal (El programa main termina, pero los hilos siguen ejecutándose)");
    }
}
