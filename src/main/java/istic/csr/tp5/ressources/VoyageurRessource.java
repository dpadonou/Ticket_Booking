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

/**
 * Relatif au requêtes portants sur un voyageur unique
 */
public class VoyageurRessource extends ServerResource {

    private final Backend backend;

    public VoyageurRessource() {
        super();
        backend = (Backend) getApplication().getContext().getAttributes().get("backend");
    }

    /**
     * Ajouter un voyageur à la base de données
     * @param representation : Description Json du voyageur à ajouter
     * @return : Une description Json du voyageur ajouté, indiquant que l'opération s'est bien terminée
     */
    @Post("json")
    public Representation addNew(JsonRepresentation representation) {
        JSONObject object = representation.getJsonObject();
        String name = object.getString("name");

        //Save the voyageur
        Voyageur voyageur = new Voyageur(name, Reseau.BILLETERIE, Reseau.ARRET);
        backend.getVoyageursDataStore().add(name, Reseau.BILLETERIE, Reseau.ARRET);

        JSONObject result = new JSONObject();
        result.put("Id", voyageur.getId_());
        result.put("Nom", voyageur.getVoyageurName());
        result.put("url", getReference() + "/" + voyageur.getId_());

        return new JsonRepresentation(result);
    }

    /**
     * @return les caractéristiquues de tous les voyageurs enregistrés dans le système
     */
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
