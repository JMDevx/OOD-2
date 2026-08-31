package speedfast;

/**
 * Pedido de comida (restaurante).
 * Tiempo: 15 min + 2 min por km.
 * Asignación automática: Luis Díaz si la distancia es 5 km o menos, Pedro Rivas si es mayor.
 */
public class PedidoComida extends Pedido {

    /**
     * @param idPedido    código del pedido
     * @param direccion   dirección de entrega
     * @param distanciaKm distancia en kilómetros
     */
    public PedidoComida(String idPedido, String direccion, int distanciaKm) {
        super(idPedido, direccion, distanciaKm);
    }

    /**
     * Comida en radio corto: Luis Díaz. Más lejos, Pedro Rivas.
     */
    @Override
    public void asignarRepartidor() {
        if (distanciaKm <= 5) {
            this.repartidor = "Luis Díaz";
        } else {
            this.repartidor = "Pedro Rivas";
        }
    }

    /**
     * Tiempo = 15 min + 2 min por cada kilómetro.
     */
    @Override
    public int calcularTiempoEntrega() {
        return 15 + 2 * distanciaKm;
    }
}
