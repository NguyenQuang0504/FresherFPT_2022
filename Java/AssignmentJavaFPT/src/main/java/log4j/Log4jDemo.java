package log4j;

import org.apache.log4j.Logger;

public class Log4jDemo {
    private static final Logger logger = Logger.getLogger(Log4jDemo.class);
//    public static void main(String[] args) {
//        logger.debug(" message");
//        logger.error("error log");
//        logger.info("info log");
//    }
    public void loggerInfor(String message){
        logger.info("Content log: " +message);
    }
    public void errorLog(String message){
        logger.error(message);
    }
}
