package pucmm.edu.encapsulaciones;

import org.bson.types.ObjectId;
import dev.morphia.annotations.*;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String mimeType;
    private String fotoBase64;

    public Foto(){};
    public Foto(String nombre, String mimeType, String fotoBase64) {
        this.nombre = nombre;
        this.mimeType = mimeType;
        this.fotoBase64 = fotoBase64;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getFotoBase64() {
        return fotoBase64;
    }

    public void setFotoBase64(String fotoBase64) {
        this.fotoBase64 = fotoBase64;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Foto foto = (Foto) o;
        return Objects.equals(id, foto.id) && Objects.equals(nombre, foto.nombre) && Objects.equals(mimeType, foto.mimeType) && Objects.equals(fotoBase64, foto.fotoBase64);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, mimeType, fotoBase64);
    }

    @Override
    public String toString() {
        return "Foto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", fotoBase64='" + fotoBase64 + '\'' +
                '}';
    }
}
