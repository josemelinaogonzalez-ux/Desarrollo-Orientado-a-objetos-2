public class Main {

    public static void main(String[] args) {

        PedidoComida comida = new PedidoComida(
                1,
                "Av. Los Lagos 123",
                4.0
        );

        PedidoEncomienda encomienda = new PedidoEncomienda(
                2,
                "Calle Puerto Montt 456",
                6.0
        );

        PedidoExpress express = new PedidoExpress(
                3,
                "Av. Austral 789",
                8.0
        );

        System.out.println("=== PEDIDO COMIDA ===");
        comida.mostrarResumen();
        System.out.println("Tiempo estimado: "
                + comida.calcularTiempoEntrega() + " minutos");

        System.out.println();

        System.out.println("=== PEDIDO ENCOMIENDA ===");
        encomienda.mostrarResumen();
        System.out.println("Tiempo estimado: "
                + encomienda.calcularTiempoEntrega() + " minutos");

        System.out.println();

        System.out.println("=== PEDIDO EXPRESS ===");
        express.mostrarResumen();
        System.out.println("Tiempo estimado: "
                + express.calcularTiempoEntrega() + " minutos");
    }
}