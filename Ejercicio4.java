package hilos_ejercicios;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Tarea implements Runnable {
    private String nombre;

    public Tarea(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        System.out.println("=> Iniciando [" + nombre + "] en: " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000); // Simulando un trabajo que toma 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("<= Finalizando [" + nombre + "]");
    }
}

public class Ejercicio4 {
    public static void main(String[] args) {
        System.out.println("Creando un Pool de 3 Hilos (FixedThreadPool)...");
        // Reutilizará 3 hilos para manejar todas las tareas que le enviemos
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Enviamos 7 tareas al executor
        for (int i = 1; i <= 7; i++) {
            Runnable tarea = new Tarea("Tarea-" + i);
            executor.execute(tarea);
        }

        // shutdown() no interrumpe las tareas iniciadas, pero impide que se acepten tareas nuevas
        executor.shutdown();
        
        while (!executor.isTerminated()) {
            // Esperando en bucle a que terminen todas las tareas (se suele hacer mejor con awaitTermination)
        }
        
        System.out.println("Programa principal: Todas las tareas del Pool han finalizado.");
    }
}
