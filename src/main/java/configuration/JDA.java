package configuration;

import listeners.CommandListener;
import logger.DiscordLogger;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class JDA {
    private static net.dv8tion.jda.api.JDA jdaInstance = null;
    public static net.dv8tion.jda.api.JDA getJDABuilderInstance() {
      if(jdaInstance == null) {
          try {
              initJdaInstance();
          }catch (LoginException ex) {
              DiscordLogger.err("Login Exception " + ex.getMessage());
          }
      }
      return jdaInstance;
    }
    private static void initJdaInstance() throws LoginException {
        //TODO: get token

        jdaInstance = new  JDABuilder(AccountType.BOT)
                .setToken(getToken())
                .addEventListeners(new CommandListener())
                .build();
    }
    private static String getToken() {
        File tokenFile = null;
        URL resource = JDA.class.getClassLoader().getResource("token.txt");
        if (resource == null) {
            DiscordLogger.err("Token file not found!");
        } else {
            try {
                tokenFile  = new File(resource.toURI());
            }catch(URISyntaxException ex) {
                DiscordLogger.err("Unknown error > " + ex.getMessage());
            }
        }
        if(tokenFile != null ) {
            try {
                return new Scanner(tokenFile).nextLine();
            }catch(FileNotFoundException ex) {
                DiscordLogger.err("Token file not found!");
                return "";
            }
        }
        return "";
    }
}
