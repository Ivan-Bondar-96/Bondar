package com.qoobico.gotokino;

/**
 * Created by Ivan on 08.05.2017.
 */

public class Soon {

    private String soon_film;
    private String photo_soon_film;
    private String url_soon_film;

    public void setSoon_film(String soon_film) {
        this.soon_film = soon_film;
    }

    public void setPhoto_soon_film(String photo_soon_film) {
        this.photo_soon_film = photo_soon_film;
    }

    public void setUrl_soon_film(String url_soon_film) {
        this.url_soon_film = url_soon_film;
    }

    public String getSoon_film() {
        return soon_film;
    }

    public String getPhoto_soon_film() {
        return photo_soon_film;
    }


    public String getUrl_soon_film() {
        return url_soon_film;
    }


    public Soon(String soon_film, String photo_soon_film, String url_soon_film) {

        this.soon_film = soon_film;
        this.photo_soon_film = photo_soon_film;
        this.url_soon_film = url_soon_film;
    }

}
