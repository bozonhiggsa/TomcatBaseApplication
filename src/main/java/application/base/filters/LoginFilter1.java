package application.base.filters;

import application.base.UserCache;

import org.apache.log4j.Logger;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Фильтр для проверки, что введённые login и password не пустые строки
 * В случае обнаружения пустых строк рендерит страницу ошибки
 * Иначе передаёт запрос на следующий фильтр
 * @author Ihor Savchenko
 * @version 1.0
 */
public class LoginFilter1 extends BaseFilter {

    private static final Logger logger1 = Logger.getLogger(LoginFilter1.class.getName()); // создание логгера с именем класса
    private static final UserCache USER_CACHE = UserCache.getInstance();

    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws IOException, ServletException {

        // логирование
        logger1.info("Стартовал фильтр для определения пустых значений полей login и/или password");
        // окончание блока логирования

        long t1 = System.nanoTime();

        if((req.getParameter("login") =="" || req.getParameter("password") == "")){
            logger1.info("Фильтр обнаружил пустое поле, создаёт атрибут с мапой юзеров и выполняет внутренний редирект на страницу ошибки");
            req.setAttribute("usersAttr", this.USER_CACHE.values());
            RequestDispatcher dispatcher = req.getRequestDispatcher("views/ErrorEmpty.jsp"); // внутренний редирект на ErrorEmpty.jsp
            dispatcher.forward(req, resp);
        }
        else {
            logger1.info("Фильтр не обнаружил пустых полей и отправляет запрос дальше по цепочке");
            filterChain.doFilter(req, resp);
        }

        long t2 = System.nanoTime();
        System.out.println("Разница между временем захода запроса в фильтр LoginFilter1 и временем выхода из него = "
                + (t2 - t1)/1000000 + " ms");

        // логирование
        logger1.info("Финишировал фильтр для определения пустых значений полей login и/или password");
        // окончание блока логирования
    }
}
