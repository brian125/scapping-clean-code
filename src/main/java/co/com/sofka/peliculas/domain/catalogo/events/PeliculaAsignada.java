package co.com.sofka.peliculas.domain.catalogo.events;

import co.com.sofka.peliculas.domain.generic.DomainEvent;

public class PeliculaAsignada extends DomainEvent {

    private final String peliculaId;
    private final String nombrePelicula;
    private final String year;
    private final String duracion;
    private final String descripcion;
    private final String genero;
    private final String url;

    public PeliculaAsignada(String peliculaId, String nombrePelicula, String year, String duracion, String descripcion, String genero, String url) {
        super("sofka.catalogo.peliculas.peliculaagregada");
        this.peliculaId = peliculaId;
        this.nombrePelicula = nombrePelicula;
        this.year = year;
        this.duracion = duracion;
        this.descripcion = descripcion;
        this.genero = genero;
        this.url = url;
    }

    public String getPeliculaId() {
        return peliculaId;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public String getYear() {
        return year;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getGenero() {
        return genero;
    }

    public String getUrl() {
        return url;
    }
}
