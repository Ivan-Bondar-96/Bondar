package com.qoobico.gotokino;

/**
 * Created by Ivan on 08.05.2017.
 */

public class Cinema {

    private String cinema_nazva;
    private String photo;
    private String adress;
    private String url;

    public String getCinema_nazva() {
        return cinema_nazva;
    }

    public String getCinemaPhoto() {
        return photo;
    }

    public String getUrl() {
        return url;
    }

    public String getAdress() {
        return adress;
    }

    public Cinema(String cinema_nazva, String photo, String adress, String url) {
        this.cinema_nazva = cinema_nazva;
        this.photo = photo;
        this.adress=adress;

        this.url = url;
    }
}
