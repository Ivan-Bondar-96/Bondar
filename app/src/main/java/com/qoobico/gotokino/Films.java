package com.qoobico.gotokino;

public class Films {
    public String getFilm_nazva() {
        return film_nazva;
    }

    public void setFilm_nazva(String film_nazva) {
        this.film_nazva = film_nazva;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    String film_nazva;

    public String getFoto() {
        return foto;
    }

    String foto;
    String url;

    public Films(String film_nazva, String foto, String url) {
        this.film_nazva = film_nazva;
        this.foto= foto;
        this.url = url;
    }
}