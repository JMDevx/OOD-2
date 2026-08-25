package speedfast;

/**
 * Prueba de la jerarquía de pedidos.
 * Crea un objeto de cada tipo y muestra su resumen junto al tiempo estimado de entrega.
 */
public class Main {

    /**
     * Arranca las pruebas en consola.
     *
     * @param args no se usan
     */
    public static void main(String[] args) {
        Pedido comida = new PedidoComida("001", "Av. Italia 456", 4);
        Pedido encomienda = new PedidoEncomienda("002", "Av. Independencia 123", 6);
        Pedido express = new PedidoExpress("003", "Av. Apoquindo 1500", 7);

        Pedido[] pedidos = {comida, encomienda, express};

        for (Pedido pedido : pedidos) {
            pedido.mostrarResumen();
            System.out.println("Tiempo estimado de entrega: " + pedido.calcularTiempoEntrega() + " minutos");
            System.out.println();
            System.out.println();
        }
    }
}
