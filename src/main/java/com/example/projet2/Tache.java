
package com.example.projet2;

import java.util.ArrayList;

public class Tache {
    private int id;
    private String nom;
    private String description;
    private String commentaire;
    private String priorite;
    private String categorie;
    private String echeance;


    // Truc à se mettre d'accord sur les attributs
    public Tache(int id, String nom, String description, String commentaire, String priorite, String categorie, String echeance){
        this.id = id;
        this.nom= nom;
        this.description = description;
        this.priorite = priorite;
        this.commentaire = commentaire;
        this.categorie = categorie;
        this.echeance = echeance;
    }

    public static void newEmploye(String nom, String poste, String email, ArrayList<Projet> historiqueProjets){

        Employe nvemploye =  new Employe(nom, poste, email, historiqueProjets);

    }

    public static void supprEmploye(Employe employe){

    }

    public void attribuerTache (Tache tache, Employe employe){
        employe.ajouterTache(tache);
    }

    public String attribuerTache(Employe id){

        return "Tâche attribué avec succés";
    }
}