package speedfast;

/**
 * Pedido de encomienda (documentos o paquetes).
 * Tiempo: 20 min + 1.5 min por km, ajustado a entero.
 * Asignación automática: Daniela Tapia (furgón de encomiendas).
 */
public class PedidoEncomienda extends Pedido {

    /**
     * @param idPedido    código del pedido
     * @param direccion   dirección de entrega
     * @param distanciaKm distancia en kilómetros
     */
    public PedidoEncomienda(String idPedido, String direccion, int distanciaKm) {
        super(idPedido, direccion, distanciaKm);
    }

    /**
     * Las encomiendas las toma Juan Bonilla.
     */
    @Override
    public void asignarRepartidor() {
        this.repartidor = "Juan Bonilla";
    }

    /**
     * Tiempo = 20 min + 1.5 min por kilómetro, redondeado.
     */
    @Override
    public int calcularTiempoEntrega() {
        return (int) Math.round(20 + 1.5 * distanciaKm);
    }
}
