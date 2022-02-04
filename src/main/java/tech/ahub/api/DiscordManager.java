package tech.ahub.api;

import lombok.SneakyThrows;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import tech.ahub.util.PropertiesReader;

public class DiscordManager {

    private static JDA jda;

    @SneakyThrows
    public void init(){
        String token = new PropertiesReader().getToken();
        jda = JDABuilder.createDefault(token).build();
    }

    public static JDA getJDA(){
        return jda;
    }
}
