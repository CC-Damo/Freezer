package uk.co.ddelay.freezer;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerListener implements Listener{
public Freezer plugin;

public PlayerListener(Freezer plugin) {
		this.plugin = plugin;
	}

@EventHandler(priority = EventPriority.HIGHEST)
public void onPlayerMoveEvent(PlayerMoveEvent event){
	Player player = event.getPlayer();
	if(plugin.players.contains(player)){
		if(event.getFrom().getX() != event.getTo().getX() || event.getFrom().getY() != event.getTo().getY() || event.getFrom().getZ() != event.getTo().getZ())
		{
			World world = event.getFrom().getWorld();
			double x = event.getFrom().getX();
			double y = event.getFrom().getY();
			double z = event.getFrom().getZ();
			Math.floor(z);
			Math.floor(y);
			Math.floor(x);
			Location loc = new Location(world, x, y, z);
			loc.setPitch(event.getTo().getPitch());
			loc.setYaw(event.getTo().getYaw());
			event.getPlayer().teleport(loc);
		}
	}
}


}
