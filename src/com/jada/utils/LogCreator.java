package com.jada.utils;


import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public final class LogCreator {

    public static Logger createLogger(String name, boolean consoleOutput){
        Logger logger = Logger.getLogger(name);
        FileHandler fh;
        FileHandler htmlFile;
        try{
            fh = new FileHandler("logs/" + name + ".log");
            logger.addHandler(fh);
            SimpleFormatter sf = new SimpleFormatter();
            fh.setFormatter(sf);

            htmlFile = new FileHandler("logs/" + name + ".html");
            HtmlFormatter htmlFormatter = new HtmlFormatter();
            htmlFile.setFormatter(htmlFormatter);
            logger.addHandler(htmlFile);

            logger.setLevel(Level.ALL);
            logger.setUseParentHandlers(consoleOutput); //<-- Consolen Output aus
            logger.info("Create the log for " + name);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return logger;
    }

}
