package pucmm.edu.encapsulaciones;
import jakarta.persistence.GenerationType;
import pucmm.edu.util.RolesApp;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String usuario;
    private String clave;
    @Enumerated(EnumType.STRING)

    private RolesApp rol;
    private String fecha;

    public Usuario(){};
    public Usuario(String nombre, String usuario, String clave, RolesApp rol) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.clave = clave;
        this.rol = rol;
        this.fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public RolesApp getRol() {
        return rol;
    }

    public void setRol(RolesApp rol) {
        this.rol = rol;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario1 = (Usuario) o;
        return Objects.equals(nombre, usuario1.nombre) && Objects.equals(usuario, usuario1.usuario) && Objects.equals(clave, usuario1.clave) && Objects.equals(rol, usuario1.rol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, usuario, clave, rol);
    }

    @Override
    public String toString() {
        return "usuario{" +
                "nombre='" + nombre + '\'' +
                ", usuario='" + usuario + '\'' +
                ", clave='" + clave + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
