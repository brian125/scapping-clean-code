package co.com.sofka.peliculas.domain.generic;
import co.com.sofka.peliculas.infra.generic.StoredEvent;

import java.util.List;


public interface EventStoreRepository {

    List<co.com.sofka.peliculas.domain.generic.DomainEvent> getEventsBy(String aggregateName, String aggregateRootId);


    void saveEvent(String aggregateName, String aggregateRootId, StoredEvent storedEvent);

}