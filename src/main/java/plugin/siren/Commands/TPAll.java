package plugin.siren.Commands;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.math.vector.Transform;
import com.hypixel.hytale.math.vector.Vector3d;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.CommandManager;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.console.ConsoleSender;
import com.hypixel.hytale.server.core.entity.LivingEntity;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.modules.entity.component.TransformComponent;
import com.hypixel.hytale.server.core.modules.entity.teleport.Teleport;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.Universe;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import plugin.siren.MermaidCommands;

import javax.annotation.Nonnull;
import java.util.List;

public class TPAll extends AbstractPlayerCommand {
    private final MermaidCommands instance;

    public TPAll(MermaidCommands instance) {
        super("tpall", "Teleports all players to you");
        this.instance = instance;
    }

    @Override
    protected boolean canGeneratePermission() {
        return false;
    }

    @Override
    protected void execute(@Nonnull CommandContext context,
                           @Nonnull Store<EntityStore> store,
                           @Nonnull Ref<EntityStore> ref,
                           @Nonnull PlayerRef playerRef,
                           @Nonnull World world) {

        /*TransformComponent transform = store.getComponent(ref,
                TransformComponent.getComponentType());

        if (transform == null) {
            context.sendMessage(Message.raw("Could not get position"));
            return;
        }*/

        world.execute(() -> {
            List<PlayerRef> onlinePlayers = Universe.get().getPlayers();

            for(PlayerRef plyRef : onlinePlayers){
                if(!plyRef.getUsername().equalsIgnoreCase(playerRef.getUsername())) {
                    if (world.equals(plyRef)) {
                        CommandManager.get().handleCommand(ConsoleSender.INSTANCE, "tp " + plyRef.getUsername() + " " + playerRef.getUsername());
                    }
                }
            }
        });

        //Vector3d pos = transform.getPosition();
        /*context.sendMessage(Message.raw(String.format(
                "You are at %.1f, %.1f, %.1f",
                pos.getX(), pos.getY(), pos.getZ()
        )));*/
        /*
        LivingEntity playerSender = context.senderAs(Player.class);

        World playerWorld = playerSender.getWorld();

        List<PlayerRef> players = Universe.get().getPlayers();

        for(int i = 0; i < players.size(); i++){
            PlayerRef currPlayerRef = players.get(i);

            assert world != null;
            world.execute(() -> {
                Teleport teleport = new Teleport(new Transform(pos.getX(), pos.getY(), pos.getZ()));

                store.addComponent(currPlayerRef.getReference(), Teleport.getComponentType(), teleport);

                currPlayerRef.sendMessage(Message.raw("Teleported to " + playerRef.getUsername()));
            });
        }
         */
    }
}