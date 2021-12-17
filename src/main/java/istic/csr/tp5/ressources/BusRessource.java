package istic.csr.tp5.ressources;

import istic.csr.tp5.backend.Backend;
import istic.csr.tp5.dao.Bus;
import istic.csr.tp5.dao.Voyageur;
import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Relatif au requêtes portants sur un seul Bus
 */
public class BusRessource extends ServerResource {

    private final Backend backend;

    public BusRessource() {
        super();
        backend = (Backend) getApplication().getContext().getAttributes().get("backend");
    }

    /**
     * Récupérer un bus grâce à son identifiant
     * @return les caractéristiques du bus dont l'ID est spécifier dans l'URL
     */
    @Get("json")
    public Representation getAll() {
        Collection<Bus> busCollection = backend.getBusDataStore().getAll();
        Collection<JSONObject> jsonObjects = new ArrayList<JSONObject>();

        if(!busCollection.isEmpty()){
            for (Bus bus : busCollection) {
                JSONObject vObject = new JSONObject();
                vObject.put("Id", bus.getId_());
                vObject.put("Capacité", Bus.CAPACITY);
                vObject.put("Nombre de passager à bord", bus.getNbPassagers());
                vObject.put("Liste des passagers", new JSONArray(bus.getPassagers()));
                jsonObjects.add(vObject);
            }
        }else {
            jsonObjects.add(new JSONObject().put("Message", "Aucun bus retrouvé."));
        }
        JSONArray jsonArray = new JSONArray(jsonObjects);
        return new JsonRepresentation(jsonArray);
    }
}
