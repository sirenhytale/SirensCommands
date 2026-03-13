package plugin.siren.Commands;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractAsyncCommand;
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.Universe;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import plugin.siren.MermaidCommands;

import javax.annotation.Nonnull;
import java.awt.*;

public class MermaidCommandsList extends CommandBase {

    public MermaidCommandsList(String name, String description) {super(name,description);}

    @Override
    protected void executeSync(@Nonnull CommandContext context){
        //Ref<EntityStore> ref = context.senderAsPlayerRef();
        //Player player = ref.getStore().getComponent(ref, Player.getComponentType());

        context.sendMessage(Message.raw("Siren Commands").color(Color.CYAN).bold(true));
        context.sendMessage(Message.raw("Version: " + MermaidCommands.getVersion()).color(Color.cyan).italic(true));
        context.sendMessage(Message.raw("==-==-==-==-==-==-==-==").color(Color.CYAN));
        context.sendMessage(Message.raw("/sirencommands, /scmds : See this menu").color(Color.CYAN));
        context.sendMessage(Message.raw("/list, /players : See who is connected to the server").color(Color.CYAN));
        context.sendMessage(Message.raw("/gmc, /gma : Sets the player's gamemode").color(Color.CYAN));
        context.sendMessage(Message.raw("/top : Sends player to the surface").color(Color.CYAN));
        context.sendMessage(Message.raw("/sucide, /die : Kills the player").color(Color.CYAN));
        context.sendMessage(Message.raw("/back : Teleports the player to last location").color(Color.CYAN));
    }
}