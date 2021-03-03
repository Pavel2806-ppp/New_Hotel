package hotel.utils;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Config {

    private static Logger log = LogUtil.getLogger(Config.class);

    
    private Config() {

    }

    public static synchronized Properties readProperties(String pathToProperties) {
        Properties prop = new Properties();
        InputStream is = Config.class.getClassLoader().getResourceAsStream(pathToProperties);
        try {
            prop.load(is);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return prop;
    }

}
