package com.example.projet2;

import java.util.ArrayList;

public class Employe {
    private static int idCompteur = 0;
    private int id;
    private String nom;
    private String poste;
    private String email;
    private ArrayList<Projet> historiqueProjets;
    public static ArrayList<Employe> listesEmployes = new ArrayList<>();
    private ArrayList<Tache> listTache =new ArrayList<>();

    public Employe(String nom, String poste, String email, ArrayList<Projet> historiqueProjets){
        this.id = idCompteur ++;
        this.nom = nom;
        this.poste = poste;
        this.email = email;
        this.historiqueProjets= new ArrayList<>();
    }

    public static void newEmploye(String nom, String poste, String email, ArrayList<Projet> historiqueProjets){

        Employe nvemploye =  new Employe(nom, poste, email, historiqueProjets);
        listesEmployes.add(nvemploye);
    }

    public static void supprEmploye(Employe employe){
        listesEmployes.remove(employe);
    }

    public void ajouterTache(Tache tache) {

        listTache.add(tache);
    }

    public int getIdentifiant() {
        return id;
    }

    public void setIdentifiant(int identifiant) {
        this.id = identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public ArrayList<Projet> gethistoriqueProjets(){

        return historiqueProjets;
    }
    public void sethistoriqueProjets(Projet projet){

        this.historiqueProjets.add(projet);
    }



    public String visualiserInfos(){
        return "id:"+ getIdentifiant()+"Nom:"+ getNom()+"Poste:"+ getPoste()+"Email:" + getEmail() ;
    }
    public String afficherHistorique(){

        return "historique des projets:"+ gethistoriqueProjets();
    }
}
