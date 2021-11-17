
public class Billeterie {
	
	private int nBilletsVendus = 0;
    
	/**
	 * Incremente le nombre de billets vendus
	 */
    public synchronized void prendreBillet() {
    	nBilletsVendus++;
    	System.out.println("Nouveau billet vendu, Nombre de billets vendus: "+nBilletsVendus);
    }
  
}
