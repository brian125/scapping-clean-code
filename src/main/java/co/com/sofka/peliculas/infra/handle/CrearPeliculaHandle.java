package co.com.sofka.peliculas.infra.handle;

import co.com.sofka.peliculas.domain.catalogo.command.CrearCatalogo;
import co.com.sofka.peliculas.infra.generic.UseCaseHandle;
import co.com.sofka.peliculas.usecase.CrearCatalogoUseCase;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CrearPeliculaHandle extends UseCaseHandle {

    private final CrearCatalogoUseCase useCase;

    public CrearPeliculaHandle(CrearCatalogoUseCase useCase){
        this.useCase = useCase;
    }

    @ConsumeEvent(value = "sofka.catalogo.peliculas.crearcatalogo")
    void consumeBlocking(CrearCatalogo command) {
        var events = useCase.apply(command);
        save(command.getCatalogoId(), events);
    }
}
