package Vince.util;

import Vince.exception.SystemException;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DButil {

    private static volatile DataSource DS;

    private static final String URL = "jdbc:mysql://localhost:3306/blogdemo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "2816";

    //单例模式双重校验锁
    //(1)两次null判断，第一次保证效率，第二次保证同一个对象
    //(2)中间使用synchronized加锁，保证对象赋值操作的原子性
    //(3)共享变量使用volatile保证可见性，禁止指令重排序
    public static DataSource getDataSource() {
        if (DS == null) {
            synchronized (DButil.class) {
                if (DS == null) {
                    DS = new MysqlDataSource();
                    ((MysqlDataSource) DS).setURL(URL);
                    ((MysqlDataSource) DS).setUser(USERNAME);
                    ((MysqlDataSource) DS).setPassword(PASSWORD);
                }
            }
        }
        return DS;
    }

    //获取数据库连接
    public static Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw new SystemException("000", "获取数据库连接失败", e);
        }
    }

    //插入修改删除不需要释放ResultSet对象
    public static void close(Connection c, Statement s){
        close(c,s,null);
    }
    //释放资源操作：数据库服务请求/响应也是基于网络数据传输的，也就是网络io
    //需要在使用完之后要释放资源
    public static void close(Connection c, Statement s, ResultSet r) {
        try {
            if (c != null) {
                c.close();
            }
            if (s != null) {
                s.close();
            }
            if (r != null) {
                r.close();
            }
        } catch (SQLException e) {
            throw new SystemException("000", "释放数据库资源失败", e);
        }
    }
}
