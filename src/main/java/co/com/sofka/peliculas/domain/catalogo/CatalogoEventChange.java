package co.com.sofka.peliculas.domain.catalogo;

import co.com.sofka.peliculas.domain.catalogo.events.CatalogoCreado;
import co.com.sofka.peliculas.domain.catalogo.events.PeliculaAsignada;
import co.com.sofka.peliculas.domain.generic.EventChange;

import java.util.HashMap;

public class CatalogoEventChange implements EventChange {

    public CatalogoEventChange(Catalogo catalogo) {

        listener((CatalogoCreado event) -> {
            catalogo.nombre =event.getNombre();
            catalogo.peliculas = new HashMap<>();
        });
        listener((PeliculaAsignada event) -> {
            catalogo.peliculas.put(event.getPeliculaId(), new Pelicula(
                    event.getPeliculaId(),
                    event.getNombrePelicula(),
                    event.getYear(),
                    event.getDuracion(),
                    event.getDescripcion(),
                    event.getGenero(),
                    event.getUrl()
            ));
        });
    }
}
