package ar.com.xeven;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private int codReserva;
    private Estado estado;
    private int cantidadHuespedes;
    private int cantidadHabitaciones;
    private List<Habitacion> habitaciones = new ArrayList<>();
    private List<Huesped> huespedes = new ArrayList<>();
    private final String dbName = "hotel";
    private final String dbUser = "root";
    private final String dbPwd = "unafacil";

    public Reserva(String nombreReserva, int cantidadHuespedes, int cantidadHabitaciones, String mail, String telefono) {
        huespedes.add(new Huesped(nombreReserva, mail, telefono));
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.cantidadHuespedes = cantidadHuespedes;
        this.estado = Estado.NUEVA;
        guardarReserva(Estado.CONFIRMADA.ordinal(), cantidadHuespedes, cantidadHabitaciones);
        guardarHuesped(nombreReserva, mail, telefono);
        // TODO actualizar tablas!
        //actualizarHabitaciones(codReserva);
        //actualizarHuespedes(codReserva);
    }

    private void guardarHuesped(String nombre, String mail, String telefono) {
        ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPwd);
        try {
            conexionDB.actualizar("INSERT INTO `hotel`.`huespedes` (`nombre`, `email`, `telefono`) VALUES ('"+nombre+"', '"+mail+"', '"+telefono+"');");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            conexionDB.cerrar();
        }
    }

    private void guardarReserva(int estado, int cantidadHuespedes, int cantidadHabitaciones) {
        ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPwd);
        try {
            conexionDB.actualizar("INSERT INTO `reservas` (`estado`, `cantidadHuespedes`, `cantidadHabitaciones`) VALUES ("+estado+","+cantidadHuespedes+","+cantidadHabitaciones+");");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            conexionDB.cerrar();
        }
    }

    public Reserva(int codReserva, Estado estado, String nombreReserva, int cantidadHuespedes, int cantidadHabitaciones, String mail, String telefono) {
        this.codReserva = codReserva;
        this.estado = estado;
        huespedes.add(new Huesped(nombreReserva, mail, telefono));
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.cantidadHuespedes = cantidadHuespedes;
    }

    public void agregarHuesped(String nombre) {
        huespedes.add(new Huesped(nombre));
    }

    public void agregarHuesped(String nombre, String mail, String telefono) {
        huespedes.add(new Huesped(nombre, mail, telefono));
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public List<Huesped> getHuespedes() {
        return huespedes;
    }

    public int getCodReserva() {
        return codReserva;
    }

    public void setCodReserva(int codReserva) {
        this.codReserva = codReserva;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getCantidadHuespedes() {
        return cantidadHuespedes;
    }

    public void setCantidadHuespedes(int cantidadHuespedes) {
        this.cantidadHuespedes = cantidadHuespedes;
    }

    public int getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public void setCantidadHabitaciones(int cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codReserva=" + codReserva +
                ", estado=" + estado +
                ", cantidadHuespedes=" + cantidadHuespedes +
                ", cantidadHabitaciones=" + cantidadHabitaciones +
                ", habitaciones=" + habitaciones +
                ", huespedes=" + huespedes +
                '}';
    }
}
