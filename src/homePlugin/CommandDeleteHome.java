package homePlugin;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class CommandDeleteHome implements CommandExecutor, Listener {

	homePlugin plugin;

	public CommandDeleteHome(homePlugin instance) {

		plugin = instance;

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player) {
		
			Player user = (Player) sender;

			
			
			
			if (args.length == 1) {
					
			String ids = plugin.getConfig().getString("id");
			String[] newIds = ids.split(", ");
			
			for (int i = 0; i < newIds.length; i++) {
				
				if (newIds[i] != null) {
					System.out.println(newIds[i]);
				}
				
			}
			
			String[] newestIds = new String[newIds.length];
			
			//for loop finds the designated arg
			for (int i = 0; i < newIds.length; i++) {
				
				System.out.println(args[0]);
				System.out.println(newIds[i]);
				
				if (newIds[i].contains(args[0])) {
					newIds[i] = null;
					System.out.println("deleted");
				}
				
				if (newIds[i] != null) {
					newestIds[i] = newIds[i];
				}
				
			}

			String newString = StringUtils.join(newestIds, ", ");
				
			plugin.getConfig().set("id", newString);
			plugin.getConfig().set(args[0], null);
			user.sendMessage(ChatColor.RED + "You've deleted your home.");
			plugin.saveConfig();		
					
				
				
				
			} else {
				
				user.sendMessage(ChatColor.RED + "Enter a valid home name!~");
			}
			
		
		}

	return true;

	}

}
