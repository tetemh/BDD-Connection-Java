package eu.tetemh.exemple;

import eu.tetemh.jobs.bdd.SqlConnection;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static SqlConnection sql;

    @Override
    public void onEnable() {
        sql = new SqlConnection("jdbc:mysql://", "host", "db_name", "name", "password");
        sql.connection();
    }

    @Override
    public void onDisable() {
        sql.disconnect();
    }

    public static SqlConnection getSqlConnection() {
        return sql;
    }
}
