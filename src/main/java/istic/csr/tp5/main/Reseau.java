package istic.csr.tp5.main;

import istic.csr.tp5.backend.Backend;
import istic.csr.tp5.dao.Arret;
import istic.csr.tp5.dao.Billeterie;

/**
 * Class permettant de fournir une billeterie et arrêt unique pour tout les processus du système
 */
public class Reseau {
    static final int NB_BUS = 5;

    public static final Arret ARRET = new Arret();
    public static final Billeterie BILLETERIE = new Billeterie();

    Reseau(Backend backend) {
        /* Instantiation of bus */
        for (int i = 0; i < NB_BUS; i++) {
            backend.getBusDataStore().add(Reseau.ARRET);
        }
    }
}
