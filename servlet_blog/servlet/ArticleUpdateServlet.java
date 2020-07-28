package Vince.servlet;

import Vince.dao.ArticleDAO;
import Vince.exception.BusinessException;
import Vince.model.Article;
import Vince.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

@WebServlet("/articleUpdate")
public class ArticleUpdateServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        //文章修改，包含ID，title，content
        InputStream is = req.getInputStream();
        Article article = JSONUtil.deserialize(is,Article.class);
        int num = ArticleDAO.updata(article);
        if(num != 1){
            throw new BusinessException("004","文章修改出错");
        }
        //模拟数据库修改操作

        System.out.println("=====================\n"+article);
        return null;
    }
}
