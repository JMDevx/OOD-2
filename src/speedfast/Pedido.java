package speedfast;

/**
 * Clase abstracta que representa un pedido de SpeedFast
 * Reune los atributos y el comportamiento común a todos los tipos de pedido
 * y obliga a cada subclase a definir como se calcula su tiempo de entrega.
 */
public abstract class Pedido {

    /** Código del pedido. */
    protected String idPedido;

    /** Dirección a la que se lleva el pedido. */
    protected String direccionEntrega;

    /** Distancia hasta el punto de entrega en kilometros */
    protected int distanciaKm;

    /**
     * Crea un pedido con sus datos comunes
     *
     * @param idPedido         codigo del pedido
     * @param direccionEntrega direccion de entrega
     * @param distanciaKm      distancia en kilometros
     */
    public Pedido(String idPedido, String direccionEntrega, int distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
    }

    /**
     * Imprime los datos básicos del pedido
     */
    public void mostrarResumen() {
        System.out.println(getClass().getSimpleName() + " #" + idPedido);
        System.out.println("Dirección: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
    }

    /**
     * Calcula el tiempo estimado de entrega en minutos
     * Cada subclase aplica su propia formula
     *
     * @return tiempo estimado en minutos
     */
    public abstract int calcularTiempoEntrega();

    /**
     * @return codigo del pedido
     */
    public String getIdPedido() {
        return idPedido;
    }

    /**
     * @return distancia en kilometros
     */
    public int getDistanciaKm() {
        return distanciaKm;
    }
}
