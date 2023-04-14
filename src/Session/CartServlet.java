package Session;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/CartServlet")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        List<Cake> cart = null;
        boolean purFlag = true;
        HttpSession session = request.getSession(false);

        if (session == null) {
            purFlag = false;
        } else {
            cart = (List) session.getAttribute("cart");
            if (cart == null) {
                purFlag = false;
            }
        }
        if (!purFlag) {
            out.write("对不起！您还没有购买任何商品！<br>");
        } else {
            out.write("您购买的蛋糕有：<br>");
            double price = 0;
            for (Cake cake : cart) {
                out.write(cake.getName() + "<br>");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
