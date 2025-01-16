package com.example.projet2;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class kaban {
    private Map<String, List<Tache>> kanban;

    public kaban() {
        kanban = new HashMap<>();
        kanban.put("À faire", new ArrayList<>());
        kanban.put("En cours", new ArrayList<>());
        kanban.put("Terminé", new ArrayList<>());
    }


    public List<Tache> get(String columnKey) {
        return kanban.getOrDefault(columnKey, new ArrayList<>());
    }

    public void ajouterTacheKanban(Tache tache) {

        kanban.get("À faire").add(tache);
    }

    // Déplacer une tâche entre les colonnes
    public void deplacerTacheKanban(Tache tache, String nouvelleColonne) {
        for (String colonne : kanban.keySet()) {
            if (kanban.get(colonne).remove(tache)) {
                kanban.get(nouvelleColonne).add(tache);
                return;
            }
        }
        System.out.println("Tâche non trouvée dans le Kanban.");
    }


    public void afficherKanban() {
        System.out.println("Vue Kanban :");
        for (String colonne : kanban.keySet()) {
            System.out.println("Colonne: " + colonne);
            for (Tache tache : kanban.get(colonne)) {
                System.out.println("  - " + tache.getNom() + " (" + tache.getEcheance() + ")");
            }
        }
    }


    public void afficherCalendrier() {
        System.out.println("Vue Calendrier :");
        Tache.ttTaches.stream()
                .sorted((t1, t2) -> t1.getEcheance().compareTo(t2.getEcheance()))
                .forEach(tache -> System.out.println("Tâche: " + tache.getNom() + " - Échéance: " + tache.getEcheance()));
    }
}
