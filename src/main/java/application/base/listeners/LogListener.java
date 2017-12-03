package application.base.listeners;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;

/**
 * Листенер для логирования
 * @author Ihor Savchenko
 * @version 1.0
 */
public class LogListener implements ServletContextListener {

    private static final Logger logger5 = Logger.getLogger(LogListener.class.getName()); // создание логгера с именем класса

    public void contextInitialized(ServletContextEvent event) {

            String homeDir = event.getServletContext().getRealPath("/"); // извлекаем путь к корню
                                                    // ServletContext, т.е. внутри директории webapp
            File propertiesFile = new File(homeDir,"WEB-INF/Log4JconfigRolling.properties");
            PropertyConfigurator.configure(propertiesFile.toString());

        // логирование
        logger5.info("Инициализирован ServletContext. Запущен процесс логирования");
        // окончание блока логирования
        }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        // логирование
        logger5.info("Уничтожен ServletContext");
        // окончание блока логирования
    }
}
