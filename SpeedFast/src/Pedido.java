import java.util.ArrayList;

public abstract class Pedido implements Despachable, Cancelable, Rastreable {

    // Atributos solicitados para esta semana
    protected int id;
    protected String direccionEntrega;
    protected EstadoPedido estado;

    // Atributos utilizados por las clases anteriores
    protected double distanciaKm;
    protected String repartidor;
    protected ArrayList<String> historial = new ArrayList<>();

    // Constructor principal solicitado
    public Pedido(int id, String direccionEntrega) {
        this.id = id;
        this.direccionEntrega = direccionEntrega;
        this.estado = EstadoPedido.PENDIENTE;

        historial.add("Pedido creado");
    }

    // Constructor compatible con las clases anteriores
    public Pedido(int id, String direccionEntrega, double distanciaKm) {
        this(id, direccionEntrega);
        this.distanciaKm = distanciaKm;
    }

    // Getter del ID
    public int getId() {
        return id;
    }

    // Setter del ID
    public void setId(int id) {
        this.id = id;
    }

    // Getter de dirección
    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    // Setter de dirección
    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    // Getter del estado
    public EstadoPedido getEstado() {
        return estado;
    }

    // Setter del estado
    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    // Método solicitado por el enunciado
    public void setEstado(String nuevoEstado) {
        this.estado = EstadoPedido.valueOf(nuevoEstado.toUpperCase());
    }

    // Método utilizado por el proyecto anterior
    public void mostrarResumen() {
        System.out.println("ID Pedido: " + id);
        System.out.println("Dirección de entrega: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
        System.out.println("Estado: " + estado);

        if (repartidor != null) {
            System.out.println("Repartidor: " + repartidor);
        }
    }

    // Se mantiene para las clases hijas existentes
    public abstract int calcularTiempoEntrega();

    // Se mantiene para las clases hijas existentes
    public abstract void asignarRepartidor();

    public void asignarRepartidor(String nombre) {
        this.repartidor = nombre;
        historial.add("Repartidor asignado manualmente: " + nombre);
        System.out.println("Repartidor asignado manualmente: " + nombre);
    }

    @Override
    public void despachar() {
        historial.add("Pedido despachado");
        System.out.println("Pedido " + id + " despachado.");
    }

    @Override
    public void cancelar() {
        historial.add("Pedido cancelado");
        System.out.println("Pedido " + id + " cancelado.");
    }

    @Override
    public void verHistorial() {
        System.out.println("Historial del pedido " + id + ":");

        for (String evento : historial) {
            System.out.println("- " + evento);
        }
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", direccionEntrega='" + direccionEntrega + '\'' +
                ", estado=" + estado +
                '}';
    }
}