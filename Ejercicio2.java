package hilos_ejercicios;

class Contador {
    private int cuenta = 0;

    // La palabra clave 'synchronized' asegura que solo un hilo a la vez acceda a este método
    public synchronized void incrementar() {
        cuenta++;
    }

    public int getCuenta() {
        return cuenta;
    }
}

public class Ejercicio2 {
    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();

        // Tarea que incrementa el contador 1000 veces
        Runnable tarea = () -> {
            for (int i = 0; i < 1000; i++) {
                contador.incrementar();
            }
        };

        // Creamos dos hilos que ejecutarán la misma tarea
        Thread t1 = new Thread(tarea);
        Thread t2 = new Thread(tarea);

        t1.start();
        t2.start();

        // join() hace que el hilo principal (main) espere a que t1 y t2 terminen
        t1.join();
        t2.join();

        // Si no usáramos 'synchronized', el resultado sería impredecible (condición de carrera)
        System.out.println("Cuenta final (debería ser 2000 gracias al synchronized): " + contador.getCuenta());
    }
}
