package tech.ahub.util;


import lombok.Getter;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

@Getter
public class PropertiesReader {
    private final String token;

    @SneakyThrows
    public PropertiesReader(){
        File file = new File("bot.properties");
        Properties properties = new Properties();
        properties.load(new FileReader(file));
        token = properties.getProperty("TOKEN");
    }
}
