package de.moritz;


import de.moritz.mongo.Mongo;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Database extends JavaPlugin {

    private Mongo mongo;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage(Component.text("API started").color(TextColor.color(0xcc0000)));

        // Creating Mongo instance?
        mongo = new Mongo();

    }

    public Mongo getMongo() {
        return mongo;
    }
}
