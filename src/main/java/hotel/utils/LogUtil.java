package hotel.utils;

import org.apache.log4j.Logger;

public class LogUtil {
    private LogUtil(){

    }

    public static synchronized Logger getLogger(Class className){
        return Logger.getLogger(className);
    }
}


