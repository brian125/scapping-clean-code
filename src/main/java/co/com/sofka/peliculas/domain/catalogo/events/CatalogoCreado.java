package co.com.sofka.peliculas.domain.catalogo.events;

import co.com.sofka.peliculas.domain.generic.DomainEvent;

public class CatalogoCreado extends DomainEvent {

    private final String catalogoId;
    private final String nombre;


    public CatalogoCreado(String catalogoId, String nombre) {
        super("sofka.catalogo.peliculas.catalogocreado");
        this.catalogoId = catalogoId;
        this.nombre = nombre;
    }

    public String getCatalogoId() {
        return catalogoId;
    }

    public String getNombre() {
        return nombre;
    }
}
