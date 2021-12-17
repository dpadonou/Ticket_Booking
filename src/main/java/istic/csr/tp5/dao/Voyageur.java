package istic.csr.tp5.dao;

public class Voyageur extends Thread {
    static int N = 1000;
    private int id_;
    private final String voyageurName;

    private final Billeterie billeterie;
    private final Arret arret;

    /**
     * @param billeterie: Où accheter son billet
     * @param arret: Où attendre le bus
     */
    public Voyageur(String name, Billeterie billeterie, Arret arret) {
        super();
        this.voyageurName = name;
        this.billeterie = billeterie;
        this.arret = arret;
    }

    public void setId_(int id_) {
        this.id_ = id_;
    }

    public int getId_() {
        return id_;
    }

    public String getVoyageurName() {
        return voyageurName;
    }

    @Override
    public void run() {
        //Acheter un billet
        billeterie.prendreBillet(this);
        //Se rendre à l'arrêt
        try {
            Thread.sleep(Voyageur.N);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        arret.monterBus(this);
    }

}
