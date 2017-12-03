package application.base.listeners;

import org.apache.log4j.Logger;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Листенер, слушающий события, связанные с запросами
 * @author Ihor Savchenko
 * @version 1.0
 */
public class RequestListener implements ServletRequestListener {

    private static final Logger logger7 = Logger.getLogger(RequestListener.class.getName()); // создание логгера с именем класса

    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

        // логирование
        logger7.info("Уничтожен объект Request");
        // окончание блока логирования
    }

    public void requestInitialized(ServletRequestEvent servletRequestEvent) {

        // логирование
        logger7.info("Создан объект Request");
        // окончание блока логирования
    }
}
