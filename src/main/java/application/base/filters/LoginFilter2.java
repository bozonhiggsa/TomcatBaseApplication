package application.base.filters;

import application.base.User;
import application.base.UserCache;

import org.apache.log4j.Logger;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Фильтр для проверки, что введённые login и password не совпадают с уже существующими
 * В случае обнаружения совпадений ренлерит страницу ошибки
 * Иначе передаёт запрос дальше по цепочке
 * @author Ihor Savchenko
 * @version 1.0
 */
public class LoginFilter2 extends BaseFilter {

    private static final Logger logger2 = Logger.getLogger(LoginFilter2.class.getName()); // создание логгера с именем класса
    private static final UserCache USER_CACHE = UserCache.getInstance();

    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws IOException, ServletException {

        // логирование
        logger2.info("Стартовал фильтр для проверки значений полей login и password на совпадения с уже существующими");
        // окончание блока логирования

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        boolean mark = false;

        for (User user: this.USER_CACHE.values()) {
            if(user.getLogin().equals(login) || user.getPassword().equals(password)){
                mark = true;
            }
        }

        if(mark == true){
            logger2.info("Фильтр обнаружил совпаданение, создаёт атрибут с мапой юзеров и выполняет внутренний редирект на страницу ошибки");
            req.setAttribute("usersAttr", this.USER_CACHE.values());
            RequestDispatcher dispatcher = req.getRequestDispatcher("views/ErrorLoginPassword.jsp"); // внутренний редирект на ErrorLoginPassword.jsp
            dispatcher.forward(req, resp);
        }
        else {
            logger2.info("Фильтр не обнаружил совпадений и отправляет запрос дальше по цепочке");
            filterChain.doFilter(req, resp);
        }

        // логирование
        logger2.info("Финишировал фильтр для проверки значений полей login и password на совпадения");
        // окончание блока логирования
    }
}
