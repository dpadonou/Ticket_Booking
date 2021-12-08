package istic.csr.tp5.main;

import istic.csr.tp5.app.ApplicationEntry;
import istic.csr.tp5.backend.Backend;
import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Context;
import org.restlet.data.Protocol;

/**
 * Entrée de l'application
 * Déclare l'objet "backend" représentant la base de donnée sur laquelle les requettes seront lancées
 * Initialise le réseau
 */
public final class Main {

    Main() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) throws Exception{
        // Create a component
        Component component = new Component();
        Context context = component.getContext().createChildContext();
        component.getServers().add(Protocol.HTTP, 8124);

        // Create an application
        Application application = new ApplicationEntry(context);

        // Add the backend into component's context
        Backend backend = new Backend();
        context.getAttributes().put("backend", backend);
        component.getDefaultHost().attach(application);

        // Start the component
        component.start();

        //Création des Bus et des Arrêts puis en route des bus
        new Reseau(backend);

    }

}
