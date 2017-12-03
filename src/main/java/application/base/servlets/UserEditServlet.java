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
 * Сервлет для редактирования юзера
 * @author Ihor Savchenko
 * @version 1.0
 */
public class UserEditServlet extends HttpServlet {

    private static final Logger logger10 = Logger.getLogger(UserEditServlet.class.getName()); // создание логгера с именем класса
    private static final UserCache USER_CACHE = UserCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // логирование
        logger10.info("Стартовал UserEditServlet");
        // окончание блока логирования

        logger10.info("Добавляем в атрибут редактируемого юзера");
        req.setAttribute("userAttr", this.USER_CACHE.get(Integer.valueOf(req.getParameter("id"))));
        logger10.info("Выполняем внутренний редирект на EditUser.jsp");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/EditUser.jsp");
        dispatcher.forward(req, resp);

        // логирование
        logger10.info("Финишировал UserEditServlet");
        // окончание блока логирования
    }
}
