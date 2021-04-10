package ar.com.xeven;

public class Huesped {

    private int idHuesped;
    private String nombre;
    private String mail;
    private String telefono;

    public Huesped(String nombreReserva, String mail, String telefono) {
        this.nombre = nombreReserva;
        this.mail = mail;
        this.telefono = telefono;
    }

    public Huesped(String nombre) {
        this.nombre = nombre;
    }

    public Huesped(int idHuesped, String nombre, String mail, String telefono) {
        this.idHuesped = idHuesped;
        this.nombre = nombre;
        this.mail = mail;
        this.telefono = telefono;
    }

    public int getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
