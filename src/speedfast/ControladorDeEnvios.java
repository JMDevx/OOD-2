package speedfast;

import java.util.ArrayList;

/**
 * Opera despacho, cancelación e historial sin meter esa lógica en Pedido.
 * Implementa Despachable, Cancelable y Rastreable.
 */
public class ControladorDeEnvios implements Despachable, Cancelable, Rastreable {

    private Pedido pedidoEnCurso;
    private final ArrayList<Pedido> historial;

    public ControladorDeEnvios() {
        this.historial = new ArrayList<>();
        this.pedidoEnCurso = null;
    }

    /**
     * Fija el pedido sobre el que corren despachar, cancelar y reservar.
     *
     * @param pedido pedido a operar
     */
    public void seleccionar(Pedido pedido) {
        this.pedidoEnCurso = pedido;
    }

    /**
     * Reserva el envío: asignación automática si todavía no hay repartidor.
     */
    public void reservar() {
        if (pedidoEnCurso == null) {
            System.out.println("No hay pedido seleccionado para reservar.");
            return;
        }
        if (!"pendiente".equals(pedidoEnCurso.getEstado())) {
            System.out.println("No se puede reservar el pedido #" + pedidoEnCurso.getIdPedido()
                    + " (estado: " + pedidoEnCurso.getEstado() + ").");
            return;
        }
        if (pedidoEnCurso.getRepartidor() == null) {
            pedidoEnCurso.asignarRepartidor();
        }
    }

    /**
     * Despacha el pedido en curso y lo agrega al historial de entregas.
     */
    @Override
    public void despachar() {
        if (pedidoEnCurso == null) {
            System.out.println("No hay pedido seleccionado para despachar.");
            return;
        }
        if (pedidoEnCurso.getRepartidor() == null) {
            System.out.println("No se puede despachar el pedido #" + pedidoEnCurso.getIdPedido()
                    + " sin repartidor.");
            return;
        }
        if (pedidoEnCurso.marcarDespachado()) {
            historial.add(pedidoEnCurso);
            System.out.println("Pedido despachado correctamente.");
        } else {
            System.out.println("No se puede despachar el pedido #" + pedidoEnCurso.getIdPedido()
                    + " (estado: " + pedidoEnCurso.getEstado() + ").");
        }
    }

    /**
     * Cancela el pedido en curso si sigue pendiente.
     */
    @Override
    public void cancelar() {
        if (pedidoEnCurso == null) {
            System.out.println("No hay pedido seleccionado para cancelar.");
            return;
        }
        if (pedidoEnCurso.marcarCancelado()) {
            System.out.println("Cancelando " + pedidoEnCurso.getEtiqueta() + " #"
                    + pedidoEnCurso.getIdPedido() + "...");
            System.out.println("→ Pedido cancelado exitosamente.");
        } else {
            System.out.println("No se puede cancelar el pedido #" + pedidoEnCurso.getIdPedido()
                    + " (estado: " + pedidoEnCurso.getEstado() + ").");
        }
    }

    /**
     * Muestra el historial de entregas despachadas.
     */
    @Override
    public void verHistorial() {
        System.out.println("Historial:");
        if (historial.isEmpty()) {
            System.out.println("No hay entregas registradas.");
            return;
        }
        for (Pedido pedido : historial) {
            System.out.println("- " + pedido.getClass().getSimpleName() + " #" + pedido.getIdPedido()
                    + " – entregado por " + pedido.getRepartidor());
        }
    }
}
