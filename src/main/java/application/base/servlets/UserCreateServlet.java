package application.base.servlets;

import application.base.User;
import application.base.UserCache;

import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Сервлет для создания нового юзера
 * @author Ihor Savchenko
 * @version 1.0
 */
public class UserCreateServlet extends HttpServlet {

    private static final Logger logger8 = Logger.getLogger(UserCreateServlet.class.getName()); // создание логгера с именем класса
    final AtomicInteger ids = new AtomicInteger();
    private static final UserCache USER_CACHE = UserCache.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // логирование
        logger8.info("Стартовал UserCreateServlet");
        // окончание блока логирования


        if(Integer.valueOf(req.getParameter("id")) != -1){
            this.USER_CACHE.delete(Integer.valueOf(req.getParameter("id")));
            logger8.info("Удалён старый юзер");
        }
        logger8.info("Добавляем в атрибут Attr число");
        req.setAttribute("Attr", 12); // Этим атрибутом нельзя будет воспользоваться, т.к. он будет уничтожен вместе с текущим запросом
        this.USER_CACHE.add(new User(this.ids.incrementAndGet(), req.getParameter("login"), req.getParameter("password")));
        logger8.info("Добавлен новый юзер в мапу юзеров и выполняется внешний редирект на /view");
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/view")); // внешний редирект
        //resp.sendRedirect("/view");  // такой вариант тоже подходит для запуска из IDE, но для запуска из папки Tomcat
                                       // необходимо прописывать полный путь, как выше, чтобы URI включал название .war
                                       // архива

        // логирование
        logger8.info("Финишировал UserCreateServlet");
        // окончание блока логирования
    }
}
