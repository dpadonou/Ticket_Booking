package istic.csr.tp5.dao;

public class Billeterie {

    private int nBilletsVendus = 0;

    /**
     * Incremente le nombre de billets vendus
     */
    public synchronized void prendreBillet(Voyageur v) {
        nBilletsVendus++;
        System.out.println("Nouveau billet vendu à "+ v.getVoyageurName() +" : Total vendus (" + nBilletsVendus +").");
    }

}
