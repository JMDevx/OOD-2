package speedfast;

/**
 * Simulación Semana 3. Salida alineada al ejemplo referencial de la pauta.
 */
public class Main {

    /**
     * @param args no se usan
     */
    public static void main(String[] args) {
        Pedido comida = new PedidoComida("101", "Av. Italia 456", 4);
        Pedido encomienda = new PedidoEncomienda("102", "Av. Santa Rosa 567", 7);
        Pedido express = new PedidoExpress("103", "Av. Apoquindo 1500", 3);

        ControladorDeEnvios controlador = new ControladorDeEnvios();

        controlador.seleccionar(comida);
        controlador.reservar();

        encomienda.asignarRepartidor("Daniela Tapia");

        comida.mostrarResumen();
        controlador.seleccionar(comida);
        controlador.despachar();
        System.out.println();

        encomienda.mostrarResumen();
        controlador.seleccionar(encomienda);
        controlador.despachar();
        System.out.println();

        controlador.seleccionar(express);
        controlador.cancelar();
        System.out.println();

        controlador.verHistorial();
    }
}
