package co.com.sofka.peliculas.domain.catalogo;

public class Pelicula {
    private final String id;
    private String nombrePelicula;
    private String year;
    private String duracion;
    private String descripcion;
    private String genero;
    private String url;

    public Pelicula(String id, String nombrePelicula, String year, String duracion, String descripcion, String genero, String url) {
        this.id = id;
        this.nombrePelicula = nombrePelicula;
        this.year = year;
        this.duracion = duracion;
        this.descripcion = descripcion;
        this.genero = genero;
        this.url = url;
    }

    public String id() {
        return id;
    }

    public String nombrePelicula() {
        return nombrePelicula;
    }

    public String year() {
        return year;
    }

    public String duracion() {
        return duracion;
    }

    public String descripcion() {
        return descripcion;
    }

    public String genero() {
        return genero;
    }

    public String url() {
        return url;
    }
}