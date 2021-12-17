
class Reseau {
	static final int NB_VOYAGEUR = 100;
	static final int NB_BUS = 5;
	private Arret arret = new Arret();
	private Billeterie billeterie = new Billeterie();
	private Voyageur[] voyageurs = new Voyageur[NB_VOYAGEUR];
	private Bus[] bus = new Bus[NB_BUS];
	
	 Reseau() {
		
		
		/** Instanciation des voyageurs **/
		for(int i=0;i<NB_VOYAGEUR;i++) {
			voyageurs[i] = new Voyageur(i, billeterie, arret);
		}
		
		/** Instanciation des bus **/
		for(int i=0;i<NB_BUS;i++) {
			bus[i] = new Bus(i,arret);
			bus[i].setDaemon(true);
		}
		
		
		/** Lancer les voyageurs et les bus **/
		for(int i=0;i<NB_BUS;i++) {
			bus[i].start();
		}
		
		
		for(int i=0;i<NB_VOYAGEUR;i++) {
			voyageurs[i].start();
			/*try {
				voyageurs[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		
	}

	public static void main(String[] args) {
			new Reseau();
		    //System.out.println("Tous les voyageurs sont mont�s dans un bus");
	}

}
