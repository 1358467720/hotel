package cn.hotal.web.servlet;

import cn.hotal.bean.Admin;
import cn.hotal.bean.User;
import cn.hotal.dao.AdminDao;
import cn.hotal.dao.UserDao;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/InsertUserServlet")
public class InsertUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        Map<String, String[]> map = request.getParameterMap();
        User insertUser = new User();
        try {
            BeanUtils.populate(insertUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        int i = UserDao.insertUser(insertUser);//插入数据库，成功为1，失败为0

        if (i == 1) {
            //插入成功
            response.sendRedirect("/insert_user_success.html");

        }else{
            //插入失败
            response.sendRedirect("/insert_user_failed.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
