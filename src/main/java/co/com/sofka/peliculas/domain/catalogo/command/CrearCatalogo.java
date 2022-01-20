package co.com.sofka.peliculas.domain.catalogo.command;

import co.com.sofka.peliculas.domain.catalogo.Pelicula;
import co.com.sofka.peliculas.domain.generic.Command;

import java.util.Map;

public class CrearCatalogo extends Command {

    private String catalogoId;
    private String nombre;

    public CrearCatalogo() {
    }

    public String getCatalogoId() {
        return catalogoId;
    }

    public void setCatalogoId(String catalogoId) {
        this.catalogoId = catalogoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
