package istic.csr.tp5.backend;

import istic.csr.tp5.database.BusDataStore;
import istic.csr.tp5.database.VoyageursDataStore;

/**
 * Centralise les différents informations des "bases de données" dans une seule classe
 * @author Dieu-Donné PADONOU
 * @author Arnauld DJEDJEMEL
 * @version 1.0.0
 */
public class Backend {
    BusDataStore busDataStore;
    VoyageursDataStore voyageursDataStore;

    public Backend() {
        busDataStore = new BusDataStore();
        voyageursDataStore = new VoyageursDataStore();
    }

    public BusDataStore getBusDataStore() {
        return busDataStore;
    }

    public VoyageursDataStore getVoyageursDataStore() {
        return voyageursDataStore;
    }
}
