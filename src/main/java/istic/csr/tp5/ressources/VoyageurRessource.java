package istic.csr.tp5.ressources;

import istic.csr.tp5.backend.Backend;
import istic.csr.tp5.dao.Voyageur;
import istic.csr.tp5.main.Reseau;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import java.util.ArrayList;
import java.util.Collection;

public class VoyageurRessource extends ServerResource {

    private final Backend backend;

    public VoyageurRessource() {
        super();
        backend = (Backend) getApplication().getContext().getAttributes().get("backend");
    }

    @Post("json")
    public Representation addNew(JsonRepresentation representation) {
        JSONObject object = representation.getJsonObject();
        String name = object.getString("nom");

        //Save the voyageur
        Voyageur voyageur = new Voyageur(name, Reseau.BILLETERIE, Reseau.ARRET);

        JSONObject result = new JSONObject();
        result.put("Id", voyageur.getId_());
        result.put("Nom", voyageur.getVoyageurName());
        result.put("url", getReference() + "/" + voyageur.getId_());

        return new JsonRepresentation(result);
    }

    @Get("json")
    public Representation getAll() {
        Collection<Voyageur> voyageurs = backend.getVoyageursDataStore().getVoyageurs();
        Collection<JSONObject> jsonObjects = new ArrayList<JSONObject>();

        if(!voyageurs.isEmpty()){


            for (Voyageur voyageur : voyageurs) {
                JSONObject current = new JSONObject();
                current.put("id", voyageur.getId_());
                current.put("name", voyageur.getVoyageurName());
                current.put("url", getReference() + "/" + voyageur.getId_());
                jsonObjects.add(current);
            }

        }else {
            jsonObjects.add(new JSONObject().put("Message", "Aucun voyageur retrouvé."));
        }
        JSONArray jsonArray = new JSONArray(jsonObjects);
        return new JsonRepresentation(jsonArray);
    }
}
