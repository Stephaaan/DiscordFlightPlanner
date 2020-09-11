package listeners;

import enums.Action;
import logger.DiscordLogger;
import models.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import services.CommandService;

import javax.annotation.Nonnull;

public class CommandListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        if(event.getAuthor().isBot()) {
            return;
        }
        Command command = new Command(event.getMessage().getContentRaw());

        switch(command.getAction()){
            case PING:
                CommandService.onPingCommandReceive(event,command);
                break;
        }
    }
}
