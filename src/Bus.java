public class Bus extends Thread {
    static int CAPACITY = 15;
    static int VOYAGE = 1000;
    static int STATIONNEMENT = 1000;
    private int nbPassagers = 0;
    private Arret arret;
    private int nbBus = 0;

    /**
     * @param arret
     */
    public Bus(int nbBus, Arret arret) {
        super();
        this.nbBus = nbBus;
        this.arret = arret;
    }

    /**
     * @return the nbBus
     */
    public int getNbBus() {
        return nbBus;
    }

    /**
     * @param nbBus the nbBus to set
     */
    public void setNbBus(int nbBus) {
        this.nbBus = nbBus;
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

    public void monter() {
        nbPassagers++;
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

    @Override
    public String toString() {
        return "Bus " + nbBus;
    }



}
