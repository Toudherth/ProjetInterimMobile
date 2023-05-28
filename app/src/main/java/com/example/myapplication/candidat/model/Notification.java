package com.example.myapplication.candidat.model;

public class Notification {

    String titre;
    String message;
    String date;

    public Notification() {}
    public Notification(String titre, String message, String date) {
        this.titre = titre;
        this.message = message;
        this.date= date;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = message;
    }
}
