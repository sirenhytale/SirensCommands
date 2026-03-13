package plugin.siren.Commands;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.Universe;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

import javax.annotation.Nonnull;
import java.awt.*;
import java.util.List;

public class ListCmd extends CommandBase {

    public ListCmd(String name, String description) {super(name,description);}

    @Override
    protected void executeSync(@Nonnull CommandContext context){
        String playerListStr = "";

        List<PlayerRef> players = Universe.get().getPlayers();

        for(int i = 0; i < players.size(); i++){
            if(i != 0){
                playerListStr += ", ";
            }
            PlayerRef playerRef = players.get(i);

            playerListStr += playerRef.getUsername();
        }

        Ref<EntityStore> ref = context.senderAsPlayerRef();

        String playerCount = "There ";

        if(players.size() == 1){
            playerCount += "is";
        }else{
            playerCount += "are";
        }

        playerCount += " " + Integer.toString(players.size()) + " ";

        if(players.size() == 1){
            playerCount += "player";
        }else{
            playerCount += "players";
        }

        playerCount += " connected to the server.";

        context.sendMessage(Message.raw(playerCount).color(Color.YELLOW));
        context.sendMessage(Message.raw(playerListStr).color(Color.YELLOW));
    }
}