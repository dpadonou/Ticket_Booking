
public class Arret {
	
    private boolean isOccuped = false;
    private Bus busStationne;
    
    /**
     * Un bus stationne
     */
    public synchronized void stationner(Bus bus) {
    	while(isOccuped) {
    		try {wait();} catch (InterruptedException e) {e.printStackTrace();}
    	}
    	busStationne = bus;
    	busStationne.viderBus();
    	isOccuped = true;
    	notifyAll();
    }
    /**
     * depart du bus
     */
    public synchronized void quitterArret() {
    	isOccuped = false;
    	notifyAll();
    }
    
    public synchronized void attendreBus() {
    	while(!isOccuped) {
    		try {wait();} catch (InterruptedException e) {e.printStackTrace();}
    	}
    	
    }
    
    public synchronized void monterBus() {
    	while(busStationne.getNbPassagers() <= Bus.CAPACITY) {
    		busStationne.monter();
    		System.out.println("Le voyageur "+Thread.currentThread().toString()+" est monté dans un bus");
    	}
    }
}
