package istic.csr.tp5.dao;

public class Arret {

    private boolean isOccuped = false;
    private Bus busStationne;

    /**
     * Un bus stationne
     */
    public synchronized void stationner(Bus bus) {
        while (isOccuped) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        busStationne = bus;
        isOccuped = true;
        System.out.println("Le " + Thread.currentThread() + " est stationn� ");
        this.notifyAll();
    }

    /**
     * depart du bus
     */
    public synchronized void quitterArret() {
        isOccuped = false;
        busStationne = null;
        System.out.println("Le " + Thread.currentThread() + " est parti ");
        this.notifyAll();
    }


    public synchronized void monterBus(Voyageur voyageur) {
        while (busStationne == null || busStationne.getNbPassagers() >= Bus.CAPACITY) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        busStationne.monter(voyageur);
        voyageur.setBus(busStationne);
        System.out.println("Le " + Thread.currentThread() + " est monté dans le bus " + busStationne.getId_());
        this.notifyAll();
    }
}
