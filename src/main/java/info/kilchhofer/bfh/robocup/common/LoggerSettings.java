package info.kilchhofer.bfh.robocup.common;

import ch.quantasy.mqtt.gateway.client.message.annotations.StringForm;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.spi.StandardLevel;

public class LoggerSettings {
    @StringForm
    public String name;

    public StandardLevel level;

    public LoggerSettings(String loggerName, StandardLevel logLevel) {
        this.name = loggerName;
        this.level = logLevel;
    }

    /**
     * Needed for deserialization
     */
    public LoggerSettings(){
    }

    public void configure(){
        Level newLevel = Level.getLevel(this.level.name());
        String loggerName = this.name;
        System.out.println("Loglevel of '" + loggerName +"' should be: "+ newLevel);

        Logger loggers = (Logger) LogManager.getLogger(loggerName);
        System.out.println("old level" + loggers.getLevel());

        loggers.setLevel(newLevel);
        System.out.println("new level" + loggers.getLevel());
    }
}
