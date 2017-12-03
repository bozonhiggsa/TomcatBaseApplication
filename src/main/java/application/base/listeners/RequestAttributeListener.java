package application.base.listeners;

import org.apache.log4j.Logger;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * Листенер для работы с атрибутами запроса
 * @author Ihor Savchenko
 * @version 1.0
 */
public class RequestAttributeListener implements ServletRequestAttributeListener {

    private static final Logger logger6 = Logger.getLogger(RequestAttributeListener.class.getName()); // создание логгера с именем класса

    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {

        // логирование
        logger6.info("Добавлен атрибут в Request");
        // окончание блока логирования
    }

    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {

        // логирование
        logger6.info("Удалён атрибут из Request");
        // окончание блока логирования
    }

    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {/*NOP*/}
}
