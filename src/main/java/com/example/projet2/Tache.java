
package com.example.projet2;

import java.util.ArrayList;

public class Tache {
    private static int idCompteur = 0;
    private int id;
    private String nom;
    private String description;
    private ArrayList<String> commentaire = new ArrayList<>();
    private String priorite;
    private String categorie;
    private String echeance;
    public static ArrayList<Tache> ttTaches = new ArrayList<>();


    public Tache( String nom, String description,  String priorite, String categorie, String echeance){
        this.id = idCompteur++;
        this.nom= nom;
        this.description = description;
        this.priorite = priorite;
        this.categorie = categorie;
        this.echeance = echeance;
    }

    public static void newTache(String nom, String description,  String priorite, String categorie, String echeance){
        Tache nvtache =  new Tache( nom,  description, priorite,  categorie,  echeance);
        ttTaches.add(nvtache);

    }

    public static void supprEmploye(Employe employe){
        ttTaches.remove(employe);

    }

    public void ajouterCom (String com){
        commentaire.add(com);

    }


    public String attribuerTache (Employe employe){
        employe.ajouterTache(this);
        return "Tâche attribué avec succés";
    }



    public String getNom(){
        return nom;
    }

    public String getEcheance(){
        return echeance;
    }
}