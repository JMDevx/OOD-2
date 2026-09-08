package speedfast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Repartidor concurrente de SpeedFast.
 * Cada instancia corre como un hilo independiente y procesa
 * su lista de pedidos de forma secuencial, simulando el tiempo
 * de entrega con pausas aleatorias.
 */
public class Repartidor implements Runnable {

    /** Nombre del repartidor. */
    private final String nombre;

    /** Lista de pedidos asignados a este repartidor. */
    private final List<Pedido> pedidos;

    /**
     * Crea un repartidor sin pedidos asignados.
     *
     * @param nombre nombre del repartidor
     */
    public Repartidor(String nombre) {
        this.nombre = nombre;
        this.pedidos = new ArrayList<>();
    }

    /**
     * Agrega un pedido a la lista de este repartidor.
     *
     * @param pedido pedido a asignar
     */
    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    /**
     * Entrega todos los pedidos de forma secuencial.
     * Por cada pedido imprime un mensaje de inicio, simula el tiempo
     * de traslado con Thread.sleep() aleatorio (500 a 2 000 ms) e
     * imprime la confirmación de entrega.
     */
    @Override
    public void run() {
        for (Pedido pedido : pedidos) {
            System.out.println("[Repartidor: " + nombre + "] Entregando "
                    + pedido.getEtiqueta() + " #" + pedido.getIdPedido() + "...");
            try {
                // ThreadLocalRandom evita contención entre hilos (sin race conditions)
                int espera = ThreadLocalRandom.current().nextInt(500, 2001);
                Thread.sleep(espera);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("[Repartidor: " + nombre + "] Hilo interrumpido.");
                return;
            }
            System.out.println("[Repartidor: " + nombre + "] Pedido #"
                    + pedido.getIdPedido() + " entregado.");
        }
    }

    public String getNombre() {
        return nombre;
    }
}
