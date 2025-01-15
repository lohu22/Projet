
package com.example.projet2;

import java.util.ArrayList;

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

    public static void newEmploye(String nom, String poste, String email, ArrayList<Projet> historiqueProjets){

        Employe nvemploye =  new Employe(nom, poste, email, historiqueProjets);

    }

    public static void supprEmploye(Employe employe){

    }

    public String attribuerTache(Employe id){

        return "Tâche attribué avec succés";
    }
}