package istic.csr.tp5.ressources;

import istic.csr.tp5.backend.Backend;
import istic.csr.tp5.main.Reseau;
import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Relatif aux ajouts mutiple de voyageurs
 */
public class BatchVoyageurRessource extends ServerResource {

    private final Backend backend_;

    /**
     * Constructor.
     * Call for every single user request.
     */
    public BatchVoyageurRessource() {
        super();
        backend_ = (Backend) getApplication().getContext().getAttributes().get("backend");
    }

    /**
     * Permet de faire l'ajout multiple de voyageurs
     * @param representation Une représentation Json de chaque voyageur à ajpouter
     * @return une représentation Json des voyageurs qui viennent d'être ajoutés
     */
    @Post("json")
    public Representation addMany(JsonRepresentation representation){
        JSONObject objects = representation.getJsonObject();
        JSONArray voyageurs = objects.getJSONArray("voyageurs");

        Collection<JSONObject> objectCollection = new ArrayList<>();

        JSONObject msg = new JSONObject().put("Resultat", voyageurs.length() + " voyageurs ajoutés.");
        objectCollection.add(msg);
        JSONObject voyageur_;
        for (int i = 0; i < voyageurs.length(); i++) {
            voyageur_ = voyageurs.getJSONObject(i);
            String name = voyageur_.getString("name");

            // Sauvegarder chaque voyageur
            backend_.getVoyageursDataStore().add(name, Reseau.BILLETERIE, Reseau.ARRET);

            objectCollection.add(voyageur_);
        }

        // generate result
        JSONArray output = new JSONArray(objectCollection);
        return new JsonRepresentation(output);
    }
}
