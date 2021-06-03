package team.hub.discordbot;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import team.hub.discordbot.actions.SuggestController;
import team.hub.discordbot.commands.Apresentation;

import javax.security.auth.login.LoginException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static team.hub.discordbot.actions.SuggestController.channelSuggestions;

public class Main  {

    /*
     * Construído por Martin Hartfelder
     * 02/05/21
     */

    public static void main(String[] args) throws IOException, LoginException {

        // Properties File
        Properties props = new Properties();
        props.load(new FileReader("bot.properties"));

        // Main Builder
        JDABuilder builder = JDABuilder.createDefault(props.getProperty("token"));

        // Strings Props
        channelSuggestions = props.getProperty("channelSuggestions");

        // Propriedades do BOT
        builder.addEventListeners(new Apresentation(), new SuggestController());
        builder.setActivity(Activity.listening("em Hub Tech"));
        builder.build();
    }
}
