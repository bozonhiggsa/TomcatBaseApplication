package application.base.listeners;

import org.apache.log4j.Logger;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * Листенер для работы с атрибутами контекста
 * @author Ihor Savchenko
 * @version 1.0
 */
public class ContextAttributeListener implements ServletContextAttributeListener {

    private static final Logger logger4 = Logger.getLogger(ContextAttributeListener.class.getName()); // создание логгера с именем класса

    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {

        // логирование
        logger4.info("Добавлен атрибут в ServletContext");
        // окончание блока логирования
    }

    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {

        // логирование
        logger4.info("Удалён атрибут из ServletContext");
        // окончание блока логирования
    }

    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {/*NOP*/}
}
