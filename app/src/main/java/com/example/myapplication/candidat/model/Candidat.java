package com.example.myapplication.candidat.model;


import java.util.ArrayList;
import java.util.List;

public class Candidat {

    private Long idcandidat;
    private String nom;
    private String prenom;
    private String nationalite;
    private String datenaissance;
    private String tel;
    private String ville;
    private String cv;
    private String lettre;
    private String email;
    private String password;

    private List<Offre> offresSauvegardees;

    // save vacancie Contructer
    public Candidat(String nom) {
        this.nom = nom;
        this.offresSauvegardees = new ArrayList<>();
    }

    public Candidat(){}

    public Candidat(Long idcandidat){
        this.idcandidat = idcandidat;
    }

    public Candidat( String nom, String prenom, String nationalite, String datenaissance, String tel, String ville, String cv, String lettre, String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.nationalite = nationalite;
        this.datenaissance = datenaissance;
        this.tel = tel;
        this.ville = ville;
        this.cv = cv;
        this.lettre = lettre;
        this.email = email;
        this.password = password;
    }

    public Candidat(Long idcandidat, String nom, String prenom, String nationalite, String datenaissance, String tel, String ville, String cv, String lettre, String email, String password) {
        this.idcandidat = idcandidat;
        this.nom = nom;
        this.prenom = prenom;
        this.nationalite = nationalite;
        this.datenaissance = datenaissance;
        this.tel = tel;
        this.ville = ville;
        this.cv = cv;
        this.lettre = lettre;
        this.email = email;
        this.password = password;
    }

    public Long getIdcandidat() {
        return idcandidat;
    }

    public void setIdcandidat(Long idcandidat) {
        this.idcandidat = idcandidat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(String datenaissance) {
        this.datenaissance = datenaissance;
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

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getLettre() {
        return lettre;
    }

    public void setLettre(String lettre) {
        this.lettre = lettre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Offre> getOffresSauvegardees() {
        return offresSauvegardees;
    }


    // sauvgarder l'offre
    public void sauvegarderOffre(Offre offre) {
        offresSauvegardees.add(offre);

    }

}
