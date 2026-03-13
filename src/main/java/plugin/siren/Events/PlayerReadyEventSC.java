package plugin.siren.Events;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.universe.world.World;
import plugin.siren.MermaidCommands;
import plugin.siren.Utils.UpdateChecker;

import java.awt.*;

public class PlayerReadyEventSC {
    public static void onPlayerReadyEvent(PlayerReadyEvent event){
        World world = event.getPlayer().getWorld();
        world.execute(() -> {
            Player player = event.getPlayer();

            String recentVersion = UpdateChecker.checkForUpdate();
            if(!MermaidCommands.getVersion().equalsIgnoreCase(recentVersion)){
                String versionMessage = "The Siren's Commands Mod version is outdated, Siren's Commands has released v" + recentVersion +".";
                MermaidCommands.LOGGER.atInfo().log(versionMessage);
                /*if(player.hasPermission("*")){
                    player.sendMessage(Message.raw(versionMessage).color(Color.RED));
                }*/
            }
        });
    }
}
