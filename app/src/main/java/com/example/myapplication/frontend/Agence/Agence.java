package com.example.myapplication.frontend.Agence;

public class Agence {

    private String email;
    private String tel;
    private String password;
    private String interim,link,adresse;
    private String img;

    public Agence() {
    }

    public Agence(String email, String tel, String password, String interim,String link, String adresse,String img) {

        this.interim = interim;
        this.email = email;
        this.tel = tel;
        this.link = link;
        this.password = password;
        this.img = img;
        this.adresse = adresse;
    }

    public String getInterim() {
        return interim;
    }

    public void setInterim(String interim) {
        this.interim = interim;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAddress() {
        return adresse;
    }

    public void setAddress(String address) {
        this.adresse = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
