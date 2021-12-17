
public class Reseau {
	static final int NB_VOYAGEUR = 100;
	static final int NB_BUS = 5;
	/**
	 * 
	 */
	public Reseau() {
		Arret arret = new Arret();
		Billeterie billeterie = new Billeterie();
		Voyageur[] voyageurs = new Voyageur[NB_VOYAGEUR];
		Bus[] bus = new Bus[NB_BUS];
		
		/** Instanciation des voyageurs **/
		for(int i=1;i<NB_VOYAGEUR;i++) {
			voyageurs[i] = new Voyageur(i, billeterie, arret);
		}
		/** Instanciation des bus **/
		for(int i=1;i<NB_BUS;i++) {
			bus[i] = new Bus(arret);
			bus[i].setDaemon(true);
		}
		
		/** Lancer les voyageurs et les bus **/
		for(int i=1;i<NB_BUS;i++) {
			bus[i].start();
			//try {bus[i].join();} catch (InterruptedException e) {e.printStackTrace();}
		}
		/*for(int i=1;i<NB_BUS;i++) {
			try {bus[i].join();} catch (InterruptedException e) {e.printStackTrace();}
		}*/
		for(int i=1;i<NB_VOYAGEUR;i++) {
			voyageurs[i].start();
			try {
				voyageurs[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*for(int i=1;i<NB_VOYAGEUR;i++) {
			try {voyageurs[i].join();} catch (InterruptedException e) {e.printStackTrace();}
		}*/
		
		
	}

	public static void main(String[] args) {
			new Reseau();
			System.out.println("Tous les voyageurs sont mont�s dans un bus");
	}

}
