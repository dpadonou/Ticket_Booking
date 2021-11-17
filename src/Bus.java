
public class Bus extends Thread {
      static int CAPACITY = 15;
      static int VOYAGE = 1000;
      static int STATIONNEMENT = 2000;
      private int nbPassagers = 0;
      private Arret arret;
	
      /**
	 * @param arret
	 */
	public Bus(Arret arret) {
		super();
		this.arret = arret;
	}
	/**
	 * @return the nbPassagers
	 */
	public int getNbPassagers() {
		return nbPassagers;
	}
	/**
	 * @param nbPassagers the nbPassagers to set
	 */
	public void viderBus() {
		this.nbPassagers = 0;
	}
	
	public void monter() {
	 	nbPassagers++;
	 }
	
	@Override
	public void run() {
		//Voyager
		try {Thread.sleep(Bus.VOYAGE);} catch (InterruptedException e) {e.printStackTrace();}
		//se garer
		arret.stationner(this);
		//stationner
		try {Thread.sleep(Bus.STATIONNEMENT);} catch (InterruptedException e) {e.printStackTrace();}
		//quitter l'arret
		arret.quitterArret();
	}
	
	
      
      
}
