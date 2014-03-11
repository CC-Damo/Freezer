package uk.co.ddelay.freezer;

import java.util.HashSet;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Freezer extends JavaPlugin {
	Logger log = Logger.getLogger("Minecraft");
	public HashSet<Player> players = new HashSet<Player>();
	public final static String freeze = ChatColor.AQUA + "[Freezer]: ";
	public final PlayerListener pl = new PlayerListener(this);
	
	
	public void onEnable(){
		this.logMessage("Enabled!");
	PluginManager pm = this.getServer().getPluginManager();
	pm.registerEvents(pl, this);
	getCommand("freeze").setExecutor(new CommandHandler(this));
	}
	
	public void onDisable(){
		this.logMessage("Disabled");
	}
	
	public void logMessage(String msg){
		PluginDescriptionFile pdFile = this.getDescription();
		String LogFirst = pdFile.getName() + " " + pdFile.getVersion() + ": ";
		this.log.info(LogFirst + msg);
		
	}
	
	public void freezePlayer(CommandSender sender, Player name){
		if(players.contains(name)){
			players.remove(name);
			sender.sendMessage(freeze + "Player " + name.getDisplayName().toString() + " Thawed!"); 
			name.sendMessage(freeze + "You have Been Thawed!");
		}else{
			players.add(name);
			sender.sendMessage(freeze + "Player " + name.getDisplayName().toString() + " Frozen!");
			name.sendMessage(freeze + "You have Been Frozen!");
			this.encasePlayer(name);
		}
	}
	private void encasePlayer(Player n) {
		World world = n.getLocation().getWorld();
		double x = n.getLocation().getX();
		double y = n.getLocation().getY();
		double z = n.getLocation().getZ();
		Location loc = new Location(world, x, y, z);
		Block block_front1 = loc.getBlock().getRelative(BlockFace.EAST);
		Block block_back1 = loc.getBlock().getRelative(BlockFace.WEST);
		Block block_left1 = loc.getBlock().getRelative(BlockFace.NORTH);
		Block block_right1 = loc.getBlock().getRelative(BlockFace.SOUTH);

		
		block_front1.setType(Material.PACKED_ICE);
		block_back1.setType(Material.PACKED_ICE);
		block_left1.setType(Material.PACKED_ICE);
		block_right1.setType(Material.PACKED_ICE);
		
		loc.add(0, 1, 0);
		Block block_front2 = loc.getBlock().getRelative(BlockFace.EAST);
		Block block_back2 = loc.getBlock().getRelative(BlockFace.WEST);
		Block block_left2 = loc.getBlock().getRelative(BlockFace.NORTH);
		Block block_right2 = loc.getBlock().getRelative(BlockFace.SOUTH);
		
		block_front2.setType(Material.GLASS);
		block_back2.setType(Material.GLASS);
		block_left2.setType(Material.GLASS);
		block_right2.setType(Material.GLASS);
		
		loc.add(0, 1, 0);
		Block block_front3 = loc.getBlock().getRelative(BlockFace.EAST);
		Block block_back3 = loc.getBlock().getRelative(BlockFace.WEST);
		Block block_left3 = loc.getBlock().getRelative(BlockFace.NORTH);
		Block block_right3 = loc.getBlock().getRelative(BlockFace.SOUTH);
		
		block_front3.setType(Material.PACKED_ICE);
		block_back3.setType(Material.PACKED_ICE);
		block_left3.setType(Material.PACKED_ICE);
		block_right3.setType(Material.PACKED_ICE);
		
		Block block_top = loc.getBlock().getRelative(BlockFace.UP);
		block_top.setType(Material.PACKED_ICE);
		
		loc.add(0,1,0);
		Block torch_top = loc.getBlock().getRelative(BlockFace.UP);
		torch_top.setType(Material.TORCH);
		
	}

}
