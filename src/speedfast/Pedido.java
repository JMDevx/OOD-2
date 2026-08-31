package speedfast;

/**
 * Clase abstracta de un pedido SpeedFast.
 * Atributos y mostrarResumen() comunes. calcularTiempoEntrega() y
 * asignarRepartidor() los resuelve cada subclase.
 */
public abstract class Pedido {

    /** Código del pedido. */
    protected String idPedido;

    /** Dirección de entrega. */
    protected String direccionEntrega;

    /** Distancia en kilómetros. */
    protected int distanciaKm;

    /** Nombre del repartidor asignado, o null si aún no hay. */
    protected String repartidor;

    /** pendiente, despachado o cancelado */
    protected String estado;

    /**
     * Crea un pedido pendiente, sin repartidor.
     *
     * @param idPedido         código del pedido
     * @param direccionEntrega dirección de entrega
     * @param distanciaKm      distancia en kilómetros
     */
    public Pedido(String idPedido, String direccionEntrega, int distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
        this.estado = "pendiente";
        this.repartidor = null;
    }

    /**
     * Asignación automática. Cada subclase aplica su propia regla.
     */
    public abstract void asignarRepartidor();

    /**
     * Asignación manual del repartidor por nombre (sobrecarga).
     *
     * @param nombre nombre del repartidor
     */
    public void asignarRepartidor(String nombre) {
        this.repartidor = nombre;
    }

    /**
     * Tiempo estimado de entrega en minutos. Cada subclase usa su fórmula.
     *
     * @return minutos
     */
    public abstract int calcularTiempoEntrega();

    /**
     * Etiqueta de consola: "Pedido Comida", "Pedido Encomienda", "Pedido Express".
     */
    public String getEtiqueta() {
        String nombre = getClass().getSimpleName();
        if ("PedidoComida".equals(nombre)) {
            return "Pedido Comida";
        }
        if ("PedidoEncomienda".equals(nombre)) {
            return "Pedido Encomienda";
        }
        if ("PedidoExpress".equals(nombre)) {
            return "Pedido Express";
        }
        return nombre;
    }

    /**
     * Imprime el resumen en el formato del ejemplo de la pauta.
     */
    public void mostrarResumen() {
        System.out.println("[" + getEtiqueta() + "]");
        System.out.println("Pedido #" + idPedido);
        System.out.println("Dirección: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
        if (repartidor != null) {
            System.out.println("Repartidor asignado: " + repartidor);
        } else {
            System.out.println("Repartidor asignado: sin asignar");
        }
        System.out.println("Tiempo estimado: " + calcularTiempoEntrega() + " minutos");
    }

    public String getIdPedido() {
        return idPedido;
    }

    public int getDistanciaKm() {
        return distanciaKm;
    }

    public String getRepartidor() {
        return repartidor;
    }

    public String getEstado() {
        return estado;
    }

    /**
     * Pasa el pedido a despachado. Lo usa el controlador.
     *
     * @return true si se pudo despachar
     */
    boolean marcarDespachado() {
        if (!"pendiente".equals(estado)) {
            return false;
        }
        this.estado = "despachado";
        return true;
    }

    /**
     * Pasa el pedido a cancelado. Lo usa el controlador.
     *
     * @return true si se pudo cancelar
     */
    boolean marcarCancelado() {
        if (!"pendiente".equals(estado)) {
            return false;
        }
        this.estado = "cancelado";
        return true;
    }
}
