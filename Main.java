package eu.tetemh.jobs;

import eu.tetemh.jobs.bdd.SqlConnection;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;
    private static SqlConnection sql;

    @Override
    public void onEnable() {
        sql = new SqlConnection("jdbc:mysql://", "87.106.169.47:3309", "s101_survival", "", "");
        sql.connection();
        Main.instance = this;
    }

    @Override
    public void onDisable() {
        sql.disconnect();
    }

    public static SqlConnection getSqlConnection() {
        return sql;
    }
    public static Main getInstance() {
        return instance;
    }
}
