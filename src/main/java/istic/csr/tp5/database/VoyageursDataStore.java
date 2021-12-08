package istic.csr.tp5.database;

import istic.csr.tp5.dao.Arret;
import istic.csr.tp5.dao.Billeterie;
import istic.csr.tp5.dao.Voyageur;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VoyageursDataStore {
    Map<Integer, Voyageur> voyageurMap;
    private int identifier;

    public VoyageursDataStore() {
        this.voyageurMap = new HashMap<>();
    }

    public synchronized void add(String name, Billeterie billeterie, Arret arret){
        Voyageur voyageur = new Voyageur(name, billeterie, arret);
        voyageur.setId_(identifier);
        voyageurMap.put(identifier, voyageur);
        //Démarrer le nouveau voyageur
        voyageur.start();
        identifier++;
    }

    public Collection<Voyageur> getVoyageurs() {
        return voyageurMap.values();
    }

    public Voyageur findById(int id){
        return voyageurMap.get(id);
    }
}
