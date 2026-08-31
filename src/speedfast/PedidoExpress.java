package speedfast;

/**
 * Pedido express (supermercado o farmacia).
 * Tiempo: 10 min base; +5 min si supera 5 km.
 * Asignación automática: Carla Núñez si es 5 km o menos, Soto Express si es mayor.
 */
public class PedidoExpress extends Pedido {

    /**
     * @param idPedido    código del pedido
     * @param direccion   dirección de entrega
     * @param distanciaKm distancia en kilómetros
     */
    public PedidoExpress(String idPedido, String direccion, int distanciaKm) {
        super(idPedido, direccion, distanciaKm);
    }

    /**
     * Express corto: Carla Núñez. Si pasa 5 km, Soto Express.
     */
    @Override
    public void asignarRepartidor() {
        if (distanciaKm <= 5) {
            this.repartidor = "Carla Núñez";
        } else {
            this.repartidor = "Soto Express";
        }
    }

    /**
     * Tiempo = 10 min base; +5 si la distancia supera 5 kilómetros.
     */
    @Override
    public int calcularTiempoEntrega() {
        int tiempo = 10;
        if (distanciaKm > 5) {
            tiempo += 5;
        }
        return tiempo;
    }
}
