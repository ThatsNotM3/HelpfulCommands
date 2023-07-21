package net.thatsnotm3.helpfulcommands.command;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.HoverEvent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.server.command.CommandManager;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.Entity;

public class CMD_Ignite{

    static final String cmdName="ignite";

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess registryAccess, CommandManager.RegistrationEnvironment environment){
        dispatcher.register(CommandManager.literal(cmdName)
            .then(CommandManager.argument("time", IntegerArgumentType.integer(0)).executes(ctx->run(ctx,IntegerArgumentType.getInteger(ctx, "time"),null))
                .then(CommandManager.argument("target", EntityArgumentType.entities()).executes(ctx->run(ctx,IntegerArgumentType.getInteger(ctx, "time"),EntityArgumentType.getEntities(ctx, "target"))))
            )
        );
    }

    public static int run(CommandContext<ServerCommandSource> ctx, int time, Collection<? extends Entity> targets) throws CommandSyntaxException{
        ServerPlayerEntity player=ctx.getSource().getPlayer();

        if(!ModCommandManager.RunChecks(cmdName,player)) return -1;

        if(targets!=null){
            int i=0;
            Iterator iter=targets.iterator();
            List<String> targetNames=new ArrayList<String>();
            while(iter.hasNext()){
                Entity target=(Entity) iter.next();
                target.setOnFireFor(time);
                
                if(target!=player){
                    MutableText msg=Text.literal(player.getEntityName()+": ")
                        .formatted(Formatting.GRAY)
                        .append(Text.translatable("message.command.ignite.self").formatted(Formatting.WHITE))
                    ;
                    target.sendMessage(msg);
                }

                targetNames.add(target.getEntityName());
                ++i;
            }
            if(i>0){
                String allTargetNames="";
                for(String n : targetNames) allTargetNames=allTargetNames+n+"\n";
                allTargetNames=allTargetNames.substring(0, allTargetNames.length()-1);
                Style playerList=Style.EMPTY
                    .withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,Text.literal(allTargetNames)))
                    .withColor(Formatting.AQUA)
                ;
                MutableText msg=Text.translatable("message.command.ignite.target",Text.literal(Integer.toString(i)).setStyle(playerList),Text.literal(Integer.toString(time)).formatted(Formatting.GOLD)).formatted(Formatting.GREEN);
                player.sendMessage(msg);
            } else{
                player.sendMessage(Text.translatable("text.noTargets").formatted(Formatting.RED));
            }
        } else{
            player.setOnFireFor(time);
            player.sendMessage(Text.translatable("message.command.ignite.self",Text.literal(Integer.toString(time)).formatted(Formatting.GOLD)).formatted(Formatting.GREEN));
        }

        return 1;
    }
}