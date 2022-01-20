package co.com.sofka.peliculas.usecase;

import co.com.sofka.peliculas.domain.catalogo.Catalogo;
import co.com.sofka.peliculas.domain.catalogo.command.AgregarPelicula;
import co.com.sofka.peliculas.domain.generic.DomainEvent;
import co.com.sofka.peliculas.domain.generic.EventStoreRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.enterprise.context.Dependent;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Dependent
public class AgregarPeliculaUseCase implements Function<AgregarPelicula, List<DomainEvent>> {

    private final EventStoreRepository repository;
    final String baseURL = "https://pelisplus.so/estrenos";

    public AgregarPeliculaUseCase(EventStoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(AgregarPelicula command) {
        var events = repository.getEventsBy("catalogo", command.getCatalogoId());
        var catalogo = Catalogo.from(command.getCatalogoId(),events);

        var document = urlBase();
        Elements entradas = document.select(".items-peliculas .item-pelicula a");

        for (Element elem : entradas) {
            final String urlPelicula = elem.attr("href");
            try {
                final Document movie = Jsoup.connect("https://pelisplus.so" + urlPelicula).get();
                UUID uuid = UUID.randomUUID();

                String nombrePelicula = movie.select(".info-content h1").text();
                String genero = movie.select(".info-content p:nth-of-type(4) span:nth-of-type(2)").text();
                String descripcion = movie.select(".sinopsis").text();
                String year = movie.select(".info-content p:nth-of-type(2) span:nth-of-type(2)").text();
                String url = movie.select(".player.player-normal ul:nth-of-type(2)  li:nth-of-type(1)").attr("data-video");
                String duracion = movie.select(".info-content p:nth-of-type(3) span:nth-of-type(2)").text();

                catalogo.agregarPelicula(
                        String.valueOf(uuid),
                        nombrePelicula,
                        year,
                        duracion,
                        descripcion,
                        genero,
                        url
                        );

            }catch (Exception e){
                throw new RuntimeException("No se pudo obtener la información de la pelicula");
            }

        }
        return catalogo.getUncommittedChanges();
    }

    public Document urlBase() {
        try {
            return Jsoup.connect(baseURL).get();
        }catch (IOException e){
            throw new RuntimeException("Error con es status de la página");
        }
    }
}
