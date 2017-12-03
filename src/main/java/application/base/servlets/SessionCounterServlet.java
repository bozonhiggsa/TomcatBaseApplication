package application.base.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Сервлет для примера работы с сессией и прямого вывода текста клиенту, установка куки
 * @author Ihor Savchenko
 * @version 1.0
 */
public class SessionCounterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies;
        Cookie cookie = null;
        boolean mark = false;

        cookies = req.getCookies();
        for (Cookie cookieFromRequest: cookies) {
                System.out.println("Из запроса извлечен Cookie c именем " + cookieFromRequest.getName()
                        + " и значением " + cookieFromRequest.getValue());
            if(cookieFromRequest.getName().equals("set")){
                mark = true;
                cookie = cookieFromRequest;
            }
        }

        if(!mark){
            // создаём куку с именем set, если его ещё нет
            cookie = new Cookie("set", "123");
        }

        // посылаем клиенту куку с именем set
        resp.addCookie(cookie);

        // Работа с атрибутом сессии
        HttpSession session = req.getSession();
        AtomicInteger counter = (AtomicInteger) session.getAttribute("counter");
        if(counter == null){
            counter = new AtomicInteger(1);
            session.setAttribute("counter", counter);
        }

        int numberOfVisit = counter.getAndIncrement();
        resp.getWriter().write("Your visit on this page is " + numberOfVisit + " times");
    }
}
