package Vince.servlet;

import Vince.dao.ArticleDAO;
import Vince.exception.BusinessException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/articleDelete")
public class ArticleDeleteServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //ids = 1,2,3
        String idsString = req.getParameter("ids");
        int[] ids = parseIds(idsString);
        int num = ArticleDAO.delete(ids);
        if(num==0){
            throw new BusinessException("005","文章删除出错");

        }
        //把ids传到数据库做删除操作
        return null;
    }
    public static int[] parseIds(String s){
        String[] array = s.split(",");
        int[] arr = new int[array.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(array[i]);
        }
        return arr;
    }
}
