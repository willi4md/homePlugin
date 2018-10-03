package homePlugin;

import org.bukkit.Location;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class CommandSetHome implements CommandExecutor, Listener {

	homePlugin plugin;

	public CommandSetHome(homePlugin instance) {

		plugin = instance;

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {

			Player user = (Player) sender;
			String[] homes = new String[2];

			if (args.length == 1) {

				String homeName = args[0];
				
				if (plugin.getConfig().getString("id") == null) {
					
					plugin.getConfig().set("id", homeName);
					plugin.getConfig().set(homeName + ".xcoords", user.getLocation().getX());
					plugin.getConfig().set(homeName + ".ycoords", user.getLocation().getY());
					plugin.getConfig().set(homeName + ".zcoords", user.getLocation().getZ());
					plugin.getConfig().set(homeName + ".world", user.getWorld().getName());
					
					
				} else {
					
				homes[0] = plugin.getConfig().getString("id");
				homes[1] = homeName;
					
				plugin.getConfig().set("id", homes[0] + ", " + homes[1]);		
				plugin.getConfig().set(homeName + ".xcoords", user.getLocation().getX());
				plugin.getConfig().set(homeName + ".ycoords", user.getLocation().getY());
				plugin.getConfig().set(homeName + ".zcoords", user.getLocation().getZ());
				plugin.getConfig().set(homeName + ".world", user.getWorld().getName());
				
				
				}

				user.sendMessage(ChatColor.GOLD + "You set a new home named: " + homeName);

			} else {

				user.sendMessage(ChatColor.RED + "Please enter a name for your home!~");

			}

			// on the running of the command, the players config is reset to their current
			// location
			plugin.saveConfig();

		}

		return true;
	}

}
