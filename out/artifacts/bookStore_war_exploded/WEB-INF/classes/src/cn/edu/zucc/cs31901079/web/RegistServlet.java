package cn.edu.zucc.cs31901079.web;

import cn.edu.zucc.cs31901079.bean.User;
import cn.edu.zucc.cs31901079.service.UserService;
import cn.edu.zucc.cs31901079.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code");
        String email = req.getParameter("email");

        if("abcde".equalsIgnoreCase(code)){
            if (userService.existsUsername(username)){
                System.out.println("用户名"+username+"不可用");
                req.getRequestDispatcher("/pages/user/register.html").forward(req, resp);
            } else {
                userService.registUser(new User(null, username, password, email));
                //跳到注册成功页面 regist_success.html
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req, resp);
            }
        } else {
            System.out.println("验证码["+code+"]错误,应该为abcde");
            req.getRequestDispatcher("/pages/user/register.html").forward(req, resp);
        }

    }
}
