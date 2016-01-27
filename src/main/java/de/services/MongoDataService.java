package de.services;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import de.util.RestaurantData;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Sorts.ascending;

/**
 * Created by niebuhr on 22.01.16.
 */
public class MongoDataService {

    private MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

    private MongoDatabase db = mongoClient.getDatabase("test");

    private MongoCollection<Document> collection = db.getCollection("restaurants");

    public List<String> getDbNames() {
        List<String> dbNames = mongoClient.getDatabaseNames();

        return dbNames;
    }

    public ArrayList<String> getRestaurantNames() {

        ArrayList<String> restaurants = new ArrayList<String>();
        FindIterable<Document> search = collection.find();

        if (search == null) {
            return null;
        }

        for (Document current : search) {
            String name = current.getString("name");
            restaurants.add(name);
        }

        return  restaurants;
    }

    public String findRestaurantByName(String _name) {

        Document query = new Document("name", _name);
        FindIterable<Document> search = collection.find(query);

        if (search == null) {
            return null;
        }

        // Example to read documents
//        for (Document current : search) {
//            Category category = new Category(current.getString("name"),
//                    current.getString("color"),
//                    current.getString("_idUser"));
//            category.setId(current.getObjectId("_id").toString());
//            categoryList.add(category);
//        }

        return search.first().toJson();
    }


}
