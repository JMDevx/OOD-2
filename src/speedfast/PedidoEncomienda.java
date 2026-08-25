package speedfast;

/**
 * Pedido de encomienda (documentos o paquetes)
 * Tiempo de entrega: 20 minutos base mas 1.5 minutos por kilometro
 */
public class PedidoEncomienda extends Pedido {

    /**
     * Crea un pedido de encomienda.
     *
     * @param idPedido    codigo del pedido
     * @param direccion   dirección de entrega
     * @param distanciaKm distancia en kilometros
     */
    public PedidoEncomienda(String idPedido, String direccion, int distanciaKm) {
        super(idPedido, direccion, distanciaKm);
    }

    /**
     * Tiempo = 20 min + 1.5 min por kilometro ajustado a entero
     */
    @Override
    public int calcularTiempoEntrega() {
        return (int) Math.round(20 + 1.5 * distanciaKm);
    }
}
