package co.com.sofka.peliculas.infra.handle;

import co.com.sofka.peliculas.domain.catalogo.command.AgregarPelicula;
import co.com.sofka.peliculas.infra.generic.UseCaseHandle;
import co.com.sofka.peliculas.usecase.AgregarPeliculaUseCase;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AgregarPeliculaHandle extends UseCaseHandle {

    private final AgregarPeliculaUseCase useCase;

    public AgregarPeliculaHandle(AgregarPeliculaUseCase useCase) {
        this.useCase = useCase;
    }

    @ConsumeEvent(value = "sofka.catalogo.peliculas.agregarpelicula")
    void consumeBlocking(AgregarPelicula command) {
        var events = useCase.apply(command);
        save(command.getCatalogoId(), events);
    }
}
