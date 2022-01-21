package co.com.sofka.peliculas.infra.materialize;

import co.com.sofka.peliculas.domain.catalogo.events.CatalogoCreado;
import co.com.sofka.peliculas.domain.catalogo.events.PeliculaAsignada;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Filters;
import io.quarkus.vertx.ConsumeEvent;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class CatalogoHandle {

    private final MongoClient mongoClient;

    public CatalogoHandle(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @ConsumeEvent(value = "sofka.catalogo.peliculas.catalogocreado", blocking = true)
    void consumeCatalogoCreado(CatalogoCreado event) {
        Map<String, Object> document = new HashMap<>();
        document.put("_id", event.getAggregateId());
        document.put("name", event.getNombre());

        mongoClient.getDatabase("queries")
                .getCollection("catalogo")
                .insertOne(new Document(document));
    }

    @ConsumeEvent(value = "sofka.catalogo.peliculas.peliculaagregada", blocking = true)
    void consumePeliculaAgregada(PeliculaAsignada event) {
        BasicDBObject document = new BasicDBObject();
        document.put("pelicula."+event.getPeliculaId()+".nombre", event.getNombrePelicula());
        document.put("pelicula."+event.getPeliculaId()+".agno", event.getYear());
        document.put("pelicula."+event.getPeliculaId()+".duracion", event.getDuracion());
        document.put("pelicula."+event.getPeliculaId()+".descripcion", event.getDescripcion());
        document.put("pelicula."+event.getPeliculaId()+".genero", event.getGenero());
        document.put("pelicula."+event.getPeliculaId()+".url", event.getUrl());
        document.put("pelicula."+event.getPeliculaId()+".fecha", Instant.now());

        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", document);

        mongoClient.getDatabase("queries")
                .getCollection("catalogo")
                .updateOne(Filters.eq("_id", event.getAggregateId()), updateObject);
    }

}
