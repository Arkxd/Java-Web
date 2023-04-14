package Cookie;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "LastAccess", value = "/LastAccess")
public class LastAccess extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = utf-8");
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        if (cookies.length > 0 && cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("lastTime".equals(name)) {
                    flag = true;
                    String value = cookie.getValue();
                    System.out.println("解码前：" + value);
                    value = URLDecoder.decode(value, StandardCharsets.UTF_8);
                    System.out.println("解码后：" + value);
                    response.getWriter().write("欢迎回来，您上次访问时间为：" + value);
                    Date date = new Date();
                    SimpleDateFormat timesdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_time = timesdf.format(date);
                    System.out.println("编码前：" + str_time);
                    str_time = URLEncoder.encode(str_time, StandardCharsets.UTF_8);
                    System.out.println("编码后：" + str_time);
                    cookie.setValue(str_time);
                    cookie.setMaxAge(60*60*24*30);
                    response.addCookie(cookie);
                    break;
                }
            }
            if (cookies == null || cookies.length == 0 || flag == false) {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                String str_date = sdf.format(date);
                System.out.println("编码前：" + str_date);
                str_date = URLEncoder.encode(str_date, StandardCharsets.UTF_8);
                System.out.println("编码后：" + str_date);
                Cookie cookie = new Cookie("lastTime", str_date);
                cookie.setMaxAge(60*60*24*30);
                response.addCookie(cookie);
                response.getWriter().write("您好，欢迎您首次访问");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
