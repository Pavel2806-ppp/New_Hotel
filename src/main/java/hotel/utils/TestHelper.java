package hotel.utils;

import org.apache.log4j.Logger;


public final class TestHelper {
    private TestHelper(){}

    private static Logger log = LogUtil.getLogger(TestHelper.class);

    public static synchronized void sleepSeconds(Long seconds) {
        try {
            log.info(String.format("Sleep seconds: %s", seconds));
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
