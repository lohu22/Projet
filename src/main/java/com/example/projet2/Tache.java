package com.example.projet2;
public class Tache {
    private int id;
    private String nom;
    private String description;
    private String priorite;
    private String statut;
    private String echeance;

    // Truc à se mettre d'accord surles attributs
    public Tache(int id, String nom, String description, String priorite, String statut, String echeance){
        this.id = id;
        this.nom= nom;
        this.description = description;
        this.priorite = priorite;
        this.statut = statut;
        this.echeance = echeance;
    }
}