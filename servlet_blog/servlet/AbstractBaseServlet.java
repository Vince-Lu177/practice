package Vince.servlet;

import Vince.exception.BaseException;
import Vince.model.Article;
import Vince.model.Result;
import Vince.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractBaseServlet extends HttpServlet {

    private static final ConcurrentMap<String, Integer> MAP = new ConcurrentHashMap<>();
    private static final ConcurrentMap<String, AtomicInteger> MAP2 = new ConcurrentHashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");

        //前端约定好的同意返回的json格式
        Result result = new Result();
        try {
            //正确返回业务数据
            Object data = process(req, resp);
            result.setSuccess(true);
            result.setData(data);

        } catch (Exception e) {
            //捕获到异常，需要设置前端需要的错误信息和堆栈信息
            if (e instanceof BaseException) {
                BaseException be = (BaseException) e;
                result.setMassage("错误码：" + be.getCode() + ",错误信息：" + be.getMessage());
            } else {
                result.setMassage("服务器异常：未知的错误");
            }

            StringWriter sw = new StringWriter();
            PrintWriter epw = new PrintWriter(sw);
            e.printStackTrace(epw);
            result.setStackTrace(sw.toString());
        }
        PrintWriter pw = resp.getWriter();
        pw.println(JSONUtil.serialize(result));
        pw.flush();


        synchronized (MAP){
            String path = req.getServletPath();
            Integer count = MAP.get(path);
            if(count == null){
                count = 1;
            }else{
                count++;
            }
            MAP.put(path,count);
        }
        String path = req.getServletPath();
        AtomicInteger count = MAP2.putIfAbsent(path, new AtomicInteger(1));

        if (count != null) {
            count.incrementAndGet();
        }
    }

    public abstract Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception;

    public static ConcurrentMap<String, Integer> getMAP() {
        return MAP;
    }

    public static ConcurrentMap<String, AtomicInteger> getMAP2() {
        return MAP2;
    }
}
