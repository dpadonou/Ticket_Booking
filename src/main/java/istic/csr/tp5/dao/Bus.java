package istic.csr.tp5.dao;

import java.util.ArrayList;
import java.util.Collection;

public class Bus extends Thread {
    public static int CAPACITY = 15;
    static int VOYAGE = 1000;
    static int STATIONNEMENT = 1000;

    private final Arret arret;
    private Collection<Voyageur> passagers;
    private int nbPassagers = 0;
    private int id_;

    /**
     * @param arret
     */
    public Bus(Arret arret) {
        super();
        passagers = new ArrayList<>();
        this.arret = arret;
    }

    /**
     * @return the nbBus
     */
    public int getId_() {
        return id_;
    }

    /**
     * @param id_ the nbBus to set
     */
    public void setId_(int id_) {
        this.id_ = id_;
    }

    /**
     * @return the nbPassagers
     */
    public int getNbPassagers() {
        return nbPassagers;
    }

    public void viderBus() {
        this.nbPassagers = 0;
    }

    public void monter(Voyageur voyageur) {
        nbPassagers++;
        this.passagers.add(voyageur);
    }

    public Collection<Voyageur> getPassagers() {
        return passagers;
    }

    @Override
    public void run() {
        while (true) {
            //Voyager
            try {
                Thread.sleep(Bus.VOYAGE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //se garer
            arret.stationner(this);
            //stationner pendant un tps
            try {
                Thread.sleep(Bus.STATIONNEMENT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //quitter l'arret
            arret.quitterArret();
            //vider le bus
            viderBus();
        }
    }

}
