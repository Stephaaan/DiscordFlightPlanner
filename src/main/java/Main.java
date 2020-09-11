import logger.DiscordLogger;
import net.dv8tion.jda.api.JDA;

public class Main {
    public static void main(String[] args) {
        JDA jda = configuration.JDA.getJDABuilderInstance();
        if(jda == null) {
            DiscordLogger.err("JDA Object is null, application stopping...");
            return;
        }

    }
}
