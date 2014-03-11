package uk.co.ddelay.freezer;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {
private Freezer plugin;
	public CommandHandler(Freezer instance) {
		this.plugin = instance;
	}
	private String freeze = Freezer.freeze;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel,
			String[] args) {
		if(cmd.getName().equalsIgnoreCase("freeze")){
			if(args.length == 0){
				return false;
			}else{
				if(args.length == 1){
					String playername = args[0];
					Player target = Bukkit.getServer().getPlayer(playername);
					if(target == null){
						sender.sendMessage(freeze + "Player not online!");
						return true;
					}else{
						plugin.freezePlayer(sender, target);
						return true;
					}
				}
			}
		}
		return false;
	}

}
