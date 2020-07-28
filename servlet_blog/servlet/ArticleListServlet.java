package Vince.servlet;

import Vince.dao.ArticleDAO;
import Vince.model.Article;
import Vince.model.Result;
import Vince.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/articleList")
public class ArticleListServlet extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Article> articles = ArticleDAO.list();
        return articles;
    }

    //测试数据
//    public static List<Article> testData(){
//        List<Article> articles = new ArrayList<>();
//        Article a1 = new Article();
//        a1.setId(1);
//        a1.setTitle("Akira");
//        a1.setContent("笑傲江湖");
//        a1.setUserId(1);
//        a1.setCreateTime(new Date());
//        Article a2 = new Article();
//        a2.setId(2);
//        a2.setTitle("slkdn");
//        a2.setContent("倚天屠龙");
//        a2.setUserId(2);
//        a2.setCreateTime(new Date());
//        articles.add(a1);
//        articles.add(a2);
//        return articles;
//    }


}
