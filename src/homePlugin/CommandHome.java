package homePlugin;

import org.bukkit.Location;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class CommandHome implements CommandExecutor, Listener {
	
	homePlugin plugin;
	
	public CommandHome(homePlugin instance) {
		
		plugin = instance;
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {
			
			Player user = (Player) sender;
			Location userHome;
			
			if (args.length == 1 && plugin.getConfig().getString("id").contains(args[0])) {
				
				double x = plugin.getConfig().getDouble(args[0] + ".xcoords");
				double y = plugin.getConfig().getDouble(args[0] + ".ycoords");
				double z = plugin.getConfig().getDouble(args[0] + ".zcoords");
							
				userHome = new Location(user.getWorld(), x, y, z);
				
				user.teleport(userHome);
				user.sendMessage(ChatColor.GOLD + "You've been teleported home!");
				
				
			} else {
				user.sendMessage(ChatColor.RED + "Please specify your home name!");
			}
			
		}
		plugin.saveConfig();
		return true;
	}

}
