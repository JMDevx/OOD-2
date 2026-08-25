package speedfast;

/**
 * Pedido de compras express (supermercado o farmacia).
 * Tiempo de entrega: 10 minutos base; si supera los 5 kilometros, se suman 5 minutos.
 */
public class PedidoExpress extends Pedido {

    /**
     * Crea un pedido express
     *
     * @param idPedido    codigo del pedido
     * @param direccion   direccion de entrega
     * @param distanciaKm distancia en kilometros
     */
    public PedidoExpress(String idPedido, String direccion, int distanciaKm) {
        super(idPedido, direccion, distanciaKm);
    }

    /**
     * Tiempo = 10 min base, si la distancia supera 5 kilometros, se agregan 5 min extra
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
