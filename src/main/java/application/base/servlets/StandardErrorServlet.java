package application.base.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет, возвращающий одну из стандартных страниц с кодом ошибки
 * Срабатывает при попытке доступа по адресу /error
 * @author Ihor Savchenko
 * @version 1.0
 */
public class StandardErrorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Если возвращается код ответа, подразумевающий редирект, то надо указать новый URI
        resp.addHeader("Location", "/view");
        //resp.sendError(HttpServletResponse.SC_FOUND);
        //resp.sendError(HttpServletResponse.SC_TEMPORARY_REDIRECT);
        resp.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT); // Данный метод возвращает код ошибки, но не рендерит страницу
                                                                   // В случае редиректа это подходит

        //resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        //resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        //resp.sendError(HttpServletResponse.SC_NOT_MODIFIED);
        //resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        //resp.setStatus(HttpServletResponse.SC_OK); // Данный метод возвращает код ошибки, но не рендерит страницу

    }
}
