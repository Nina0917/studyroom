package com.mandian.study.biz;

import com.mandian.study.bean.User;
import com.mandian.study.dao.UserDao;

import java.sql.SQLException;

public class UserBiz {
    //构建UserDao对象
    UserDao userDao = new UserDao();

    public User getUser(String name, String pwd){
        User user = null;
        try {
            user = userDao.getUser(name, pwd);
        } catch (SQLException e) {
            //以后可以把异常放在日志中
            e.printStackTrace();
        }
        return user;
    }

    public int modifyPwd(long id, String pwd) {
        int count=0;
        try {
            count = userDao.modifyPwd(id, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
