public class Main {

    public static void main(String[] args) {

        Pedido comida = new PedidoComida(
                1,
                "Avenida Los Lagos 123",
                "Comida"
        );

        Pedido encomienda = new PedidoEncomienda(
                2,
                "Calle Puerto 456",
                "Encomienda"
        );

        Pedido express = new PedidoExpress(
                3,
                "Avenida Central 789",
                "Express"
        );

        System.out.println("=== SPEEDFAST ===");

        System.out.println("\nPedido de comida:");
        comida.asignarRepartidor();
        comida.asignarRepartidor("Juan");

        System.out.println("\nPedido de encomienda:");
        encomienda.asignarRepartidor();
        encomienda.asignarRepartidor("Pedro");

        System.out.println("\nPedido express:");
        express.asignarRepartidor();
        express.asignarRepartidor("Carlos");
    }
}