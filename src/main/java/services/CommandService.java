package services;

import models.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.Arrays;

public class CommandService {
    public static void onPingCommandReceive(MessageReceivedEvent e, Command c){
        e.getChannel().sendMessage("Pong").queue();
    }
}
