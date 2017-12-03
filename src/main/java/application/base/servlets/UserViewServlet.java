package application.base.servlets;

import application.base.UserCache;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет для подготовки к рендерингу страницы UserView.jsp
 * @author Ihor Savchenko
 * @version 1.0
 */
public class UserViewServlet extends HttpServlet {

    private static final Logger logger11 = Logger.getLogger(UserViewServlet.class.getName()); // создание логгера с именем класса
    private static final UserCache USER_CACHE = UserCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // логирование
        logger11.info("Стартовал UserViewServlet");
        // окончание блока логирования

        logger11.info("UserViewServlet пытается извлечь атрибут из запроса, но Attr = " + req.getAttribute("Atr"));

        logger11.info("Добавляем в атрибут мапу юзеров");
        req.setAttribute("usersAttr", this.USER_CACHE.values()); // Создаём по ключу usersAttr объект, в который записывается
                                                             // коллекция юзеров из map
        logger11.info("Выполняем внутренний редирект на UserView.jsp");
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/UserView.jsp"); // внутренний редирект на UserView.jsp
        dispatcher.forward(req, resp);

        // логирование
        logger11.info("Финишировал UserViewServlet");
        // окончание блока логирования
    }
}
