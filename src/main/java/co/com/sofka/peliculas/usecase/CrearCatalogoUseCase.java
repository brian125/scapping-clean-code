package co.com.sofka.peliculas.usecase;

import co.com.sofka.peliculas.domain.catalogo.Catalogo;
import co.com.sofka.peliculas.domain.catalogo.command.CrearCatalogo;
import co.com.sofka.peliculas.domain.generic.DomainEvent;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class CrearCatalogoUseCase implements Function<CrearCatalogo, List<DomainEvent>> {

    @Override
    public List<DomainEvent> apply(CrearCatalogo command) {
        var course = new Catalogo(command.getCatalogoId(), command.getNombre());
        return course.getUncommittedChanges();
    }
}
