package cn.edu.zucc.cs31901079.web;

import cn.edu.zucc.cs31901079.bean.User;
import cn.edu.zucc.cs31901079.service.UserService;
import cn.edu.zucc.cs31901079.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet   {

    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User loginUser = userService.login(new User(null, username, password, null));
        if (loginUser == null){
            System.out.println("用户名不存在");
            req.getRequestDispatcher("/pages/user/login.html").forward(req, resp);
        } else {
            req.getRequestDispatcher("/pages/user/login_success.html").forward(req, resp);
        }

    }
}
