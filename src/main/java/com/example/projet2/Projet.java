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
    private ArrayList<Tache> taches;
    private ArrayList<Employe> membres;
    private ArrayList<Projet> listeProjets;

    public Projet( String nom, String descr, String dateDebut, String dateFin, ArrayList<Tache> taches, ArrayList<Employe> membres) {
        this.id = idCompteur++;
        this.nom = nom;
        this.descr = descr;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.taches = new ArrayList<>();
        this.membres = new ArrayList<>();
    }

    public int getId(){
        return id;
    }

    public void creerProjet (String nom, String descr, String dateDebut, String dateFin, ArrayList<Tache> taches, ArrayList<Employe> membres){
       Projet newProjet = new Projet(nom, descr,  dateDebut,  dateFin,  taches,  membres);
       listeProjets.add(newProjet);
    }
    public boolean supprimerProjet(ArrayList<Projet> listeProjets, int idProjet) {
        Iterator<Projet> iterator = listeProjets.iterator();
        while (iterator.hasNext()) {
            Projet projet = iterator.next();
            if (projet.getId() == idProjet) {
                iterator.remove();
                System.out.println("Projet supprimée avec succès.");
                return true;
            }
        }
        System.out.println("Projet introuvable.");
        return false;
    }

}

