package istic.csr.tp5.ressources;

import istic.csr.tp5.backend.Backend;
import istic.csr.tp5.dao.Voyageur;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class SingleVoyageurRessource extends ServerResource {

    private final Backend backend;

    public SingleVoyageurRessource() {
        super();
        backend = (Backend) getApplication().getContext().getAttributes().get("backend");
    }

    @Get("json")
    public Representation findById(){
        String idString = (String) getRequest().getAttributes().get("id");
        int id = Integer.parseInt(idString);
        Voyageur voyageur = backend.getVoyageursDataStore().findById(id);

        JSONObject vObject = new JSONObject();
        if (voyageur != null) {
            vObject.put("Id", voyageur.getId_());
            vObject.put("Nom", voyageur.getName());
            vObject.put("Current bus", new JSONObject(voyageur.getBus()));
        } else {
            vObject.put("Message", "Aucun voyageur portant ce identifiant n'a été retrouvé.");
        }

        return new JsonRepresentation(vObject);
    }
}
