package homePlugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class CommandHomes implements CommandExecutor, Listener {
	
	homePlugin plugin;
	
	public CommandHomes(homePlugin instance) {
		
		plugin = instance;
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {
			
			Player user = (Player) sender;
			String test = plugin.getConfig().getString("id");
			user.sendMessage(ChatColor.AQUA + "Available Homes:");
			user.sendMessage(ChatColor.GOLD + test);
			
		}
		
		return true;
	}
	


}
