package istic.csr.tp5.app;

import istic.csr.tp5.ressources.BatchVoyageurRessource;
import istic.csr.tp5.ressources.BusRessource;
import istic.csr.tp5.ressources.SingleVoyageurRessource;
import istic.csr.tp5.ressources.VoyageurRessource;
import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class ApplicationEntry extends Application {

    public ApplicationEntry(Context context) {
        super(context);
    }

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());
        router.attach("/voyageurs", VoyageurRessource.class);
        router.attach("/voyageurs/many", BatchVoyageurRessource.class);
        router.attach("/voyageurs/{id}", SingleVoyageurRessource.class);

        router.attach("/bus", BusRessource.class);
        return router;
    }
}
