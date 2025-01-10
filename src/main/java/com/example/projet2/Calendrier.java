package com.example.projet2;
import java.util.*;

public class Calendrier {
    private Map<Date  , List<Tache>> events;
    private List<String> kaban;

    public Calendrier(){
        this.events = new HashMap<>();
        this.kaban= new ArrayList<>(Arrays.asList("A faire", "En cours", "Terminé"));
    }
}
