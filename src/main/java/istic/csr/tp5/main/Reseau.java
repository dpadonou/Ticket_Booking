package istic.csr.tp5.main;

import istic.csr.tp5.dao.Arret;
import istic.csr.tp5.dao.Billeterie;
import istic.csr.tp5.database.BusDataStore;

public class Reseau {
    static final int NB_BUS = 5;

    public static final Arret ARRET = new Arret();
    public static final Billeterie BILLETERIE = new Billeterie();

    private final BusDataStore busDataStore = new BusDataStore();

    Reseau() {

        /** Instanciation des bus **/
        for (int i = 0; i < NB_BUS; i++) {
            busDataStore.add(Reseau.ARRET);
        }
    }
}
