package com.example.projet2;
import java.util.ArrayList;

public class Projet {
    private int id;
    private String nom;
    private String descr;
    private String dateDebut;
    private String dateFin;
    private ArrayList<Tache> taches;
    private ArrayList<Employe> membres;

    public Projet(int id, String nom, String descr, String dateDebut, String dateFin, ArrayList<Tache> taches, ArrayList<Employe> membres) {
        this.id = id;
        this.nom = nom;
        this.descr = descr;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.taches = new ArrayList<>();
        this.membres = new ArrayList<>();
    }
}

