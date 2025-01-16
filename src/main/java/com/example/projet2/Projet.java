package com.example.projet2;

import java.util.ArrayList;
import java.util.Iterator;

public class Projet {
    private static int idCompteur = 0;
    private int id;
    private String nom;
    private String descr;
    private String dateDebut;
    private String dateFin;
    private ArrayList<Tache> taches = new ArrayList<>(); // Liste de tâches associées
    private ArrayList<Employe> membres = new ArrayList<>(); // Liste de membres associés
    private static ArrayList<Projet> listeProjets = new ArrayList<>();

    public Projet(String nom, String descr, String dateDebut, String dateFin) {
        this.id = idCompteur++;
        this.nom = nom;
        this.descr = descr;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Tache> getTaches() {
        return taches;
    }


    public static void creerProjet(String nom, String descr, String dateDebut, String dateFin) {
        Projet newProjet = new Projet(nom, descr, dateDebut, dateFin);
        listeProjets.add(newProjet);
    }


    public static boolean supprimerProjet(int idProjet) {
        Iterator<Projet> iterator = listeProjets.iterator();
        while (iterator.hasNext()) {
            Projet projet = iterator.next();
            if (projet.getId() == idProjet) {
                iterator.remove();
                System.out.println("Projet supprimé avec succès.");
                return true;
            }
        }
        System.out.println("Projet introuvable.");
        return false;
    }


    public void modifierProjet(String nom, String descr, String dateDebut, String dateFin) {
        if (nom != null) this.nom = nom;
        if (descr != null) this.descr = descr;
        if (dateDebut != null) this.dateDebut = dateDebut;
        if (dateFin != null) this.dateFin = dateFin;
    }


    public void ajouterTache(Tache tache) {
        if (tache != null && !taches.contains(tache)) {
            taches.add(tache);
            tache.setProjet(this); // Associe la tâche à ce projet
            System.out.println("Tâche ajoutée au projet : " + tache.getNom());
        }
    }


    public void supprimerTache(Tache tache) {
        if (taches.remove(tache)) {
            tache.setProjet(null); // Dissocie la tâche de ce projet
            System.out.println("Tâche supprimée du projet : " + tache.getNom());
        }
    }


    public void afficherTaches() {
        System.out.println("Tâches associées au projet " + nom + " :");
        for (Tache tache : taches) {
            System.out.println("- " + tache.getNom() + " (Échéance : " + tache.getEcheance() + ")");
        }
    }
}
