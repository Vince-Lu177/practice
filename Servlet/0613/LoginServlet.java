package Vince.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 通过http请求路径/login路径映射到本地servlet，通过@WebServlet 中配置的路径
 * @WebServlet必须以/开头
 */
@WebServlet("login ")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//请求数据的编码，只对请求体产生作用，对url中的数据无效
        resp.setCharacterEncoding("UTF-8");//服务端响应的内容编码
        //告诉浏览器 1.数据类型(浏览器处理数据的方式) 2.编码(浏览器解析数据的编码)
        resp.setContentType("text/html; charset=UTF-8");

        String username = req.getParameter("username");//根据key获取value，获取不到为null
        String password = req.getParameter("password");
        PrintWriter pw  = resp.getWriter();
        if("abc".equals(username) && "123".equals(password)){
            pw.println("登陆成功");
        }else{
            pw.println("登录失败");
        }
        pw.flush();
    }
}
