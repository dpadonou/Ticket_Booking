package istic.csr.tp5.dao;

import java.time.LocalDateTime;

public class Voyageur extends Thread {
    static int N = 1000;
    private int id_;
    private String name;

    private final Billeterie billeterie;
    private final Arret arret;
    private Bus bus = null;

    /**
     * @param billeterie
     * @param arret
     */
    public Voyageur(String name, Billeterie billeterie, Arret arret) {
        super();
        this.name = name;
        this.billeterie = billeterie;
        this.arret = arret;
    }

    public void setId_(int id_) {
        this.id_ = id_;
    }

    public int getId_() {
        return id_;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    @Override
    public void run() {
        //Acheter un billet
        billeterie.prendreBillet();
        //Se rendre à l'arrêt
        try {
            Thread.sleep(Voyageur.N);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        arret.monterBus(this);
    }

}
