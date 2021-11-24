package istic.csr.tp5.backend;

import istic.csr.tp5.database.BusDataStore;
import istic.csr.tp5.database.VoyageursDataStore;

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
