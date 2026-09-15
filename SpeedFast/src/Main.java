import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        // Crear la zona de carga compartida
        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

        // Crear y agregar 5 pedidos
        Pedido pedido1 = new Pedido(1, "Av. Alemania 123, Temuco") {
            @Override
            public int calcularTiempoEntrega() {
                return 20;
            }

            @Override
            public void asignarRepartidor() {
            }
        };

        Pedido pedido2 = new Pedido(2, "Calle Manuel Rodríguez 456, Temuco") {
            @Override
            public int calcularTiempoEntrega() {
                return 25;
            }

            @Override
            public void asignarRepartidor() {
            }
        };

        Pedido pedido3 = new Pedido(3, "Av. Rudecindo Ortega 789, Temuco") {
            @Override
            public int calcularTiempoEntrega() {
                return 30;
            }

            @Override
            public void asignarRepartidor() {
            }
        };

        Pedido pedido4 = new Pedido(4, "Calle Lautaro 321, Temuco") {
            @Override
            public int calcularTiempoEntrega() {
                return 15;
            }

            @Override
            public void asignarRepartidor() {
            }
        };

        Pedido pedido5 = new Pedido(5, "Av. Pablo Neruda 654, Temuco") {
            @Override
            public int calcularTiempoEntrega() {
                return 20;
            }

            @Override
            public void asignarRepartidor() {
            }
        };

        zonaDeCarga.agregarPedido(pedido1);
        zonaDeCarga.agregarPedido(pedido2);
        zonaDeCarga.agregarPedido(pedido3);
        zonaDeCarga.agregarPedido(pedido4);
        zonaDeCarga.agregarPedido(pedido5);

        // Crear un ExecutorService con 3 hilos
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Crear los 3 repartidores
        Repartidor repartidor1 = new Repartidor("Carlos", zonaDeCarga);
        Repartidor repartidor2 = new Repartidor("María", zonaDeCarga);
        Repartidor repartidor3 = new Repartidor("Pedro", zonaDeCarga);

        // Ejecutar los repartidores
        executor.execute(repartidor1);
        executor.execute(repartidor2);
        executor.execute(repartidor3);

        // No aceptar nuevas tareas
        executor.shutdown();

        // Esperar a que terminen todos los repartidores
        while (!executor.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        // Mensaje final
        System.out.println();
        System.out.println("Todos los pedidos han sido entregados correctamente");
    }
}