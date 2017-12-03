package application.base.listeners;

import org.apache.log4j.Logger;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Листенер для работы с атрибутами сессии
 * @author Ihor Savchenko
 * @version 1.0
 */
public class SessionAttributeListener implements HttpSessionAttributeListener {

    private static final Logger logger6_1 = Logger.getLogger(SessionAttributeListener.class.getName()); // создание логгера с именем класса


    public void attributeAdded(HttpSessionBindingEvent event) {

        // логирование
        logger6_1.info("Добавлен атрибут в Session");
        // окончание блока логирования
    }

    public void attributeRemoved(HttpSessionBindingEvent event) {

        // логирование
        logger6_1.info("Удалён атрибут из Session");
        // окончание блока логирования
    }

    public void attributeReplaced(HttpSessionBindingEvent event) {/*NOP*/}
}
