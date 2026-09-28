package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Entrega {
    private int idEntrega;
    private Pedido pedido;
    private Repartidor repartidor;
    private LocalDate fecha;
    private LocalTime hora;

    public Entrega( Pedido pedido, Repartidor repartidor, LocalDate fecha, LocalTime hora ) {
        setPedido(pedido);
        setRepartidor(repartidor);
        setFecha(fecha);
        setHora(hora);
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) throws IllegalArgumentException {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido inválido. Registre un nuevo pedido");
        }
        this.pedido = pedido;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) throws IllegalArgumentException {
        if (repartidor == null) {
            throw new IllegalArgumentException(
                    "Repartidor inválido. Registre un repartidor.");
        }
        this.repartidor = repartidor;
    }

    public int getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(int idEntrega) {
        if (idEntrega < 0) {
            throw new IllegalArgumentException("El identificador no puede ser negativo.");
        }
        this.idEntrega = idEntrega;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) throws IllegalArgumentException {
        if (fecha == null) {
            throw new IllegalArgumentException("Fecha inválida. Registre una nueva fecha");
        }
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) throws  IllegalArgumentException {
        if (hora == null) {
            throw new IllegalArgumentException("Hora inválida. Registre una hora");
        }
        this.hora = hora;
    }



}

