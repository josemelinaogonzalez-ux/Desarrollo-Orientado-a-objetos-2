import java.util.LinkedList;
import java.util.Queue;

public class ZonaDeCarga {

    private final Queue<Pedido> pedidosPendientes = new LinkedList<>();

    public synchronized void agregarPedido(Pedido p) {
        pedidosPendientes.add(p);
        System.out.println("Pedido " + p.getId() + " agregado a la zona de carga.");
    }

    public synchronized Pedido retirarPedido() {
        if (pedidosPendientes.isEmpty()) {
            return null;
        }

        return pedidosPendientes.poll();
    }
}