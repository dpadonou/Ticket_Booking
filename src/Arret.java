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
        //isBus = true;
        System.out.println("Le " + Thread.currentThread().toString() + " est stationné ");
        this.notifyAll();
    }

    /**
     * depart du bus
     */
    public synchronized void quitterArret() {
        isOccuped = false;
        busStationne = null;
        System.out.println("Le " + Thread.currentThread().toString() + " est parti ");
        //nbVoyageursABord = 0;
        this.notifyAll();
    }

    /**
     * Les voyageurs attendent un bus
     */
    public synchronized void attendreBus() {
        while (!isOccuped) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        //monterBus();
    }

    public synchronized void monterBus() {
        while (busStationne == null || busStationne.getNbPassagers() >= Bus.CAPACITY) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    	/*while(busStationne == null) {
    		try {this.wait();} catch (InterruptedException e) {e.printStackTrace();}
    	}
    	while(busStationne.getNbPassagers() >= Bus.CAPACITY) {
    		try {this.wait();} catch (InterruptedException e) {e.printStackTrace();}
    	}*/
        //if(busStationne != null) {
        busStationne.monter();
        System.out.println("Le " + Thread.currentThread().toString() + " est monté dans le bus " + busStationne.getNbBus());
        this.notifyAll();
        //}

    }
}
