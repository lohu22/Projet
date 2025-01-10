package com.example.projet2;
import java.util.ArrayList;

public class Gestion {
    private ArrayList<Employe> employes;
    private ArrayList<Projet> projets;

    public Gestion(){
        employes = new ArrayList<>();
        projets = new ArrayList<>();
    }

    public void ajouter_des_employés(Employe employe){
        employes.add(employe);
    }

    public void supprimer_des_employés(int identifiant_employé){
    }



}
