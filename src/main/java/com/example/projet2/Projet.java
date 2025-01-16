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
    private static ArrayList<Projet> listeProjets = new ArrayList<>();


    public Projet( String nom, String descr, String dateDebut, String dateFin, ArrayList<Tache> taches, ArrayList<Employe> membres) {
        this.id = idCompteur++;
        this.nom = nom;
        this.descr = descr;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.taches = taches;
        this.membres = membres;
    }

    public int getId(){
        return id;
    }

    public static void creerProjet ( String nom, String descr, String dateDebut, String dateFin, ArrayList<Tache> taches, ArrayList<Employe> membres){
       Projet newProjet = new Projet(nom, descr,  dateDebut,  dateFin,  taches,  membres);
       listeProjets.add(newProjet);

    }
    public boolean supprimerProjet( int idProjet) {
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

    public void modifierProjet(String nom, String descr, String dateDebut, String dateFin) {
        if (nom != null) this.nom = nom;
        if (descr != null) this.descr = descr;
        if (dateDebut != null) this.dateDebut = dateDebut;
        if (dateFin != null) this.dateFin = dateFin;
    }
}

