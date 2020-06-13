package Vince.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("test")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("UTF-8");
        PrintWriter pw = resp.getWriter();
        String i = req.getParameter("i");
        if("1".equals(i)){
            resp.sendRedirect("index.html");
        }else if("2".equals(i)){
            req.getRequestDispatcher("index.html").forward(req,resp);
        }else{
            try {
                Integer.parseInt(i);
                pw.println("正常数值" + i);
            } catch (NumberFormatException e) {
                resp.setStatus(400);
                pw.println("非数值" + i);
            }
        }
    }
}
