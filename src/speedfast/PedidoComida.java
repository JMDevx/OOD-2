package speedfast;

/**
 * Pedido de comida de un restaurante
 * Tiempo de entrega: 15 minutos base mas 2 minutos por cada kilometro
 */
public class PedidoComida extends Pedido {

    /**
     * Crea un pedido de comida.
     *
     * @param idPedido    codigo del pedido
     * @param direccion   direccion de entrega
     * @param distanciaKm distancia en kilometros
     */
    public PedidoComida(String idPedido, String direccion, int distanciaKm) {
        super(idPedido, direccion, distanciaKm);
    }

    /**
     * Tiempo = 15 min + 2 min por cada kilometro
     */
    @Override
    public int calcularTiempoEntrega() {
        return 15 + 2 * distanciaKm;
    }
}
