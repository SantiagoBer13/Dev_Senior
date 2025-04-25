package com.code;

import java.time.LocalDate;

public class Evento implements Comparable<Evento> {

    private String title;
    private LocalDate date;

    public Evento(String title, LocalDate date) {
        this.title = title;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public int compareTo(Evento evento) {
        return this.date.compareTo(evento.getDate());
    }
    
}
