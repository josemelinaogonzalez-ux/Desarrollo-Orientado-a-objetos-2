public class Main {

    public static void main(String[] args) {

        Pedido pedido1 = new PedidoComida(
                1,
                "Av. Los Lagos 123",
                4.0
        );

        Pedido pedido2 = new PedidoEncomienda(
                2,
                "Calle Puerto Montt 456",
                6.0
        );

        Pedido pedido3 = new PedidoExpress(
                3,
                "Av. Austral 789",
                8.0
        );

        System.out.println("=== PEDIDO COMIDA ===");
        pedido1.asignarRepartidor();
        pedido1.mostrarResumen();
        System.out.println("Tiempo estimado: "
                + pedido1.calcularTiempoEntrega() + " minutos");
        pedido1.despachar();
        pedido1.verHistorial();

        System.out.println();

        System.out.println("=== PEDIDO ENCOMIENDA ===");
        pedido2.asignarRepartidor("Carlos");
        pedido2.mostrarResumen();
        System.out.println("Tiempo estimado: "
                + pedido2.calcularTiempoEntrega() + " minutos");
        pedido2.despachar();
        pedido2.verHistorial();

        System.out.println();

        System.out.println("=== PEDIDO EXPRESS ===");
        pedido3.asignarRepartidor();
        pedido3.mostrarResumen();
        System.out.println("Tiempo estimado: "
                + pedido3.calcularTiempoEntrega() + " minutos");
        pedido3.cancelar();
        pedido3.verHistorial();
    }
}
