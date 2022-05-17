package cn.edu.zucc.cs31901079.test;

import cn.edu.zucc.cs31901079.bean.User;
import cn.edu.zucc.cs31901079.dao.UserDao;
import cn.edu.zucc.cs31901079.dao.impl.UserDaoImpl;
import org.junit.Test;

public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        if (userDao.queryUserByUsername("admin1234") == null) {
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("admin", "admin") == null) {
//            if (userDao.queryUserByUsernameAndPassword("admin", "admin1234") == null) {
                System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("查询成功查询成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null, "wzg168", "123456", "wzg168@qq.com")));
    }
}