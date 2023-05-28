package com.example.myapplication.candidat.view;

import com.example.myapplication.models.Vacancies;

import java.util.List;

public class Candidats {

    private String name,prenom;
    private String email,nationalite,datenaiss,tel,ville,cv,img;
    private String password;
    private List<Vacancies> saveVacancy;

    public Candidats() {
    }

    public Candidats(String name, String prenom,String nationalite, String datenaiss,String tel,String ville,String email, String password,String cv,String img) {

        this.name = name;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.datenaiss = datenaiss;
        this.nationalite = nationalite;
        this.ville = ville;
        this.tel = tel;
        this.cv = cv;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNational() {
        return nationalite;
    }

    public void setNational(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDate() {
        return datenaiss;
    }

    public void setDate(String datenaiss) {  this.datenaiss = datenaiss;   }

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

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public List<Vacancies> getOffresSauvegardees() {
        return saveVacancy;
    }


    // sauvgarder l'offre
    public void sauvegarderOffre(Vacancies offre) {
        saveVacancy.add(offre);

    }
}
