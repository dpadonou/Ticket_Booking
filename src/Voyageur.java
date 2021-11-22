public class Voyageur extends Thread {
    static int N = 1000;
    private int numeroVoyageur;
    private Billeterie billeterie;
    private Arret arret;

    /**
     * @param numeroVoyageur
     * @param billeterie
     * @param arret
     */
    public Voyageur(int numeroVoyageur, Billeterie billeterie, Arret arret) {
        super();
        this.numeroVoyageur = numeroVoyageur;
        this.billeterie = billeterie;
        this.arret = arret;
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
        arret.monterBus();
    }

    @Override
    public String toString() {
        return "Voyageur " + numeroVoyageur;
    }


}
