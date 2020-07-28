package Vince.servlet;

import Vince.dao.ArticleDAO;
import Vince.exception.BusinessException;
import Vince.exception.ClientException;
import Vince.model.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@WebServlet("/articleDetail")
public class ArticleDetailServlet extends AbstractBaseServlet{

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取请求数据中的ID(文章ID)
        String id = req.getParameter("id");
        Integer articleId;

        try {
            articleId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new ClientException("001","请求参数错误[id="+id+"]");
        }
        Article article = ArticleDAO.query(articleId);
        if(article == null){
            throw new BusinessException("002","查询不到文章详情id="+articleId);
        }
        return article;//测试代码，以后替换成数据库根据文章ID查询文章信息操作

    }

//    public static Article testData(){
//        Article article = new Article();
//        article.setId(1);
//        article.setTitle("abc");
//        article.setContent("你好，江湖");
//        article.setUserId(1);
//        article.setCreateTime(new Date());
//        return article;
//    }
}
