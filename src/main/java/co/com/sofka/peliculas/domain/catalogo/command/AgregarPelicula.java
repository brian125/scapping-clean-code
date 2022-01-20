package co.com.sofka.peliculas.domain.catalogo.command;

import co.com.sofka.peliculas.domain.generic.Command;

public class AgregarPelicula extends Command {

    private String catalogoId;
    private String peliculaId;
    private String nombrePelicula;
    private String year;
    private String duracion;
    private String descripcion;
    private String genero;
    private String url;

    public AgregarPelicula() {
    }

    public String getCatalogoId() {
        return catalogoId;
    }

    public void setCatalogoId(String catalogoId) {
        this.catalogoId = catalogoId;
    }

    public String getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(String peliculaId) {
        this.peliculaId = peliculaId;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
