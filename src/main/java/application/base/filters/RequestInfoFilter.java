package application.base.filters;

import org.apache.log4j.Logger;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * Фильтр для извлечения параметров запроса
 * @author Ihor Savchenko
 * @version 1.0
 */
public class RequestInfoFilter extends BaseFilter {

    private static final Logger logger3 = Logger.getLogger(RequestInfoFilter.class.getName()); // создание логгера с именем класса

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws IOException, ServletException {

        // логирование
        logger3.info("Стартовал фильтр, выводящий в консоль параметры запроса");
        // окончание блока логирования

        System.out.println("LocalAddr : " + req.getLocalAddr());
        System.out.println("Protocol : " + req.getProtocol());
        System.out.println("RemoteAddr : " + req.getRemoteAddr());
        System.out.println("LocalPort : " + req.getLocalPort());
        System.out.println("RemotePort : " + req.getRemotePort());
        System.out.println("Method : " + req.getMethod());
        System.out.println("Path : " + req.getServletPath());
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");

        filterChain.doFilter(req, resp);

        // логирование
        logger3.info("Финишировал фильтр, выводящий в консоль параметры запроса");
        // окончание блока логирования
    }
}
