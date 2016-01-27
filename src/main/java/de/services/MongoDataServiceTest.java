package de.services;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by niebuhr on 27.01.16.
 */
public class MongoDataServiceTest {

    private MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

    private MongoDatabase db = mongoClient.getDatabase("test");

    private MongoCollection<Document> collection = db.getCollection("restaurants");


    @Test
    public void shouldFindARestaurantByName () {
        MongoDataService mongoDatraService = new MongoDataService();
        String name = "The Movable Feast";
        String restaurantJSON = "{ \"_id\" : { \"$oid\" : \"569e3019847264be68c1ffb7\" }, \"address\" : { \"building\" : \"284\", \"coord\" : [-73.9829239, 40.6580753], \"street\" : \"Prospect Park West\", \"zipcode\" : \"11215\" }, \"borough\" : \"Brooklyn\", \"cuisine\" : \"American \", \"grades\" : [{ \"date\" : { \"$date\" : 1416355200000 }, \"grade\" : \"A\", \"score\" : 11 }, { \"date\" : { \"$date\" : 1384387200000 }, \"grade\" : \"A\", \"score\" : 2 }, { \"date\" : { \"$date\" : 1354665600000 }, \"grade\" : \"A\", \"score\" : 13 }, { \"date\" : { \"$date\" : 1337212800000 }, \"grade\" : \"A\", \"score\" : 11 }], \"name\" : \"The Movable Feast\", \"restaurant_id\" : \"40361606\" }";

        String result = mongoDatraService.findRestaurantByName(name);

        assertEquals("Result should be JSON-String!", restaurantJSON, result);
    }
}