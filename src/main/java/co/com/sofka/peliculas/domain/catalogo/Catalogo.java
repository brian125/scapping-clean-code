package co.com.sofka.peliculas.domain.catalogo;

import co.com.sofka.peliculas.domain.catalogo.events.CatalogoCreado;
import co.com.sofka.peliculas.domain.catalogo.events.PeliculaAsignada;
import co.com.sofka.peliculas.domain.generic.AggregateRoot;
import co.com.sofka.peliculas.domain.generic.DomainEvent;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Catalogo extends AggregateRoot {
    protected Map<String, Pelicula> peliculas;
    protected String nombre;

    public Catalogo(String catalogoId, String nombre) {
        super(catalogoId);
        Objects.requireNonNull(nombre);
        subscribe(new CatalogoEventChange(this));
        appendChange(new CatalogoCreado(catalogoId, nombre)).apply();
    }

    private Catalogo(String id) {
        super(id);
        subscribe(new CatalogoEventChange(this));
    }

    public static Catalogo from(String id, List<DomainEvent> events) {
        var catalog = new Catalogo(id);
        events.forEach(catalog::applyEvent);
        return catalog;
    }

    public void agregarPelicula(String id, String nombre, String year, String duracion, String descripcion, String genero, String url) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(year);
        Objects.requireNonNull(duracion);
        Objects.requireNonNull(descripcion);
        Objects.requireNonNull(genero);
        appendChange(new PeliculaAsignada(id, nombre, year, duracion, descripcion, genero, url)).apply();
    }
}