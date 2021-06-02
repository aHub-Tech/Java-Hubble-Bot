package team.hub.discordbot;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import team.hub.discordbot.commands.Apresentation;

import javax.security.auth.login.LoginException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main  {

    /*
     * Construído por Martin Hartfelder
     * 02/05/21
     */

    public static void main(String[] args) throws IOException, LoginException {

        Properties props = new Properties();
        props.load(new FileReader("bot.properties"));
        JDABuilder builder = JDABuilder.createDefault(props.getProperty("token"));


        builder.addEventListeners(new Apresentation());
        builder.setActivity(Activity.listening("em Hub Tech"));
        builder.build();
    }
}
