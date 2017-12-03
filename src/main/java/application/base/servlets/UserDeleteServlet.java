package application.base.servlets;

import application.base.UserCache;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет для удаления юзера по его id
 * @author Ihor Savchenko
 * @version 1.0
 */
public class UserDeleteServlet extends HttpServlet{

    private static final Logger logger9 = Logger.getLogger(UserDeleteServlet.class.getName()); // создание логгера с именем класса
    private static final UserCache USER_CACHE = UserCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // логирование
        logger9.info("Стартовал UserDeleteServlet");
        // окончание блока логирования

        USER_CACHE.delete(Integer.valueOf(req.getParameter("id")));
        logger9.info("Удалён юзер из мапы юзеров и выполняется внешний редирект на /view");
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/view"));

        // логирование
        logger9.info("Финишировал UserDeleteServlet");
        // окончание блока логирования
    }
}
