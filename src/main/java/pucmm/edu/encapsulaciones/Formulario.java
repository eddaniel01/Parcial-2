package pucmm.edu.encapsulaciones;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import jakarta.persistence.*;
@Entity
public class Formulario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String sector;
    private String nivelEscolar;
    private String fecha;
    private String latitude;
    private String longitude;
    private String accuracy;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario user;

    public Formulario(){};
    public Formulario(String nombre, String sector, String nivelEscolar, Usuario user, String latitude, String longitude, String accuracy) {
        this.nombre = nombre;
        this.sector = sector;
        this.nivelEscolar = nivelEscolar;
        this.user= user;
        this.fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        this.latitude = latitude;
        this.longitude = longitude;
        this.accuracy = accuracy;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getNivelEscolar() {
        return nivelEscolar;
    }

    public void setNivelEscolar(String nivelEscolar) {
        this.nivelEscolar = nivelEscolar;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public String getAccuracy() {
        return accuracy;
    }
    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formulario that = (Formulario) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(sector, that.sector) && Objects.equals(nivelEscolar, that.nivelEscolar) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, sector, nivelEscolar, user);
    }

    @Override
    public String toString() {
        return "Formulario{" +
                "nombre='" + nombre + '\'' +
                ", sector='" + sector + '\'' +
                ", nivelEscolar='" + nivelEscolar + '\'' +
                ", user=" + user +
                '}';
    }
}
