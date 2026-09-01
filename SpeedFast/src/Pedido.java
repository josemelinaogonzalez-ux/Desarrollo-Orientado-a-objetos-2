import java.util.ArrayList;

public abstract class Pedido implements Despachable, Cancelable, Rastreable {

    protected int idPedido;
    protected String direccionEntrega;
    protected double distanciaKm;
    protected String repartidor;

    protected ArrayList<String> historial = new ArrayList<>();

    public Pedido(int idPedido, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;

        historial.add("Pedido creado");
    }

    public void mostrarResumen() {
        System.out.println("ID Pedido: " + idPedido);
        System.out.println("Dirección de entrega: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");

        if (repartidor != null) {
            System.out.println("Repartidor: " + repartidor);
        }
    }

    public abstract int calcularTiempoEntrega();

    public abstract void asignarRepartidor();

    public void asignarRepartidor(String nombre) {
        this.repartidor = nombre;
        historial.add("Repartidor asignado manualmente: " + nombre);
        System.out.println("Repartidor asignado manualmente: " + nombre);
    }

    @Override
    public void despachar() {
        historial.add("Pedido despachado");
        System.out.println("Pedido " + idPedido + " despachado.");
    }

    @Override
    public void cancelar() {
        historial.add("Pedido cancelado");
        System.out.println("Pedido " + idPedido + " cancelado.");
    }

    @Override
    public void verHistorial() {
        System.out.println("Historial del pedido " + idPedido + ":");

        for (String evento : historial) {
            System.out.println("- " + evento);
        }
    }
}