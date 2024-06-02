package de.moritz.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bson.Document;
import org.bukkit.Bukkit;

public class Mongo {

    public static MongoDatabase mongoDatabase;
    public static MongoCollection<Document> collection;

    // Method to connect to the database
    public static void connect(String name, String password, String ip, int port) {

        try (MongoClient mongoClient = MongoClients.create("mongodb://" + name + ":" + password + "@" + ip + ":" + port + "/?authSource=admin")) {

            mongoDatabase = mongoClient.getDatabase("admin");
            collection = mongoDatabase.getCollection("players");

            Bukkit.getConsoleSender().sendMessage(Component.text("Successfully connected to the database!").color(TextColor.color(0xcc0000)));

        } catch (Exception e) {

            Bukkit.getConsoleSender().sendMessage(Component.text("Cant connect to the database!").color(TextColor.color(0xcc0000)));

        }

    }

}
