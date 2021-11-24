package istic.csr.tp5.ressources;

import istic.csr.tp5.backend.Backend;
import istic.csr.tp5.dao.Bus;
import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class SingleBusRessource extends ServerResource {

    private final Backend backend;

    public SingleBusRessource() {
        super();
        backend = (Backend) getApplication().getContext().getAttributes().get("backend");
    }

    @Get("json")
    public Representation findById() {
        String idString = (String) getRequest().getAttributes().get("id");
        int id = Integer.parseInt(idString);
        Bus bus = backend.getBusDataStore().findById(id);

        JSONObject vObject = new JSONObject();
        if (bus != null) {
            vObject.put("Id", bus.getId_());
            vObject.put("Capacité", Bus.CAPACITY);
            vObject.put("Nombre de passager à bord", bus.getNbPassagers());
            vObject.put("Liste des passagers", new JSONArray(bus.getPassagers()));
        } else {
            vObject.put("Message", "Aucun bus portant ce identifiant n'a été retrouvé.");
        }

        return new JsonRepresentation(vObject);
    }
}
