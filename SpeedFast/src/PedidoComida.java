public class PedidoComida extends Pedido {

    public PedidoComida(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public int calcularTiempoEntrega() {
        return 15 + (int) (2 * distanciaKm);
    }

    @Override
    public void asignarRepartidor() {
        repartidor = "Repartidor de comida";
        System.out.println("Repartidor asignado automáticamente: " + repartidor);
    }
}