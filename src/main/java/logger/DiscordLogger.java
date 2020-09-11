package logger;

public class DiscordLogger {
    private static String discordBotPrefix = "Discord Flight App | ";
    public static void out (String msg){
        System.out.println(discordBotPrefix + msg);
    }
    public static void err (String msg) {
        System.out.println(discordBotPrefix + msg);
    }
}
