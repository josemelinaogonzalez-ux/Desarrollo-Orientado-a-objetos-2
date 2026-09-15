public class Repartidor implements Runnable {

    private String nombre;
    private ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    @Override
    public void run() {

        while (true) {

            Pedido pedido = zonaDeCarga.retirarPedido();

            if (pedido == null) {
                break;
            }

            pedido.setEstado(EstadoPedido.EN_REPARTO);

            System.out.println(
                    nombre + " retiró el pedido " +
                            pedido.getId() +
                            " y está realizando la entrega."
            );

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(nombre + " fue interrumpido.");
                return;
            }

            pedido.setEstado(EstadoPedido.ENTREGADO);

            System.out.println(
                    nombre + " entregó correctamente el pedido " +
                            pedido.getId() +
                            " en " +
                            pedido.getDireccionEntrega()
            );
        }
    }
}