package hilos_ejercicios;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Callable a diferencia de Runnable, SI puede devolver un resultado y lanzar Excepciones
class SumaAleatoria implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(" > Hilo secundario (" + Thread.currentThread().getName() + "): Pensando y calculando...");
        Thread.sleep(3000); // Simulamos una operación costosa
        
        int a = (int) (Math.random() * 100);
        int b = (int) (Math.random() * 100);
        System.out.println(" > Hilo secundario: Sumaré " + a + " + " + b);
        
        return a + b;
    }
}

public class Ejercicio5 {
    public static void main(String[] args) {
        // En este caso, creamos un pool de un solo hilo
        ExecutorService executor = Executors.newSingleThreadExecutor();

        System.out.println("1. Hilo principal: Enviando tarea matemática al Callable...");
        
        // Future almacena la promesa de un resultado que llegará en el futuro
        Future<Integer> resultadoFuturo = executor.submit(new SumaAleatoria());

        System.out.println("2. Hilo principal: Haciendo otras cosas UI/Main mientras el cálculo ocurre de fondo...");
        try {
            Thread.sleep(1000);
            System.out.println(" (Hilo principal sigue libre)");
        } catch (InterruptedException e) {}

        try {
            System.out.println("3. Hilo principal: Esperando el resultado final usando get()...");
            // get() bloquea este hilo principal HASTA que el Callable termine y devuelva el Integer
            Integer resultado = resultadoFuturo.get(); 
            
            System.out.println("4. Hilo principal: !!! El resultado devuelto por el hilo es: " + resultado);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
