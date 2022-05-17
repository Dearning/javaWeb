package cn.edu.zucc.cs31901079.service.impl;

import cn.edu.zucc.cs31901079.bean.User;
import cn.edu.zucc.cs31901079.dao.UserDao;
import cn.edu.zucc.cs31901079.dao.impl.UserDaoImpl;
import cn.edu.zucc.cs31901079.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if(userDao.queryUserByUsername(username) == null){
            return false;
        }
        return true;
    }
}
