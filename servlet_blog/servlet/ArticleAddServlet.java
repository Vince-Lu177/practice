package Vince.servlet;

import Vince.dao.ArticleDAO;
import Vince.exception.BusinessException;
import Vince.model.Article;
import Vince.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/articleAdd")
public class ArticleAddServlet extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        InputStream is = req.getInputStream();
        //http请求content-type为application/json。请求体是json的字符串，需要反序列化为java对象
        //需要检查json字符串的键，必须要和java类型中的属性匹配，
        // 如果json中的字段在java类型中没有，就会抛异常
        //文章添加，包含ID，content，userAccout;
        Article article = JSONUtil.deserialize(is,Article.class);
        System.out.println("=====================\n"+article);
        int num = ArticleDAO.insert(article);
        if(num!=1){
            throw new BusinessException("001","插入文章错误");
        }
        //模拟数据库插入操作
        return null;
    }
}
