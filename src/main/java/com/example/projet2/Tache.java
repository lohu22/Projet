package com.example.projet2;

import java.util.ArrayList;

public class Tache {
    private static int idCompteur = 0;
    private int id;
    private String nom;
    private String description;
    private ArrayList<String> commentaires = new ArrayList<>();
    private String priorite;
    private String categorie;
    private String echeance;
    private Projet projet; // Référence au projet associé
    public static ArrayList<Tache> ttTaches = new ArrayList<>();

    public Tache(String nom, String description, String priorite, String categorie, String echeance) {
        this.id = idCompteur++;
        this.nom = nom;
        this.description = description;
        this.priorite = priorite;
        this.categorie = categorie;
        this.echeance = echeance;
    }

    public static void newTache(String nom, String description, String priorite, String categorie, String echeance) {
        Tache nvtache = new Tache(nom, description, priorite, categorie, echeance);
        ttTaches.add(nvtache);
    }

    public static void supprTache(Tache tache) {
        ttTaches.remove(tache);
    }

    public void modifierTache(String nom, String description, String priorite, String categorie, String echeance) {
        if (nom != null) this.nom = nom;
        if (description != null) this.description = description;
        if (priorite != null) this.priorite = priorite;
        if (categorie != null) this.categorie = categorie;
        if (echeance != null) this.echeance = echeance;
    }

    public void ajouterCommentaire(String commentaire) {
        commentaires.add(commentaire);
    }

    public String getNom() {
        return nom;
    }

    public String getEcheance() {
        return echeance;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }
}
