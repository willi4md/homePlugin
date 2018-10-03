package homePlugin;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class homePlugin extends JavaPlugin{
	
	@Override
	public void onEnable() {
		
		if (getConfig().toString() == "") {
		getConfig().options().copyDefaults(true);
		saveConfig();
		} else {
		reloadConfig();
		getServer().getPluginManager().registerEvents( new CommandSetHome(this), this);
		getCommand("sethome").setExecutor(new CommandSetHome(this));
		getCommand("home").setExecutor(new CommandHome(this));
		getCommand("homes").setExecutor(new CommandHomes(this));
		getCommand("deletehome").setExecutor(new CommandDeleteHome(this));
		}
	}
	
	@Override
	public void onDisable() {
		saveConfig();
	}

}