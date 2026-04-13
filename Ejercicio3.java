package hilos_ejercicios;

import java.util.LinkedList;
import java.util.Queue;

class Buffer {
    private Queue<Integer> queue = new LinkedList<>();
    private int capacidad = 3;

    public synchronized void producir(int valor) throws InterruptedException {
        while (queue.size() == capacidad) {
            System.out.println("Buffer lleno. Productor en espera...");
            wait(); // Espera si el buffer está lleno (libera el candado / lock)
        }
        queue.add(valor);
        System.out.println("O Productor almacenó: " + valor);
        notifyAll(); // Notifica y despierta a los consumidores en espera
    }

    public synchronized void consumir() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Buffer vacío. Consumidor en espera...");
            wait(); // Espera si el buffer está vacío
        }
        int valor = queue.poll();
        System.out.println(" X Consumidor sacó: " + valor);
        notifyAll(); // Notifica y despierta a los productores en espera
    }
}

public class Ejercicio3 {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        Thread productor = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    buffer.producir(i);
                    Thread.sleep(100); // Produce rápido
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumidor = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    buffer.consumir();
                    Thread.sleep(500); // Consume lento (el buffer se llenará)
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        productor.start();
        consumidor.start();
    }
}
