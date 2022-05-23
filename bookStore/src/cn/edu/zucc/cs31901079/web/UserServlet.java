package cn.edu.zucc.cs31901079.web;

import cn.edu.zucc.cs31901079.bean.User;
import cn.edu.zucc.cs31901079.service.UserService;
import cn.edu.zucc.cs31901079.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User loginUser = userService.login(new User(null, username, password, null));
        if (loginUser == null){
            String errorMsg = "用户名不存在";
            System.out.println(errorMsg);
            req.setAttribute("msg",errorMsg);
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }

    }
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code");
        String email = req.getParameter("email");

        if("abcde".equalsIgnoreCase(code)){
            if (userService.existsUsername(username)){
                System.out.println("用户名"+username+"已存在");
                String errorMsg = "用户名"+username+"已存在";
                System.out.println(errorMsg);
                req.setAttribute("msg",errorMsg);
                req.getRequestDispatcher("/pages/user/register.html").forward(req, resp);
            } else {
                userService.registUser(new User(null, username, password, email));
                //跳到注册成功页面 regist_success.jsp
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            System.out.println("验证码["+code+"]错误,应该为abcde");

            String errorMsg = "验证码["+code+"]错误,应该为abcde";
            System.out.println(errorMsg);
            req.setAttribute("msg",errorMsg);
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            req.getRequestDispatcher("/pages/user/register.html").forward(req, resp);
        }

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if("login".equalsIgnoreCase(action)){
            login(req, resp);
        } else if ("regist".equals(action)) {
            regist(req, resp);
        }
    }
}
