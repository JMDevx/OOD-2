package speedfast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Simulación Semana 4 — Concurrencia con hilos.
 * Tres repartidores procesan sus pedidos en paralelo mediante ExecutorService.
 */
public class Main {

    /**
     * @param args no se usan
     */
    public static void main(String[] args) {

        // -- Repartidor 1: Camila — comida + encomienda
        Repartidor camila = new Repartidor("Camila");
        camila.agregarPedido(new PedidoComida("101", "Av. Italia 456", 4));
        camila.agregarPedido(new PedidoEncomienda("104", "Av. Los Leones 200", 3));

        // -- Repartidor 2: Luis — express + comida
        Repartidor luis = new Repartidor("Luis");
        luis.agregarPedido(new PedidoExpress("102", "Av. Santa Rosa 567", 6));
        luis.agregarPedido(new PedidoComida("105", "Calle Bello 300", 2));

        // -- Repartidor 3: Daniela — encomienda + express
        Repartidor daniela = new Repartidor("Daniela");
        daniela.agregarPedido(new PedidoEncomienda("103", "Av. Apoquindo 1500", 8));
        daniela.agregarPedido(new PedidoExpress("106", "Av. Irarrázaval 100", 5));

        // ExecutorService con un hilo por repartidor (3 en paralelo)
        ExecutorService pool = Executors.newFixedThreadPool(3);

        pool.submit(camila);
        pool.submit(luis);
        pool.submit(daniela);

        // Cierra el pool y espera a que todos los repartidores terminen
        pool.shutdown();
        try {
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("La simulación fue interrumpida antes de completarse.");
        }

        System.out.println("\nTodas las entregas han finalizado.");
    }
}
