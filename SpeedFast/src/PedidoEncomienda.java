public class PedidoEncomienda extends Pedido {

    public PedidoEncomienda(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public int calcularTiempoEntrega() {
        return (int) Math.round(20 + (1.5 * distanciaKm));
    }

    @Override
    public void asignarRepartidor() {
        repartidor = "Repartidor de encomiendas";
        System.out.println("Repartidor asignado automáticamente: " + repartidor);
    }
}