package com.mandian.study.dao;

import com.mandian.study.bean.User;
import com.mandian.study.util.DBHelper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {
    //创建QueryRunner对象,在dbutils的jar包里
    QueryRunner runner = new QueryRunner();

    /**
     * Get user according to name and password
     * used in login page
     * @param name
     * @param pwd
     * @return
     * @throws SQLException
     */
    public User getUser(String name, String pwd) throws SQLException {
        //1.调用DBHelper获取连接对象
        Connection conn = DBHelper.getConnection();
        //2.准备执行的sql语句
        String sql = "SELECT * from user WHERE name=? and pwd =? and state=1";
        //3.调用查询方法，将查询的数据封装成User对象
        User user = runner.query(conn, sql, new BeanHandler<User>(User.class), name, pwd);
        //4.关闭连接对象
        conn.close();
        //5.返回User
        return user;
    }

    /**
     * 修改密码
     * @param id 需要修改密码的用户编号
     * @param pwd 新的密码
     * @return 受影响的行数
     */
    public int modifyPwd(long id, String pwd) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "update user set pwd=? where id=?";
        int count = runner.update(conn, sql, pwd, id);
        conn.close();
        return count;
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        try {
            User user = userDao.getUser("admin", "123");
            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
