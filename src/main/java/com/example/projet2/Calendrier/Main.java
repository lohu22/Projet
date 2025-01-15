package com.example.projet2.Calendrier;


import com.example.projet2.Tache;
import com.example.projet2.kaban;

public class Main {
    public static void main(String[] args) {

        kaban calendrier = new kaban();


        Tache.newTache("Créer ", "Configurer ", "Haute", "Développement", "2025-02-01");
        Tache.newTache("Modifier", "Développer ", "Moyenne", "Interface", "2025-02-10");
        Tache.newTache("Écrire ", "Rédiger ", "Basse", "Documentation", "2025-01-25");


        for (Tache tache : Tache.ttTaches) {
            calendrier.ajouterTacheKanban(tache);
        }


        System.out.println("=== Kanban initial ===");
        calendrier.afficherKanban();


        System.out.println("\n=== Déplacement de tâches ===");
        Tache tache1 = Tache.ttTaches.get(0);
        calendrier.deplacerTacheKanban(tache1, "En cours");

        Tache tache2 = Tache.ttTaches.get(1);
        calendrier.deplacerTacheKanban(tache2, "Terminé");


        System.out.println("\n=== Kanban après déplacement ===");
        calendrier.afficherKanban();


        System.out.println("\n=== Vue Calendrier ===");
        calendrier.afficherCalendrier();
    }
}
